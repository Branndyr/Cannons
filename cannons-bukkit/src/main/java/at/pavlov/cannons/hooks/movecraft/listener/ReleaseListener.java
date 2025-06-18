package at.pavlov.cannons.hooks.movecraft.listener;

import at.pavlov.cannons.Cannons;
import at.pavlov.cannons.cannon.Cannon;
import at.pavlov.cannons.hooks.movecraft.MovecraftUtils;
import net.countercraft.movecraft.craft.Craft;
import net.countercraft.movecraft.craft.PlayerCraft;
import net.countercraft.movecraft.events.CraftReleaseEvent;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

import java.util.Set;

public class ReleaseListener implements Listener {
    private static final Cannons cannon = Cannons.getPlugin();

    @EventHandler
    public void onCraftRelease(CraftReleaseEvent e) {
        Craft craft = e.getCraft();
        Set<Cannon> cannons = MovecraftUtils.getCannons(craft);;

        if (!(craft instanceof PlayerCraft))
            return;
        for (Cannon i: cannons) {
            i.setOnShip(false);
        }


    }
}
