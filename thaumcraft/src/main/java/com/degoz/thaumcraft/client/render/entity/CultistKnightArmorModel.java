package com.degoz.thaumcraft.client.render.entity;

import com.degoz.thaumcraft.Thaumcraft;
import com.degoz.thaumcraft.common.items.items.CultistKnightArmorItem;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class CultistKnightArmorModel extends AnimatedGeoModel<CultistKnightArmorItem> {
    @Override
    public ResourceLocation getModelResource(CultistKnightArmorItem object) {
        return new ResourceLocation(Thaumcraft.MOD_ID, "geo/cultist_knight_armor.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(CultistKnightArmorItem object) {
        return new ResourceLocation(Thaumcraft.MOD_ID, "textures/models/armor/cultist_knight_armor.png");
    }

    @Override
    public ResourceLocation getAnimationResource(CultistKnightArmorItem animatable) {
        return new ResourceLocation(Thaumcraft.MOD_ID, "animations/cultist_knight_armor_animation.json");
    }
}
