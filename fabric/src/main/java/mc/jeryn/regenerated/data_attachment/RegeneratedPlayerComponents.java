package mc.jeryn.regenerated.data_attachment;

import mc.jeryn.regenerated.Regenerated;
import mc.jeryn.regenerated.common.data.player.fabric.RegeneratedEntityDataImpl;
import net.minecraft.resources.ResourceLocation;
import org.ladysnake.cca.api.v3.component.ComponentKey;
import org.ladysnake.cca.api.v3.component.ComponentRegistryV3;
import org.ladysnake.cca.api.v3.entity.EntityComponentFactoryRegistry;
import org.ladysnake.cca.api.v3.entity.EntityComponentInitializer;
import org.ladysnake.cca.api.v3.entity.RespawnCopyStrategy;

public class RegeneratedPlayerComponents implements EntityComponentInitializer {

    public static final ComponentKey<RegeneratedEntityDataImpl> REGENERATION_ENTITY_DATA_COMPONENT_KEY =
            ComponentRegistryV3.INSTANCE.getOrCreate(ResourceLocation.fromNamespaceAndPath(Regenerated.MOD_ID, "regenerated_data"), RegeneratedEntityDataImpl.class);

    @Override
    public void registerEntityComponentFactories(EntityComponentFactoryRegistry entityComponentFactoryRegistry) {
        entityComponentFactoryRegistry.registerForPlayers(REGENERATION_ENTITY_DATA_COMPONENT_KEY, RegeneratedEntityDataImpl::new, RespawnCopyStrategy.ALWAYS_COPY);
    }
}