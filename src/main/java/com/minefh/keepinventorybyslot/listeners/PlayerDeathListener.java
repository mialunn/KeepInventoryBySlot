package com.minefh.keepinventorybyslot.listeners;

import com.minefh.keepinventorybyslot.config.MainConfig;
import net.kyori.adventure.text.Component;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class PlayerDeathListener implements Listener {

    private final MainConfig mainConfig;


    public PlayerDeathListener(MainConfig mainConfig) {
        this.mainConfig = mainConfig;
    }


    @EventHandler
    public void onDeath(PlayerDeathEvent event) {
        Player player = event.getPlayer();
        Inventory playerInventory = player.getInventory();

        for (ItemStack item: playerInventory.getContents()) {
            if (item != null)
                player.sendMessage(Component.text(item.getType().toString()));
        }
    }
}
