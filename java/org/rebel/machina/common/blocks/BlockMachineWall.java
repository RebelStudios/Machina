package org.rebel.machina.common.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;

import java.util.Random;

/**
 * Created by XVicarious on 6/15/2014.
 */
public class BlockMachineWall extends Block {

    public BlockMachineWall() {
        super(Material.iron);
    }

    @Override
    public Item getItemDropped(int metadata, Random random, int fortune) {
        return null;
    }

}
