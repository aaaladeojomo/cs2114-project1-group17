package Apocalypse_Shelter_Survival_Game;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class DropCommandTest
{
    // ~ Fields ................................................................
    private DropCommand drop;
    private Player player;
    private Item item1;
    private Item item2;
    private Location loc;
    private DropCommand drop2;

    // ~ Constructors ..........................................................
    @BeforeEach
    public void setUp()
    {
        player = new Player();
        loc = new Location("testlocation");
        item1 = new Item("item1", 10, "food", 10);
        item2 = new Item("item2", 10, "water", 10);
        drop = new DropCommand("item1");
        drop2 = new DropCommand("item2");
        player.addItem(item1);
        player.setCurrentLocation(loc);

    }
    // ~Public Methods ........................................................

    @Test
    public void testExecuteDropNull()
    {
        // test that execute returns false when item name is null
        DropCommand nulls = new DropCommand(null);
        assertFalse(nulls.execute(player));

    }

    @Test
    public void testExecuteDropEmpty()
    {
        // tests the execute returns false when there is no valid item name
        DropCommand empty = new DropCommand("");
        assertFalse(empty.execute(player));

    }

    @Test
    public void testExecuteDrop()
    {
        // tests that execute returns true when we try to drop an item the
        // player has in their invetory
        assertTrue(drop.execute(player));

        // tests that execute returns false when we try to drop an item the
        // player doesn't have
        assertFalse(drop2.execute(player));

    }
}
