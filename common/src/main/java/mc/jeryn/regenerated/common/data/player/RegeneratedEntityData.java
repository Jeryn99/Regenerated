package mc.jeryn.regenerated.common.data.player;

import dev.architectury.injectables.annotations.ExpectPlatform;
import mc.jeryn.regenerated.common.data.skin.RegeneratedSkinEntry;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.entity.LivingEntity;

import java.util.Optional;

public class RegeneratedEntityData implements Regen {

    private LivingEntity livingEntity;

    private int regenerations = 0;

    private Optional<RegeneratedSkinEntry> skinData = Optional.empty();

    public RegeneratedEntityData(LivingEntity livingEntity) {
        this.livingEntity = livingEntity;
    }

    @ExpectPlatform
    public static Optional<RegeneratedEntityData> get(LivingEntity livingEntity) {
        throw new RuntimeException();
    }


    public Optional<RegeneratedSkinEntry> getSkinData() {
        return skinData;
    }

    public void setSkinData(RegeneratedSkinEntry skinData) {
        this.skinData = Optional.ofNullable(skinData);
    }

    public LivingEntity getLivingEntity() {
        return livingEntity;
    }

    @Override
    public int remainingRegenerations() {
        return regenerations;
    }

    @Override
    public void setRemainingRegenerations(int regenerations) {
        this.regenerations = regenerations;
    }

    @Override
    public void addRemainingRegenerations(int regenerations) {
        this.regenerations += regenerations;
    }

    @Override
    public boolean shouldRenderCustomSkin() {
        return skinData.isPresent();
    }

    @Override
    public CompoundTag serializeNBT() {
        CompoundTag compoundTag = new CompoundTag();
        skinData.ifPresent(data -> compoundTag.put(RegeneratedEntityDataConstants.SKIN_DATA, data.serializeNBT()));
        compoundTag.putInt(RegeneratedEntityDataConstants.REMAINING_REGENERATIONS, regenerations);
        return compoundTag;
    }

    @Override
    public void deserializeNBT(CompoundTag arg) {
        if (arg.contains(RegeneratedEntityDataConstants.SKIN_DATA)) {
            RegeneratedSkinEntry data = new RegeneratedSkinEntry();
            data.deserializeNBT(arg.getCompound(RegeneratedEntityDataConstants.SKIN_DATA));
            skinData = Optional.of(data);
        } else {
            skinData = Optional.empty();
        }
        regenerations = arg.getInt(RegeneratedEntityDataConstants.REMAINING_REGENERATIONS);
    }
}
