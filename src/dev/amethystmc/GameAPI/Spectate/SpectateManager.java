package dev.amethystmc.GameAPI.Spectate;

import dev.amethystmc.Core.Utils.ItemUtil;
import dev.amethystmc.GameAPI.Module;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ben on 10/17/2016.
 */
public class SpectateManager extends Module
{

    private List<String> spectators = new ArrayList<>();


    public SpectateManager(JavaPlugin plugin)
    {

        super("Spectate Manager", plugin);

    }

    public void makePlayerSpectator(Player p)
    {

        try
        {

            p.getInventory().clear();
            p.getInventory().setArmorContents(null);
            p.setAllowFlight(true);
            //SPECTATOR TEAM
            p.getInventory().setItem(8, ItemUtil.createItem(Material.WATCH, "&dHub &8- &7Right Click", "&7Click to return to the hub"));
            spectators.add(p.getName());

        } catch (Exception e)
        {

            e.printStackTrace();
            return;

        }

    }

}

