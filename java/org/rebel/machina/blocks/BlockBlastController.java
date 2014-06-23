package org.rebel.machina.blocks;

import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import org.rebel.machina.multiblock.helper.BlockMultiblockBase;
import org.rebel.machina.multiblock.helper.MultiblockControllerBase;
import org.rebel.machina.tileentity.TEBlastFurnace;

/**
 * Created by XVicarious on 6/22/2014.
 */
public class BlockBlastController extends BlockBlastFurnacePart {

    public BlockBlastController() {
        super();
    }

    @Override
    public TileEntity createNewTileEntity(World var1, int var2) {
        return new TEBlastFurnace();
    }
}
