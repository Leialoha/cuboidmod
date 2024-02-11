package com.cuboiddroid.cuboidmod.modules.chest.block;

import javax.annotation.Nullable;

import com.cuboiddroid.cuboidmod.Config;
import com.cuboiddroid.cuboidmod.setup.ModTileEntities;
import com.cuboiddroid.cuboidmod.modules.chest.tile.KudbebeddaChestTileEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.core.BlockPos;

public class KudbebeddaChestBlock extends CuboidChestBlockBase {

    public KudbebeddaChestBlock() {
        super(CuboidChestTypes.KUDBEBEDDA, ModTileEntities.KUDBEBEDDA_CHEST::get, null, Config.kudbebeddaChestCanOpenWhenObstructedAbove.get());
    }

    public KudbebeddaChestBlock(Properties properties) {
        super(CuboidChestTypes.KUDBEBEDDA, ModTileEntities.KUDBEBEDDA_CHEST::get, properties, Config.kudbebeddaChestCanOpenWhenObstructedAbove.get());
    }

    @Override
    @Nullable
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new KudbebeddaChestTileEntity(pos, state);
    }
}
