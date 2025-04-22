package com.xyonox.demonicspells.block;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import com.xyonox.demonicspells.DemonicSpells;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, DemonicSpells.MOD_ID);

    // Beispielblock
    public static final RegistryObject<Block> DEMONIC_BLOCK = BLOCKS.register("demonic_block",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE).strength(4.0f)));
}