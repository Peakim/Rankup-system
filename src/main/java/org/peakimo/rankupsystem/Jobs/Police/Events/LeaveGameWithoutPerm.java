package org.peakimo.rankupsystem.Jobs.Police.Events;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

public class LeaveGameWithoutPerm implements Listener {

    @EventHandler
    public void PlayerQuit(PlayerQuitEvent event){

        Player bazikon = event.getPlayer();
        Inventory inventory = bazikon.getInventory();
        ItemStack[] contents = event.getPlayer().getInventory().getContents();

        // Respect point Item
        ArrayList<String> LoreRespectPoint = new ArrayList<>();
        LoreRespectPoint.add(color("&7Respect point"));
        ItemStack respectpointR1 = new ItemStack(Material.GOLD_NUGGET, 1);
        ItemMeta respectpointMeta = (ItemMeta) respectpointR1.getItemMeta();
        respectpointMeta.setDisplayName(color("&c&lامتیاز رنک آپ"));


        //Set Meta
        respectpointMeta.setLore(LoreRespectPoint);
        respectpointR1.setItemMeta(respectpointMeta);

        if (!bazikon.hasPermission("rankup-system.use")) {

            for (ItemStack item : contents) {
                if (item != null && item.getType() == Material.GOLD_NUGGET && item.hasItemMeta() && item.getItemMeta().hasDisplayName() && item.getItemMeta().getDisplayName().equals(color("&c&lامتیاز رنک آپ"))) {

                    event.getPlayer().getInventory().remove(item);


                }
            }
        }


    }

    private String color (String str) {
        //CodeColor
        return ChatColor.translateAlternateColorCodes('&', str);
        //CodeColor
    }
}
