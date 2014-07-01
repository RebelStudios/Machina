package org.rebel.machina.tileentity;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.item.ItemStack;
import org.rebel.machina.gui.GuiBlastFurnace;
import org.rebel.machina.gui.container.ContainerBlastFurnace;
import org.rebel.machina.multiblock.helper.MultiblockValidationException;

/**
 * Created by Brian on 7/1/2014.
 */
public class TEBlastFurnaceCarbon extends TEBlastFurnacePart {

    public ItemStack[] inventory;

    public TEBlastFurnaceCarbon() {}

    @Override
    public void isGoodForSides() throws MultiblockValidationException {
        throw new MultiblockValidationException("Carbon Acceptor isn't good for the sides!!");
    }

    @Override
    public void isGoodForFrame() throws MultiblockValidationException {
        throw new MultiblockValidationException("Carbon Acceptor isn't good for the frame!!");
    }

    @Override
    public Object getContainer(InventoryPlayer inventoryPlayer) {
        if (!this.isConnected() || !this.getMultiblockController().isAssembled()) {
            return null;
        }
        return new ContainerBlastFurnace(this, inventoryPlayer.player);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public Object getGuiElement(InventoryPlayer inventoryPlayer) {
        if (!this.isConnected() || !this.getMultiblockController().isAssembled()) {
            return null;
        }
        return new GuiBlastFurnace(new ContainerBlastFurnace(this, inventoryPlayer.player), this);
    }

}
