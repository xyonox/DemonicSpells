package com.xyonox.demonicspells.event;

import com.xyonox.demonicspells.DemonicSpells;
import com.xyonox.demonicspells.blackforce.IBlackForce;
import com.xyonox.demonicspells.capabilities.CapabilityAttacher;
import com.xyonox.demonicspells.capabilities.CapabilityHandler;
import com.xyonox.demonicspells.demonic.DemonicType;
import net.minecraft.nbt.CompoundTag;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = DemonicSpells.MOD_ID)
public class CapabilitySyncEvents {

    @SubscribeEvent
    public static void onPlayerClone(PlayerEvent.Clone event) {
        System.out.println("hey");
        Player oldPlayer = event.getOriginal();
        Player newPlayer = event.getEntity();

        oldPlayer.reviveCaps(); // wichtig!

        oldPlayer.getCapability(CapabilityHandler.BLACK_FORCE_CAPABILITY).ifPresent(oldCap -> {
            CompoundTag nbt = new CompoundTag();
            CapabilityAttacher.BlackForceProvider tempProvider = new CapabilityAttacher.BlackForceProvider();
            nbt = tempProvider.serializeNBT(); // oder direkt oldCap serialize, siehe unten

            // Sicherer: manuell schreiben
            CompoundTag data = new CompoundTag();
            data.putInt("Current", oldCap.getCurrent());
            data.putInt("Max", oldCap.getMax());
            data.putBoolean("Transformed", oldCap.isTransformed());
            data.putString("CurrentType", oldCap.getType().toString());

            newPlayer.getCapability(CapabilityHandler.BLACK_FORCE_CAPABILITY).ifPresent(newCap -> {
                newCap.setCurrent(data.getInt("Current"));
                newCap.setMax(data.getInt("Max"));
                newCap.setTransformed(data.getBoolean("Transformed"));
                newCap.setType(DemonicType.valueOf(data.getString("CurrentType")));
            });
        });
    }

    // ✅ Beim Speichern in .dat-Datei (z. B. Welt verlassen)
    @SubscribeEvent
    public static void onPlayerSave(PlayerEvent.SaveToFile event) {
        Player player = event.getEntity();
        player.getCapability(CapabilityHandler.BLACK_FORCE_CAPABILITY).ifPresent(cap -> {
            CompoundTag tag = new CompoundTag();
            tag.putInt("Current", cap.getCurrent());
            tag.putInt("Max", cap.getMax());
            tag.putBoolean("Transformed", cap.isTransformed());
            tag.putString("CurrentType", cap.getType().toString());

            player.getPersistentData().put("BlackForceData", tag);
        });
    }

    // ✅ Beim Laden aus .dat-Datei (z. B. Join nach Minecraft-Neustart)
    @SubscribeEvent
    public static void onPlayerLoad(PlayerEvent.LoadFromFile event) {
        Player player = event.getEntity();
        CompoundTag tag = player.getPersistentData().getCompound("BlackForceData");

        if (tag.isEmpty()) return;

        player.getCapability(CapabilityHandler.BLACK_FORCE_CAPABILITY).ifPresent(cap -> {
            cap.setCurrent(tag.getInt("Current"));
            cap.setMax(tag.getInt("Max"));
            cap.setTransformed(tag.getBoolean("Transformed"));
            try {
                cap.setType(DemonicType.valueOf(tag.getString("CurrentType")));
            } catch (IllegalArgumentException e) {
                cap.setType(DemonicType.NONE);
            }
        });
    }
}
