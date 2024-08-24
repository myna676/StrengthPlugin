package me.myna.strength.utils;

import me.myna.strength.Strength;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Hashtable;

public class StrengthTable {
    public static StrengthTable strengthTable = new StrengthTable();

    private File file;
    private YamlConfiguration config;


    public void load(){
        file = new File(Strength.getInstance().getDataFolder() , "table.yml");

        if(!file.exists()) {
            Strength.getInstance().saveResource("table.yml", false);
        }
        config = new YamlConfiguration();
        config.options().parseComments(true);

        try {
            config.load(file);
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    public void save(){
        try {
            config.save(file);
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }

    public void set(String path , Object value){
        config.set(path , value);

        save();
    }
    public Object get(String path){
        return config.get(path);
    }

    public void setStrengthForPlayer(Player player , Integer amount){
        set("Players." + player.getName() , amount);
    }
    public Integer getStrengthForPlayer(Player player){
        return (Integer) config.get("Players." + player.getName());
    }
}
