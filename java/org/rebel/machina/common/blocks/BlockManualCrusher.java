package org.rebel.machina.common.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import org.rebel.machina.common.tileentity.TEManualCrusher;
import org.rebel.machina.util.LogHelper;
import net.minecraft.world.World;
import net.minecraft.entity.Entity;

/**
 * Created by XVicarious on 6/16/2014.
 */
public class BlockManualCrusher extends BlockContainer {

    TEManualCrusher te;

    public BlockManualCrusher() {
        super(Material.rock);
    }


    @Override
    public TileEntity createNewTileEntity(World var1, int var2) {
        te = new TEManualCrusher();
        return te;
    }

    @Override
    public void onFallenUpon(World world, int par2, int par3, int par4, Entity par5, float par6) {
        te.crushTick();
    }

}
