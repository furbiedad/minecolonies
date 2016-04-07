package com.minecolonies.util;

import com.minecolonies.lib.Constants;
import net.minecraft.entity.Entity;
import net.minecraft.world.World;

public class SoundHandler
{

    /**
     * @param world World to play sound in
     * @param name  Name of the sound to play
     * @param x     X-coordinate
     * @param y     Y-coordinate
     * @param z     Z-coordinate
     * @see {@link #playSound(World, String, double, double, double, float, float)}
     */
    public static void playSound(World world, String name, int x, int y, int z)
    {
        playSound(world, name, x + 0.5D, y + 0.5D, z + 0.5D, 1.0F, world.rand.nextFloat() * 0.1F + 0.9F);
    }

    /**
     * Plays a sound effect at a specific location.
     * Pitch and volume will be applied
     *
     * @param world  World to play sound in
     * @param name   Name of the sound
     * @param x      X-coordinate
     * @param y      Y-coordinate
     * @param z      Z-coordinate
     * @param volume Volume to play sound
     * @param pitch  Pitch to play sound
     */
    public static void playSound(World world, String name, double x, double y, double z, float volume, float pitch)
    {
        world.playSoundEffect(x, y, z, Constants.MOD_ID + ":" + name, volume, pitch);
    }

    /**
     * Plays sound near an entity
     *
     * @param entity Entity to play sound at
     * @param name   Name of the sound to play
     * @param volume Volume to play sound
     * @param pitch  Pitch to play sound
     */
    public static void playSoundAtEntity(Entity entity, String name, float volume, float pitch)
    {
        entity.worldObj.playSoundAtEntity(entity, Constants.MOD_ID + ":" + name, volume, pitch);
    }
}
