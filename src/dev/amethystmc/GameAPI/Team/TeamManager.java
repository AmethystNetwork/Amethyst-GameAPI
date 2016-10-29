package dev.amethystmc.GameAPI.Team;

import dev.amethystmc.Core.Utils.MessageUtil;
import dev.amethystmc.GameAPI.Event.UpdateEvent;
import dev.amethystmc.GameAPI.Module;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
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

            if (team.getName().equalsIgnoreCase(name))
            {

                return team;

            }

        }

        return null;

    }

    public GameTeam getTeam(Player p)
    {

        for (GameTeam team : allTeams)
        {

            if (team.getMembers().contains(p.getName()))
            {

                return team;

            }

        }

        return null;

    }

    public void joinTeam(Player p, GameTeam team)
    {

        if (team == null)
        {

            return;

        }

        if (team.getMaxSize() == -1)
        {

            leaveTeam(p);
            MessageUtil.sendRawMessage(p, "&eYou joined Team" + team.getColor() + team.getName());
            team.getMembers().add(p.getName());
            return;

        }

        if (team.getMaxSize() > team.getMembers().size())
        {

            leaveTeam(p);
            MessageUtil.sendRawMessage(p, "&eYou joined Team" + team.getColor() + team.getName());
            team.getMembers().add(p.getName());
            return;

        }

        MessageUtil.sendRawMessage(p, "&cThat team is full!");
        return;

    }

    public boolean hasTeam(Player p)
    {

        if (getTeam(p) != null)
            return false;

        return true;

    }

    public void leaveTeam(Player p)
    {

        if (hasTeam(p))
        {

            GameTeam team = getTeam(p);
            team.getMembers().remove(p.getName());
            MessageUtil.sendRawMessage(p, "&cYou left Team" + team.getColor() + team.getName());
            return;

        }

    }

    @EventHandler
    public void hidePlayers(UpdateEvent e)
    {

        for (GameTeam team : allTeams)
        {

            if (team.isVisable() == false)
            {

                for (String s : team.getMembers())
                {

                    Player p = Bukkit.getPlayer(s);

                    for (Player online : Bukkit.getOnlinePlayers())
                    {

                        online.hidePlayer(p);

                    }

                }

            }

        }

    }

}

