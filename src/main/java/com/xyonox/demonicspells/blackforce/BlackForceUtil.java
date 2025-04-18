package com.xyonox.demonicspells.blackforce;

import com.xyonox.demonicspells.capabilities.CapabilityHandler;
import com.xyonox.demonicspells.demonic.DemonicType;
import com.xyonox.demonicspells.network.NetworkHandler;
import com.xyonox.demonicspells.network.SyncBlackForceS2CPacket;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.network.PacketDistributor;

public class BlackForceUtil {

    public static boolean consume(Player player, int amount) {
        return player.getCapability(CapabilityHandler.BLACK_FORCE_CAPABILITY).map(force -> {
            if (force.getCurrent() >= amount) {
                force.subtract(amount);
                sync(player);
                return true;
            }
            return false;
        }).orElse(false);
    }

    public static void add(Player player, int amount) {
        player.getCapability(CapabilityHandler.BLACK_FORCE_CAPABILITY).ifPresent(force -> {
            force.add(amount);
            sync(player);
        });
    }

    public static void set(Player player, int amount) {
        player.getCapability(CapabilityHandler.BLACK_FORCE_CAPABILITY).ifPresent(force -> {
            force.setCurrent(amount);
            sync(player);
        });
    }

    public static void setMax(Player player, int newMax) {
        player.getCapability(CapabilityHandler.BLACK_FORCE_CAPABILITY).ifPresent(force -> {
            force.setMax(newMax);
            if (force.getCurrent() > newMax) {
                force.setCurrent(newMax);
            }
            sync(player);
        });
    }

    public static int get(Player player) {
        LazyOptional<IBlackForce> cap = player.getCapability(CapabilityHandler.BLACK_FORCE_CAPABILITY);
        return cap.map(IBlackForce::getCurrent).orElse(0);
    }

    public static int getMax(Player player) {
        LazyOptional<IBlackForce> cap = player.getCapability(CapabilityHandler.BLACK_FORCE_CAPABILITY);
        return cap.map(IBlackForce::getMax).orElse(100);
    }

    public static boolean isTransformed(Player player) {
        return player.getCapability(CapabilityHandler.BLACK_FORCE_CAPABILITY)
                .map(IBlackForce::isTransformed)
                .orElse(false);
    }

    public static void setTransformed(Player player, boolean transformed) {
        player.getCapability(CapabilityHandler.BLACK_FORCE_CAPABILITY).ifPresent(force -> {
            force.setTransformed(transformed);
            sync(player);
        });
    }

    // Getter für 'currentType'
    public static DemonicType getCurrentType(Player player) {
        return player.getCapability(CapabilityHandler.BLACK_FORCE_CAPABILITY)
                .map(IBlackForce::getType)
                .orElse(DemonicType.NONE);
    }

    // Setter für 'currentType'
    public static void setCurrentType(Player player, DemonicType type) {
        player.getCapability(CapabilityHandler.BLACK_FORCE_CAPABILITY).ifPresent(force -> {
            force.setType(type);
            sync(player);
        });
    }

    public static void sync(Player player) {
        if (player instanceof ServerPlayer serverPlayer) {
            player.getCapability(CapabilityHandler.BLACK_FORCE_CAPABILITY).ifPresent(force -> {
                NetworkHandler.INSTANCE.send(PacketDistributor.PLAYER.with(() -> serverPlayer),
                        new SyncBlackForceS2CPacket(force.getCurrent(), force.getMax(), force.isTransformed(), force.getType()));
            });
        }
    }
}