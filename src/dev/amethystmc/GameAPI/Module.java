package dev.amethystmc.GameAPI;

import org.bukkit.craftbukkit.libs.jline.internal.Log;
import org.bukkit.event.Listener;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitScheduler;

/**
 * Created by Ben on 10/12/2016.
 */
public abstract class Module implements Listener
{

    protected String moduleName = "Game Module";
    protected JavaPlugin plugin;

    public Module(String moduleName, JavaPlugin plugin)
    {

        this.moduleName = moduleName;
        this.plugin = plugin;

        onEnable();

        RegisterEvents(this);
        AddCommands();

    }

    public final void onEnable()
    {

        long time = System.currentTimeMillis();
        Log("Initializing...");
        Enable();
        Log("Enabled...");

    }

    public final void onDisable()
    {

        Disable();

        Log("Disabled...");

    }

    public JavaPlugin getPlugin()
    {

        return plugin;

    }

    public BukkitScheduler getScheduler()
    {

        return getPlugin().getServer().getScheduler();

    }

    public PluginManager getPluginManager()
    {

        return getPlugin().getServer().getPluginManager();

    }

    public void RegisterEvents(Listener listener)
    {

        getPluginManager().registerEvents(listener, getPlugin());

    }

    public void Enable()
    {



    }

    public void Disable()
    {



    }

    public void AddCommands()
    {



    }

    public void Log(String message)
    {

        System.out.println("[" + moduleName + "]: " + message);

    }

}

