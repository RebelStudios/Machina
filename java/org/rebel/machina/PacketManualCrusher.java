package org.rebel.machina;

import cpw.mods.fml.common.network.ByteBufUtils;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;
import io.netty.buffer.ByteBuf;

/**
 * Created by XVicarious on 6/16/2014.
 */
public class PacketManualCrusher implements IMessage {

    public int world;
    public int x, y, z;

    public PacketManualCrusher() {}

    public PacketManualCrusher(int world, int x, int y, int z) {
        this.world = world;
        this.x = x;
        this.y = y;
        this.z = z;
    }

    @Override
    public void fromBytes(ByteBuf buf) {
        world = ByteBufUtils.readVarInt(buf,2);
        x = ByteBufUtils.readVarInt(buf,2);
        y = ByteBufUtils.readVarInt(buf,2);
        z = ByteBufUtils.readVarInt(buf,2);
    }

    @Override
    public void toBytes(ByteBuf buf) {
        ByteBufUtils.writeVarInt(buf, world, 2);
        ByteBufUtils.writeVarInt(buf, x, 2);
        ByteBufUtils.writeVarInt(buf, y, 2);
        ByteBufUtils.writeVarInt(buf, z, 2);
    }

    public static class Handle implements IMessageHandler<PacketManualCrusher, IMessage> {

        @Override
        public IMessage onMessage(PacketManualCrusher message, MessageContext ctx) {
            Machina.proxy.handleManualCrusher(message);
            return null;
        }

    }

}
