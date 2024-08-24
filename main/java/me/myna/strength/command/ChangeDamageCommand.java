package me.myna.strength.command;

import me.myna.strength.utils.StrengthChanger;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;

public class ChangeDamageCommand implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {
        if(commandSender instanceof Player && !(commandSender.isOp())){return false;}
        if(strings.length != 2){return false;}

        try {
            StrengthChanger.setStrength(Bukkit.getPlayerExact(strings[0]), Integer.valueOf(strings[1]));
            for (Player onlinePlayer : Bukkit.getOnlinePlayers()) {
                onlinePlayer.sendMessage(commandSender.getName() + " has Changed " + strings[0] + "'s Strength by " + strings[1]);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return true;
    }
}
