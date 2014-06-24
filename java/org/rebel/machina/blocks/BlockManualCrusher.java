package org.rebel.machina.blocks;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;
import org.rebel.machina.Machina;
import org.rebel.machina.tileentity.TEManualCrusher;

/**
 * Created by XVicarious on 6/16/2014.
 */
public class BlockManualCrusher extends BlockContainer {

    private TEManualCrusher te;
    private IIcon sideTexture;
    private IIcon topTexutre;

    public BlockManualCrusher() {
        super(Material.rock);
    }


    @Override
    public TileEntity createNewTileEntity(World var1, int var2) {
        te = new TEManualCrusher();
        return te;
    }

    @Override
    public void onFallenUpon(World world, int par2, int par3, int par4, Entity par5, float par6) {
        te.crushTick();
    }

    public void registerBlockIcons(IIconRegister icon) {
        sideTexture = icon.registerIcon(Machina.MODID + ":blockManualCrusher_Side");
        topTexutre = icon.registerIcon(Machina.MODID + ":blockManualCrusher_Top");
    }

    @Override
    public IIcon getIcon(int side, int metadata) {
        if (side != 0 && side != 1) {
            return sideTexture;
        } else if (side == 1) {
            return topTexutre;
        }
        return null;
    }

}
