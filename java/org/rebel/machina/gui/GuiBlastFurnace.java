package org.rebel.machina.gui;

import net.minecraft.inventory.Container;
import org.rebel.machina.tileentity.TEBlastFurnace;
import org.rebel.machina.tileentity.TEBlastFurnacePart;

/**
 * Created by XVicarious on 6/29/2014.
 */
public class GuiBlastFurnace extends MachinaGUIBase {

    TEBlastFurnacePart part;

    public GuiBlastFurnace(Container container, TEBlastFurnacePart te) {
        super(container);
        this.part = te;
    }

}
