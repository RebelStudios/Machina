package org.rebel.machina.network;

import cpw.mods.fml.common.network.ByteBufUtils;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;
import io.netty.buffer.ByteBuf;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.common.DimensionManager;
import org.rebel.machina.Machina;
import org.rebel.machina.util.LogHelper;

/**
 * Created by XVicarious on 6/16/2014.
 */
public class PacketManualCrusher implements IMessage {

    public int world;
    public int crushing;
    public int x, y, z;
    public ItemStack i;

    public PacketManualCrusher() {}

    public PacketManualCrusher(int world, int crushing, int x, int y, int z, ItemStack i) {
        this.world = world;
        this.crushing = crushing;
        this.x = x;
        this.y = y;
        this.z = z;
        this.i = i;
    }

    @Override
    public void fromBytes(ByteBuf buf) {
        world = ByteBufUtils.readVarInt(buf,5);
        crushing = ByteBufUtils.readVarInt(buf,5);
        x = ByteBufUtils.readVarInt(buf,5);
        y = ByteBufUtils.readVarInt(buf,5);
        z = ByteBufUtils.readVarInt(buf,5);
        i = ByteBufUtils.readItemStack(buf);
    }

    @Override
    public void toBytes(ByteBuf buf) {
        ByteBufUtils.writeVarInt(buf, world, 5);
        ByteBufUtils.writeVarInt(buf, crushing, 5);
        ByteBufUtils.writeVarInt(buf, x, 5);
        ByteBufUtils.writeVarInt(buf, y, 5);
        ByteBufUtils.writeVarInt(buf, z, 5);
        ByteBufUtils.writeItemStack(buf, i);
    }

    public static class Handle implements IMessageHandler<PacketManualCrusher, IMessage> {

        @Override
        public IMessage onMessage(PacketManualCrusher message, MessageContext ctx) {
            World worldObj = DimensionManager.getWorld(message.world);
            int xCoord = message.x;
            int yCoord = message.y;
            int zCoord = message.z;
            int crushing = message.crushing;
            ItemStack i = message.i;
            LogHelper.info("Setting block to air.");
            worldObj.setBlockToAir(xCoord, yCoord - 1, zCoord);
            LogHelper.info("Spawning item.");
            EntityItem ei = new EntityItem(worldObj, xCoord, yCoord - 1, zCoord, i);
            worldObj.spawnEntityInWorld(ei);
            return null;
        }

    }

}
