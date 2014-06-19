package org.rebel.machina.tileentity;

import javafx.util.Pair;
import net.minecraft.block.Block;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import org.rebel.machina.recipe.MCRecipe;
import org.rebel.machina.recipe.RecipeLists;

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
        if (worldObj.isRemote) {
            //Machina.packetPipeline.
        }
        /*if (worldObj.getBlock(this.xCoord,this.yCoord-1,this.zCoord) == Blocks.iron_ore) {
            if (this.crushing == 5) {
                worldObj.setBlockToAir(this.xCoord,this.yCoord-1,this.zCoord);
                EntityItem ei = new EntityItem(worldObj,this.xCoord,this.yCoord-1,this.zCoord,new ItemStack(Items.iron_ingot));
                worldObj.spawnEntityInWorld(ei);
            } else {
                this.crushing++;
            }
        } else {
            crushing = 0;
        }*/
        Block toCrush = worldObj.getBlock(this.xCoord,this.yCoord-1,this.zCoord);
        MCRecipe recipe = null;
        for (MCRecipe r : RecipeLists.mcRecipes) {
            if (r.isValidOre(toCrush)) {
                recipe = r;
                break;
            }
        }
        if (recipe != null) {
            if (this.crushing >= recipe.jumpsToCrush) {
                worldObj.setBlockToAir(this.xCoord, this.yCoord - 1, this.zCoord);
                for (Pair<ItemStack, Float> p : recipe.outputs) {
                    Random r = new Random();
                    float c = r.nextFloat();
                    if (c < p.getValue()) {
                        EntityItem ei = new EntityItem(worldObj, this.xCoord, this.yCoord - 1, this.zCoord, p.getKey());
                        worldObj.spawnEntityInWorld(ei);
                    }
                }
            } else {
                this.crushing++;
            }
        }
    }

}
