package org.rebel.machina.blocks;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;

/**
 * Created by XVicarious on 6/15/2014.
 */
public abstract class BlockMachine extends BlockContainer {

    private boolean isActive;

    public BlockMachine() {
        super(Material.iron);
    }

}
