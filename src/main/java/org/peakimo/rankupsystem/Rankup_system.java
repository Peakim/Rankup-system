package org.peakimo.rankupsystem;

import org.bukkit.Material;
import org.bukkit.plugin.java.JavaPlugin;
import org.peakimo.rankupsystem.Jobs.Police.Events.*;
import org.peakimo.rankupsystem.Jobs.Police.giverp;
import org.peakimo.rankupsystem.Jobs.Police.Rankup;
import org.peakimo.rankupsystem.Jobs.Police.removerp;
import org.peakimo.rankupsystem.commands.reload;


public final class Rankup_system extends JavaPlugin {

    private final String specialItemName = "GOLD_NUGGET";
    private final String specialItemDisplayName = "&c&lامتیاز رنک آپ";



    public static Rankup_system instance;
    public static Rankup_system getInstance(){

        return instance;

    }

    @Override
    public void onEnable() {

        //Config
        saveDefaultConfig();
        instance = this;


        // Plugin Commands
        getCommand("rankup").setExecutor(new Rankup());
        getCommand("giverp").setExecutor(new giverp());
        getCommand("removerp").setExecutor(new removerp());
        getCommand("rankup-reload").setExecutor(new reload());

        // Events
        getServer().getPluginManager().registerEvents(new Lock_item(),this);
        getServer().getPluginManager().registerEvents(new PlayerDrop_item(),this);
        getServer().getPluginManager().registerEvents(new LeaveGameWithoutPerm(),this);
        getServer().getPluginManager().registerEvents(new CancelCommand(),this);
        getServer().getPluginManager().registerEvents(new PlayerDeath_KeepItem(this), this);
        getServer().getPluginManager().registerEvents(new PlayerRespawnListener(), this);



    }

    public String getSpecialItemName() {
        return specialItemName;
    }

    public String getSpecialItemDisplayName() {
        return specialItemDisplayName;
    }

    public Material getSpecialItem() {
        return Material.getMaterial(specialItemName);
    }


    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
