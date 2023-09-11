package com.minefh.keepinventorybyslot.config;

import com.minefh.keepinventorybyslot.KeepInventoryBySlot;
import lombok.Getter;
import org.bukkit.configuration.file.FileConfiguration;

import java.util.ArrayList;
import java.util.List;

public class ConfigManager {

    private final KeepInventoryBySlot plugin;

    @Getter
    private List<Integer> keepSlots;

    public ConfigManager(KeepInventoryBySlot plugin) {
        this. plugin = plugin;

        this.keepSlots = new ArrayList<>();
        load(); // Load on startup!
    }

    public void load() {
        FileConfiguration config = plugin.getConfig();

        this.keepSlots = config.getIntegerList("keep-inventory.slots");
        plugin.getLogger().info(keepSlots.toString());
    }
}
