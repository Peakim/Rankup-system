package org.peakimo.rankupsystem.Jobs.Police.Events;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.peakimo.rankupsystem.Rankup_system;

public class CancelCommand implements Listener {

    private Rankup_system instance = Rankup_system.getInstance();

    @EventHandler
    public void onPlayerCommand(PlayerCommandPreprocessEvent event) {

        String command = event.getMessage().toLowerCase();
        String disablecommand = instance.getConfig().getString("disable-command");

        // بررسی فرمان ah
        if (command.startsWith(disablecommand)) {
            // بررسی اینکه آیا بازیکن امتیاز در دست دارد
            if (event.getPlayer().getInventory().getItemInMainHand().getType() == Material.GOLD_NUGGET && event.getPlayer().getInventory().getItemInMainHand().getItemMeta().getDisplayName().equals(color("&c&lامتیاز رنک آپ"))) {
                event.setCancelled(true); // لغو فرمان
                event.getPlayer().sendMessage(color("&cYou cannot use this command when respect point in your hand!")); // پیام به بازیکن
            }
        }
    }
    private String color (String str) {
        //CodeColor
        return ChatColor.translateAlternateColorCodes('&', str);
        //CodeColor
    }
}
