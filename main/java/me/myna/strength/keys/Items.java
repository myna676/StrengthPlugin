package me.myna.strength.keys;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataType;

public class Items {
    public static final ItemStack getStrengthItem(){
        ItemStack itemStack = new ItemStack(Material.CLOCK);
        ItemMeta itemMeta = itemStack.getItemMeta();
        itemMeta.displayName(Component.text("Strength Item").color(NamedTextColor.RED));
        itemMeta.getPersistentDataContainer().set(keys.STRENGTH_ITEM , PersistentDataType.BOOLEAN , true);
        itemStack.setItemMeta(itemMeta);
        return itemStack;
    }
}
