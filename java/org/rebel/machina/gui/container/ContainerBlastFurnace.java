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
    Slot[] blastInput;
    Slot blastFuel;
    Slot blastOutput;

    public ContainerBlastFurnace(TEBlastFurnacePart part, EntityPlayer player) {
        this.part = part;
        this.bindInventory(player.inventory);
        blastInput = new Slot[10];
        blastFuel = addSlotToContainer(new Slot(part, 0, 19, 30)); // The fuel for the furnace
        blastInput[0] = addSlotToContainer(new Slot(part, 1, 19, 12)); // The carbon for cooking steel
        // Input for the iron (the 3x3 inventory part)
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                blastInput[i] = addSlotToContainer(new Slot(part, j + (1 + 3 * i), 44 + j * 18, 12 + i * 18));
            }
        }
        blastOutput = addSlotToContainer(new Slot(part, 11, 137, 30));
    }

    @Override
    public boolean canInteractWith(EntityPlayer var1) {
        return part.getBlastFurnaceController() != null;
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
