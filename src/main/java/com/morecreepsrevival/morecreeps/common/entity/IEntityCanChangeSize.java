package com.morecreepsrevival.morecreeps.common.entity;

public interface IEntityCanChangeSize {

    /**
     * The amount a shrink/grow ray shrinks/grows this entity when it hits.
     */
    float getRayAmount();

    /**
     * The maximun size this entity can be.
     */
    float maxGrowth();

    /**
     * What happens when this entity grows.
     */
    default void onGrow(EntityGrow source) {}

    /**
     * The smallest size this entity can be.
     */
    float maxShrink();

    /**
     * What happens when this entity shrinks.
     */
    default void onShrink(EntityShrink source) {}
}
