package com.morecreepsrevival.morecreeps.common.entity;

import net.minecraft.world.World;

public class EntityArmyGuy extends EntityCreepBase implements IEntityCanChangeSize {
    public EntityArmyGuy(World world) {
        super(world);
    }

    public void setLoyal(boolean loyal) {
        //TODO: implement this method.
    }

    @Override
    public float maxShrink() {
        return 0.4f;
    }

    @Override
    public float getRayAmount() {
        return 0.2f;
    }

    @Override
    public float maxGrowth() {
        return 4.0f;
    }

    @Override
    public void onGrow(EntityGrow source) {
        setLoyal(false);
    }

}
