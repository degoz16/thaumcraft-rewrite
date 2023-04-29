package com.degoz.thaumcraft.common.items.items;

import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;

import javax.annotation.Nonnull;
import java.util.List;

public class SalisMundusItem extends Item {
    public SalisMundusItem(Properties p_41383_) {
        super(p_41383_);
    }

    @Nonnull
    @Override
    public InteractionResult useOn(@Nonnull UseOnContext useOnContext) {
        useOnContext.getClickLocation();
        return super.useOn(useOnContext);
    }

}
