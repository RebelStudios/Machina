package org.rebel.machina.common.blocks;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import org.rebel.machina.ModNames;

import java.util.List;

/**
 * Created by XVicarious on 6/17/2014.
 */
public class BlockMetal extends Block {

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
    public int damageDropped(int metadata) {
        return metadata;
    }

}
