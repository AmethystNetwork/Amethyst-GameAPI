package dev.amethystmc.GameAPI.Team;

import org.bukkit.ChatColor;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ben on 10/17/2016.
 */
public class GameTeam
{

    private String name;
    private ChatColor color;
    private boolean visable = true;
    private int maxSize = -1;

    private List<String> members = new ArrayList<>();

    public GameTeam(String name, ChatColor color)
    {

        this.name = name;
        this.color = color;

    }

    public String getName()
    {

        return name;

    }

    public ChatColor getColor()
    {

        return color;

    }

    public boolean isVisable()
    {

        return visable;

    }

    public int getMaxSize()
    {

        return maxSize;

    }

    public List<String> getMembers()
    {

        return members;

    }

}

