package com.minefh.keepinventorybyslot;

import com.minefh.keepinventorybyslot.commands.CommandManager;
import com.minefh.keepinventorybyslot.config.ConfigManager;
import com.minefh.keepinventorybyslot.listeners.PlayerDeathListener;
import org.bukkit.Bukkit;
import org.bukkit.command.PluginCommand;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Objects;

public final class KeepInventoryBySlot extends JavaPlugin {

    private ConfigManager configManager;


    @Override
    public void onEnable() {
        this.saveDefaultConfig();

        this.configManager = new ConfigManager(this);

        this.registerListeners();
        this.registerCommands();
    }


    @Override
    public void onDisable() {
        // TODO: Implementing shutdown functions here
    }


    private void registerListeners() {
        PluginManager pluginManager = Bukkit.getPluginManager();

        pluginManager.registerEvents(new PlayerDeathListener(this.configManager), this);
    }

    private void registerCommands() {
        Objects.requireNonNull(getCommand("kibs")).setExecutor(new CommandManager(configManager));
    }
}
