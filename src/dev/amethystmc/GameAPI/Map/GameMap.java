package dev.amethystmc.GameAPI.Map;

/**
 * Created by Ben on 10/12/2016.
 */
public class GameMap
{

    private String name;
    private String author;
    private String folderName;
    private int votes = 0;

    public GameMap(String name, String author, String folderName)
    {

        this.name = name;
        this.author = author;
        this.folderName = folderName;

    }

    public String getName()
    {

        return name;

    }

    public String getAuthor()
    {

        return author;

    }

    public String getFolderName()
    {

        return folderName;

    }

    public int getVotes()
    {

        return votes;

    }

    public void addVote(int i)
    {

        votes = votes + i;

    }

    public void removeVote(int i)
    {

        votes = votes - i;

        if (votes < 0)
            votes = 0;

    }

}

