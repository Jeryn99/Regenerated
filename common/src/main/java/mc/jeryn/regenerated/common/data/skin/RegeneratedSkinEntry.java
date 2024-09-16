package mc.jeryn.regenerated.common.data.skin;

import net.minecraft.client.multiplayer.PlayerInfo;
import net.minecraft.client.resources.DefaultPlayerSkin;
import net.minecraft.client.resources.PlayerSkin;

public class RegeneratedSkinEntry  {

    private String skinBase64;
    private boolean isAlex;

    public RegeneratedSkinEntry(String skinBase64, boolean isAlex) {
        super();
        this.skinBase64 = skinBase64;
        this.isAlex = isAlex;
    }

    public boolean isAlex() {
        return isAlex;
    }

    public String getSkinBase64() {
        return skinBase64;
    }
}
