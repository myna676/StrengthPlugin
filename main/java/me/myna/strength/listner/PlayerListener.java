package me.myna.strength.listner;

import me.myna.strength.keys.Items;
import me.myna.strength.keys.keys;
import me.myna.strength.utils.StrengthChanger;
import me.myna.strength.utils.StrengthTable;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.EquipmentSlot;

import java.util.Arrays;
import java.util.Date;
import java.util.Objects;

public class PlayerListener implements Listener {
    @EventHandler
    private void PlayerDie(PlayerDeathEvent event){
        Player player = event.getPlayer();
        if(player.getKiller() == null || !(player.getKiller() instanceof Player)){
            player.getWorld().dropItem(player.getLocation() , Items.getStrengthItem());
        }
        else{
            Player killer = player.getKiller();
            if (Arrays.stream(killer.getInventory().getStorageContents()).anyMatch(Objects::isNull)) {
                killer.getInventory().addItem(Items.getStrengthItem());
            } else {
                player.getWorld().dropItem(player.getLocation(), Items.getStrengthItem());
            }

        }
        StrengthChanger.setStrength(player , -1);
        for (Player onlinePlayer : Bukkit.getOnlinePlayers()) {
            onlinePlayer.sendMessage(player.getName() + " Strength is " + StrengthTable.strengthTable.get("Players." + player.getName()));
        }

        if(((Integer) StrengthTable.strengthTable.get("Players." + player.getName())) < -5){
            player.banPlayer("Skill issue");
            for (Player onlinePlayer : Bukkit.getOnlinePlayers()) {
                onlinePlayer.sendMessage(player.getName() + " has been ban");
            }
        }

    }
    @EventHandler
    private void PlayerUseItem(PlayerInteractEvent event){
        if(event.getAction().isLeftClick()){return;}
        Player player = event.getPlayer();
        if(event.getItem() != null){
            if(event.getItem().hasItemMeta()){
                if(event.getItem().getItemMeta().getPersistentDataContainer().has(keys.STRENGTH_ITEM)){
                    if(((Integer) StrengthTable.strengthTable.get("Players." + player.getName())) != 5) {
                        StrengthChanger.setStrength(player, 1);
                        Bukkit.getOnlinePlayers().forEach(player1 -> {
                            player1.sendMessage(player.getName() + " Strength is " + StrengthTable.strengthTable.get("Players." + player.getName()));
                        });
                        event.getItem().setAmount(event.getItem().getAmount() - 1);
                    }else {
                        player.sendMessage("Your Strength is max");
                    }
                }
            }
        }

    }

}
