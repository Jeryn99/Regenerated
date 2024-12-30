package mc.jeryn.regenerated.common.data.player;

import mc.jeryn.regenerated.common.data.Serializable;
import mc.jeryn.regenerated.common.data.skin.RegeneratedSkinEntry;

import java.util.Optional;

public interface Regen extends Serializable {

    Optional<RegeneratedSkinEntry> getSkinData();

    void setSkinData(RegeneratedSkinEntry skinData);

    int remainingRegenerations();
    void setRemainingRegenerations(int regenerations);
    void addRemainingRegenerations(int regenerations);
    boolean shouldRenderCustomSkin();

}
