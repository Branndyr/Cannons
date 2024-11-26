New features/fixes:
---------------
- 1.20.6 + Support
- Upgraded to Java 14 language level
- Requires Java 21
- Added Netherite and newer armor protection support
- Simplified Chinese Translation by [SnowCutieOwO](https://github.com/SnowCutieOwO)
- New area commands

Optimizations:
---------------
- Better FlyingProjectile lookup
- UserMessage Optimization
- Some CannonManager Optimization
- Random Optimization (Original created a random number generator every time it needed to be used, now each object has its own Random)
- Distance optimization by using `Location#distanceSquared()` over `Location#distance` when possible
- Aiming shot simulation Optimization
- Simulating aim is less resource expensive (after testing, this feature requires about 50% less CPU usage)
- `CannonAPI#getCannon` should now not create massive lag when there are a lot of designs
- `/cannons claim` and commands executed in a radius won't deadlock your server anymore, and it is executed on a separate thread

API Changes/New Events:
--------------
- ProjectilePiercingEvent is now cancellable
- New CannonLinkFiringEvent to handle linked cannons operations
- New CannonLinkAimingEvent to handle linked cannons aiming
- You can now get more data from CannonDestroyEvent, which execute when cannons are broken too
- New CannonPreLoadEvent 
- New CannonRenameEvent
- New CannonGunpowderLoadEvent (gives accurate data on how much gunpowder is loaded)
- ArmorCalculationUtil now handles internal calculations for damage, every method there is public and can be used by an addon