package Apocalypse_Shelter_Survival_Game;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Tests the Player class for proper methods and initialization.
 *
 * @author mniac
 * @version Sep 20, 2026
 */
public class PlayerTest
{
    private Player player;
    private Location location;
    private Item item;

    /**
     * Sets up the objects used in the tests.
     */
    @BeforeEach
    public void setUp()
    {
        player = new Player();
        location = new Location("Kitchen");
        item = new Item("Bread", 10, "Food", 10);
    }

    /**
     * Tests the initial current location.
     */
    @Test
    public void testInitialCurrentLocation()
    {
        assertNull(player.getCurrentLocation());
    }

    /**
     * Tests setting and getting the current location.
     */
    @Test
    public void testSetAndGetCurrentLocation()
    {
        player.setCurrentLocation(location);

        assertEquals(location, player.getCurrentLocation());
    }

    /**
     * Tests the initial inventory.
     */
    @Test
    public void testGetInventory()
    {
        assertTrue(player.getInventory().isEmpty());
    }

    /**
     * Tests the initial current weight.
     */
    @Test
    public void testGetCurrentWeight()
    {
        assertEquals(0, player.getCurrentWeight());
    }

    /**
     * Tests the initial remaining weight.
     */
    @Test
    public void testGetRemainingWeight()
    {
        assertEquals(50, player.getRemainingWeight());
    }

    /**
     * Tests adding a valid item.
     */
    @Test
    public void testAddItem()
    {
        assertTrue(player.addItem(item));

        assertTrue(player.getInventory().contains(item));
        assertEquals(10, player.getCurrentWeight());
        assertEquals(40, player.getRemainingWeight());
    }

    /**
     * Tests adding a null item.
     */
    @Test
    public void testAddNullItem()
    {
        assertFalse(player.addItem(null));

        assertTrue(player.getInventory().isEmpty());
        assertEquals(0, player.getCurrentWeight());
    }

    /**
     * Tests adding an item that is too heavy.
     */
    @Test
    public void testAddItemTooHeavy()
    {
        Item heavyItem = new Item("Heavy", 51, "Tool", 10);

        assertFalse(player.addItem(heavyItem));

        assertFalse(player.getInventory().contains(heavyItem));
        assertEquals(0, player.getCurrentWeight());
    }

    /**
     * Tests adding an item that exactly reaches the maximum weight.
     */
    @Test
    public void testAddItemAtMaximumWeight()
    {
        Item heavyItem = new Item("Heavy", 50, "Tool", 10);

        assertTrue(player.addItem(heavyItem));

        assertEquals(50, player.getCurrentWeight());
        assertEquals(0, player.getRemainingWeight());
        assertTrue(player.getInventory().contains(heavyItem));
    }

    /**
     * Tests removing an item from the inventory.
     */
    @Test
    public void testRemoveItem()
    {
        player.addItem(item);

        assertTrue(player.removeItem(item));

        assertFalse(player.getInventory().contains(item));
        assertEquals(0, player.getCurrentWeight());
        assertEquals(50, player.getRemainingWeight());
    }

    /**
     * Tests removing a null item.
     */
    @Test
    public void testRemoveNullItem()
    {
        assertFalse(player.removeItem(null));

        assertTrue(player.getInventory().isEmpty());
        assertEquals(0, player.getCurrentWeight());
    }

    /**
     * Tests removing an item that is not in the inventory.
     */
    @Test
    public void testRemoveItemNotInInventory()
    {
        assertFalse(player.removeItem(item));

        assertTrue(player.getInventory().isEmpty());
        assertEquals(0, player.getCurrentWeight());
    }

    /**
     * Tests removing one item when multiple items are in the inventory.
     */
    @Test
    public void testRemoveOneOfMultipleItems()
    {
        Item item2 = new Item("Milk", 15, "Drink", 10);

        player.addItem(item);
        player.addItem(item2);

        assertEquals(25, player.getCurrentWeight());

        assertTrue(player.removeItem(item));

        assertFalse(player.getInventory().contains(item));
        assertTrue(player.getInventory().contains(item2));
        assertEquals(15, player.getCurrentWeight());
        assertEquals(35, player.getRemainingWeight());
    }
}
