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
import org.peakimo.rankupsystem.Rankup_system;

import java.util.ArrayList;

public class Rankup implements CommandExecutor {

    public Rankup_system instance = Rankup_system.getInstance();

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        Player bazikon = (Player) sender;
        PlayerInventory inventorytarget = bazikon.getInventory();
        String playerName = bazikon.getName();

        // Rankup Pd 1

        int rankup1pd_point = instance.getConfig().getInt("rankup1pd-point");
        String rankup1pd_name = instance.getConfig().getString("rankup1pd-name");
        String rankup1pd_message = color(instance.getConfig().getString("rankup1pd-message"));
        String rankup1pd_notenough_message = color(instance.getConfig().getString("rankup1pd-notenough-message"));

        String rankup1pd_command1 = instance.getConfig().getString("rankup1pd-command1");
        String rankup1pd_command2 = instance.getConfig().getString("rankup1pd-command2");

        String rankup1pd_command1_CP = rankup1pd_command1.replace("%PLAYER%",bazikon.getPlayer().getName());
        String rankup1pd_command2_CP = rankup1pd_command2.replace("%PLAYER%",bazikon.getPlayer().getName());

        // Rankup Pd  2

        int rankup2pd_point = instance.getConfig().getInt("rankup2pd-point");
        String rankup2pd_name = instance.getConfig().getString("rankup2pd-name");
        String rankup2pd_message = color(instance.getConfig().getString("rankup2pd-message"));
        String rankup2pd_notenough_message = color(instance.getConfig().getString("rankup2pd-notenough-message"));

        String rankup2pd_command1 = instance.getConfig().getString("rankup2pd-command1");
        String rankup2pd_command2 = instance.getConfig().getString("rankup2pd-command2");

        String rankup2pd_command1_CP = rankup2pd_command1.replace("%PLAYER%",bazikon.getPlayer().getName());
        String rankup2pd_command2_CP = rankup2pd_command2.replace("%PLAYER%",bazikon.getPlayer().getName());

        // Rankup Pd 3

        int rankup3pd_point = instance.getConfig().getInt("rankup3pd-point");
        String rankup3pd_name = instance.getConfig().getString("rankup3pd-name");
        String rankup3pd_message = color(instance.getConfig().getString("rankup3pd-message"));
        String rankup3pd_notenough_message = color(instance.getConfig().getString("rankup3pd-notenough-message"));

        String rankup3pd_command1 = instance.getConfig().getString("rankup3pd-command1");
        String rankup3pd_command2 = instance.getConfig().getString("rankup3pd-command2");

        String rankup3pd_command1_CP = rankup3pd_command1.replace("%PLAYER%",bazikon.getPlayer().getName());
        String rankup3pd_command2_CP = rankup3pd_command2.replace("%PLAYER%",bazikon.getPlayer().getName());

        // Rankup Pd 4

        int rankup4pd_point = instance.getConfig().getInt("rankup4pd-point");
        String rankup4pd_name = instance.getConfig().getString("rankup4pd-name");
        String rankup4pd_message = color(instance.getConfig().getString("rankup4pd-message"));
        String rankup4pd_notenough_message = color(instance.getConfig().getString("rankup4pd-notenough-message"));

        String rankup4pd_command1 = instance.getConfig().getString("rankup4pd-command1");
        String rankup4pd_command2 = instance.getConfig().getString("rankup4pd-command2");

        String rankup4pd_command1_CP = rankup4pd_command1.replace("%PLAYER%",bazikon.getPlayer().getName());
        String rankup4pd_command2_CP = rankup4pd_command2.replace("%PLAYER%",bazikon.getPlayer().getName());

        // Rankup Pd 5

        int rankup5pd_point = instance.getConfig().getInt("rankup5pd-point");
        String rankup5pd_name = instance.getConfig().getString("rankup5pd-name");
        String rankup5pd_message = color(instance.getConfig().getString("rankup5pd-message"));
        String rankup5pd_notenough_message = color(instance.getConfig().getString("rankup5pd-notenough-message"));

        String rankup5pd_command1 = instance.getConfig().getString("rankup5pd-command1");
        String rankup5pd_command2 = instance.getConfig().getString("rankup5pd-command2");

        String rankup5pd_command1_CP = rankup5pd_command1.replace("%PLAYER%",bazikon.getPlayer().getName());
        String rankup5pd_command2_CP = rankup5pd_command2.replace("%PLAYER%",bazikon.getPlayer().getName());

