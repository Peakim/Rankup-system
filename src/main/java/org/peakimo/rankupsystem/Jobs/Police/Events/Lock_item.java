package org.peakimo.rankupsystem.Jobs.Police.Events;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

public class Lock_item implements Listener {

    @EventHandler
    public void onInventoryClick(InventoryClickEvent event) {

        // Respect point Item
        ArrayList<String> LoreRespectPoint = new ArrayList<>();
        LoreRespectPoint.add(color("&7Respect point"));
        ItemStack respectpointR1 = new ItemStack(Material.GOLD_NUGGET, 1);
        ItemMeta respectpointMeta = (ItemMeta) respectpointR1.getItemMeta();
        respectpointMeta.setDisplayName(color("&c&lامتیاز رنک آپ"));
        Player bazikon = (Player) event.getWhoClicked();


        //Set Meta
        respectpointMeta.setLore(LoreRespectPoint);
        respectpointR1.setItemMeta(respectpointMeta);

        if (!event.getWhoClicked().hasPermission("Rankup-system.admin.use")) {

        if (event.getCurrentItem() != null && event.getCurrentItem().getType() == Material.GOLD_NUGGET && event.getCurrentItem().getItemMeta().getDisplayName().equals(color("&c&lامتیاز رنک آپ"))) {


                event.setCancelled(true);
        }
        if (event.getClick().isShiftClick() && event.getCurrentItem() != null && event.getCurrentItem().getType() == Material.GOLD_NUGGET && event.getCurrentItem().getItemMeta().getDisplayName().equals(color("&c&lامتیاز رنک آپ"))){

                event.setCancelled(true);

            }
    }


    }
    private String color (String str) {
        //CodeColor
        return ChatColor.translateAlternateColorCodes('&', str);
        //CodeColor
    }

    }

