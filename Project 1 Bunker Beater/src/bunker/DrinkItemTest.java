package bunker;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

// -------------------------------------------------------------------------
/**
 * Tests the creation of a drink item for the DrinkItem class.
 * 
 * @author mniac
 * @version Sep 20, 2026
 */
class DrinkItemTest
{

    // ~ Fields ................................................................

    private Item drink;
    // ----------------------------------------------------------

    // ~ Constructors ..........................................................

    // ~Public Methods ........................................................

    /**
     * Sets up a drink item for the following tests.
     */
    @BeforeEach
    public void setUp()
    {
        drink = new DrinkItem("Coffee", 5, 10);
    }


    // ----------------------------------------------------------
    /**
     * Tests the getName() method the DrinkItem class inherits.
     */
    @Test
    public void testGetName()
    {
        assertEquals("Coffee", drink.getName());
    }
    
    /**
     * Tests the getWeight() method the FoodItem class inherits.
     */
    @Test
    public void testGetWeight()
    {
        assertEquals(5, drink.getWeight());
    }
    
    /**
     * Tests the getType() method the DrinkItem class inherits.
     */
    @Test
    public void testGetType()
    {
        assertEquals("Drink", drink.getType());
    }
    
    /**
     * Tests the getPoints() method the DrinkItem class inherits.
     */
    @Test
    public void testGetPoints()
    {
        assertEquals(10, drink.getPoints());
    }
}
