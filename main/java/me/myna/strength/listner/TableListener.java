package me.myna.strength.listner;

import me.myna.strength.Strength;
import me.myna.strength.utils.StrengthTable;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class TableListener implements Listener {

    @EventHandler
    private void playerJoin(PlayerJoinEvent event){
        if(StrengthTable.strengthTable.get("Players." + event.getPlayer().getName()) == null){
            StrengthTable.strengthTable.set("Players." + event.getPlayer().getName(), 0);
            Strength.getInstance().getLogger().info(StrengthTable.strengthTable.get("Players." + event.getPlayer().getName()).toString());

        }
    }
}
