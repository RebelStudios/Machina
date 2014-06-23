package org.rebel.machina.blocks;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import org.rebel.machina.info.ModNames;

import java.util.List;

/**
 * Created by XVicarious on 6/22/2014.
 */
public class BlockBlastFurnacePart extends BlockContainer {

    public static final int _CONTROLLER_META = 0;

    public BlockBlastFurnacePart() {
        super(Material.rock);
    }

    @Override
    public TileEntity createNewTileEntity(World var1, int var2) {
        return null;
    }

    public static boolean isController(int metadata) {
        if (metadata == _CONTROLLER_META) {
            return true;
        }
        return false;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void getSubBlocks(Item item, CreativeTabs tab, List subItems)     {
        for (int i = 0; i < ModNames.blockBFPart.length; i++) {
            subItems.add(new ItemStack(this, 1, i));
        }
    }

}
