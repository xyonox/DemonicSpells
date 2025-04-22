package com.xyonox.demonicspells.client;

import com.mojang.blaze3d.vertex.PoseStack;
import com.xyonox.demonicspells.DemonicSpells;
import com.xyonox.demonicspells.blackforce.BlackForceUtil;
import com.xyonox.demonicspells.demonic.DemonicType;
import com.xyonox.demonicspells.network.NetworkHandler;
import com.xyonox.demonicspells.network.TransformC2SPacket;
import com.xyonox.demonicspells.util.KeyBinding;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Font;
import net.minecraft.client.gui.GuiComponent;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.*;
import net.minecraftforge.client.gui.overlay.VanillaGuiOverlay;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = DemonicSpells.MOD_ID, value = Dist.CLIENT)
public class ClientEvents {

    @SubscribeEvent
    public static void onRenderOverlay(RenderGuiOverlayEvent.Post event) {
        if (event.getOverlay().id() != VanillaGuiOverlay.HOTBAR.id()) return;

        Minecraft mc = Minecraft.getInstance();
        Player player = mc.player;
        if (player == null) return;

        int force = BlackForceUtil.get(player);
        DemonicType type = BlackForceUtil.getCurrentType(player);
        Boolean isTransformed = BlackForceUtil.isTransformed(player);

        int x = mc.getWindow().getGuiScaledWidth() - 90;
        int y = mc.getWindow().getGuiScaledHeight() - 40;

        String force_text = "Black Force: " + force;
        String type_text = "Type: " + type.name();
        Font font = mc.font;

        PoseStack poseStack = new PoseStack();

        int width = Math.max(
                Math.max(font.width(force_text), font.width(type_text)),
                font.width(String.valueOf(isTransformed))
        );

        int height = 3 * 9;

        GuiComponent.fill(poseStack, x - 2, y - 2, x + width + 2, y + height + 2, 0xAA000000);

        font.drawShadow(poseStack, force_text, x, y, 0xAA00FF);
        font.drawShadow(poseStack, type_text, x, y + 9, 0xAA00FF);
        font.drawShadow(poseStack, String.valueOf(isTransformed), x, y + 18, 0xAA00FF);
    }

    @Mod.EventBusSubscriber(modid = DemonicSpells.MOD_ID, value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class ClientModBusEvents {
        @SubscribeEvent
        public static void onKeyRegister(RegisterKeyMappingsEvent event) {
            event.register(KeyBinding.TRANSFORM_KEY);
        }
    }

    @Mod.EventBusSubscriber(modid = DemonicSpells.MOD_ID, value = Dist.CLIENT)
    public static class ClientForgeEvents {
        @SubscribeEvent
        public static void onKeyInput(InputEvent.Key event) {
            if(KeyBinding.TRANSFORM_KEY.consumeClick()) {
                Minecraft mc = Minecraft.getInstance();
                LocalPlayer player = mc.player;

                if (player != null) {
                    if(BlackForceUtil.getCurrentType(player) != DemonicType.NONE) {
                        boolean currentTransformed = BlackForceUtil.isTransformed(player);
                        // Statt direkt zu setzen:
                        // BlackForceUtil.setTransformed(player, !currentTransformed);

                        NetworkHandler.INSTANCE.sendToServer(new TransformC2SPacket(!currentTransformed));
                    }
                }
            }
        }
    }
}

