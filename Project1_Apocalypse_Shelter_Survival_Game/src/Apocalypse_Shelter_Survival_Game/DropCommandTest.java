package Apocalypse_Shelter_Survival_Game;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Tests the DropCommand class and its item dropping behavior.
 *
 * @author Ayomide Alade-Ojomo
 * @version 2026.09.24
 */
public class DropCommandTest
{
    // ~ Fields ................................................................

    private DropCommand drop;
    private Player player;
    private Item item1;
    private Location loc;
    private DropCommand drop2;

    // ~ Constructors ..........................................................

    /**
     * Sets up the player, location, items, and drop commands
     * before each test.
     */
    @BeforeEach
    public void setUp()
    {
        player = new Player();
        loc = new Location("testlocation");
        item1 = new Item("item1", 10, "food", 10);
        drop = new DropCommand("item1");
        drop2 = new DropCommand("item2");

        player.addItem(item1);
        player.setCurrentLocation(loc);
    }

    // ~Public Methods ........................................................

    /**
     * Tests that execute returns false when the item name is null.
     */
    @Test
    public void testExecuteDropNull()
    {
        DropCommand nulls = new DropCommand(null);
        assertFalse(nulls.execute(player));
    }

    /**
     * Tests that execute returns false when the item name is empty.
     */
    @Test
    public void testExecuteDropEmpty()
    {
        DropCommand empty = new DropCommand("");
        assertFalse(empty.execute(player));
    }

    /**
     * Tests that execute returns true when dropping an item
     * that the player has in their inventory and returns false
     * when dropping an item that the player does not have.
     */
    @Test
    public void testExecuteDrop()
    {
        assertTrue(drop.execute(player));

        assertFalse(drop2.execute(player));
    }
}