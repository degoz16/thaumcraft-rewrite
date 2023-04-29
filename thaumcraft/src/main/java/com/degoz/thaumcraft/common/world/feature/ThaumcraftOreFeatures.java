package com.degoz.thaumcraft.common.world.feature;

import com.degoz.thaumcraft.Thaumcraft;
import com.degoz.thaumcraft.common.world.feature.features.CrystalFeature;
import com.google.common.base.Suppliers;
import net.minecraft.core.Registry;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ThaumcraftOreFeatures {
    public static final DeferredRegister<Feature<?>> FEATURES =
            DeferredRegister.create(Registry.FEATURE_REGISTRY, Thaumcraft.MOD_ID);

    public static final RegistryObject<Feature<OreConfiguration>> CRYSTAL_ORE_FEATURE = FEATURES.register("crystal_ore_generate", Suppliers.memoize(() -> new CrystalFeature(OreConfiguration.CODEC)));

    public static void register(IEventBus eventBus) {
        FEATURES.register(eventBus);
    }
}
