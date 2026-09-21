package bunker;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

// -------------------------------------------------------------------------
/**
 * Tests the creation of an entertainment item for the EntertainmentItem class.
 * 
 * @author mniac
 * @version Sep 20, 2026
 */
class EntertainmentItemTest
{

    // ~ Fields ................................................................

    private Item entertain;
    // ----------------------------------------------------------

    // ~ Constructors ..........................................................

    // ~Public Methods ........................................................

    /**
     * Sets up a entertainment item for the following tests.
     */
    @BeforeEach
    public void setUp()
    {
        entertain = new EntertainmentItem("TV", 5, 10);
    }


    // ----------------------------------------------------------
    /**
     * Tests the getName() method the EntertainmentItem class inherits.
     */
    @Test
    public void testGetName()
    {
        assertEquals("TV", entertain.getName());
    }


    /**
     * Tests the getWeight() method the EntertainmentItem class inherits.
     */
    @Test
    public void testGetWeight()
    {
        assertEquals(5, entertain.getWeight());
    }


    /**
     * Tests the getType() method the EntertainmentItem class inherits.
     */
    @Test
    public void testGetType()
    {
        assertEquals("Entertainment", entertain.getType());
    }


    /**
     * Tests the getPoints() method the EntertainmentItem class inherits.
     */
    @Test
    public void testGetPoints()
    {
        assertEquals(10, entertain.getPoints());
    }
}
