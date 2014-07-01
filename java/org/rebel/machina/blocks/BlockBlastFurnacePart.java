package org.rebel.machina.blocks;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;
import org.rebel.machina.Machina;
import org.rebel.machina.info.MachinaNames;
import org.rebel.machina.tileentity.TEBlastFurnacePart;

import java.util.List;

/**
 * Created by XVicarious on 6/22/2014.
 */
public class BlockBlastFurnacePart extends BlockContainer {

    public static final int _CONTROLLER_META = 0;

    @SideOnly(Side.CLIENT)
    private IIcon[] icons;

    public BlockBlastFurnacePart() {
        super(Material.rock);
    }

    public static boolean isController(int metadata) {
        if (metadata == _CONTROLLER_META) {
            return true;
        }
        return false;
    }

    @Override
    public TileEntity createNewTileEntity(World var1, int var2) {
        return new TEBlastFurnacePart();
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void getSubBlocks(Item item, CreativeTabs tab, List subItems) {
        for (int i = 0; i < MachinaNames.blockBFPart.length; i++) {
            subItems.add(new ItemStack(this, 1, i));
        }
    }

    @Override
    @SideOnly(Side.CLIENT)
    public IIcon getIcon(int par1, int par2) {
        return icons[par2];
    }

    @Override
    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int p_149727_6_, float p_149727_7_, float p_149727_8_, float p_149727_9_) {
        player.openGui(Machina.instance, 0, world, x, y, z);
        return true;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister ir) {
        icons = new IIcon[2];
        icons[0] = ir.registerIcon(Machina.MODID + ":" + "blockBlastController");
        icons[1] = ir.registerIcon(Machina.MODID + ":" + "blockToughBrick");
    }
}
