package com.degoz.thaumcraft.common.items.items;

import net.minecraft.client.Minecraft;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Pose;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.Item;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.PlayState;
import software.bernie.geckolib3.core.builder.AnimationBuilder;
import software.bernie.geckolib3.core.controller.AnimationController;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.manager.AnimationData;
import software.bernie.geckolib3.core.manager.AnimationFactory;
import software.bernie.geckolib3.item.GeoArmorItem;
import software.bernie.geckolib3.util.GeckoLibUtil;

public class CultistKnightArmorItem extends GeoArmorItem implements IAnimatable {
    private static final Logger LOGGER = LogManager.getLogger();
    private final AnimationFactory factory = GeckoLibUtil.createFactory(this);

    public CultistKnightArmorItem(ArmorMaterial material, EquipmentSlot slot, Item.Properties settings) {
        super(material, slot, settings);
    }

    @Override
    public void registerControllers(AnimationData data) {
        data.addAnimationController(new AnimationController<>(this, "controller",
                10, this::predicate));
    }

    @Override
    public AnimationFactory getFactory() {
        return this.factory;
    }

    private <P extends IAnimatable> PlayState predicate(AnimationEvent<P> event) {
        event.getController().setAnimationSpeed(1);

        LivingEntity livingEntity = event.getExtraDataOfType(LivingEntity.class).get(0);
        var partialTick = Minecraft.getInstance().getPartialTick();
        var limbSwingAmount = Mth.lerp(partialTick, livingEntity.animationSpeedOld, livingEntity.animationSpeed);
        event.getController().setAnimationSpeed(1d);
        // LOGGER.debug(Optional.ofNullable(event.getController().getCurrentAnimation()).map(o -> o.animationName));
        if (limbSwingAmount > 0.2f || limbSwingAmount < -0.2f) {
            if (livingEntity.getPose() == Pose.CROUCHING) {
                event.getController().setAnimation(new AnimationBuilder().addAnimation("armor.knight.walk_crouch"));
            } else {
                event.getController().setAnimation(new AnimationBuilder().addAnimation("armor.knight.walk"));
            }
        } else {
            if (livingEntity.getPose() == Pose.CROUCHING) {
                event.getController().setAnimation(new AnimationBuilder().addAnimation("armor.knight.idle_crouch"));
            } else {
                event.getController().setAnimation(new AnimationBuilder().addAnimation("armor.knight.idle"));
            }
        }

        return PlayState.CONTINUE;
    }

}
