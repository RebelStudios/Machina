package org.rebel.machina.items;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import org.rebel.machina.Machina;
import org.rebel.machina.info.MachinaNames;

import java.util.List;

/**
 * Created by XVicarious on 6/16/2014.
 */
public class ItemDust extends Item {

    public static IIcon[] itemIcons;

    public ItemDust() {
        super();
        this.setHasSubtypes(true);
        this.setMaxDamage(0);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IIconRegister ir) {
        itemIcons = new IIcon[MachinaNames.itemDustStrings.length];
        for (int i = 0; i < itemIcons.length; i++) {
            itemIcons[i] = ir.registerIcon(Machina.MODID + ":" + MachinaNames.itemDustStrings[i]);
        }
    }

    public IIcon getIconFromDamage(int meta) {
        return itemIcons[meta];
    }

    @Override
    public String getUnlocalizedName(ItemStack itemstack) {
        int i = MathHelper.clamp_int(itemstack.getItemDamage(), 0, MachinaNames.itemDustStrings.length - 1);
        return "item." + MachinaNames.itemDustStrings[i];
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void getSubItems(Item par1, CreativeTabs creativeTab, List par3) {
        for (int x = 0; x < MachinaNames.itemDustStrings.length; x++) {
            par3.add(new ItemStack(this, 1, x));
        }
    }

}
