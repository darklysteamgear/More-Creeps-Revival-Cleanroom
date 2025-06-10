package com.morecreepsrevival.morecreeps.common.entity;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.world.World;

public class EntityGrow extends EntityShrink {

    public EntityGrow(World world) {
        super(world);
    }

    public EntityGrow(World world, EntityLivingBase entity) {
        super(world, entity);
    }

    @Override
    public void applyRay(EntityCreepBase entityCreep) {
        if(!(entityCreep instanceof IEntityCanChangeSize)) return;
        IEntityCanChangeSize entitySizable = (IEntityCanChangeSize) entityCreep;

        float currentSize = entityCreep.getModelSize();
        if (currentSize < entitySizable.maxGrowth()) {
            float grow = entitySizable.getRayAmount();
            entityCreep.growModelSize(grow, entitySizable.maxGrowth());

            // Calculate the difference between the old model size and new
            // Then, apply it to the hitbox size.
            float growthDifference = 100 - (currentSize * 100f / entityCreep.getModelSize());
            entityCreep.growHitboxSize(entityCreep.currentSize / 100f * growthDifference);

            entitySizable.onGrow(this);
        }
    }
}
