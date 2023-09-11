package com.minefh.keepinventorybyslot.commands;

import com.minefh.keepinventorybyslot.config.ConfigManager;
import net.kyori.adventure.text.Component;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;

public class CommandManager implements CommandExecutor {

    public final ConfigManager configManager;

    public CommandManager(ConfigManager configManager) {
        this.configManager = configManager;
    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (!sender.hasPermission("kibs.admin")) {
            return true;
        }

        if (args.length == 0) {
            sender.sendMessage(Component.text("Vui lòng dùng lệnh /kibs reload để tải lại config"));
            return true;
        }

        if (args.length == 1 && args[0].equalsIgnoreCase("reload")) {
            configManager.load();
            sender.sendMessage(Component.text("Đã reload file config thành công!"));
        }

        return true;
    }
}
