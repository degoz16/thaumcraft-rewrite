package com.degoz.thaumcraft.common.blocks;

import com.degoz.thaumcraft.Thaumcraft;
import com.degoz.thaumcraft.common.blocks.blocks.CrystalBlock;
import com.google.common.base.Suppliers;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ThaumcraftBlocks {

    private ThaumcraftBlocks() {
    }

    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, Thaumcraft.MOD_ID);

    public static final RegistryObject<Block> CRYSTAL_BLOCK = BLOCKS.register("crystal_block", Suppliers.memoize(CrystalBlock::new));

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
