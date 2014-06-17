package org.rebel.machina;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;

import java.util.Random;

/**
 * Created by XVicarious on 6/15/2014.
 */
public class MachineWall extends Block {

    public MachineWall() {
        super(Material.iron);
    }

    @Override
    public Item getItemDropped(int metadata, Random random, int fortune) {
        return null;
    }

}
