package com.xyonox.demonicspells.capabilities;

import com.xyonox.demonicspells.blackforce.BlackForce;
import com.xyonox.demonicspells.blackforce.IBlackForce;
import com.xyonox.demonicspells.demonic.DemonicType;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber
public class CapabilityAttacher {
    private static final ResourceLocation BLACK_FORCE_ID = new ResourceLocation("demonicspells", "black_force");

    @SubscribeEvent
    public static void attach(AttachCapabilitiesEvent<Object> event) {
        if (event.getObject() instanceof net.minecraft.world.entity.player.Player) {
            event.addCapability(BLACK_FORCE_ID, new BlackForceProvider());
        }
    }

   public static class BlackForceProvider implements ICapabilitySerializable<CompoundTag> {
        private final BlackForce instance = new BlackForce();
        private final LazyOptional<IBlackForce> optional = LazyOptional.of(() -> instance);

        @Override
        public <T> LazyOptional<T> getCapability(Capability<T> cap, Direction side) {
            return cap == CapabilityHandler.BLACK_FORCE_CAPABILITY ? optional.cast() : LazyOptional.empty();
        }

       public CompoundTag serializeNBT() {
           CompoundTag tag = new CompoundTag();
           tag.putInt("Current", instance.getCurrent());
           tag.putInt("Max", instance.getMax());
           tag.putBoolean("Transformed", instance.isTransformed());
           tag.putString("CurrentType", instance.getType().toString());
           return tag;
       }

       @Override
       public void deserializeNBT(CompoundTag nbt) {
           instance.setCurrent(nbt.getInt("Current"));
           instance.setMax(nbt.getInt("Max"));
           instance.setTransformed(nbt.getBoolean("Transformed"));

           if (nbt.contains("CurrentType")) {
               try {
                   instance.setType(DemonicType.valueOf(nbt.getString("CurrentType")));
               } catch (IllegalArgumentException e) {
                   instance.setType(DemonicType.NONE);
               }
           } else {
               instance.setType(DemonicType.NONE);
           }
       }
    }
}
