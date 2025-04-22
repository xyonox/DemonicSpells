package com.xyonox.demonicspells.network;

import com.xyonox.demonicspells.capabilities.CapabilityHandler;
import com.xyonox.demonicspells.demonic.DemonicType;
import net.minecraft.client.Minecraft;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.network.NetworkEvent;

import java.util.function.Supplier;

public class SyncBlackForceS2CPacket {
    private final int current;
    private final int max;
    private final boolean transformed;
    private final DemonicType currentType;

    public SyncBlackForceS2CPacket(int current, int max, boolean transformed, DemonicType currentType) {
        this.current = current;
        this.max = max;
        this.transformed = transformed;
        this.currentType = currentType;
    }

    public static void encode(SyncBlackForceS2CPacket packet, FriendlyByteBuf buf) {
        buf.writeInt(packet.current);
        buf.writeInt(packet.max);
        buf.writeBoolean(packet.transformed);
        buf.writeUtf(packet.currentType.toString());
    }

    public static SyncBlackForceS2CPacket decode(FriendlyByteBuf buf) {
        int current = buf.readInt();
        int max = buf.readInt();
        boolean transformed = buf.readBoolean();
        DemonicType currentType = DemonicType.valueOf(buf.readUtf());
        return new SyncBlackForceS2CPacket(current, max, transformed, currentType);
    }

    public static void handle(SyncBlackForceS2CPacket packet, Supplier<NetworkEvent.Context> ctx) {
        ctx.get().enqueueWork(() -> {
            Player player = Minecraft.getInstance().player;
            if (player != null) {
                player.getCapability(CapabilityHandler.BLACK_FORCE_CAPABILITY).ifPresent(force -> {
                    force.setCurrent(packet.current);
                    force.setMax(packet.max);
                    force.setTransformed(packet.transformed);
                    force.setType(packet.currentType);
                });
            }
        });
        ctx.get().setPacketHandled(true);
    }
}