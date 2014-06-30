package org.rebel.machina.gui;

import net.minecraft.inventory.Container;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;
import org.rebel.machina.Machina;
import org.rebel.machina.tileentity.TEBlastFurnace;
import org.rebel.machina.tileentity.TEBlastFurnacePart;
import org.rebel.machina.util.MachinaLog;

/**
 * Created by XVicarious on 6/29/2014.
 */
public class GuiBlastFurnace extends MachinaGUIBase {

    TEBlastFurnacePart part;

    public GuiBlastFurnace(Container container, TEBlastFurnacePart te) {
        super(container);
        MachinaLog.info("Making gui.");
        this.part = te;
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float var1, int var2, int var3) {
        //fontRendererObj.drawString("Blast Furnace", 8, 6, 4210752);
        ResourceLocation containerBg = new ResourceLocation("machina", "textures/gui/guiBlastFurnace.png");
        GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
        this.mc.renderEngine.bindTexture(containerBg);
        this.drawTexturedModalRect((width-xSize)/2, (height-ySize)/2, 0, 0, xSize, ySize);
    }
}
