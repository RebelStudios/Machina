package us.xvicario.multiblockmachines;

import net.minecraft.block.BlockFurnace;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

/**
 * Created by XVicarious on 6/15/2014.
 */

public class BlockCrusher extends BlockMachine {

    public IIcon machineFace;
    public IIcon machineSide;

    @Override

    public TileEntity createNewTileEntity(World world, int j) {
        return null;
    }

    public void registerBlockIcons(IIconRegister icon) {
        machineFace = icon.registerIcon(MBMachine.MODID + ":machineCrusher_face");
        machineSide = icon.registerIcon(MBMachine.MODID + ":machineWall_0");
    }

    public IIcon getIcon(int side, int metadata) {
        return side == 1 ? this.machineSide : (side == 0 ? this.machineSide : (side != metadata ? this.machineFace : this.machineSide));
    }

}


