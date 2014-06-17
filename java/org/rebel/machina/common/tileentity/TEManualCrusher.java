package org.rebel.machina.common.tileentity;

import net.minecraft.entity.item.EntityItem;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import org.rebel.machina.Machina;

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
/*        if (worldObj.getBlock(this.xCoord,this.yCoord-1,this.zCoord) == Blocks.iron_ore) {
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
    }

}
