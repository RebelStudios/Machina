package org.rebel.machina.blocks;

import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import org.rebel.machina.tileentity.TEToughBrick;

/**
 * Created by XVicarious on 6/22/2014.
 */
public class BlockToughBrick extends BlockBlastFurnacePart {

    private BlockToughBrick() {
        super();
    }

    @Override
    public TileEntity createNewTileEntity(World var1, int var2) {
        return new TEToughBrick();
    }
}
