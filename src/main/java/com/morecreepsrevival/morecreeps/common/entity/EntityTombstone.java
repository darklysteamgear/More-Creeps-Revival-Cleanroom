package com.morecreepsrevival.morecreeps.common.entity;

import com.morecreepsrevival.morecreeps.common.items.CreepsItemHandler;
import com.morecreepsrevival.morecreeps.common.sounds.CreepsSoundHandler;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.function.Function;
import java.util.function.Supplier;

public class EntityTombstone extends EntityCreepBase {

    private NBTTagCompound additionalProps;
    private TombstoneType type;

    public EntityTombstone(World worldIn) {
        super(worldIn);
        additionalProps = new NBTTagCompound();
    }

    public EntityTombstone(World worldIn, EntityCreepBase deadEntity) {
        this(worldIn);

        creatureType = EnumCreatureType.AMBIENT;
        experienceValue = 0;
        setLocationAndAngles(deadEntity.posX, deadEntity.posY, deadEntity.posZ, deadEntity.rotationYaw, 0.0f);
        baseSpeed = 0.0d;
        setBaseTexture(deadEntity.getBaseTexture());
        setLevel(deadEntity.getLevel());
        setExperience(deadEntity.getExperience());
        setTotalDamage(deadEntity.getTotalDamage());
        setArmor(deadEntity.getArmor());
        setInterest(deadEntity.getInterest());
        setOwner(deadEntity.getOwnerId());
        setWanderState(deadEntity.getWanderState());
        setHealthBoost(deadEntity.getHealthBoost());
        setSkillAttack(deadEntity.getSkillAttack());
        setSkillDefend(deadEntity.getSkillDefend());
        setSkillHealing(deadEntity.getSkillHealing());
        setSkillSpeed(deadEntity.getSkillSpeed());
        type = TombstoneType.getTombstoneType(deadEntity.getClass());

        deadEntity.onTombstoneCreate(additionalProps);

        updateAttributes();
    }

    @Override
    protected void initEntityAI() {
        clearAITasks();
    }

    @Override
    protected SoundEvent getAmbientSound() {
        if (rand.nextInt(10) == 0) {
            return CreepsSoundHandler.tombstoneSound;
        }

        return null;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource damageSource) {
        return null;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return null;
    }

    @Override
    public boolean isEntityInsideOpaqueBlock() {
        return false;
    }

    @Override
    public int getMaxSpawnedInChunk() {
        return 1;
    }

    @Override
    public boolean canDespawn() {
        return false;
    }

    @Override
    public boolean processInteract(EntityPlayer player, EnumHand hand) {
        ItemStack itemStack = player.getHeldItem(hand);

        if (itemStack.isEmpty() || itemStack.getItem() != CreepsItemHandler.lifeGem) {
            if (!world.isRemote) {
                player.sendMessage(new TextComponentString("Use a \2474LifeGem\247f on this tombstone to bring your pet back to life!"));
            }

            return true;
        } else if (!isPlayerOwner(player)) {
            if (!world.isRemote) {
                player.sendMessage(new TextComponentString("This is not your tamed pet!"));
            }

            return true;
        }

        itemStack.shrink(1);

        player.swingArm(hand);

        smoke();

        if (!world.isRemote && this.type != null) {
            EntityCreepBase entity = this.type.getNewInstance().apply(getEntityWorld());

            if (entity != null) {
                entity.setPositionAndRotation(player.posX, player.posY, player.posZ, player.rotationYaw, player.rotationPitch);
                entity.setBaseTexture(getBaseTexture());
                entity.setLevel(Math.max(1, getLevel() - 1));
                if(hasCustomName()) entity.setCustomNameTag(getCustomNameTag());
                entity.setExperience(getExperience());
                entity.setTotalDamage(getTotalDamage());
                entity.setArmor(getArmor());
                entity.setInterest(getInterest());
                entity.setOwner(getOwnerId());
                entity.setWanderState(getWanderState());
                entity.setHealthBoost(getHealthBoost());
                entity.setSkillAttack(getSkillAttack());
                entity.setSkillDefend(getSkillDefend());
                entity.setSkillHealing(getSkillHealing());
                entity.setSkillSpeed(getSkillSpeed());
                entity.onRevive(additionalProps);
                entity.setInitialHealth();
                world.spawnEntity(entity);
                setDead();
            }
        }

        return true;
    }

    @Override
    protected void updateTexture() {
        setTexture("textures/entity/tombstone.png");
    }

    @Override
    public void onLivingUpdate() {
        motionX = 0.0d;
        motionY = 0.0d;
        motionZ = 0.0d;

        super.onLivingUpdate();
    }

    @Override
    public void writeEntityToNBT(NBTTagCompound compound) {
        super.writeEntityToNBT(compound);

        compound.setTag("MoreCreepsTombstone", additionalProps);
        compound.setString("MoreCreepsTombstoneType", this.type.name());
    }

    @Override
    public void readEntityFromNBT(NBTTagCompound compound) {
        super.readEntityFromNBT(compound);

        additionalProps = compound.getCompoundTag("MoreCreepsTombstone");
        this.type = TombstoneType.valueOf(compound.getString("MoreCreepsTombstoneType"));
    }

    @Override
    public boolean attackEntityFrom(@Nullable DamageSource damageSource, float amt) {
        return false;
    }

    private enum TombstoneType {

        GUINEA_PIG(EntityGuineaPig.class, EntityGuineaPig::new),
        HOTDOG(EntityHotdog.class, EntityHotdog::new);

        private final Class<? extends Entity> entityClass;
        private final Function<World, EntityCreepBase> newInstance;

        TombstoneType(Class<? extends Entity> entityClass, Function<World, EntityCreepBase> newInstance) {
            this.entityClass = entityClass;
            this.newInstance = newInstance;
        }

        public Class<? extends Entity> getEntityClass() {
            return entityClass;
        }

        public Function<World, EntityCreepBase> getNewInstance() {
            return newInstance;
        }

        public static TombstoneType getTombstoneType(Class<? extends Entity> entityClass) {
            for (TombstoneType type : TombstoneType.values()) {
                if (type.getEntityClass() == entityClass) {
                    return type;
                }
            }

            return null;
        }

    }

}
