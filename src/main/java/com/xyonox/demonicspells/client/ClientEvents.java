package com.xyonox.demonicspells.client;

import com.mojang.blaze3d.vertex.PoseStack;
import com.xyonox.demonicspells.DemonicSpells;
import com.xyonox.demonicspells.blackforce.BlackForceUtil;
import com.xyonox.demonicspells.demonic.DemonicType;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Font;
import net.minecraft.client.gui.GuiComponent;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.RenderGuiOverlayEvent;
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
}

// https://discord.com/channels/1129059589325852724/1129069842805301371/1362070825897033919