package dev.amethystmc.GameAPI.Maps;

import dev.amethystmc.GameAPI.Module;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashMap;
import java.util.List;

/**
 * Created by Ben on 10/12/2016.
 */
public class MapManager extends Module
{

    private List<GameMap> maps;

    public HashMap<String, GameMap> playerVotes = new HashMap<>();

    private boolean votingEnabled = false;

    public MapManager(JavaPlugin plugin)
    {

        super("Map Manager", plugin);

    }

    public void giveMaps(List<GameMap> gameMaps)
    {

        maps = gameMaps;
        return;

    }

    public List<GameMap> getMaps()
    {

        return maps;

    }

    public void checkForVoting()
    {



    }

}

