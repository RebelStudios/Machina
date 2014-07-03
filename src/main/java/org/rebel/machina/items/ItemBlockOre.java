package org.rebel.machina.items;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import org.rebel.machina.info.MachinaNames;

/**
 * Created by XVicarious on 6/17/2014.
 */
public class ItemBlockOre extends ItemBlock {

    public ItemBlockOre(Block block) {
        super(block);
        setHasSubtypes(true);
    }

    @Override
    public int getMetadata(int metadata) {
        return metadata;
    }

    @Override
    public String getUnlocalizedName(ItemStack itemStack) {
        return getUnlocalizedName() + "." + MachinaNames.blockOreNames[itemStack.getItemDamage()];
    }

}
