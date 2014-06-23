package org.rebel.machina.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import org.rebel.machina.multiblock.helper.BlockMultiblockBase;
import org.rebel.machina.tileentity.TEToughBrick;

/**
 * Created by XVicarious on 6/22/2014.
 */
public class BlockToughBrick extends BlockBlastFurnacePart {

    public BlockToughBrick() {
        super();
    }

    @Override
    public TileEntity createNewTileEntity(World var1, int var2) {
        return new TEToughBrick();
    }
}
