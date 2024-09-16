package mc.jeryn.regenerated.common.data.skin;

import mc.jeryn.regenerated.common.data.Serializable;
import net.minecraft.nbt.CompoundTag;

/**
 * Represents data related to the regenerated skin of a player.
 *
 * @author Jeryn99
 */
public class RegeneratedSkinData implements Serializable {

    /**
     * The current skin entry for the player.
     */
    private RegeneratedSkinEntry currentSkin;

    /**
     * Sets the current skin entry for the player.
     *
     * @param skinEntry the new skin entry
     */
    public void setCurrentSkin(RegeneratedSkinEntry skinEntry) {
        this.currentSkin = skinEntry;
    }

    /**
     * Resets the current skin entry for the player.
     */
    public void resetCurrentSkin() {
        this.currentSkin = null;
    }

    /**
     * Serializes this skin data to a CompoundTag.
     *
     * @return the serialized CompoundTag
     */
    @Override
    public CompoundTag serializeNBT() {
        CompoundTag compoundTag = new CompoundTag();
        if (currentSkin != null) {
            compoundTag.putString("SkinBase64", currentSkin.getSkinBase64());
            compoundTag.putBoolean("IsAlex", currentSkin.isAlex());
        }
        return compoundTag;
    }

    /**
     * Deserializes skin data from a CompoundTag.
     *
     * @param arg the CompoundTag to deserialize from
     */
    @Override
    public void deserializeNBT(CompoundTag arg) {
        if (arg.contains("SkinBase64") && arg.contains("IsAlex")) {
            String skinBase64 = arg.getString("SkinBase64");
            boolean isAlex = arg.getBoolean("IsAlex");
            this.currentSkin = new RegeneratedSkinEntry(skinBase64, isAlex);
        } else {
            this.currentSkin = null;
        }
    }
}