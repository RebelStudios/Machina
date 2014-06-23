package org.rebel.machina.items;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import org.rebel.machina.info.ModNames;

/**
 * Created by XVicarious on 6/22/2014.
 */
public class ItemBlockBlastFurnacePart extends ItemBlock {

    public ItemBlockBlastFurnacePart(Block block) {
        super(block);
        setHasSubtypes(true);
    }

    @Override
    public int getMetadata(int metadata) {
        return metadata;
    }

    @Override
    public String getUnlocalizedName(ItemStack itemStack) {
        return getUnlocalizedName() + "." + ModNames.blockBFPart[itemStack.getItemDamage()];
    }

}
