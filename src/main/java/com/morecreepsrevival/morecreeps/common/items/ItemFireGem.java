package com.morecreepsrevival.morecreeps.common.items;

import com.morecreepsrevival.morecreeps.common.entity.*;
import com.morecreepsrevival.morecreeps.common.sounds.CreepsSoundHandler;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumHand;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.world.World;

import javax.annotation.Nonnull;

public class ItemFireGem extends CreepsItem {
    public ItemFireGem() {
        super("fire_gem");
        setMaxStackSize(1);
        setMaxDamage(64);
    }

    @Override
    @Nonnull
    public ActionResult<ItemStack> onItemRightClick(World world, EntityPlayer player, @Nonnull EnumHand hand) {
        player.playSound(CreepsSoundHandler.fireGemSound, 1.0f, 1.0f);
        player.getHeldItem(hand).damageItem(1, player);
        player.swingArm(hand);

        for (EntityLivingBase entity : world.getEntitiesWithinAABB(EntityLivingBase.class,
                new AxisAlignedBB(player.posX - 5, player.posY - 5, player.posZ - 5,
                                    player.posX + 5, player.posY + 5, player.posZ + 5)
        )) {
            if ((entity instanceof EntityCreepBaseOwnable && ((EntityCreepBaseOwnable) entity).isTamed()) || entity instanceof EntityHunchback || entity instanceof EntityPlayer || entity instanceof EntityPreacher) {
                continue;
            }

            for (int i = 0; i < 10; i++) {
                double d = itemRand.nextGaussian() * 0.02D;
                double d1 = itemRand.nextGaussian() * 0.02D;
                double d2 = itemRand.nextGaussian() * 0.02D;
                world.spawnParticle(EnumParticleTypes.SMOKE_NORMAL, entity.posX + (double) (itemRand.nextFloat() * 1.5F), entity.posY + 0.5D + (double) (itemRand.nextFloat() * 2.5F), entity.posZ + (double) (itemRand.nextFloat() * 1.5F), d, d1, d2);
            }

            entity.attackEntityFrom(DamageSource.IN_FIRE, 2.0f);
            entity.motionY += 0.5d;
            entity.setFire(15);
        }

        return super.onItemRightClick(world, player, hand);
    }
}
