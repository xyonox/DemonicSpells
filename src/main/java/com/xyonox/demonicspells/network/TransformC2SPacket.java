package com.xyonox.demonicspells.network;

import com.xyonox.demonicspells.blackforce.BlackForceUtil;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraftforge.network.NetworkEvent;

import java.util.function.Supplier;

public class TransformC2SPacket {
    private final boolean newState;

    public TransformC2SPacket(boolean newState) {
        this.newState = newState;
    }

    public static void encode(TransformC2SPacket packet, FriendlyByteBuf buf) {
        buf.writeBoolean(packet.newState);
    }

    public static TransformC2SPacket decode(FriendlyByteBuf buf) {
        return new TransformC2SPacket(buf.readBoolean());
    }

    public static void handle(TransformC2SPacket packet, Supplier<NetworkEvent.Context> ctx) {
        ctx.get().enqueueWork(() -> {
            var player = ctx.get().getSender();
            if (player != null) {
                BlackForceUtil.setTransformed(player, packet.newState);
            }
        });
        ctx.get().setPacketHandled(true);
    }
}