package Apocalypse_Shelter_Survival_Game;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

 // -------------------------------------------------------------------------
/**
 * Tests the Item class to make sure it compiles correctly.
 * 
 * @author mniac
 * @version Sep 20, 2026
 */
public class ItemTest
{

    // ----------------------------------------------------------
    
    // ~ Fields ................................................................

    private Item item1;
    private Item item2;
    // ~ Constructors ..........................................................

    // ~Public Methods ........................................................

    /**
     * Creates items to be used in the later tests.
     */
    @BeforeEach
    public void setUp()
    {
        item1 = new Item("Bread", 2, "Food", 5);
        item2 = new Item("Milk", 5, "Drink", 6);
    }
    
    // ----------------------------------------------------------
    /**
     * Tests the getName() method in the Item class.
     */
    @Test
    public void testGetName()
    {
        assertEquals("Bread", item1.getName());
    }
    
    /**
     * Tests the getWeight() method in the Item class.
     */
    @Test
    public void testGetWeight()
    {
        assertEquals(5, item2.getWeight());
    }
    
    /**
     * Tests the getType() method in the Item class.
     */
    @Test
    public void testGetType()
    {
        assertEquals("Food", item1.getType());
    }
    
    /**
     * Tests the getPoints() method in the Item class.
     */
    @Test
    public void testGetPoints()
    {
        assertEquals(6, item2.getPoints());
    }
}
