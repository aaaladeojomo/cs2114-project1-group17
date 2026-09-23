package Apocalypse_Shelter_Survival_Game;

import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

// -------------------------------------------------------------------------
/**
 * Test for the Points class and its methods.
 * 
 * @author mniac
 * @version Sep 20, 2026
 */
class PointsTest
{

    // ~ Fields ................................................................

    private Points points;
    private ArrayList<Item> inventory;
    private Item item1;
    private Item item2;
    private Item item3;

    // ----------------------------------------------------------

    // ~ Constructors ..........................................................

    // ~Public Methods ........................................................

    /**
     * Provides a set up for the following test methods.
     */
    @BeforeEach
    public void setUp()
    {
        points = new Points();
        inventory = new ArrayList<>();
        item1 = new Item("Bread", 5, "Food", 10);
        item2 = new Item("Water", 5, "Drink", 20);
        item3 = new Item("Radio", 3, "Entertainment", 5);
    }


    // ----------------------------------------------------------
    /**
     * Tests the initial points in the inventory are zero with no items.
     */
    @Test
    public void testInitialPoints()
    {
        assertEquals(0, points.calculatePoints(inventory));
    }


    // ----------------------------------------------------------
    /**
     * Tests the amounts of points in the inventory with items.
     */
    @Test
    public void testCalculatePoints()
    {
        inventory.add(item1);
        inventory.add(item2);
        inventory.add(item3);

        assertEquals(35, points.calculatePoints(inventory));
    }


    // ----------------------------------------------------------
    /**
     * Tests the points in the inventory and the total points with no items in
     * inventory.
     */
    @Test
    public void testCalculatePointsEmptyInventory()
    {
        assertEquals(0, points.calculatePoints(inventory));
        assertEquals(0, points.getTotalPoints());
    }


    // ----------------------------------------------------------
    /**
     * Tests the points in the inventory when there is a null item in the
     * inventory.
     */
    @Test
    public void testCalculatePointsNullInventory()
    {
        assertEquals(0, points.calculatePoints(null));
        assertEquals(0, points.getTotalPoints());
    }
}
