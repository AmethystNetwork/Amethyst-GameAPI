package dev.amethystmc.GameAPI.Game;

import dev.amethystmc.GameAPI.GameAPI;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Created by Ben on 10/2/2016.
 */
public class Arena
{

    public static List<Arena> arenaList = new ArrayList<>();
    List<UUID> players;
    List<UUID> spectators;
    List<Team> teams;
    List<Map> maps;

    Map currentMap;
    Team winner;
    Team spectatorsTeam = Team.Spectator();
    ArenaState gameState;
    String name;
    String desc;
    List<String> preGameNotes;
    int id;
    GameRunnable gameRunnable;
    List<Integer> countdowns;
    Location lobby;


    public Arena(int id, List<Team> teams, List<Map> maps, GameRunnable gameRunnable)
    {

        this.teams = teams;
        this.maps = maps;
        //this.name
        //this.desc
        //this.preGameNotes
        this.gameState = ArenaState.PRE_GAME;
        this.players = new ArrayList<>();
        this.id = id;
        this.gameRunnable = gameRunnable;
        //this.game
        arenaList.add(this);

    }

    public void addPlayer(Player p)
    {

        if (gameState.equals(ArenaState.PRE_GAME))
        {

            players.add(p.getUniqueId());
            //p.teleport(GameAPI.)
            p.setHealth(20);
            p.setFoodLevel(20);
            p.setFireTicks(0);
            p.getInventory().clear();
            p.getInventory().setArmorContents(null);
            p.setGameMode(GameMode.SURVIVAL);
            //LobbyManager

            for (Player online : Bukkit.getOnlinePlayers())
            {

                if (!players.contains(online.getUniqueId()))
                {

                    p.hidePlayer(online);
                    online.hidePlayer(p);

                }

                else {
                    p.showPlayer(online);
                    online.showPlayer(p);
                }

            }
            giveRandomTeam(p);
            //checkStart
        }

        else if (gameState.equals(ArenaState.IN_GAME))
        {

            spectators.add(p.getUniqueId());
            //p.teleport
            p.setHealth(20);
            p.setFoodLevel(20);
            p.setFireTicks(0);
            p.getInventory().clear();
            p.getInventory().setArmorContents(null);
            //LobbyManager

            for (Player online : Bukkit.getOnlinePlayers())
            {

                if (!(spectators.contains(p.getUniqueId())))
                {

                    p.hidePlayer(online);
                    online.hidePlayer(p);

                }

                else {
                    p.showPlayer(online);
                    online.hidePlayer(p);
                }

            }

            spectatorsTeam.addPlayer(p);
        }

    }

    private void giveRandomTeam(Player p)
    {

        Team t = null;
        for (Team te : teams)
        {

            if (t == null || te.getPlayers().size() < t.getPlayers().size())
                t = te;
            t.addPlayer(p);

        }

    }

    public void checkStart()
    {

        //Countdown

    }

    public void removePlayer(Player p)
    {

        players.remove(p.getUniqueId());
        //p.teleport()
        p.setHealth(20);
        p.setFoodLevel(20);
        p.setFireTicks(0);
        p.getInventory().clear();
        p.getInventory().setArmorContents(null);
        //LobbyManager

        if (players.size() < 1)
        {
            //stop
        }
    }

    public boolean isInArena(Player p)
    {

        return players.contains(p.getUniqueId());

    }

    public void start()
    {

        if (gameState.equals(ArenaState.PRE_GAME))
        {

            //currentMap = getRandomMap;
            currentMap.loadWorld();

            if (gameRunnable != null)
                gameRunnable.start();
            //startMessage

            gameState = ArenaState.IN_GAME;


        }

    }

}

