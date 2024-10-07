package org.peakimo.rankupsystem.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.peakimo.rankupsystem.Rankup_system;

public class reload implements CommandExecutor {

    private Rankup_system instance = Rankup_system.getInstance();
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args){

        Player bazikon = (Player) sender;

        if (sender instanceof Player){
            if (sender.hasPermission("Rankup-system.admin.reload")){

                instance.reloadConfig();
                bazikon.sendMessage(ChatColor.GREEN + "Rankup-system reloaded!");

            }



        }



        return true;
    }
}
