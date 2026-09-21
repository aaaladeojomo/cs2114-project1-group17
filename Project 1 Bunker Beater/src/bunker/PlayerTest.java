package bunker;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

// -------------------------------------------------------------------------
/**
 * Tests the Player class for proper methods and initialization.
 * 
 * @author mniac
 * @version Sep 20, 2026
 */
class PlayerTest
{

    // ~ Fields ................................................................

    /**
     * Creates a player1 object.
     */
    Player player1;
    /**
     * Creates a player2 object.
     */
    Player player2;
    /**
     * Creates a location1 object.
     */
    Location location1;
    /**
     * Creates a location2 object.
     */
    Location location2;
    /**
     * Creates a item1 object.
     */
    Item item1;
    /**
     * Creates a item2 object.
     */
    Item item2;
    /**
     * Creates a item3 object.
     */
    Item item3;
    // ----------------------------------------------------------

    // ~ Constructors ..........................................................

    // ~Public Methods ........................................................

    /**
     * Provides a set up for the following tests.
     */
    @BeforeEach
    public void setUp()
    {
        location1 = new Location("Kitchen");
        location2 = new Location("Living Room");
        item1 = new Item("Bread", 10, "Food", 10);
        item2 = new Item(null, 10, "Food", 10);
        item3 = new Item("Milk", 15, "Drink", 10);
        player1 = new Player(location1, 20);
        player2 = new Player(null, 20);
    }


    // ----------------------------------------------------------
    /**
     * Tests the getCurrentLocation method to retrieve the player's current
     * location.
     */
    @Test
    public void testGetCurrentLocation()
    {
        assertEquals(location1, player1.getCurrentLocation());
    }


    /**
     * Tests the getCurrentLocation method to retrieve the player's current
     * location.
     */
    @Test
    public void testGetInventory()
    {
        location1.addItem(item1);

        player1.pickup("Bread");

        assertTrue(player1.getInventory().contains(item1));
    }


    // ----------------------------------------------------------
    /**
     * Tests the getCurrentWeight method to see if the players current weight is
     * returned.
     */
    @Test
    public void testGetCurrentWeight()
    {
        assertEquals(0, player1.getCurrentWeight());

        location1.addItem(item1);
        player1.pickup("Bread");

        assertEquals(10, player1.getCurrentWeight());
    }


    // ----------------------------------------------------------
    /**
     * Tests the getMaxWeight() method to retrieve the player's max carry
     * weight.
     */
    @Test
    public void testGetMaxWeight()
    {
        assertEquals(20, player1.getMaxWeight());
    }


    // ----------------------------------------------------------
    /**
     * Tests the pickup() method when the location the player is in is null.
     */
    @Test
    public void testPickupLocationNull()
    {
        assertFalse(player2.pickup("Bread"));
    }


    /**
     * Tests the pickup() method when the item the player wants to pick up is
     * null name.
     */
    @Test
    public void testPickupItemNull()
    {
        assertFalse(player1.pickup(null));
    }


    // ----------------------------------------------------------
    /**
     * Tests the pickup() method when the item name is capitalized
     */
    @Test
    public void testPickupIgnoreCase()
    {
        location1.addItem(item1);

        assertTrue(player1.pickup("BREAD"));
    }


    // ----------------------------------------------------------
    /**
     * Tests the pickup() method when picking up an item goes over the max
     * weight.
     */
    @Test
    public void testPickupOverMaxWeight()
    {
        location1.addItem(item1);
        location1.addItem(item3);

        player1.pickup("Bread");

        assertFalse(player1.pickup("MILK"));
    }


    // ----------------------------------------------------------
    /**
     * Tests the pickup() method when there is no item to pick up.
     */
    @Test
    public void testPickupWithNoItem()
    {
        assertFalse(player1.pickup("Bread"));
    }


    // ----------------------------------------------------------
    /**
     * Tests the pickup() method with the wrong item.
     */
    @Test
    public void testPickupWrongItem()
    {
        location1.addItem(item1);

        assertFalse(player1.pickup("Milk"));
        assertFalse(player1.getInventory().contains(item1));
    }


    // ----------------------------------------------------------
    /**
     * Tests the drop() method for correctness.
     */
    @Test
    public void testDrop()
    {
        location1.addItem(item1);

        player1.pickup("Bread");

        assertTrue(player1.getInventory().contains(item1));

        player1.drop("Bread");

        assertFalse(player1.getInventory().contains(item1));
    }


    // ----------------------------------------------------------
    /**
     * Tests the drop() method when the player doesn't have the item in their
     * inventory.
     */
    @Test
    public void testDropItemNotInInventory()
    {
        assertFalse(player1.drop("Bread"));
    }


    // ----------------------------------------------------------
    /**
     * Tests when the item being dropped has a null name.
     */
    @Test
    public void testDropItemNameNull()
    {

        assertFalse(player1.drop("null"));
    }


    // ----------------------------------------------------------
    /**
     * Tests when the item is being dropped in a null location.
     */
    @Test
    public void testDropLocationNull()
    {
        assertFalse(player2.drop("Bread"));
    }


    // ----------------------------------------------------------
    /**
     * Tests when the item and location are both null.
     */
    @Test
    public void testDropItemNullLocationNull()
    {
        assertFalse(player2.drop(null));
    }


    // ----------------------------------------------------------
    /**
     * Tests the drop() method to ignore upper and lower case.
     */
    @Test
    public void testDropItemWrongItem()
    {
        location1.addItem(item1);

        player1.pickup("Bread");

        assertTrue(player1.getInventory().contains(item1));

        player1.drop("Milk");

        assertTrue(player1.getInventory().contains(item1));
    }


    // ----------------------------------------------------------
    /**
     * Tests the move() method for correctness.
     */
    @Test
    public void testMove()
    {
        location1.connectLocation("north", location2);

        player1.move("north");

        assertEquals(location2, player1.getCurrentLocation());
    }


    /**
     * Tests the move() method with a null direction.
     */
    @Test
    public void testMoveNullDirection()
    {
        location1.connectLocation("north", location2);

        player1.move(null);

        assertEquals(location1, player1.getCurrentLocation());
    }


    /**
     * Tests the move() method with a null start location.
     */
    @Test
    public void testMoveNullStartLocation()
    {
        location1.connectLocation("north", null);

        player2.move("north");

        assertNotEquals(location1, player2.getCurrentLocation());
    }


    /**
     * Tests the move() method with a null new location.
     */
    @Test
    public void testMoveNewLocationNull()
    {
        location1.connectLocation("north", null);

        player1.move("north");

        assertEquals(location1, player1.getCurrentLocation());
    }
}
