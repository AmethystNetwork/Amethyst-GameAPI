package dev.amethystmc.GameAPI.Prevention;

/**
 * Created by Ben on 10/12/2016.
 */
public class PreventionSet
{

    private boolean isCanPvP = false;
    private boolean isCanPvE = false;
    private boolean isCanPlayersTakeDamage = false;
    private boolean isCanMobsSpawn = false;
    private boolean isCanPlayersDropItems = false;
    private boolean isCanPlayersPickupItems = false;
    private boolean isCanPlayersBreakBlocks = false;
    private boolean isCanPlayersPlaceBlocks = false;
    private boolean isCanPlayersUseBuckets = false;

    public PreventionSet(boolean isCanPvP, boolean isCanPvE, boolean isCanPlayersTakeDamage, boolean isCanMobsSpawn, boolean isCanPlayersDropItems, boolean isCanPlayersPickupItems, boolean isCanPlayersBreakBlocks, boolean isCanPlayersPlaceBlocks, boolean isCanPlayersUseBuckets)
    {
        this.isCanPvP = isCanPvP;
        this.isCanPvE = isCanPvE;
        this.isCanPlayersTakeDamage = isCanPlayersTakeDamage;
        this.isCanMobsSpawn = isCanMobsSpawn;
        this.isCanPlayersDropItems = isCanPlayersDropItems;
        this.isCanPlayersPickupItems = isCanPlayersPickupItems;
        this.isCanPlayersBreakBlocks = isCanPlayersBreakBlocks;
        this.isCanPlayersPlaceBlocks = isCanPlayersPlaceBlocks;
        this.isCanPlayersUseBuckets = isCanPlayersUseBuckets;
    }

}

