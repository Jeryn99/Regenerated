package mc.jeryn.regenerated.common.data.player;

import dev.architectury.injectables.annotations.ExpectPlatform;
import mc.jeryn.regenerated.common.data.skin.RegeneratedSkinEntry;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.entity.AnimationState;
import net.minecraft.world.entity.LivingEntity;

import java.util.Optional;

public class RegeneratedEntityData {

    // Don't write to Disk
    private final LivingEntity livingEntity;

    // Regeneration Information
    private int regenerations = 0;
    private RegenState regenState = RegenState.IDLE;

    // Animation Information
    private AnimationState regenerationAnim = new AnimationState();

    // Skin Information
    private Optional<RegeneratedSkinEntry> skinData = Optional.empty();


    public RegeneratedEntityData(LivingEntity livingEntity) {
        this.livingEntity = livingEntity;
    }

    @ExpectPlatform
    public static Optional<RegeneratedEntityData> get(LivingEntity livingEntity) {
        throw new RuntimeException();
    }

    public void tick(){
        if(getRegenState() == RegenState.REGENERATING){
            regenerationAnim.startIfStopped(livingEntity.tickCount);
        }
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

    
    public int remainingRegenerations() {
        return regenerations;
    }

    
    public void setRemainingRegenerations(int regenerations) {
        this.regenerations = regenerations;
    }

    
    public void addRegeneration(int regenerations) {
        this.regenerations += regenerations;
    }

    
    public void removeRegeneration() {
        this.regenerations--;
    }

    
    public boolean shouldRenderCustomSkin() {
        return skinData.isPresent();
    }

    
    public RegenState getRegenState() {
        return regenState;
    }

    
    public void setRegenState(RegenState regenState) {
        this.regenState = regenState;
    }

    
    public CompoundTag serializeNBT() {
        CompoundTag compoundTag = new CompoundTag();
        skinData.ifPresent(data -> compoundTag.put(RegeneratedEntityDataConstants.SKIN_DATA, data.serializeNBT()));
        compoundTag.putInt(RegeneratedEntityDataConstants.REMAINING_REGENERATIONS, regenerations);
        compoundTag.putString(RegeneratedEntityDataConstants.REGEN_STATUS, regenState.getStatus());
        return compoundTag;
    }

    
    public void deserializeNBT(CompoundTag arg) {
        if (arg.contains(RegeneratedEntityDataConstants.SKIN_DATA)) {
            RegeneratedSkinEntry data = new RegeneratedSkinEntry();
            data.deserializeNBT(arg.getCompound(RegeneratedEntityDataConstants.SKIN_DATA));
            skinData = Optional.of(data);
        } else {
            skinData = Optional.empty();
        }
        regenerations = arg.getInt(RegeneratedEntityDataConstants.REMAINING_REGENERATIONS);
        regenState = RegenState.find(arg.getString(RegeneratedEntityDataConstants.REGEN_STATUS));
    }
}
