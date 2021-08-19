package com.cuboiddroid.cuboidmod.modules.chest.inventory;

import com.cuboiddroid.cuboidmod.setup.ModContainers;
import com.cuboiddroid.cuboidmod.modules.chest.block.CuboidChestTypes;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Inventory;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.ContainerType;
import net.minecraft.inventory.container.Slot;
import net.minecraft.item.ItemStack;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class CuboidChestContainer extends Container {

    private final IInventory inventory;

    private final CuboidChestTypes chestType;

    // private constructor
    private CuboidChestContainer(ContainerType<?> containerType, int windowId, PlayerInventory playerInventory) {
        this(containerType, windowId, playerInventory, new Inventory(CuboidChestTypes.NOTSOGUDIUM.size), CuboidChestTypes.NOTSOGUDIUM);
    }

    // Notsogudium
    public static CuboidChestContainer createNotsogudiumContainer(int windowId, PlayerInventory playerInventory) {
        return new CuboidChestContainer(ModContainers.NOTSOGUDIUM_CHEST.get(), windowId, playerInventory, new Inventory(CuboidChestTypes.NOTSOGUDIUM.size), CuboidChestTypes.NOTSOGUDIUM);
    }

    public static CuboidChestContainer createNotsogudiumContainer(int windowId, PlayerInventory playerInventory, IInventory inventory) {
        return new CuboidChestContainer(ModContainers.NOTSOGUDIUM_CHEST.get(), windowId, playerInventory, inventory, CuboidChestTypes.NOTSOGUDIUM);
    }

    // Kudbebedda
    public static CuboidChestContainer createKudbebeddaContainer(int windowId, PlayerInventory playerInventory) {
        return new CuboidChestContainer(ModContainers.KUDBEBEDDA_CHEST.get(), windowId, playerInventory, new Inventory(CuboidChestTypes.KUDBEBEDDA.size), CuboidChestTypes.KUDBEBEDDA);
    }

    public static CuboidChestContainer createKudbebeddaContainer(int windowId, PlayerInventory playerInventory, IInventory inventory) {
        return new CuboidChestContainer(ModContainers.KUDBEBEDDA_CHEST.get(), windowId, playerInventory, inventory, CuboidChestTypes.KUDBEBEDDA);
    }

    // Notarfbadium
    public static CuboidChestContainer createNotarfbadiumContainer(int windowId, PlayerInventory playerInventory) {
        return new CuboidChestContainer(ModContainers.NOTARFBADIUM_CHEST.get(), windowId, playerInventory, new Inventory(CuboidChestTypes.NOTARFBADIUM.size), CuboidChestTypes.NOTARFBADIUM);
    }

    public static CuboidChestContainer createNotarfbadiumContainer(int windowId, PlayerInventory playerInventory, IInventory inventory) {
        return new CuboidChestContainer(ModContainers.NOTARFBADIUM_CHEST.get(), windowId, playerInventory, inventory, CuboidChestTypes.NOTARFBADIUM);
    }

    // Wikidium
    public static CuboidChestContainer createWikidiumContainer(int windowId, PlayerInventory playerInventory) {
        return new CuboidChestContainer(ModContainers.WIKIDIUM_CHEST.get(), windowId, playerInventory, new Inventory(CuboidChestTypes.WIKIDIUM.size), CuboidChestTypes.WIKIDIUM);
    }

    public static CuboidChestContainer createWikidiumContainer(int windowId, PlayerInventory playerInventory, IInventory inventory) {
        return new CuboidChestContainer(ModContainers.WIKIDIUM_CHEST.get(), windowId, playerInventory, inventory, CuboidChestTypes.WIKIDIUM);
    }

    // Thatldu
    public static CuboidChestContainer createThatlduContainer(int windowId, PlayerInventory playerInventory) {
        return new CuboidChestContainer(ModContainers.THATLDU_CHEST.get(), windowId, playerInventory, new Inventory(CuboidChestTypes.THATLDU.size), CuboidChestTypes.THATLDU);
    }

    public static CuboidChestContainer createThatlduContainer(int windowId, PlayerInventory playerInventory, IInventory inventory) {
        return new CuboidChestContainer(ModContainers.THATLDU_CHEST.get(), windowId, playerInventory, inventory, CuboidChestTypes.THATLDU);
    }

    public CuboidChestContainer(ContainerType<?> containerType, int windowId, PlayerInventory playerInventory, IInventory inventory, CuboidChestTypes chestType) {
        super(containerType, windowId);

        this.inventory = inventory;
        this.chestType = chestType;

        inventory.startOpen(playerInventory.player);

        for (int chestRow = 0; chestRow < chestType.getRowCount(); chestRow++) {
            for (int chestCol = 0; chestCol < chestType.rowLength; chestCol++) {
                this.addSlot(new Slot(inventory, chestCol + chestRow * chestType.rowLength, 12 + chestCol * 18, 18 + chestRow * 18));
            }
        }

        int leftCol = (chestType.xSize - 162) / 2 + 1;

        for (int playerInvRow = 0; playerInvRow < 3; playerInvRow++) {
            for (int playerInvCol = 0; playerInvCol < 9; playerInvCol++) {
                this.addSlot(new Slot(playerInventory, playerInvCol + playerInvRow * 9 + 9, leftCol + playerInvCol * 18, chestType.ySize - (4 - playerInvRow) * 18 - 10));
            }

        }

        for (int hotbarSlot = 0; hotbarSlot < 9; hotbarSlot++) {
            this.addSlot(new Slot(playerInventory, hotbarSlot, leftCol + hotbarSlot * 18, chestType.ySize - 24));
        }
    }

    @Override
    public boolean stillValid(PlayerEntity playerIn) {
        return this.inventory.stillValid(playerIn);
    }

    @Override
    public ItemStack quickMoveStack(PlayerEntity player, int index) {
        ItemStack itemstack = ItemStack.EMPTY;
        Slot slot = this.slots.get(index);

        if (slot != null && slot.hasItem()) {
            ItemStack itemstack1 = slot.getItem();
            itemstack = itemstack1.copy();

            if (index < this.chestType.size) {
                if (!this.moveItemStackTo(itemstack1, this.chestType.size, this.slots.size(), true)) {
                    return ItemStack.EMPTY;
                }
            }
            else if (!this.moveItemStackTo(itemstack1, 0, this.chestType.size, false)) {
                return ItemStack.EMPTY;
            }

            if (itemstack1.isEmpty()) {
                slot.set(ItemStack.EMPTY);
            }
            else {
                slot.setChanged();
            }
        }

        return itemstack;
    }

    @Override
    public void removed(PlayerEntity player) {
        super.removed(player);
        this.inventory.stopOpen(player);
    }

    @OnlyIn(Dist.CLIENT)
    public CuboidChestTypes getChestType() {
        return this.chestType;
    }
}