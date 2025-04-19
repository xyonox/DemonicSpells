package com.xyonox.demonicspells.network;

// NetworkHandler.java
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.network.NetworkRegistry;
import net.minecraftforge.network.simple.SimpleChannel;

public class NetworkHandler {
    private static final String PROTOCOL_VERSION = "1.0";
    public static final SimpleChannel INSTANCE = NetworkRegistry.newSimpleChannel(
            new ResourceLocation("demonicspells", "main"),
            () -> PROTOCOL_VERSION, s -> true, s -> true
    );

    private static int ID = 0;
    private static int id() {
        return ID++;
    }

    public static void register() {
        INSTANCE.registerMessage(id(), SyncBlackForceS2CPacket.class,
                SyncBlackForceS2CPacket::encode,
                SyncBlackForceS2CPacket::decode,
                SyncBlackForceS2CPacket::handle
        );

        INSTANCE.registerMessage(id(), TransformC2SPacket.class,
                TransformC2SPacket::encode,
                TransformC2SPacket::decode,
                TransformC2SPacket::handle
        );
    }
}
