package com.degoz.thaumcraft.common.blocks.blocks;

import com.degoz.thaumcraft.utils.BlockMaterials;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.tags.FluidTags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SimpleWaterloggedBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Material;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nonnull;
import java.util.Set;

public class CrystalBlock extends Block implements SimpleWaterloggedBlock {

    private static final Logger LOGGER = LogManager.getLogger();

    private static final Set<Material> AVAILABLE_MATERIALS = Set.of(Material.STONE);

    public static final BooleanProperty DOWN = BooleanProperty.create("down");
    public static final BooleanProperty UP = BooleanProperty.create("up");
    public static final BooleanProperty NORTH = BooleanProperty.create("north");
    public static final BooleanProperty SOUTH = BooleanProperty.create("south");
    public static final BooleanProperty WEST = BooleanProperty.create("west");
    public static final BooleanProperty EAST = BooleanProperty.create("east");
    public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;

    public CrystalBlock() {
        super(Properties.of(BlockMaterials.CRYSTAL).strength(0.5F).sound(SoundType.AMETHYST_CLUSTER));

        registerDefaultState(stateDefinition.any()
                .setValue(UP, false)
                .setValue(DOWN, false)
                .setValue(NORTH, false)
                .setValue(SOUTH, false)
                .setValue(EAST, false)
                .setValue(WEST, false)
                .setValue(WATERLOGGED, false)
        );
    }

//    public BooleanProperty getProperty(Direction side) {
//        return switch (side) {
//            case NORTH -> NORTH;
//            case SOUTH -> SOUTH;
//            case EAST -> EAST;
//            case WEST -> WEST;
//            case UP -> UP;
//            default -> DOWN;
//        };
//    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        return getState(context.getLevel(), context.getClickedPos());
    }

    private BlockState getState(Level world, BlockPos pos) {
        FluidState fluidState = world.getFluidState(pos);
        LOGGER.debug("getState");
        return defaultBlockState()
                .setValue(UP, false)
                .setValue(DOWN, isBlockAvailableForPlacing(world, pos, Direction.DOWN))
                .setValue(NORTH, isBlockAvailableForPlacing(world, pos, Direction.NORTH))
                .setValue(SOUTH, isBlockAvailableForPlacing(world, pos, Direction.SOUTH))
                .setValue(EAST, isBlockAvailableForPlacing(world, pos, Direction.EAST))
                .setValue(WEST, isBlockAvailableForPlacing(world, pos, Direction.WEST))
                .setValue(WATERLOGGED, fluidState.is(FluidTags.WATER) && fluidState.getAmount() == 8);
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(UP, DOWN, NORTH, SOUTH, EAST, WEST, WATERLOGGED);
    }

    @Override
    @Nonnull
    public Item asItem() {
        return super.asItem();
    }

    @SuppressWarnings("deprecation")
    @Override
    public boolean canSurvive(@Nonnull BlockState state, @Nonnull LevelReader levelReader, @Nonnull BlockPos blockPos) {
        return checkCanBePlaced(levelReader, blockPos);
    }

    @SuppressWarnings("deprecation")
    @Override
    public boolean canBeReplaced(@Nonnull BlockState blockState, @Nonnull BlockPlaceContext placeContext) {
        return checkCanBePlaced(
                placeContext.getLevel(),
                placeContext.getClickedPos().relative(placeContext.getClickedFace())) &&
                super.canBeReplaced(blockState, placeContext);
    }

    private static boolean isBlockAvailableForPlacing(LevelReader world, BlockPos pos, Direction facing) {
        BlockState state = world.getBlockState(pos.relative(facing));
        LOGGER.debug("{} {}", facing, AVAILABLE_MATERIALS.contains(state.getMaterial()));
        return AVAILABLE_MATERIALS.contains(state.getMaterial());
    }

    private static boolean checkCanBePlaced(@NotNull LevelReader levelReader, @NotNull BlockPos blockPos) {
        return Direction.Plane.HORIZONTAL.stream()
                .anyMatch(direction -> isBlockAvailableForPlacing(levelReader, blockPos, direction)) ||
                isBlockAvailableForPlacing(levelReader, blockPos, Direction.DOWN);
    }
}
