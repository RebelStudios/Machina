package org.rebel.machina.multiblock;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.TickEvent;
import net.minecraft.client.Minecraft;
import org.rebel.machina.util.LogHelper;

public class MultiblockClientTickHandler {
    @SubscribeEvent
    public void onClientTick(TickEvent.ClientTickEvent event) {
        if (event.phase == TickEvent.Phase.START) {
            MultiblockRegistry.tickStart(Minecraft.getMinecraft().theWorld);
        } else if (event.phase == TickEvent.Phase.END) {
            MultiblockRegistry.tickEnd(Minecraft.getMinecraft().theWorld);
        }
    }
}