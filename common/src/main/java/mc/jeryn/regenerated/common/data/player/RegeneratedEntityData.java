package mc.jeryn.regenerated.common.data.player;

import mc.jeryn.regenerated.common.data.skin.RegeneratedSkinData;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.entity.LivingEntity;

/**
 * Represents data related to the regeneration of a living entity.
 *
 * @author Jeryn99
 */
public class RegeneratedEntityData implements Regen {

    /**
     * The number of regenerations remaining for the entity.
     */
    private int regenerations = 0;

    /**
     * The living entity associated with this regeneration data.
     */
    private LivingEntity livingEntity;

    /**
     * The skin data for the entity's regeneration.
     */
    private RegeneratedSkinData skinData = new RegeneratedSkinData();

    /**
     * Constructs a new RegenerationEntityData instance for the given living entity.
     *
     * @param livingEntity the living entity to associate with this regeneration data
     */
    public RegeneratedEntityData(LivingEntity livingEntity) {
        this.livingEntity = livingEntity;
    }

    /**
     * Returns the skin data for the entity's regeneration.
     *
     * @return the skin data
     */
    public RegeneratedSkinData getSkinData() {
        return skinData;
    }

    /**
     * Returns the living entity associated with this regeneration data.
     *
     * @return the living entity
     */
    public LivingEntity getLivingEntity() {
        return livingEntity;
    }

    /**
     * Returns the number of regenerations remaining for the entity.
     *
     * @return the number of regenerations remaining
     */
    @Override
    public int remainingRegenerations() {
        return regenerations;
    }

    /**
     * Sets the number of regenerations remaining for the entity.
     *
     * @param regenerations the new number of regenerations remaining
     */
    @Override
    public void setRemainingRegenerations(int regenerations) {
        this.regenerations = regenerations;
    }

    /**
     * Adds to the number of regenerations remaining for the entity.
     *
     * @param regenerations the number of regenerations to add
     */
    @Override
    public void addRemainingRegenerations(int regenerations) {
        this.regenerations += regenerations; // Note: I fixed the typo here
    }

    /**
     * Serializes this regeneration data to a CompoundTag.
     *
     * @return the serialized CompoundTag
     */
    @Override
    public CompoundTag serializeNBT() {
        CompoundTag compoundTag = new CompoundTag();
        compoundTag.put(RegeneratedEntityDataConstants.SKIN_DATA, skinData.serializeNBT());
        compoundTag.putInt(RegeneratedEntityDataConstants.REMAINING_REGENERATIONS, regenerations);
        return compoundTag;
    }

    /**
     * Deserializes regeneration data from a CompoundTag.
     *
     * @param arg the CompoundTag to deserialize from
     */
    @Override
    public void deserializeNBT(CompoundTag arg) {
        skinData.deserializeNBT(arg.getCompound(RegeneratedEntityDataConstants.SKIN_DATA));
        regenerations = arg.getInt(RegeneratedEntityDataConstants.REMAINING_REGENERATIONS);
    }
}