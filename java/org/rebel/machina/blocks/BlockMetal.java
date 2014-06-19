package org.rebel.machina.blocks;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import org.rebel.machina.Machina;
import org.rebel.machina.info.ModNames;

import java.util.List;

/**
 * Created by XVicarious on 6/17/2014.
 */
public class BlockMetal extends Block {

    @SideOnly(Side.CLIENT)
    private IIcon[] icons;

    public BlockMetal() {
        super(Material.iron);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void getSubBlocks(Item item, CreativeTabs tab, List subItems) {
        for (int i = 0; i < ModNames.blockMetalNames.length; i++) {
            subItems.add(new ItemStack(this, 1, i));
        }
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister ir) {
        icons = new IIcon[ModNames.blockMetalNames.length];
        for (int i = 0; i < icons.length; i++) {
            icons[i] = ir.registerIcon(Machina.MODID + ":" + ModNames.blockMetalNames[i]);
        }
    }

    @Override
    @SideOnly(Side.CLIENT)
    public IIcon getIcon(int par1, int par2) {
        return icons[par2];
    }

    @Override
    public int damageDropped(int metadata) {
        return metadata;
    }

}
