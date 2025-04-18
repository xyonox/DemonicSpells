package com.xyonox.demonicspells.item.custom;

import com.xyonox.demonicspells.blackforce.BlackForceUtil;
import com.xyonox.demonicspells.demonic.DemonicType;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;

public class ILikeTestItems extends Item {
    public ILikeTestItems(Properties p_41383_) {
        super(p_41383_);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand interactionHand) {
        BlackForceUtil.setCurrentType(player, DemonicType.DEAR);
        ItemStack itemStack = player.getItemInHand(interactionHand);
        player.getInventory().removeItem(itemStack);

        // Toggle den Transformationsstatus
        boolean currentTransformed = BlackForceUtil.isTransformed(player);
        BlackForceUtil.setTransformed(player, !currentTransformed);

        // Feedback an den Spieler
        String status = BlackForceUtil.isTransformed(player) ? "transformed" : "not transformed";
        player.displayClientMessage(Component.literal("You are now in " + status + " form with DEAR type."), true);



        return super.use(level, player, interactionHand);
    }
}
