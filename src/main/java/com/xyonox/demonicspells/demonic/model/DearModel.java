package com.xyonox.demonicspells.demonic.model;

// Made with Blockbench 4.12.4
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.xyonox.demonicspells.DemonicSpells;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;

public class DearModel<T extends net.minecraft.world.entity.LivingEntity> extends EntityModel<T>{
	// This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(DemonicSpells.MOD_ID, "dear"), "main");
	private final ModelPart Head2;
	private final ModelPart geweih;
	private final ModelPart left;
	private final ModelPart left2;

	public DearModel(ModelPart root) {
		this.Head2 = root.getChild("Head2");
		this.geweih = this.Head2.getChild("geweih");
		this.left = this.geweih.getChild("left");
		this.left2 = this.geweih.getChild("left2");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition Head2 = partdefinition.addOrReplaceChild("Head2", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.1047F, 0.0873F, 0.0F));

		//PartDefinition geweih = Head2.addOrReplaceChild("geweih", CubeListBuilder.create(), PartPose.offset(0.0F, 25.0F, 2.0F));
		PartDefinition geweih = Head2.addOrReplaceChild("geweih", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition left = geweih.addOrReplaceChild("left", CubeListBuilder.create(), PartPose.offset(0.0F, -13.0F, 0.0F));
		PartDefinition cube_r1 = left.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(0, 37).addBox(-1.0F, -1.0F, 0.0F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(7.0F, 3.0F, 0.0F, 0.0F, 0.0F, -0.829F));
		PartDefinition cube_r2 = left.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(38, 34).addBox(-1.0F, -1.0F, 0.0F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.0F, 4.0F, 0.0F, 0.0F, 0.0F, -0.5236F));
		PartDefinition cube_r3 = left.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(30, 20).addBox(-1.0F, -1.0F, 0.0F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(9.0F, 0.0F, 4.0F, 0.0F, 0.0F, -0.829F));
		PartDefinition cube_r4 = left.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(30, 17).addBox(-1.0F, -1.0F, 0.0F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(7.0F, 1.0F, 4.0F, 0.0F, 0.0F, -0.5236F));
		PartDefinition cube_r5 = left.addOrReplaceChild("cube_r5", CubeListBuilder.create().texOffs(29, 34).addBox(0.0F, -1.0F, -1.0F, 1.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.0F, -1.0F, 8.0F, 1.0681F, -0.1842F, -0.2883F));
		PartDefinition cube_r6 = left.addOrReplaceChild("cube_r6", CubeListBuilder.create().texOffs(30, 0).addBox(0.0F, -1.0F, -1.0F, 1.0F, 1.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.0F, 1.0F, 5.0F, 0.5489F, -0.1489F, -0.3144F));
		PartDefinition cube_r7 = left.addOrReplaceChild("cube_r7", CubeListBuilder.create().texOffs(30, 7).addBox(0.0F, -1.0F, -1.0F, 1.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.0F, 2.0F, 4.0F, 1.0681F, -0.1842F, -0.2883F));
		PartDefinition cube_r8 = left.addOrReplaceChild("cube_r8", CubeListBuilder.create().texOffs(0, 24).addBox(0.0F, -1.0F, -1.0F, 1.0F, 1.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.0F, 4.0F, 1.0F, 0.5489F, -0.1489F, -0.3144F));
		PartDefinition cube_r9 = left.addOrReplaceChild("cube_r9", CubeListBuilder.create().texOffs(30, 12).addBox(0.0F, -1.0F, -1.0F, 1.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(7.0F, -2.0F, 6.0F, 0.8527F, 0.9729F, -0.5326F));
		PartDefinition cube_r10 = left.addOrReplaceChild("cube_r10", CubeListBuilder.create().texOffs(15, 0).addBox(0.0F, -1.0F, -4.0F, 1.0F, 1.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(7.0F, -1.0F, 6.0F, 0.6346F, 0.9729F, -0.5326F));
		PartDefinition cube_r11 = left.addOrReplaceChild("cube_r11", CubeListBuilder.create().texOffs(0, 8).addBox(0.0F, -1.0F, -4.0F, 1.0F, 1.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(6.0F, 2.0F, 4.0F, 0.5114F, 0.665F, -0.1465F));
		PartDefinition cube_r12 = left.addOrReplaceChild("cube_r12", CubeListBuilder.create().texOffs(0, 0).addBox(0.0F, -1.0F, -4.0F, 1.0F, 1.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.0F, 5.0F, 0.0F, 0.4528F, 0.4755F, 0.0678F));

		PartDefinition left2 = geweih.addOrReplaceChild("left2", CubeListBuilder.create(), PartPose.offsetAndRotation(-5.0F, -13.0F, -4.0F, 0.1309F, -1.2217F, 0.0F));
		PartDefinition cube_r13 = left2.addOrReplaceChild("cube_r13", CubeListBuilder.create().texOffs(31, 31).addBox(-1.0F, -1.0F, 0.0F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(7.0F, 3.0F, 0.0F, 0.0F, 0.0F, -0.829F));
		PartDefinition cube_r14 = left2.addOrReplaceChild("cube_r14", CubeListBuilder.create().texOffs(9, 34).addBox(-1.0F, -1.0F, 0.0F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.0F, 4.0F, 0.0F, 0.0F, 0.0F, -0.5236F));
		PartDefinition cube_r15 = left2.addOrReplaceChild("cube_r15", CubeListBuilder.create().texOffs(20, 31).addBox(-1.0F, -1.0F, 0.0F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(9.0F, 0.0F, 4.0F, 0.0F, 0.0F, -0.829F));
		PartDefinition cube_r16 = left2.addOrReplaceChild("cube_r16", CubeListBuilder.create().texOffs(9, 31).addBox(-1.0F, -1.0F, 0.0F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(7.0F, 1.0F, 4.0F, 0.0F, 0.0F, -0.5236F));
		PartDefinition cube_r17 = left2.addOrReplaceChild("cube_r17", CubeListBuilder.create().texOffs(20, 34).addBox(0.0F, -1.0F, -1.0F, 1.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.0F, -1.0F, 8.0F, 1.0681F, -0.1842F, -0.2883F));
		PartDefinition cube_r18 = left2.addOrReplaceChild("cube_r18", CubeListBuilder.create().texOffs(26, 24).addBox(0.0F, -1.0F, -1.0F, 1.0F, 1.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(6.0F, 1.0F, 5.0F, 0.5489F, -0.1489F, -0.3144F));
		PartDefinition cube_r19 = left2.addOrReplaceChild("cube_r19", CubeListBuilder.create().texOffs(0, 31).addBox(0.0F, -1.0F, -1.0F, 1.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.0F, 2.0F, 4.0F, 1.0681F, -0.1842F, -0.2883F));
		PartDefinition cube_r20 = left2.addOrReplaceChild("cube_r20", CubeListBuilder.create().texOffs(13, 24).addBox(0.0F, -1.0F, -1.0F, 1.0F, 1.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.0F, 4.0F, 1.0F, 0.5489F, -0.1489F, -0.3144F));
		PartDefinition cube_r21 = left2.addOrReplaceChild("cube_r21", CubeListBuilder.create().texOffs(11, 37).addBox(0.0F, -1.0F, 0.0F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(7.0F, -2.0F, 7.0F, 1.6286F, 0.3206F, -0.3425F));
		PartDefinition cube_r22 = left2.addOrReplaceChild("cube_r22", CubeListBuilder.create().texOffs(15, 16).addBox(0.0F, -1.0F, -4.0F, 1.0F, 1.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(7.0F, -1.0F, 6.0F, 0.6346F, 0.9729F, -0.5326F));
		PartDefinition cube_r23 = left2.addOrReplaceChild("cube_r23", CubeListBuilder.create().texOffs(0, 16).addBox(0.0F, -1.0F, -4.0F, 1.0F, 1.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(6.0F, 2.0F, 4.0F, 0.5114F, 0.665F, -0.1465F));
		PartDefinition cube_r24 = left2.addOrReplaceChild("cube_r24", CubeListBuilder.create().texOffs(15, 8).addBox(0.0F, -1.0F, -4.0F, 1.0F, 1.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.0F, 5.0F, 0.0F, 0.4528F, 0.4755F, 0.0678F));

		return LayerDefinition.create(meshdefinition, 64, 64);
	}

	@Override
	public void setupAnim(T t, float v, float v1, float v2, float v3, float v4) {

	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		Head2.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}