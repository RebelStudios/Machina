package org.rebel.machina.multiblock;

import java.util.EnumSet;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.TickEvent;
import net.minecraft.client.Minecraft;
import net.minecraft.world.World;
/**
 * This is a generic multiblock tick handler. If you are using this code on your own,
 * you will need to register this with the Forge TickRegistry on both the
 * client AND server sides.
 * Note that different types of ticks run on different parts of the system.
 * CLIENT ticks only run on the client, at the start/end of each game loop.
 * SERVER and WORLD ticks only run on the server.
 * WORLDLOAD ticks run only on the server, and only when worlds are loaded.
 */
/*
public class MultiblockServerTickHandler implements IScheduledTickHandler {

	@Override
	public void tickStart(EnumSet<TickType> type, Object... tickData) {
		if(type.contains(TickType.WORLD)) {
			World world = (World)tickData[0];
			MultiblockRegistry.tickStart(world);
		}
	}

	@Override
	public void tickEnd(EnumSet<TickType> type, Object... tickData) {
		if(type.contains(TickType.WORLD)) {
			World world = (World)tickData[0];
			MultiblockRegistry.tickEnd(world);
		}
	}

	@Override
	public EnumSet<TickType> ticks() {
		return EnumSet.of(TickType.WORLD);
	}

	@Override
	public String getLabel() {
		return "BigReactors:MultiblockServerTickHandler";
	}

	@Override
	public int nextTickSpacing() {
		return 1;
	}
}
*/

public class MultiblockServerTickHandler {
    @SubscribeEvent
    public void onServerTick(TickEvent.ServerTickEvent event) {
        if (event.phase == TickEvent.Phase.START) {
            MultiblockRegistry.tickStart(Minecraft.getMinecraft().theWorld);
        } else if (event.phase == TickEvent.Phase.END) {
            MultiblockRegistry.tickEnd(Minecraft.getMinecraft().theWorld);
        }
    }
}

