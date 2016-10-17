package dev.amethystmc.GameAPI.Lobby;

import dev.amethystmc.GameAPI.Module;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * Created by Ben on 10/17/2016.
 */
public class LobbyManager extends Module
{

    public LobbyManager(JavaPlugin plugin)
    {

        super("Lobby Manager", plugin);

    }

    public void sendPlayerToLobby(Player p)
    {

        if (Bukkit.getWorld("lobby") == null)
        {

            System.out.println("No Lobby found...");
            System.out.println("No Lobby created...");
            return;

        }

        else
        {

            p.teleport(Bukkit.getWorld("lobby").getSpawnLocation());

        }

    }

}

