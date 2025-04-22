package com.xyonox.demonicspells.demonic.model;

// Made with Blockbench 4.12.4
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;

public class OniModel<T extends Entity> extends EntityModel<T> {
    public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("modid", "oni"), "main");
    private final ModelPart head;
    private final ModelPart oni;

    public OniModel(ModelPart root) {
        this.head = root.getChild("head");
        this.oni = this.head.getChild("oni");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition head = partdefinition.addOrReplaceChild("head", CubeListBuilder.create(), PartPose.offset(0.0F, 31.2F, 0.0F));

        PartDefinition oni = head.addOrReplaceChild("oni", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition cube_r1 = oni.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(8, 10).addBox(-1.0F, -2.0F, -1.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.8F, -12.0F, -4.8F, 0.2984F, 0.4504F, -0.1513F));
        PartDefinition cube_r2 = oni.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(0, 10).addBox(-1.0F, -2.0F, -1.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.0F, -12.0F, -4.8F, 0.0774F, 0.6003F, 0.212F));
        PartDefinition cube_r3 = oni.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(0, 5).addBox(-1.0F, -3.0F, -1.0F, 2.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.0F, -7.0F, -3.0F, 0.3693F, 0.0425F, 0.5835F));
        PartDefinition cube_r4 = oni.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(8, 5).addBox(-1.0F, -3.0F, -1.0F, 2.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.0F, -9.0F, -4.0F, 0.3117F, 0.4363F, -0.0382F));
        PartDefinition cube_r5 = oni.addOrReplaceChild("cube_r5", CubeListBuilder.create().texOffs(8, 0).addBox(-1.0F, -3.0F, -1.0F, 2.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.0F, -9.0F, -4.0F, 0.1849F, 0.4443F, 0.1195F));
        PartDefinition cube_r6 = oni.addOrReplaceChild("cube_r6", CubeListBuilder.create().texOffs(0, 0).addBox(-1.0F, -3.0F, -1.0F, 2.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.0F, -7.0F, -3.0F, 0.3927F, 0.0F, -0.48F));

        return LayerDefinition.create(meshdefinition, 16, 16);
    }

    @Override
    public void setupAnim(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

    }

    @Override
    public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
        head.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
    }
}
