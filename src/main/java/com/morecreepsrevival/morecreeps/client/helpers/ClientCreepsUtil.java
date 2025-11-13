package com.morecreepsrevival.morecreeps.client.helpers;

import net.minecraft.client.Minecraft;
import net.minecraft.client.particle.Particle;
import net.minecraft.client.particle.ParticleBreaking;
import net.minecraft.item.Item;
import net.minecraft.world.World;

public class ClientCreepsUtil {

    static ParticleBreaking.Factory eatingParticlesFactory = new ParticleBreaking.Factory();

    public static Particle spawnEatingParticle(
            World world, double xCoordIn, double yCoordIn, double zCoordIn,
            double xSpeedIn, double ySpeedIn, double zSpeedIn, float size, Item itemFodder) {
        if (Minecraft.getMinecraft().isGamePaused()) return null;

        Particle toSpawn = eatingParticlesFactory.createParticle(
                -1,
                world,
                xCoordIn,
                yCoordIn,
                zCoordIn,
                xSpeedIn,
                ySpeedIn,
                zSpeedIn,
                Item.getIdFromItem(itemFodder)
        );

        toSpawn.multipleParticleScaleBy(size);

        Minecraft.getMinecraft().effectRenderer.addEffect(toSpawn);

        return toSpawn;
    }

    public static void spawnEatingParticleRGB(
            World world, double xCoordIn, double yCoordIn, double zCoordIn,
            double xSpeedIn, double ySpeedIn, double zSpeedIn, float size,
            float colorRed, float colorGreen, float colorBlue, Item itemFodder) {
        if (Minecraft.getMinecraft().isGamePaused()) return;

        Particle toSpawn = eatingParticlesFactory.createParticle(
                -1,
                world,
                xCoordIn,
                yCoordIn,
                zCoordIn,
                xSpeedIn,
                ySpeedIn,
                zSpeedIn,
                Item.getIdFromItem(itemFodder)
        );

        toSpawn.multipleParticleScaleBy(size);
        toSpawn.setRBGColorF(colorRed, colorGreen, colorBlue);

        Minecraft.getMinecraft().effectRenderer.addEffect(toSpawn);
    }

}
