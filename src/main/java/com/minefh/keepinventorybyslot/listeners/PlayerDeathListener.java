package com.minefh.keepinventorybyslot.listeners;

import com.minefh.keepinventorybyslot.config.MainConfig;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;

import java.util.List;

public class PlayerDeathListener implements Listener {

    private final MainConfig mainConfig;


    public PlayerDeathListener(MainConfig mainConfig) {
        this.mainConfig = mainConfig;
    }


    @EventHandler
    public void onDeath(PlayerDeathEvent event) {
        Player player = event.getPlayer();
        PlayerInventory playerInventory = player.getInventory();

        List<ItemStack> keepItems = event.getItemsToKeep();
        List<ItemStack> dropItems = event.getDrops();
        for (int i = 0; i < 9; i++) {
            ItemStack itemAtSpecificSlot = playerInventory.getItem(i);
            if (itemAtSpecificSlot == null) {
                continue;
            }
            keepItems.add(itemAtSpecificSlot);
            dropItems.remove(itemAtSpecificSlot);
            player.sendMessage(itemAtSpecificSlot.getType().toString() + " has been kept! At slot " + i);
        }
    }
}
