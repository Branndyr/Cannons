package at.pavlov.cannons.hooks.movecraft.type;

import net.countercraft.movecraft.craft.type.CraftType;
import net.countercraft.movecraft.craft.type.TypeData;
import net.countercraft.movecraft.craft.type.property.IntegerProperty;
import net.countercraft.movecraft.craft.type.property.ObjectPropertyImpl;
import net.countercraft.movecraft.util.Pair;
import org.bukkit.NamespacedKey;
import org.jetbrains.annotations.NotNull;

import java.util.HashSet;
import java.util.Set;

import static net.countercraft.movecraft.craft.type.TypeData.NUMERIC_PREFIX;

public class FirepowerProperty {
    public static NamespacedKey MAX_FIREPOWER = new NamespacedKey("cannons-revamped", "max_firepower");

    public static void register() {
        CraftType.registerProperty(
                new IntegerProperty("max_firepower", MAX_FIREPOWER, type -> -1)
        );
    }
}
