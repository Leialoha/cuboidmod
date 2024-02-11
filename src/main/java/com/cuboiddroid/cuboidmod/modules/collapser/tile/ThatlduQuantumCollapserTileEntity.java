package com.cuboiddroid.cuboidmod.modules.collapser.tile;

import com.cuboiddroid.cuboidmod.Config;
import com.cuboiddroid.cuboidmod.modules.collapser.inventory.ThatlduQuantumCollapserContainer;
import com.cuboiddroid.cuboidmod.setup.ModTileEntities;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;

public class ThatlduQuantumCollapserTileEntity extends QuantumCollapserTileEntityBase {
    public ThatlduQuantumCollapserTileEntity() {
        super(ModTileEntities.THATLDU_QUANTUM_COLLAPSER.get(),
                Config.thatlduQuantumCollapserSpeed.get().floatValue());
    }

    public ThatlduQuantumCollapserTileEntity(BlockPos pos, BlockState state) {
        super(ModTileEntities.THATLDU_QUANTUM_COLLAPSER.get(),
                pos, state, Config.thatlduQuantumCollapserSpeed.get().floatValue());
    }

    @Override
    public Component getDisplayName() {
        return new TranslatableComponent("cuboidmod.container.thatldu_quantum_collapser");
    }

    @Override
    public AbstractContainerMenu createContainer(int i, Level level, BlockPos pos, Inventory playerInventory, Player playerEntity) {
        return new ThatlduQuantumCollapserContainer(i, level, pos, playerInventory, playerEntity);
    }

}