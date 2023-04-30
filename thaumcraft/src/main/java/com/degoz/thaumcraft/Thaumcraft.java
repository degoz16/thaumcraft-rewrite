package com.degoz.thaumcraft;

import com.degoz.thaumcraft.client.render.particle.ThaumcraftParticles;
import com.degoz.thaumcraft.common.blocks.ThaumcraftBlocks;
import com.degoz.thaumcraft.common.items.ThaumcraftItems;
import com.degoz.thaumcraft.common.world.feature.ThaumcraftConfiguredFeatures;
import com.degoz.thaumcraft.common.world.feature.ThaumcraftOreFeatures;
import com.degoz.thaumcraft.common.world.feature.ThaumcraftPlacedFeatures;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.InterModComms;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import software.bernie.geckolib3.GeckoLib;

@Mod(Thaumcraft.MOD_ID)
public class Thaumcraft {
    public static final String MOD_ID = "thaumcraft";

    // Directly reference a log4j logger.
    private static final Logger LOGGER = LogManager.getLogger();

    // Add a comment
    public Thaumcraft() {
        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();

        ThaumcraftItems.register(eventBus);
        ThaumcraftBlocks.register(eventBus);

        ThaumcraftOreFeatures.register(eventBus);
        ThaumcraftConfiguredFeatures.register(eventBus);
        ThaumcraftPlacedFeatures.register(eventBus);

        ThaumcraftParticles.register(eventBus);

        eventBus.addListener(this::setup);
        eventBus.addListener(this::clientSetup);

        GeckoLib.initialize();

//        ModLoadingContext.get().registerConfig(ModConfig.Type.CLIENT, TutorialModClientConfigs.SPEC, "tutorialmod-client.toml");
//        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, TutorialModCommonConfigs.SPEC, "tutorialmod-common.toml");

        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);
    }

    private void clientSetup(final FMLClientSetupEvent event) {
//        ItemBlockRenderTypes.setRenderLayer(ModBlocks.EBONY_DOOR.get(), RenderType.translucent());
//        ItemBlockRenderTypes.setRenderLayer(ModBlocks.EBONY_TRAPDOOR.get(), RenderType.translucent());
//
//        ItemBlockRenderTypes.setRenderLayer(ModBlocks.PINK_ROSE.get(), RenderType.cutout());
//        ItemBlockRenderTypes.setRenderLayer(ModBlocks.POTTED_PINK_ROSE.get(), RenderType.cutout());
//
//        ItemBlockRenderTypes.setRenderLayer(ModBlocks.WINTER_WINDOW.get(), RenderType.translucent());
//        ItemBlockRenderTypes.setRenderLayer(ModBlocks.CUCUMBER_PLANT.get(), RenderType.cutout());
//
//        ItemBlockRenderTypes.setRenderLayer(ModBlocks.EBONY_LEAVES.get(), RenderType.cutout());
//        ItemBlockRenderTypes.setRenderLayer(ModBlocks.EBONY_SAPLING.get(), RenderType.cutout());
//
//        ItemBlockRenderTypes.setRenderLayer(ModBlocks.GEM_CUTTING_STATION.get(), RenderType.translucent());
//
//        ItemBlockRenderTypes.setRenderLayer(ModFluids.HONEY_BLOCK.get(), RenderType.translucent());
//        ItemBlockRenderTypes.setRenderLayer(ModFluids.HONEY_FLUID.get(), RenderType.translucent());
//        ItemBlockRenderTypes.setRenderLayer(ModFluids.HONEY_FLOWING.get(), RenderType.translucent());


//        ModItemProperties.addCustomItemProperties();

//        MenuScreens.register(ModMenuTypes.GEM_CUTTING_STATION_MENU.get(), GemCuttingStationScreen::new);
//
//        WoodType.register(ModWoodTypes.EBONY);
//        BlockEntityRenderers.register(ModBlockEntities.SIGN_BLOCK_ENTITIES.get(), SignRenderer::new);
//
//        EntityRenderers.register(ModEntityTypes.RACCOON.get(), RaccoonRenderer::new);
    }

    private void setup(final FMLCommonSetupEvent event) {
        event.enqueueWork(() -> {
//            ((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(ModBlocks.PINK_ROSE.getId(), ModBlocks.POTTED_PINK_ROSE);

//            BrewingRecipeRegistry.addRecipe(new BetterBrewingRecipe(Potions.AWKWARD,
//                    ModItems.CITRINE.get(), ModPotions.FREEZE_POTION.get()));

//            Sheets.addWoodType(ModWoodTypes.EBONY);

//            SpawnPlacements.register(ModEntityTypes.RACCOON.get(),
//                    SpawnPlacements.Type.ON_GROUND,
//                    Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
//                    Animal::checkAnimalSpawnRules);
//
//            ModVillagers.registerPOIs();
        });
    }
}
