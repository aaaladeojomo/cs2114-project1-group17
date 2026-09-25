package Apocalypse_Shelter_Survival_Game;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Tests the LookCommand class and its behavior when
 * displaying the current location and available items.
 *
 * @author Ayomide Alade-Ojomo
 * @version 2026.09.24
 */
public class LookCommandTest
{
    private LookCommand look;
    private Player player;
    private Location loc;
    private Item item1;
    private Item item2;
    private ByteArrayOutputStream outContent;
    private PrintStream originalOut;

    /**
     * Sets up the LookCommand, player, location, test items,
     * and output stream before each test.
     */
    @BeforeEach
    public void setUp()
    {
        look = new LookCommand();
        player = new Player();
        loc = new Location("testlocation");
        item1 = new Item("item1", 10, "food", 10);
        item2 = new Item("item2", 10, "water", 10);

        player.setCurrentLocation(loc);

        originalOut = System.out;
        outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
    }

    /**
     * Tests looking at a location that has no items.
     */
    @Test
    public void testExecuteNoItems()
    {
        assertTrue(look.execute(player));

        String output = outContent.toString();

        assertTrue(output.contains("There are no items here."));

        System.setOut(originalOut);
    }

    /**
     * Tests looking at a location that contains items.
     */
    @Test
    public void testExecute()
    {
        loc.addItem(item1);
        loc.addItem(item2);

        assertTrue(look.execute(player));

        String output = outContent.toString();

        assertTrue(output.contains("item1"));
        assertTrue(output.contains("item2"));

        System.setOut(originalOut);
    }
}