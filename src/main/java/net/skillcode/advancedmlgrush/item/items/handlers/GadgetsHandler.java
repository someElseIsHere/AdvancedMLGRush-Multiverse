package net.skillcode.advancedmlgrush.item.items.handlers;

import com.google.inject.Inject;
import net.skillcode.advancedmlgrush.config.configs.MessageConfig;
import net.skillcode.advancedmlgrush.event.EventHandler;
import net.skillcode.advancedmlgrush.event.EventListener;
import net.skillcode.advancedmlgrush.inventory.inventories.GadgetsInventory;
import net.skillcode.advancedmlgrush.item.EnumItem;
import net.skillcode.advancedmlgrush.item.ItemUtils;
import net.skillcode.advancedmlgrush.sql.data.SQLDataCache;
import org.bukkit.entity.Player;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.Optional;

public class GadgetsHandler implements EventHandler {

    @Inject
    private ItemUtils itemUtils;
    @Inject
    private GadgetsInventory gadgetsInventory;
    @Inject
    private MessageConfig messageConfig;
    @Inject
    private SQLDataCache sqlDataCache;

    @Override
    public void registerListeners(final @NotNull List<EventListener<?>> eventListeners) {
        eventListeners.add(onRightClick());
    }

    private EventListener<PlayerInteractEvent> onRightClick() {
        return new EventListener<PlayerInteractEvent>(PlayerInteractEvent.class) {
            @Override
            protected void onEvent(final @NotNull PlayerInteractEvent event) {
                if (event.getAction() == Action.RIGHT_CLICK_AIR
                        || event.getAction() == Action.RIGHT_CLICK_BLOCK) {

                    final Player player = event.getPlayer();
                    final ItemStack clickedItem = player.getItemInHand();

                    if (itemUtils.compare(clickedItem, EnumItem.GADGETS, Optional.of(player))) {
                        if (!sqlDataCache.isLoaded(player)) {
                            player.sendMessage(messageConfig.getWithPrefix(Optional.of(player), MessageConfig.LOADING_DATA));
                        } else {
                            gadgetsInventory.open(player);
                        }
                    }
                }
            }
        };

    }

}
