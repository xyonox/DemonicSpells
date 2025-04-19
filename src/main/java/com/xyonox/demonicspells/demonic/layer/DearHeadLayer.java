package com.xyonox.demonicspells.demonic.layer;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.xyonox.demonicspells.capabilities.CapabilityHandler;
import com.xyonox.demonicspells.demonic.DemonicType;
import com.xyonox.demonicspells.demonic.model.DearModel;
import net.minecraft.client.model.PlayerModel;
import net.minecraft.client.model.geom.EntityModelSet;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.player.AbstractClientPlayer;

public class DearHeadLayer extends RenderLayer<AbstractClientPlayer, PlayerModel<AbstractClientPlayer>> {

    private final DearModel<AbstractClientPlayer> model;

    public DearHeadLayer(RenderLayerParent<AbstractClientPlayer, PlayerModel<AbstractClientPlayer>> parent, EntityModelSet modelSet) {
        super(parent);
        this.model = new DearModel<>(modelSet.bakeLayer(DearModel.LAYER_LOCATION));
    }

    @Override
    public void render(PoseStack poseStack, MultiBufferSource bufferSource, int packedLight, AbstractClientPlayer player,
                       float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {

        player.getCapability(CapabilityHandler.BLACK_FORCE_CAPABILITY).ifPresent(cap -> {
            if (!cap.isTransformed() || cap.getType() != DemonicType.DEAR) return;

            poseStack.pushPose();

            getParentModel().head.translateAndRotate(poseStack);

            poseStack.translate(0.0, -0.25
                    , 0.0);
            poseStack.scale(0.7f, 0.7f, 0.7f);

            VertexConsumer vertex = bufferSource.getBuffer(RenderType.entityTranslucent(new ResourceLocation("demonicspells", "textures/entity/dear.png")));
            model.renderToBuffer(poseStack, vertex, packedLight, OverlayTexture.NO_OVERLAY, 1F, 1F, 1F, 1F);

            poseStack.popPose();
        });
    }
}