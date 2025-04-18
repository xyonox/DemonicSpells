// ModCreativeModeTab.java
package com.xyonox.demonicspells.item;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.network.chat.Component;
import com.xyonox.demonicspells.item.ModItems;

public class ModCreativeModeTab {

    public static final CreativeModeTab DEMONIC_TAB = new CreativeModeTab("demonic_tab") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(ModItems.DEMONIC_ESSENCE.get());
        }

        @Override
        public Component getDisplayName() {
            return Component.literal("Demonic Spells");
        }
    };
}