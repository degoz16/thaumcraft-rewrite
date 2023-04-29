package com.degoz.thaumcraft.common.items;

import com.degoz.thaumcraft.Thaumcraft;
import com.degoz.thaumcraft.common.blocks.ThaumcraftBlocks;
import com.degoz.thaumcraft.common.items.items.CultistKnightArmorItem;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.StandingAndWallBlockItem;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ThaumcraftItems {

    private ThaumcraftItems() {
    }

    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, Thaumcraft.MOD_ID);

    // Items
    public static final RegistryObject<Item> THAUMONOMICON = ITEMS.register("thaumonomicon",
            () -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_MATERIALS)));
    public static final RegistryObject<Item> SALIS_MUNDUS = ITEMS.register("salis_mundus",
            () -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_MATERIALS)));

    // Armor
    public static final RegistryObject<Item> CULTIST_KNIGHT_HELMET = ITEMS.register("cultist_knight_helmet",
            () -> new CultistKnightArmorItem(ThaumcraftArmorMaterials.CULTIST_ARMOR, EquipmentSlot.HEAD,
                    new Item.Properties().tab(CreativeModeTab.TAB_COMBAT)));
    public static final RegistryObject<Item> CULTIST_KNIGHT_CHESTPLATE = ITEMS.register("cultist_knight_chestplate",
            () -> new CultistKnightArmorItem(ThaumcraftArmorMaterials.CULTIST_ARMOR, EquipmentSlot.CHEST,
                    new Item.Properties().tab(CreativeModeTab.TAB_COMBAT)));
    public static final RegistryObject<Item> CULTIST_KNIGHT_LEGGING = ITEMS.register("cultist_knight_leggings",
            () -> new CultistKnightArmorItem(ThaumcraftArmorMaterials.CULTIST_ARMOR, EquipmentSlot.LEGS,
                    new Item.Properties().tab(CreativeModeTab.TAB_COMBAT)));
    public static final RegistryObject<Item> CULTIST_KNIGHT_BOOTS = ITEMS.register("cultist_knight_boots",
            () -> new CultistKnightArmorItem(ThaumcraftArmorMaterials.CULTIST_ARMOR, EquipmentSlot.FEET,
                    new Item.Properties().tab(CreativeModeTab.TAB_COMBAT)));

    // Block items
    public static final RegistryObject<Item> CRYSTAL = ITEMS.register("crystal_item",
            () -> new BlockItem(ThaumcraftBlocks.CRYSTAL_BLOCK.get(), new Item.Properties().tab(CreativeModeTab.TAB_MATERIALS)));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
