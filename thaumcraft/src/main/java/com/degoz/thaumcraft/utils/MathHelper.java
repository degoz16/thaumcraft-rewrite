package com.degoz.thaumcraft.utils;

import net.minecraft.util.RandomSource;

import java.util.Random;

public class MathHelper {
    public static int getInt(RandomSource random, int i, int j) {
        return i >= j ? i : random.nextInt(j - i + 1) + i;
    }
}
