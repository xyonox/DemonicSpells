package com.xyonox.demonicspells.item.custom;

import com.xyonox.demonicspells.demonic.abilities.DearAbilities;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class TestiTestoDreiItme extends Item
{
    public TestiTestoDreiItme(Properties p_41383_) {
        super(p_41383_);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        DearAbilities.castShadowForest(player);
        return super.use(level, player, hand);
    }
}
