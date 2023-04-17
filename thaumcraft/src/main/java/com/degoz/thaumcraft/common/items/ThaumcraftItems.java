package com.degoz.thaumcraft.common.items;

import com.degoz.thaumcraft.Thaumcraft;
import com.degoz.thaumcraft.common.items.items.CultistKnightArmorItem;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ThaumcraftItems {

    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, Thaumcraft.MOD_ID);

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

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
