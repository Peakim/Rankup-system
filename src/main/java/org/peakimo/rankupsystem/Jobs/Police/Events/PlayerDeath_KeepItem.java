package org.peakimo.rankupsystem.Jobs.Police.Events;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerRespawnEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.peakimo.rankupsystem.Rankup_system;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class PlayerDeath_KeepItem implements Listener {
    private final Material specialItem;
    private final String specialItemDisplayName;
    public static final Map<UUID, ItemStack[]> savedItems = new HashMap<>();

    public PlayerDeath_KeepItem(Rankup_system plugin) {
        this.specialItem = plugin.getSpecialItem();
        this.specialItemDisplayName = plugin.getSpecialItemDisplayName();
    }

    @EventHandler
    public void onPlayerDeath(PlayerDeathEvent event) {

        if (event.getEntity().hasPermission("essentials.keepinv")){ // Agar keep inventory dasht dupe nashavad
            return;
        }


        Player player = event.getEntity();
        ItemStack[] inventoryContents = player.getInventory().getContents();
        ItemStack[] savedStacks = new ItemStack[64];
        int index = 0;

        for (ItemStack item : inventoryContents) {
            if (item != null && item.getType() == specialItem && item.hasItemMeta()) {
                ItemMeta itemMeta = item.getItemMeta();
                if (itemMeta != null && itemMeta.getDisplayName().equals(color(specialItemDisplayName))) {
                    savedStacks[index++] = item.clone();
                    event.getDrops().remove(item);
                }
            }
        }

        if (index > 0) {
            ItemStack[] trimmedSavedStacks = new ItemStack[index];
            System.arraycopy(savedStacks, 0, trimmedSavedStacks, 0, index);
            savedItems.put(player.getUniqueId(), trimmedSavedStacks);
        }
    }
    private String color (String str){
        //CodeColor
        return ChatColor.translateAlternateColorCodes('&', str);
        //CodeColor
    }
}
