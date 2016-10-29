package dev.amethystmc.GameAPI.Event;

import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

/**
 * Created by Ben on 10/17/2016.
 */
public class UpdateEvent extends Event
{

    private static final HandlerList handlers = new HandlerList();

    public HandlerList getHandlers()
    {

        return handlers;

    }

    public static HandlerList getHandlerList()
    {

        return handlers;

    }

}

