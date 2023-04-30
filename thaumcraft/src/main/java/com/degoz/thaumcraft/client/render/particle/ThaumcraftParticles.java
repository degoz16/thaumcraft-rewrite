package com.degoz.thaumcraft.client.render.particle;

import com.degoz.thaumcraft.Thaumcraft;
import net.minecraft.core.particles.ParticleType;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ThaumcraftParticles {
  public static final DeferredRegister<ParticleType<?>> PARTICLE_TYPES =
      DeferredRegister.create(ForgeRegistries.PARTICLE_TYPES, Thaumcraft.MOD_ID);

  public static final RegistryObject<SimpleParticleType> MAGIC_DOTS_PARTICLES =
      PARTICLE_TYPES.register("magic_dots_particles", () -> new SimpleParticleType(true));

  public static void register(IEventBus eventBus) {
    PARTICLE_TYPES.register(eventBus);
  }
}
