package Apocalypse_Shelter_Survival_Game;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Tests the PickUpCommand class and its item pickup behavior.
 *
 * @author Ayomide Alade-Ojomo
 * @version 2026.09.24
 */
public class PickUpCommandTest
{
    private Player player;
    private Location loc;
    private Item item;
    private PickUpCommand pickUp;

    /**
     * Sets up a player, location, item, and pickup command
     * before each test.
     */
    @BeforeEach
    public void setUp()
    {
        player = new Player();
        loc = new Location("testlocation");
        item = new Item("item1", 5, "food", 10);

        player.setCurrentLocation(loc);
        loc.addItem(item);
    }

    /**
     * Tests successfully picking up an item.
     */
    @Test
    public void testPickUpItem()
    {
        pickUp = new PickUpCommand("item1");

        assertTrue(pickUp.execute(player));
        assertTrue(player.getInventory().contains(item));
        assertFalse(loc.getItems().contains(item));
    }

    /**
     * Tests attempting to pick up an item that does not exist
     * in the current location.
     */
    @Test
    public void testItemNotFound()
    {
        pickUp = new PickUpCommand("wrongitem");

        assertFalse(pickUp.execute(player));
    }

    /**
     * Tests attempting to pick up an item with an empty name.
     */
    @Test
    public void testEmptyItemName()
    {
        pickUp = new PickUpCommand("");

        assertFalse(pickUp.execute(player));
    }

    /**
     * Tests attempting to pick up an item with a null name.
     */
    @Test
    public void testNullItemName()
    {
        pickUp = new PickUpCommand(null);

        assertFalse(pickUp.execute(player));
    }

    /**
     * Tests attempting to pick up an item that is too heavy
     * for the player's remaining carrying capacity.
     */
    @Test
    public void testCannotPickUpBecauseTooHeavy()
    {
        int tooHeavyWeight = player.getRemainingWeight() + 1;
        Item heavyItem = new Item("heavy", tooHeavyWeight, "tool", 10);

        loc.addItem(heavyItem);

        pickUp = new PickUpCommand("heavy");

        assertFalse(pickUp.execute(player));
        assertFalse(player.getInventory().contains(heavyItem));
        assertTrue(loc.getItems().contains(heavyItem));
    }

    /**
     * Tests picking up an item when the item name uses
     * different letter capitalization.
     */
    @Test
    public void testItemNameIgnoreCase()
    {
        pickUp = new PickUpCommand("ITEM1");

        assertTrue(pickUp.execute(player));
        assertTrue(player.getInventory().contains(item));
    }
}