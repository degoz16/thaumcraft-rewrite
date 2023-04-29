package com.degoz.thaumcraft.common.world.feature;

import com.degoz.thaumcraft.Thaumcraft;
import com.degoz.thaumcraft.common.blocks.ThaumcraftBlocks;
import com.google.common.base.Suppliers;
import net.minecraft.core.Registry;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.structure.templatesystem.BlockMatchTest;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

import java.util.List;
import java.util.function.Supplier;

public class ThaumcraftConfiguredFeatures {
    public static final DeferredRegister<ConfiguredFeature<?, ?>> CONFIGURED_FEATURES =
            DeferredRegister.create(Registry.CONFIGURED_FEATURE_REGISTRY, Thaumcraft.MOD_ID);

    public static final Supplier<List<OreConfiguration.TargetBlockState>> OVERWORLD_CRYSTAL = Suppliers.memoize(() -> List.of(
            OreConfiguration.target(new BlockMatchTest(Blocks.AIR), ThaumcraftBlocks.CRYSTAL_BLOCK.get().defaultBlockState())));


    public static final RegistryObject<ConfiguredFeature<?, ?>> CRYSTAL = CONFIGURED_FEATURES.register("crystal_block",
            () -> new ConfiguredFeature<>(ThaumcraftOreFeatures.CRYSTAL_ORE_FEATURE.get(),
                    new OreConfiguration(OVERWORLD_CRYSTAL.get(),30)));



    public static void register(IEventBus eventBus) {
        CONFIGURED_FEATURES.register(eventBus);
    }
}