        // Rankup Pd 6

        int rankup6pd_point = instance.getConfig().getInt("rankup6pd-point");
        String rankup6pd_name = instance.getConfig().getString("rankup6pd-name");
        String rankup6pd_message = color(instance.getConfig().getString("rankup6pd-message"));
        String rankup6pd_notenough_message = color(instance.getConfig().getString("rankup6pd-notenough-message"));

        String rankup6pd_command1 = instance.getConfig().getString("rankup6pd-command1");
        String rankup6pd_command2 = instance.getConfig().getString("rankup6pd-command2");

        String rankup6pd_command1_CP = rankup6pd_command1.replace("%PLAYER%",bazikon.getPlayer().getName());
        String rankup6pd_command2_CP = rankup6pd_command2.replace("%PLAYER%",bazikon.getPlayer().getName());

        // Respect point Item
        ArrayList<String> LoreRespectPoint = new ArrayList<>();
        LoreRespectPoint.add(color("&7Respect point"));
        ItemStack respectpointR1 = new ItemStack(Material.GOLD_NUGGET,25);
        ItemMeta respectpointMeta = (ItemMeta) respectpointR1.getItemMeta();
        respectpointMeta.setDisplayName(color("&c&lامتیاز رنک آپ"));


        //Set Meta
        respectpointMeta.setLore(LoreRespectPoint);
        respectpointR1.setItemMeta(respectpointMeta);




