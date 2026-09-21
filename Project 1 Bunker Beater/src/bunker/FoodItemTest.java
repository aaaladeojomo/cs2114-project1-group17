package bunker;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

// -------------------------------------------------------------------------
/**
 * Tests the creation of a food item for the FoodItem class.
 * 
 * @author mniac
 * @version Sep 20, 2026
 */
class FoodItemTest
{

    // ~ Fields ................................................................

    private Item food;
    // ----------------------------------------------------------

    // ~ Constructors ..........................................................

    // ~Public Methods ........................................................

    /**
     * Sets up a food item for the following tests.
     */
    @BeforeEach
    public void setUp()
    {
        food = new FoodItem("Steak", 5, 10);
    }


    // ----------------------------------------------------------
    /**
     * Tests the getName() method the FoodItem class inherits.
     */
    @Test
    public void testGetName()
    {
        assertEquals("Steak", food.getName());
    }
    
    /**
     * Tests the getWeight() method the FoodItem class inherits.
     */
    @Test
    public void testGetWeight()
    {
        assertEquals(5, food.getWeight());
    }
    
    /**
     * Tests the getType() method the FoodItem class inherits.
     */
    @Test
    public void testGetType()
    {
        assertEquals("Food", food.getType());
    }
    
    /**
     * Tests the getPoints() method the FoodItem class inherits.
     */
    @Test
    public void testGetPoints()
    {
        assertEquals(10, food.getPoints());
    }
}
