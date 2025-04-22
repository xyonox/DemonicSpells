package com.xyonox.demonicspells.demonic.abilities;

import com.xyonox.demonicspells.blackforce.BlackForceUtil;
import com.xyonox.demonicspells.demonic.DemonicType;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.level.Level;

public class DearAbilities {

    public static void tryShadowDash(Player player) {
        if (!player.level.isClientSide && BlackForceUtil.isTransformed(player)
                && BlackForceUtil.getCurrentType(player) == DemonicType.DEAR) {

            performShadowDash(player);
        }
    }

    public static void performShadowDash(Player player) {
        Vec3 look = player.getLookAngle();
        Vec3 target = player.position().add(look.scale(6));

        Level level = player.level;
        AABB newBox = player.getBoundingBox().move(look.scale(6));

        if (!level.noCollision(newBox)) {
            for (int i = 5; i >= 1; i--) {
                Vec3 fallback = player.position().add(look.scale(i));
                AABB box = player.getBoundingBox().move(look.scale(i));
                if (level.noCollision(box)) {
                    target = fallback;
                    break;
                }
            }
        }

        player.teleportTo(target.x, target.y, target.z);

        if (level instanceof ServerLevel serverLevel) {
            serverLevel.sendParticles(ParticleTypes.SMOKE, player.getX(), player.getY(), player.getZ(), 20, 0.5, 0.5, 0.5, 0.01);
        }

        AABB dashZone = player.getBoundingBox().expandTowards(look.scale(6)).inflate(1.0);
        for (LivingEntity entity : level.getEntitiesOfClass(LivingEntity.class, dashZone)) {
            if (entity != player && entity.isAlive() && player.hasLineOfSight(entity)) {
                entity.hurt(DamageSource.MAGIC, 3.0F);
            }
        }

        BlackForceUtil.consume(player, 10);
    }

    public static void castHornCurse(Player player, LivingEntity target) {
        if (!player.level.isClientSide &&
                BlackForceUtil.isTransformed(player) &&
                BlackForceUtil.getCurrentType(player) == DemonicType.DEAR) {

            target.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 60, 1));
            target.addEffect(new MobEffectInstance(MobEffects.WEAKNESS, 60, 0));

            BlackForceUtil.consume(player, 5);
        }
    }

    public static void castShadowForest(Player player) {
        if (!player.level.isClientSide &&
                BlackForceUtil.isTransformed(player) &&
                BlackForceUtil.getCurrentType(player) == DemonicType.DEAR) {

            player.addEffect(new MobEffectInstance(MobEffects.INVISIBILITY, 100, 0));

            player.level.getEntitiesOfClass(LivingEntity.class, player.getBoundingBox().inflate(5)).forEach(entity -> {
                if (entity != player && player.hasLineOfSight(entity)) {
                    entity.addEffect(new MobEffectInstance(MobEffects.BLINDNESS, 60, 0));
                }
            });

            BlackForceUtil.consume(player, 10);
        }
    }
}