        if (sender instanceof Player) {
            // Sarbaz Rank-Up
            if (bazikon.hasPermission("rankup-system.pdr1")) {


                if (args.length >= 1 && args[0].equalsIgnoreCase(rankup1pd_name)) {  // Sarbaz rankup


                            int count = 0;

                            // حساب کردن تعداد آیتم‌های "عشق" در INVENTORY
                            for (ItemStack item : bazikon.getInventory().getContents()) {
                                if (item != null && item.isSimilar(respectpointR1)) {
                                    count += item.getAmount();
                                }
                            }

                            // اگر تعداد آیتم‌ها بیشتر از 30 شد، 30 تا را حذف کن
                            if (count >= rankup1pd_point) {
                                int toRemove = rankup1pd_point;
                                for (int i = 0; i < bazikon.getInventory().getSize(); i++) {
                                    ItemStack item = bazikon.getInventory().getItem(i);
                                    if (item != null && item.isSimilar(respectpointR1)) {
                                        int amount = item.getAmount();
                                        if (amount <= toRemove) {
                                            toRemove -= amount;
                                            bazikon.getInventory().clear(i);
                                        } else {
                                            item.setAmount(amount - toRemove);
                                            bazikon.getInventory().setItem(i, item);
                                            break;
                                        }
                                    }
                                    if (toRemove <= 0) {
                                        break;
                                    }
                                }
                                bazikon.sendMessage(rankup1pd_message);
                                Bukkit.dispatchCommand(Bukkit.getConsoleSender(), rankup1pd_command1_CP); // Sarbaz Remove
                                Bukkit.dispatchCommand(Bukkit.getConsoleSender(), rankup1pd_command2_CP); // Police Add
                            } else {
                                bazikon.sendMessage(rankup1pd_notenough_message);

                            }
                        }
                    // End Calculate
                } // End Sarbaz
            if (bazikon.hasPermission("rankup-system.pdr2")) {


                if (args.length >= 1 && args[0].equalsIgnoreCase(rankup2pd_name)) {  // Police rankup


                    int count = 0;

                    // حساب کردن تعداد آیتم‌های "عشق" در INVENTORY
                    for (ItemStack item : bazikon.getInventory().getContents()) {
                        if (item != null && item.isSimilar(respectpointR1)) {
                            count += item.getAmount();
                        }
                    }

                    // اگر تعداد آیتم‌ها بیشتر از 75 شد، 75 تا را حذف کن
                    if (count >= rankup2pd_point) {
                        int toRemove = rankup2pd_point;
                        for (int i = 0; i < bazikon.getInventory().getSize(); i++) {
                            ItemStack item = bazikon.getInventory().getItem(i);
                            if (item != null && item.isSimilar(respectpointR1)) {
                                int amount = item.getAmount();
                                if (amount <= toRemove) {
                                    toRemove -= amount;
                                    bazikon.getInventory().clear(i);
                                } else {
                                    item.setAmount(amount - toRemove);
                                    bazikon.getInventory().setItem(i, item);
                                    break;
                                }
                            }
                            if (toRemove <= 0) {
                                break;
                            }
                        }
                        bazikon.sendMessage(rankup2pd_message);
                        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), rankup2pd_command1_CP); // Sarbaz Remove
                        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), rankup2pd_command2_CP); // Police Add
                    } else {
                        bazikon.sendMessage(rankup2pd_notenough_message);

                    }
                }
                // End Calculate


            } // End Police

            if (bazikon.hasPermission("rankup-system.pdr3")) {


                if (args.length >= 1 && args[0].equalsIgnoreCase("national-guard")) {  // National-guard rankup


                    int count = 0;

                    // حساب کردن تعداد آیتم‌های "عشق" در INVENTORY
                    for (ItemStack item : bazikon.getInventory().getContents()) {
                        if (item != null && item.isSimilar(respectpointR1)) {
                            count += item.getAmount();
                        }
                    }

                    // اگر تعداد آیتم‌ها بیشتر از 120 شد، 120 تا را حذف کن
                    if (count >= rankup3pd_point) {
                        int toRemove = rankup3pd_point;
                        for (int i = 0; i < bazikon.getInventory().getSize(); i++) {
                            ItemStack item = bazikon.getInventory().getItem(i);
                            if (item != null && item.isSimilar(respectpointR1)) {
                                int amount = item.getAmount();
                                if (amount <= toRemove) {
                                    toRemove -= amount;
                                    bazikon.getInventory().clear(i);
                                } else {
                                    item.setAmount(amount - toRemove);
                                    bazikon.getInventory().setItem(i, item);
                                    break;
                                }
                            }
                            if (toRemove <= 0) {
                                break;
                            }
                        }
                        bazikon.sendMessage(rankup3pd_message);
                        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), rankup3pd_command1_CP); // National-guard Remove
                        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), rankup3pd_command2_CP); // Swat Add
                    } else {
                        bazikon.sendMessage(rankup3pd_notenough_message);

                    }
                }
                // End Calculate


            } // National-Guard

            if (bazikon.hasPermission("rankup-system.pdr4")) {


                if (args.length >= 1 && args[0].equalsIgnoreCase(rankup4pd_name)) {  // National-guard rankup


                    int count = 0;

                    // حساب کردن تعداد آیتم‌های "عشق" در INVENTORY
                    for (ItemStack item : bazikon.getInventory().getContents()) {
                        if (item != null && item.isSimilar(respectpointR1)) {
                            count += item.getAmount();
                        }
                    }

                    // اگر تعداد آیتم‌ها بیشتر از 175 شد، 175 تا را حذف کن
                    if (count >= rankup4pd_point) {
                        int toRemove = rankup4pd_point;
                        for (int i = 0; i < bazikon.getInventory().getSize(); i++) {
                            ItemStack item = bazikon.getInventory().getItem(i);
                            if (item != null && item.isSimilar(respectpointR1)) {
                                int amount = item.getAmount();
                                if (amount <= toRemove) {
                                    toRemove -= amount;
                                    bazikon.getInventory().clear(i);
                                } else {
                                    item.setAmount(amount - toRemove);
                                    bazikon.getInventory().setItem(i, item);
                                    break;
                                }
                            }
                            if (toRemove <= 0) {
                                break;
                            }
                        }
                        bazikon.sendMessage(rankup4pd_message);
                        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), rankup4pd_command1_CP); // National-guard Remove
                        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), rankup4pd_command2_CP);// Swat Add
                    } else {
                        bazikon.sendMessage(color(rankup4pd_notenough_message));

                    }
                }
                // End Calculate


            } // End Police
            if (bazikon.hasPermission("rankup-system.pdr5")) {


                if (args.length >= 1 && args[0].equalsIgnoreCase(rankup5pd_name)) {  // National-guard rankup


                    int count = 0;

                    // حساب کردن تعداد آیتم‌های "عشق" در INVENTORY
                    for (ItemStack item : bazikon.getInventory().getContents()) {
                        if (item != null && item.isSimilar(respectpointR1)) {
                            count += item.getAmount();
                        }
                    }

                    // اگر تعداد آیتم‌ها بیشتر از 250 شد، 250 تا را حذف کن
                    if (count >= rankup5pd_point) {
                        int toRemove = rankup5pd_point;
                        for (int i = 0; i < bazikon.getInventory().getSize(); i++) {
                            ItemStack item = bazikon.getInventory().getItem(i);
                            if (item != null && item.isSimilar(respectpointR1)) {
                                int amount = item.getAmount();
                                if (amount <= toRemove) {
                                    toRemove -= amount;
                                    bazikon.getInventory().clear(i);
                                } else {
                                    item.setAmount(amount - toRemove);
                                    bazikon.getInventory().setItem(i, item);
                                    break;
                                }
                            }
                            if (toRemove <= 0) {
                                break;
                            }
                        }
                        bazikon.sendMessage(rankup4pd_message);
                        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), rankup5pd_command1_CP); // FBI Remove
                        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), rankup5pd_command2_CP); // Marshal Add
                    } else {
                        bazikon.sendMessage(color(rankup5pd_notenough_message));

                    }
                }
                // End Calculate


            } // End FBI
            if (bazikon.hasPermission("rankup-system.pdr6")) {


                if (args.length >= 1 && args[0].equalsIgnoreCase("marshal")) {  // Leader-military rankup


                    int count = 0;

                    // حساب کردن تعداد آیتم‌های "عشق" در INVENTORY
                    for (ItemStack item : bazikon.getInventory().getContents()) {
                        if (item != null && item.isSimilar(respectpointR1)) {
                            count += item.getAmount();
                        }
                    }

                    // اگر تعداد آیتم‌ها بیشتر از 640 شد، 640 تا را حذف کن
                    if (count >= 640) {
                        int toRemove = 640;
                        for (int i = 0; i < bazikon.getInventory().getSize(); i++) {
                            ItemStack item = bazikon.getInventory().getItem(i);
                            if (item != null && item.isSimilar(respectpointR1)) {
                                int amount = item.getAmount();
                                if (amount <= toRemove) {
                                    toRemove -= amount;
                                    bazikon.getInventory().clear(i);
                                } else {
                                    item.setAmount(amount - toRemove);
                                    bazikon.getInventory().setItem(i, item);
                                    break;
                                }
                            }
                            if (toRemove <= 0) {
                                break;
                            }

                    }

                        bazikon.sendMessage(rankup6pd_message);
                        Bukkit.dispatchCommand(Bukkit.getConsoleSender(),rankup6pd_command1_CP); // Marshal Remove
                        Bukkit.dispatchCommand(Bukkit.getConsoleSender(),rankup6pd_command2_CP); // Leader-military Add
                    } else {
                        bazikon.sendMessage(color(rankup6pd_notenough_message));

                    }
                }
                // End Calculate


            }     // End Marshal
            if (bazikon.hasPermission("rankup-system.post1")) {


                if (args.length >= 1 && args[0].equalsIgnoreCase("postchi")) {  // Leader-military rankup


                    int count = 0;

                    // حساب کردن تعداد آیتم‌های "عشق" در INVENTORY
                    for (ItemStack item : bazikon.getInventory().getContents()) {
                        if (item != null && item.isSimilar(respectpointR1)) {
                            count += item.getAmount();
                        }
                    }

                    // اگر تعداد آیتم‌ها بیشتر از 150 شد، 150 تا را حذف کن
                    if (count >= 150) {
                        int toRemove = 150;
                        for (int i = 0; i < bazikon.getInventory().getSize(); i++) {
                            ItemStack item = bazikon.getInventory().getItem(i);
                            if (item != null && item.isSimilar(respectpointR1)) {
                                int amount = item.getAmount();
                                if (amount <= toRemove) {
                                    toRemove -= amount;
                                    bazikon.getInventory().clear(i);
                                } else {
                                    item.setAmount(amount - toRemove);
                                    bazikon.getInventory().setItem(i, item);
                                    break;
                                }
                            }
                            if (toRemove <= 0) {
                                break;
                            }

                        }

                        bazikon.sendMessage(ChatColor.GREEN + "You rank-up to Leader-Postchi!");
                        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "lp user " + playerName + " parent removetemp postchi rp"); // Marshal Remove
                        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "lp user " + playerName + " parent addtemp leader-postchi 130d rp"); // Leader-military Add
                    } else {
                        bazikon.sendMessage(color("&cShoma niaz be dashtan 150 Respect point dar inventory khod darid!"));

                    }
                }
                // End Calculate


            }     // End Postchi
            }

        return true;
    }
    private String color(String str){
        //CodeColor
        return ChatColor.translateAlternateColorCodes('&',str);
        //CodeColor
    }
}
