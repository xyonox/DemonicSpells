package com.xyonox.demonicspells.item;

import com.xyonox.demonicspells.DemonicSpells;
import com.xyonox.demonicspells.block.ModBlocks;
import com.xyonox.demonicspells.item.custom.FireBlastItem;
import com.xyonox.demonicspells.item.custom.ILikeTestItems;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, DemonicSpells.MOD_ID);

    public static final RegistryObject<Item> DEMONIC_ESSENCE = ITEMS.register("demonic_essence",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.DEMONIC_TAB)));

    public static final RegistryObject<Item> FIRE_BLAST= ITEMS.register("fire_blast",
            () -> new FireBlastItem());

    public static final RegistryObject<Item> TESTO_TESTI= ITEMS.register("testo_testi",
            () -> new ILikeTestItems(new Item.Properties().tab(ModCreativeModeTab.DEMONIC_TAB)));


    // Diese Methode registriert automatisch BlockItems zu den Blöcken
    public static void registerBlockItems() {
        ModBlocks.BLOCKS.getEntries().forEach(block -> {
            String name = block.getId().getPath();
            Supplier<Block> blockSupplier = block;
            ITEMS.register(name, () -> new BlockItem(blockSupplier.get(), new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS)));
        });
    }
}