package me.myna.strength.command;

import me.myna.strength.utils.StrengthTable;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class GetStrengthCommand implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {
        if(!(commandSender instanceof Player)){return false;}
        try {
            commandSender.sendMessage(strings[0] + " Strength is " + StrengthTable.strengthTable.get("Players." + strings[0]).toString());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return true;
    }
}
