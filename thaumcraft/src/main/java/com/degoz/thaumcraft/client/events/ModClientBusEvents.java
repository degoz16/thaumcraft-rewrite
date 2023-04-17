package com.degoz.thaumcraft.client.events;

import com.degoz.thaumcraft.Thaumcraft;
import com.degoz.thaumcraft.client.render.entity.CultistKnightArmorRenderer;
import com.degoz.thaumcraft.common.items.items.CultistKnightArmorItem;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import software.bernie.geckolib3.renderers.geo.GeoArmorRenderer;

@Mod.EventBusSubscriber(modid = Thaumcraft.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ModClientBusEvents {
    @SubscribeEvent
    public static void registerArmorRenderers(final EntityRenderersEvent.AddLayers event) {
        GeoArmorRenderer.registerArmorRenderer(CultistKnightArmorItem.class, CultistKnightArmorRenderer::new);
    }
}
