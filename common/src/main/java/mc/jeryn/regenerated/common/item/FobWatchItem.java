package mc.jeryn.regenerated.common.item;

import mc.jeryn.regenerated.common.data.player.RegeneratedEntityData;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class FobWatchItem extends Item {

    public FobWatchItem(Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand usedHand) {
        RegeneratedEntityData.get(player).ifPresent(regeneratedEntityData -> {
            regeneratedEntityData.setRemainingRegenerations(12);
        });
        return super.use(level, player, usedHand);
    }
}
