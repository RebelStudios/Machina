package us.xvicario.multiblockmachines;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;

import java.util.List;

/**
 * Created by XVicarious on 6/16/2014.
 */
public class ItemIngot extends Item {

    public static final String[] itemNames = new String[] {"ingotLead","ingotSilver","ingotCopper","ingotTin","ingotBronze","ingotAluminum","ingotInvar","ingotNickel","ingotSolder","ingotElectrum","ingotSteel"};
    public static IIcon[] itemIcons;

    public ItemIngot() {
        super();
        this.setHasSubtypes(true);
        this.setMaxDamage(0);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IIconRegister ir) {
        itemIcons = new IIcon[11];
        for (int i = 0; i < itemIcons.length; i++) {
            System.out.println(MBMachine.MODID + ":" + itemNames[i]);
            itemIcons[i] = ir.registerIcon(MBMachine.MODID + ":" + itemNames[i]);
        }
    }

    public IIcon getIconFromDamage(int meta) {
        return itemIcons[meta];
    }

    @Override
    public String getUnlocalizedName(ItemStack itemstack) {
        int i = MathHelper.clamp_int(itemstack.getItemDamage(),0,10);
        return "item." + itemNames[i];
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void getSubItems(Item par1, CreativeTabs creativeTab, List par3) {
        for (int x = 0; x < 11; x++) {
            par3.add(new ItemStack(this,1,x));
        }
    }

}
