package com.xyonox.demonicspells.item.custom;

import com.xyonox.demonicspells.blackforce.BlackForceUtil;
import com.xyonox.demonicspells.item.ModCreativeModeTab;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class FireBlastItem extends CooldownItem {

    public FireBlastItem() {
        super(5, new Properties().stacksTo(1).durability(64).tab(ModCreativeModeTab.DEMONIC_TAB)); // 5 Sek Cooldown
    }

    @Override
    protected void castSpell(Level level, Player player, InteractionHand hand, ItemStack stack) {

        if(BlackForceUtil.consume(player, 50)){
            player.sendSystemMessage(Component.literal("🔥 Fire Blast ausgelöst!"));

            // Beispiel-Zauber: Player brennt 2 Sekunden
            player.setSecondsOnFire(2);

            stack.hurtAndBreak(1, player, (p) -> p.broadcastBreakEvent(hand));
        }

    }
}