package org.rebel.machina.multiblock;

import java.util.EnumSet;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.TickEvent;
import net.minecraft.client.Minecraft;
/*
public class MultiblockClientTickHandler implements IScheduledTickHandler {

	@Override
	public void tickStart(EnumSet<TickType> type, Object... tickData) {
		if(type.contains(TickType.CLIENT)) {
			MultiblockRegistry.tickStart(Minecraft.getMinecraft().theWorld);
		}
	}

	@Override
	public void tickEnd(EnumSet<TickType> type, Object... tickData) {
		if(type.contains(TickType.CLIENT)) {
			MultiblockRegistry.tickEnd(Minecraft.getMinecraft().theWorld);
		}
	}

	@Override
	public EnumSet<TickType> ticks() {
		return EnumSet.of(TickType.CLIENT);
	}

	@Override
	public String getLabel() {
		return "BigReactors:MultiblockClientTickHandler";
	}

	@Override
	public int nextTickSpacing() {
		return 1;
	}

}
*/

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