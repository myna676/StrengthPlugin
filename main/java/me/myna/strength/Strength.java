package me.myna.strength;

import me.myna.strength.command.ChangeDamageCommand;
import me.myna.strength.command.GetStrengthCommand;
import me.myna.strength.keys.Items;
import me.myna.strength.listner.PlayerListener;
import me.myna.strength.listner.TableListener;
import me.myna.strength.utils.StrengthTable;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.plugin.java.JavaPlugin;
import me.myna.strength.keys.keys;

public final class Strength extends JavaPlugin {

    @Override
    public void onEnable() {

        StrengthTable.strengthTable.load();
        getServer().getPluginManager().registerEvents(new TableListener(),  this);
        getServer().getPluginManager().registerEvents(new PlayerListener(), this);
        getCommand("setStrength").setExecutor(new ChangeDamageCommand());
        getCommand("getStrength").setExecutor(new GetStrengthCommand());

        ShapedRecipe recipe = new ShapedRecipe(keys.STRENGTH_ITEM_RECIPE , Items.getStrengthItem());
        recipe.shape("ghg",
                     "gbg",
                     "ggg");
        recipe.setIngredient('g' , Material.DIAMOND_BLOCK);
        recipe.setIngredient('b' , Material.TOTEM_OF_UNDYING);
        recipe.setIngredient('g' , Material.NETHERITE_INGOT);
        Bukkit.addRecipe(recipe);

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public static Strength getInstance(){
        return getPlugin(Strength.class);
    }
}
