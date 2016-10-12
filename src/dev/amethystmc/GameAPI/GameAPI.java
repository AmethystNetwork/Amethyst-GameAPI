package dev.amethystmc.GameAPI;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Created by Ben on 10/2/2016.
 */
public class GameAPI extends JavaPlugin
{

    public static GameAPI instance;

    File f;
    FileConfiguration config;

    public void onEnable()
    {

        instance = this;
        f = new File("/plugins/GameAPI/gamenpcs.yml");
        config = YamlConfiguration.loadConfiguration(f);

    }

    private void getGameNPCs()
    {

        List<String> npcs = config.getStringList("NPCs");
        List<UUID> users = new ArrayList<>();

        for (String str : npcs)
        {

            users.add(UUID.fromString(str));

        }

    }

}

