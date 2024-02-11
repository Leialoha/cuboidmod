package com.cuboiddroid.cuboidmod.modules.chest.block;

import javax.annotation.Nullable;

import com.cuboiddroid.cuboidmod.Config;
import com.cuboiddroid.cuboidmod.setup.ModTileEntities;
import com.cuboiddroid.cuboidmod.modules.chest.tile.NotsogudiumChestTileEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.core.BlockPos;

public class NotsogudiumChestBlock extends CuboidChestBlockBase {

    public NotsogudiumChestBlock() {
        super(CuboidChestTypes.NOTSOGUDIUM, ModTileEntities.NOTSOGUDIUM_CHEST::get, null, Config.notsogudiumChestCanOpenWhenObstructedAbove.get());
    }
    
    public NotsogudiumChestBlock(Properties properties) {
        super(CuboidChestTypes.NOTSOGUDIUM, ModTileEntities.NOTSOGUDIUM_CHEST::get, properties, Config.notsogudiumChestCanOpenWhenObstructedAbove.get());
    }

    @Override
    @Nullable
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new NotsogudiumChestTileEntity(pos, state);
    }
}
