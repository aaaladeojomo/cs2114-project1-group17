package Apocalypse_Shelter_Survival_Game;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PickUpCommandTest
{
    // ~ Fields ................................................................

    private PickUpCommand pickup;
    private Player player
    private Location loc;
    private Item item1;
    private Item item2;
    private Item item3;
    private PickUpCommand pickup2;
    private PickUpCommand pickup3;

    // ~ Constructors ..........................................................
    @BeforeEach
    public void setUp()
    {
        pickup = new PickUpCommand("item1");
        player = new Player();
        loc = new Location("testlocation");
        item1 = new Item("item1", 10, "food", 10);
        item2 = new Item("item2", 10, "water", 10);
        item3 = new Item("item3", 1000, "tool", 10);
        pickup2 = new PickUpCommand("item2");
        pickup3 = new PickUpCommand("item3");
        loc.addItem(item1);
        loc.addItem(item3);

    }


    // ~Public Methods ........................................................
   @Test
    public void testExecuteNull()
    {
        //test that execute returns false when itemname is null
        PickUpCommand nulls = new PickUpCommand(null);
        assertFalse(nulls.execute(player));

    }

    @Test
    public void testExecuteEmpty()
    {
        //tests that execute returns false when there is no valid item name
        PickUpCommand empty = new PickUpCommand("");
        assertFalse(empty.execute(player));
    }

    @Test
    public void testExecuteFull()
    {
        // test that execute returns false when the player tries to pick up a
        // item exceeding its maximum weight
        assertFalse(pickup3.execute(player));

    }

    @Test
    public void testExecute()
    {
        // test that execute returns true when player tries to pick up an item
        // in the location
        assertTrue(pickup.execute(player));

        // test that execute returns false when player tried to pick up an item
        // not in the location
        assertFalse(pickup2.execute(player));
    }
}
