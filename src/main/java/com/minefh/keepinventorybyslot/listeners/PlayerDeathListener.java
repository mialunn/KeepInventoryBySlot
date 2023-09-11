package com.minefh.keepinventorybyslot.listeners;

import com.minefh.keepinventorybyslot.config.ConfigManager;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;

import java.util.List;

public class PlayerDeathListener implements Listener {

    private final ConfigManager configManager;


    public PlayerDeathListener(ConfigManager configManager) {
        this.configManager = configManager;
    }


    @EventHandler
    public void onDeath(PlayerDeathEvent event) {
        if (event.getKeepInventory()) {
            return;
        }

        Player player = event.getPlayer();
        PlayerInventory playerInventory = player.getInventory();
        List<ItemStack> keepItems = event.getItemsToKeep();
        List<ItemStack> dropItems = event.getDrops();

        configManager.getKeepSlots().forEach((slot) -> {
            ItemStack itemAtSpecificSlot = playerInventory.getItem(slot);
            if (itemAtSpecificSlot == null || itemAtSpecificSlot.getType() == Material.AIR) {
                return;
            }
            keepItems.add(itemAtSpecificSlot);
            dropItems.remove(itemAtSpecificSlot);
            player.sendMessage(itemAtSpecificSlot.getType().toString() + " has been kept! At slot " + slot);
        });
    }
}
