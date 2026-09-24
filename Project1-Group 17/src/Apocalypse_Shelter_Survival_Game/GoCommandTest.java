package Apocalypse_Shelter_Survival_Game;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class GoCommandTest

{

    // ~ Fields
    // ................................................................
    private GoCommand gon;
    private GoCommand gos;
    private GoCommand gow;
    private GoCommand goe;

    private GoCommand nodir;

    private Location loc;
    private Location east;
    private Location west;
    private Location south;
    private Location north;
    private Player player;

    // ~ Constructors
    // ..........................................................

    // ~Public Methods
    // ........................................................
    @BeforeEach
    public void setUp()
    {
        gon = new GoCommand("north");
        gos = new GoCommand("south");
        gow = new GoCommand("west");
        goe = new GoCommand("east");

        nodir = new GoCommand("NODIR");

        loc = new Location("testlocation");
        north = new Location("north to test location");
        east = new Location("east to test location");
        west = new Location("west to test location");
        south = new Location("south to test location");
        loc.connectLocation("north", north);
        loc.connectLocation("west", west);
        loc.connectLocation("south", south);
        loc.connectLocation("east", east);

        player = new Player();
        player.setCurrentLocation(loc);

    }


    public void testExecuteNorth()

    {
        // tests that false is returned if we try to go a direction that isnt
        // north south east or west
        assertFalse(nodir.execute(player));

        // tests that we can go north
        assertTrue(gon.execute(player));

    }


    public void testExecuteSouth()
    {
        // tests that we can go south
        assertTrue(gos.execute(player));
    }


    public void testExecuteEast()
    {
        // tests that we can go east
        assertTrue(goe.execute(player));
    }


    public void testExecuteWest()
    {
        // asserts that we can go west
        assertTrue(gow.execute(player));
    }


    public void testExecuteNullLocation()
    {
        // assert that execute returns false when the targeted room is null
        loc.connectLocation("north", null);
        assertFalse(gon.execute(player));
    }
}
