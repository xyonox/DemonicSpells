package com.xyonox.demonicspells.item.custom;

import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public abstract class CooldownItem extends Item {

    private final int cooldownTicks;

    public CooldownItem(int cooldownSeconds, Properties properties) {
        super(properties);
        this.cooldownTicks = cooldownSeconds * 20; // 20 Ticks = 1 Sekunde
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        ItemStack itemStack = player.getItemInHand(hand);

        if (!level.isClientSide) {
            if (!player.getCooldowns().isOnCooldown(this)) {
                castSpell(level, player, hand, itemStack);
                player.getCooldowns().addCooldown(this, cooldownTicks);
            }
        }

        return InteractionResultHolder.sidedSuccess(itemStack, level.isClientSide());
    }

    protected abstract void castSpell(Level level, Player player, InteractionHand hand, ItemStack stack);
}