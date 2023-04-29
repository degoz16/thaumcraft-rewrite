package com.degoz.thaumcraft.common.world.feature.features;

import com.degoz.thaumcraft.common.blocks.blocks.CrystalBlock;
import com.mojang.serialization.Codec;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.OreFeature;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;

import javax.annotation.Nonnull;
import java.util.function.Function;
import java.util.function.Predicate;

public class CrystalFeature extends OreFeature {
    public CrystalFeature(Codec<OreConfiguration> p_65786_) {
        super(p_65786_);
    }

    public static boolean checkNeighbors(
            @Nonnull Function<BlockPos, BlockState> blockStateFunction,
            @Nonnull BlockPos blockPos,
            @Nonnull Predicate<BlockState> predicate
    ) {
        BlockPos.MutableBlockPos mutableBlockPos = new BlockPos.MutableBlockPos();

        for(Direction direction : Direction.values()) {
            if (direction.equals(Direction.UP)) {
                continue;
            }
            mutableBlockPos.setWithOffset(blockPos, direction);
            if (predicate.test(blockStateFunction.apply(mutableBlockPos))) {
                return true;
            }
        }

        return false;
    }

    public static boolean canPlaceOre(
            @Nonnull BlockState blockState,
            @Nonnull Function<BlockPos, BlockState> blockStateFunction,
            @Nonnull RandomSource randomSource,
            @Nonnull OreConfiguration oreConfiguration,
            OreConfiguration.TargetBlockState targetBlockState,
            @Nonnull BlockPos.MutableBlockPos mutableBlockPos
    ) {
        return !targetBlockState.target.test(blockState, randomSource)
                && checkNeighbors(blockStateFunction, mutableBlockPos, (state) ->
                CrystalBlock.AVAILABLE_MATERIALS.contains(state.getMaterial()));
    }

}
