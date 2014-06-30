package org.rebel.machina.multiblock;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.player.InventoryPlayer;

/**
 * Created by XVicarious on 6/29/2014.
 */
public interface IMultiblockGuiHandler {

    public Object getContainer(InventoryPlayer inventoryPlayer);

    @SideOnly(Side.CLIENT)
    public Object getGuiElement(InventoryPlayer inventoryPlayer);

}
