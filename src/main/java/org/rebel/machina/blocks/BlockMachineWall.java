package org.rebel.machina.blocks;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import org.rebel.machina.tileentity.TEMachineWall;

import java.util.Random;

/**
 * Created by XVicarious on 6/15/2014.
 */
public class BlockMachineWall extends BlockContainer {

    public BlockMachineWall() {
        super(Material.iron);
    }

    @Override
    public Item getItemDropped(int metadata, Random random, int fortune) {
        return null;
    }

    @Override
    public TileEntity createNewTileEntity(World var1, int var2) {
        return new TEMachineWall();
    }
}
