package org.rebel.machina.gui.container;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import org.rebel.machina.tileentity.TEBlastFurnacePart;

/**
 * Created by XVicarious on 6/29/2014.
 */
public class ContainerBlastFurnace extends Container {

    TEBlastFurnacePart part;

    public ContainerBlastFurnace(TEBlastFurnacePart part, EntityPlayer player) {
        this.part = part;
        this.bindInventory(player.inventory);
    }

    @Override
    public boolean canInteractWith(EntityPlayer var1) {
        return part.getBlastFurnaceController() != null ? true : false;
    }

    private void bindInventory(InventoryPlayer inventoryPlayer) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 9; j++) {
                addSlotToContainer(new Slot(inventoryPlayer, j + i * 9 + 9, 8 + j * 18, 84 + i * 18));
            }
        }
        for (int i = 0; i < 9; i++) {
            addSlotToContainer(new Slot(inventoryPlayer, i, 8 + i * 18, 142));
        }
    }

}
