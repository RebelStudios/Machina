package org.rebel.machina.items;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import org.rebel.machina.info.MachinaNames;

/**
 * Created by XVicarious on 6/17/2014.
 */
public class ItemBlockMetal extends ItemBlock {

    public ItemBlockMetal(Block block) {
        super(block);
        setHasSubtypes(true);
    }

    @Override
    public int getMetadata(int metadata) {
        return metadata;
    }

    @Override
    public String getUnlocalizedName(ItemStack itemStack) {
        return getUnlocalizedName() + "." + MachinaNames.blockMetalNames[itemStack.getItemDamage()];
    }

}
