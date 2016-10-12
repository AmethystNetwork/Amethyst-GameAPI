package dev.amethystmc.GameAPI.Game;

import dev.amethystmc.Core.Utils.MessageUtil;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.Score;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Created by Ben on 10/2/2016.
 */
public class Team
{

    List<UUID> playersOnTeam = new ArrayList<>();

    String name;
    int maxPlayers;
    ChatColor color;
    int score;

    public Team(String name, int maxPlayers, ChatColor color)
    {

        this.name = name;
        this.maxPlayers = maxPlayers;
        this.color = color;

    }

    public Team addPlayer(Player p)
    {

        if (!isOnTeam(p))
        {

            if (maxPlayers == -1 || playersOnTeam.size() < maxPlayers)
                playersOnTeam.add(p.getUniqueId());

        }

        else {
            MessageUtil.sendRawMessage(p, "&cYou are already on the &e" + getName() + " Team&c!");
        }

        return this;

    }

    public Team removePlayer(Player p)
    {

        if (!(isOnTeam(p)))
        {

            playersOnTeam.remove(p.getUniqueId());

        }

        else {
            MessageUtil.sendRawMessage(p, "&cYou aren't on the &e" + getName() + " Team&c!");
        }

        return this;

    }

    public boolean isOnTeam(Player p)
    {

        return playersOnTeam.contains(p.getUniqueId());

    }

    public String getName()
    {

        return name;

    }

    public int getMaxPlayers()
    {

        return maxPlayers;

    }

    public ChatColor getColor()
    {

        return color;

    }

    public List<UUID> getPlayers()
    {

        return playersOnTeam;

    }

    public int setScore(int score)
    {

        this.score = score;
        return score;

    }

    public int getScore()
    {
        return score;

    }

    public void minusScore(int score)
    {

        this.score -= score;

    }

    public void resetScore()
    {

        setScore(0);

    }

    public static Team Players(int i)
    {

        return new Team("Players", i, ChatColor.YELLOW);

    }

    public static Team Spectator()
    {

        return new Team("Spectators", -1, ChatColor.GRAY);

    }

}

