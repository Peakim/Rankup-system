package org.peakimo.rankupsystem.Jobs.Police;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

public class giverp implements CommandExecutor {

    @Override
    public boolean onCommand (CommandSender sender, Command command, String label,String[] args) {



        Player targetPlayer = Bukkit.getPlayer(args[1]);
        PlayerInventory inventorytarget = targetPlayer.getInventory();
        String playertargetname = targetPlayer.getName();


        // Respect point Item
        ArrayList<String> LoreRespectPoint = new ArrayList<>();
        LoreRespectPoint.add(color("&7Respect point"));
        ItemStack respectpointR1 = new ItemStack(Material.GOLD_NUGGET, 1);
        ItemMeta respectpointMeta = (ItemMeta) respectpointR1.getItemMeta();
        respectpointMeta.setDisplayName(color("&c&lامتیاز رنک آپ"));


        //Set Meta
        respectpointMeta.setLore(LoreRespectPoint);
        respectpointR1.setItemMeta(respectpointMeta);
        
        if (!(sender instanceof Player)) {

            if (args.length >= 1 && args[0].equalsIgnoreCase("player")) {  // Player

                if (args.length != 2) {

                    sender.sendMessage(ChatColor.RED + "We dont have this player.");
                    return false;
                }

                if (targetPlayer == null || !targetPlayer.isOnline()) {
                    sender.sendMessage(ChatColor.RED + "Player is not online");
                    return true;
                }
                if (targetPlayer != null) {
                    targetPlayer.sendMessage(color("&7[&c&lRespect-Points&7] &aYou got 1 Respect point!"));

                    // AddItem
                    inventorytarget.addItem(respectpointR1);
                }
            }
            return true;
        }

        Player bazikon = (Player) sender;

        if (sender instanceof Player){
                if (bazikon.hasPermission("Rankup-system.admin.use")) {
                    if (args.length >= 1 && args[0].equalsIgnoreCase("player")) {  // Player

                        if (args.length != 2) {

                            sender.sendMessage(ChatColor.RED + "We dont have this player.");
                            return false;
                        }

                        if (targetPlayer == null || !targetPlayer.isOnline()) {
                            sender.sendMessage(ChatColor.RED + "Player is not online");
                            return true;
                        }
                        if (targetPlayer != null) {
                            targetPlayer.sendMessage(color("&7[&c&lRespect-Points&7] &aYou got 1 Respect point!"));

                            // AddItem
                            inventorytarget.addItem(respectpointR1);
                        }
                    }
                }
                }

                return true;
            }

            private String color (String str){
                //CodeColor
                return ChatColor.translateAlternateColorCodes('&', str);
                //CodeColor
            }
        }