package org.rebel.machina;

import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import net.minecraft.tileentity.TileEntity;

/**
 * Created by XVicarious on 6/16/2014.
 */
public class PacketHandler {

    public static final SimpleNetworkWrapper INSTANCE = NetworkRegistry.INSTANCE.newSimpleChannel("machina");

    private static int ID = 0;

    public static int nextID() {
        return ID++;
    }

    public static void sendToAllAround(IMessage message, TileEntity te, int range) {
        INSTANCE.sendToAllAround(message, new NetworkRegistry.TargetPoint(te.getWorldObj().provider.dimensionId,te.xCoord,te.yCoord,te.zCoord, range));
    }

    public static void sendToAllAround(IMessage message, TileEntity te) {
        sendToAllAround(message, te, 64);
    }

}
