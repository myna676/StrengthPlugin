package me.myna.strength.utils;

import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeModifier;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;

public class StrengthChanger {
    public static void setStrength(@NotNull Player player , Integer amount){
        Objects.requireNonNull(player.getAttribute(Attribute.GENERIC_ATTACK_DAMAGE)).setBaseValue(player.getAttribute(Attribute.GENERIC_ATTACK_DAMAGE).getBaseValue() + amount);

        StrengthTable.strengthTable.setStrengthForPlayer(player, (int) (StrengthTable.strengthTable.getStrengthForPlayer(player) + amount));
    }
}
