package com.xyonox.demonicspells.network;

import com.xyonox.demonicspells.DemonicSpells;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;

@Mod.EventBusSubscriber(modid = DemonicSpells.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class NetworkModSetup {
    @SubscribeEvent
    public static void onCommonSetup(FMLCommonSetupEvent event) {
        event.enqueueWork(NetworkHandler::register);
    }
}
