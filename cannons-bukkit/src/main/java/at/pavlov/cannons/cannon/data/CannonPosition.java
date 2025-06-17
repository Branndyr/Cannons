package at.pavlov.cannons.cannon.data;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.countercraft.movecraft.craft.Craft;
import org.bukkit.block.BlockFace;
import org.bukkit.util.Vector;

import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Data public class CannonPosition {
    // direction the cannon is facing
    private BlockFace cannonDirection;
    // the location is described by the offset of the cannon and the design
    private Vector offset;
    // world of the cannon
    private UUID world;
    // if the cannon is on a ship, the operation might be limited (e.g smaller angles to adjust the cannon)
    private boolean onShip;
    private Craft craft;
    // with which velocity the canno is moving (set by other plugins)
    private Vector velocity;
}
