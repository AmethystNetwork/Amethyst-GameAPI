package dev.amethystmc.GameAPI.Game;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.WorldCreator;

import java.util.HashMap;

/**
 * Created by Ben on 10/11/2016.
 */
public class Map
{

    String name;
    String world;
    String creator;
    HashMap<Team, Location> spawns;
    boolean isLoaded;

    public Map(String name, String world, String creator, HashMap<Team, Location> spawns)
    {

        this.name = name;
        this.world = world;
        this.creator = creator;
        this.spawns = spawns;
        this.isLoaded = false;

    }

    public void loadWorld()
    {

        if (isLoaded)
            unloadWorld();
        Bukkit.createWorld(new WorldCreator(world));
        isLoaded = true;

    }

    public void unloadWorld()
    {

        if (!isLoaded)
            return;
        Bukkit.unloadWorld(world, false);
        isLoaded = false;

    }

    public String getName()
    {

        return name;

    }

    public String getWorldName()
    {

        return world;

    }

    public String getCreator()
    {

        return creator;

    }

    public HashMap<Team, Location> getSpawns()
    {

        return spawns;

    }

    public boolean isLoaded()
    {

        return isLoaded;

    }

    public World getWorld()
    {

        return Bukkit.getWorld(world);

    }

}

