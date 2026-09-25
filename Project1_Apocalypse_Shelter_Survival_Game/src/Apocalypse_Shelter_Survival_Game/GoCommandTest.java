package Apocalypse_Shelter_Survival_Game;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Tests the GoCommand class and its ability to move a player
 * between connected locations.
 *
 * @author Ayomide Alade-Ojomo
 * @version 2026.09.24
 */
public class GoCommandTest
{
    // ~ Fields ................................................................

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

    // ~ Constructors ..........................................................

    // ~Public Methods ........................................................

    /**
     * Sets up the player, locations, and movement commands
     * before each test.
     */
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

    /**
     * Tests that an invalid direction returns false
     * and that moving north returns true.
     */
    @Test
    public void testExecuteNorth()
    {
        assertFalse(nodir.execute(player));
        assertTrue(gon.execute(player));
    }

    /**
     * Tests that the player can move south.
     */
    @Test
    public void testExecuteSouth()
    {
        assertTrue(gos.execute(player));
    }

    /**
     * Tests that the player can move east.
     */
    @Test
    public void testExecuteEast()
    {
        assertTrue(goe.execute(player));
    }

    /**
     * Tests that the player can move west.
     */
    @Test
    public void testExecuteWest()
    {
        assertTrue(gow.execute(player));
    }

    /**
     * Tests that execute returns false when there is
     * no location connected in the requested direction.
     */
    @Test
    public void testExecuteNullLocation()
    {
        loc.connectLocation("north", null);

        assertFalse(gon.execute(player));
    }
}