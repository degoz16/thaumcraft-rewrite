package com.degoz.thaumcraft.client.render.entity;

import com.degoz.thaumcraft.common.items.items.CultistKnightArmorItem;
import software.bernie.geckolib3.renderers.geo.GeoArmorRenderer;

public class CultistKnightArmorRenderer extends GeoArmorRenderer<CultistKnightArmorItem> {
    public CultistKnightArmorRenderer() {
        super(new CultistKnightArmorModel());

        this.headBone = "armorHead";
        this.bodyBone = "armorBody";
        this.rightArmBone = "armorRightArm";
        this.leftArmBone = "armorLeftArm";
        this.rightLegBone = "armorLeftLeg";
        this.leftLegBone = "armorRightLeg";
        this.rightBootBone = "armorLeftBoot";
        this.leftBootBone = "armorRightBoot";
    }
}
