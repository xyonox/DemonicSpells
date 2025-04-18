package com.xyonox.demonicspells;

import com.xyonox.demonicspells.blackforce.BlackForce;
import com.xyonox.demonicspells.blackforce.BlackForceUtil;
import com.xyonox.demonicspells.blackforce.IBlackForce;
import com.xyonox.demonicspells.capabilities.CapabilityHandler;
import com.xyonox.demonicspells.item.ModItems;
import com.xyonox.demonicspells.block.ModBlocks;
import com.xyonox.demonicspells.network.NetworkHandler;
import com.xyonox.demonicspells.network.SyncBlackForceS2CPacket;
import net.minecraft.core.Direction;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.network.PacketDistributor;
import net.minecraftforge.server.ServerLifecycleHooks;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

@Mod(DemonicSpells.MOD_ID)
public class DemonicSpells {
    public static final String MOD_ID = "demonicspells";

    public DemonicSpells() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        register(modEventBus);
    }

    private void register(IEventBus eventBus) {
        ModItems.ITEMS.register(eventBus);
        ModItems.registerBlockItems();
        ModBlocks.BLOCKS.register(eventBus);
    }


    @Mod.EventBusSubscriber(modid = DemonicSpells.MOD_ID)
    public class CommonEvents {

        @SubscribeEvent
        public static void onServerTick(TickEvent.ServerTickEvent event) {
            if (event.phase == TickEvent.Phase.END) {
                MinecraftServer server = ServerLifecycleHooks.getCurrentServer();
                if (server.getTickCount() % 20 == 0) { // jede Sekunde
                    for (ServerPlayer player : server.getPlayerList().getPlayers()) {
                        BlackForceUtil.add(player, 5); // Regeneration + Sync
                    }
                }
            }
        }

        @SubscribeEvent
        public static void attachCapabilities(AttachCapabilitiesEvent<Entity> event) {
            if (event.getObject() instanceof Player) {
                event.addCapability(new ResourceLocation(MOD_ID, "black_force"), new ICapabilityProvider() {
                    final LazyOptional<IBlackForce> instance = LazyOptional.of(BlackForce::new);
                    @Override
                    public <T> LazyOptional<T> getCapability(Capability<T> cap, Direction side) {
                        return cap == CapabilityHandler.BLACK_FORCE_CAPABILITY ? instance.cast() : LazyOptional.empty();
                    }
                });
            }
        }
    }

}