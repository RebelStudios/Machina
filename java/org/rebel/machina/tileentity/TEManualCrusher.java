package org.rebel.machina.tileentity;

import javafx.util.Pair;
import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagInt;
import net.minecraft.tileentity.TileEntity;
import org.rebel.machina.Machina;
import org.rebel.machina.network.MessageManualCrusher;
import org.rebel.machina.recipe.ManualCrusherRecipe;
import org.rebel.machina.recipe.RecipeLists;
import org.rebel.machina.util.Util;

/**
 * Created by XVicarious on 6/16/2014.
 */
public class TEManualCrusher extends TileEntity {

    private int crushing;

    public TEManualCrusher() {
        super();
        crushing = 0;
    }

    @Override
    public void writeToNBT(NBTTagCompound nbt) {
        super.writeToNBT(nbt);
        NBTTagInt crushingTag = new NBTTagInt(this.crushing);
        nbt.setTag("crushing", crushingTag);
    }

    @Override
    public void readFromNBT(NBTTagCompound nbt) {
        super.readFromNBT(nbt);
        NBTTagInt crushingTag = (NBTTagInt)nbt.getTag("crushing");
        this.crushing = crushingTag.func_150287_d();
    }

    public void crushTick() {
        Block toCrush = worldObj.getBlock(xCoord,yCoord-1,zCoord);
        int metadata = worldObj.getBlockMetadata(xCoord,yCoord-1,zCoord);
        ManualCrusherRecipe recipe = RecipeLists.getMCRecipe(toCrush, metadata);
        if (recipe != null) {
            if (crushing >= recipe.jumpsToCrush) {
                for (Pair<ItemStack, Float> p : recipe.outputs) {
                    if (Util.checkChance(p.getValue())) {
                        Machina.network.sendToServer(new MessageManualCrusher(this.worldObj.provider.dimensionId, this.xCoord, this.yCoord, this.zCoord, p.getKey()));
                    }
                }
                crushing = 0;
            } else {
                crushing++;
            }
        } else {
            crushing = 0;
        }
    }

}
