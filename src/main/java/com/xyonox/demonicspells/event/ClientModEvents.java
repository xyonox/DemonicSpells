package com.xyonox.demonicspells.event;

import com.xyonox.demonicspells.demonic.layer.DearHeadLayer;
import com.xyonox.demonicspells.demonic.model.DearModel;
import net.minecraft.client.model.geom.EntityModelSet;
import net.minecraft.client.renderer.entity.player.PlayerRenderer;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = "demonicspells", bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ClientModEvents {

    @SubscribeEvent
    public static void registerLayers(EntityRenderersEvent.RegisterLayerDefinitions event) {
        event.registerLayerDefinition(DearModel.LAYER_LOCATION, DearModel::createBodyLayer);
    }

    @SubscribeEvent
    public static void addPlayerLayers(EntityRenderersEvent.AddLayers event) {
        EntityModelSet modelSet = event.getEntityModels();

        for (String skinType : event.getSkins()) {
            PlayerRenderer renderer = event.getSkin(skinType);
            renderer.addLayer(new DearHeadLayer(renderer, modelSet));
        }
    }
}

