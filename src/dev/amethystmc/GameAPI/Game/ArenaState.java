package dev.amethystmc.GameAPI.Game;

/**
 * Created by Ben on 10/11/2016.
 */
public enum ArenaState
{

    PRE_GAME(true, "&ePre-Game"),
    IN_GAME(false, "&eIn-Game"),
    END_GAME(false, "&cEnd-Game");

    boolean canJoin;
    String name;

    ArenaState(boolean canJoin, String name)
    {

        this.canJoin = canJoin;
        this.name = name;

    }

    public boolean canJoin()
    {

        return canJoin;

    }

    public String getName()
    {

        return name;

    }

}

