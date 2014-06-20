package org.rebel.machina.tileentity;

import javafx.util.Pair;
import net.minecraft.block.Block;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.item.ItemStack;
import org.rebel.machina.Machina;
import org.rebel.machina.network.PacketManualCrusher;
import org.rebel.machina.recipe.ManualCrusherRecipe;
import org.rebel.machina.recipe.RecipeLists;
import org.rebel.machina.util.LogHelper;

import java.util.Random;

/**
 * Created by XVicarious on 6/16/2014.
 */
public class TEManualCrusher extends TileEntity {

    int crushing;

    public TEManualCrusher() {
        super();
        crushing = 0;
    }

    public void crushTick() {
            //Machina.network.sendToServer(new PacketManualCrusher(this.worldObj.provider.dimensionId, crushing, this.xCoord, this.yCoord, this.zCoord));
            Block toCrush = worldObj.getBlock(xCoord,yCoord-1,zCoord);
            int metadata = worldObj.getBlockMetadata(xCoord,yCoord-1,zCoord);
            LogHelper.info(toCrush.getUnlocalizedName() + ":" + metadata);
            ManualCrusherRecipe recipe = null;
            for (ManualCrusherRecipe r : RecipeLists.mcRecipes) {
                if  (r != null && r.isValidOre(toCrush, metadata)) {
                    recipe = r;
                    break;
                }
            }
            if (recipe != null) {
                if (crushing >= recipe.jumpsToCrush) {
                    for (Pair<ItemStack, Float> p : recipe.outputs) {
                        Random r = new Random();
                        float c = r.nextFloat();
                        if (c < p.getValue()) {
                            LogHelper.info("Sendddingg...");
                            Machina.network.sendToServer(new PacketManualCrusher(this.worldObj.provider.dimensionId, crushing, this.xCoord, this.yCoord, this.zCoord, p.getKey()));
                        }
                    }
                    crushing = 0;
                } else {
                    crushing++;
                }
            }
    }

}
