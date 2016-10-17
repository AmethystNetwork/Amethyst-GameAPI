package dev.amethystmc.GameAPI.Team;

import dev.amethystmc.GameAPI.Module;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ben on 10/15/2016.
 */
public class TeamManager extends Module
{

    private List<GameTeam> allTeams = new ArrayList<>();

    public TeamManager(JavaPlugin plugin)
    {

        super("Team Manager", plugin);

    }

    public void registerTeam(GameTeam team)
    {

        allTeams.add(team);

    }

    public GameTeam getTeam(String name)
    {

        for (GameTeam team : allTeams)
        {



        }

    }

}

