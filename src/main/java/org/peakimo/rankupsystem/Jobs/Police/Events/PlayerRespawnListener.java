package org.peakimo.rankupsystem.Jobs.Police.Events;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerRespawnEvent;
import org.bukkit.inventory.ItemStack;

import java.util.UUID;

public class PlayerRespawnListener implements Listener {

    @EventHandler
    public void onPlayerRespawn(PlayerRespawnEvent event) {

        if (event.getPlayer().hasPermission("essentials.keepinv")){ // Agar keep inventory dasht dupe nashavad
            return;
        }

        Player player = event.getPlayer();
        UUID playerId = player.getUniqueId();

        ItemStack[] savedStacks = PlayerDeath_KeepItem.savedItems.remove(playerId);

        if (savedStacks != null) {
            for (ItemStack stack : savedStacks) {
                if (stack != null) {
                    player.getInventory().addItem(stack);
                }
            }
        }
    }
}