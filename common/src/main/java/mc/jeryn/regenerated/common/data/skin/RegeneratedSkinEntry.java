package mc.jeryn.regenerated.common.data.skin;

import mc.jeryn.regenerated.common.data.Serializable;
import net.minecraft.nbt.CompoundTag;

public class RegeneratedSkinEntry implements Serializable {

    private byte[] skinData;
    private boolean isAlex = true;

    public RegeneratedSkinEntry() {}

    public RegeneratedSkinEntry(byte[] skinData, boolean isAlex) {
        this.skinData = skinData;
        this.isAlex = isAlex;
    }

    public boolean isAlex() {
        return isAlex;
    }

    public byte[] getSkinData() {
        return skinData;
    }

    @Override
    public CompoundTag serializeNBT() {
        CompoundTag tag = new CompoundTag();
        tag.putByteArray("skinData", skinData);
        tag.putBoolean("isAlex", isAlex);
        return tag;
    }

    @Override
    public void deserializeNBT(CompoundTag tag) {
        if (tag.contains("skinData")) {
            this.skinData = tag.getByteArray("skinData");
        }
        if (tag.contains("isAlex")) {
            this.isAlex = tag.getBoolean("isAlex");
        }
    }
}