package org.rebel.machina.blocks;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import org.rebel.machina.tileentity.TEBlastFurnace;

/**
 * Created by XVicarious on 6/22/2014.
 */
public class BlockBlastController extends BlockBlastFurnacePart {

    @Override
    public boolean onBlockActivated(World world, int p_149727_2_, int p_149727_3_, int p_149727_4_, EntityPlayer player, int p_149727_6_, float p_149727_7_, float p_149727_8_, float p_149727_9_) {
        //player.addChatMessage(new ChatComponentText("Block"));
        return true;
    }

    public BlockBlastController() {
        super();
    }

    @Override
    public TileEntity createNewTileEntity(World var1, int var2) {
        return new TEBlastFurnace();
    }
}
