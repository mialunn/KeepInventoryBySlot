package com.minefh.keepinventorybyslot;

import com.minefh.keepinventorybyslot.config.MainConfig;
import com.minefh.keepinventorybyslot.listeners.PlayerDeathListener;
import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public final class KeepInventoryBySlot extends JavaPlugin {

    private MainConfig mainConfig;


    @Override
    public void onEnable() {
        this.saveDefaultConfig();

        this.mainConfig = new MainConfig();

        this.registerListeners();
    }


    @Override
    public void onDisable() {
        // TODO: Implementing shutdown functions here
    }


    private void registerListeners() {
        PluginManager pluginManager = Bukkit.getPluginManager();

        pluginManager.registerEvents(new PlayerDeathListener(this.mainConfig), this);
    }
}
