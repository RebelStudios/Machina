package org.rebel.machina.blocks;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

/**
 * Created by XVicarious on 6/22/2014.
 */
public class BlockBlastFurnacePart extends BlockContainer {
    public BlockBlastFurnacePart() {
        super(Material.rock);
    }
    @Override
    public TileEntity createNewTileEntity(World var1, int var2) {
        return null;
    }
    public static boolean isController(int metadata) {
        return false;
    }
}
