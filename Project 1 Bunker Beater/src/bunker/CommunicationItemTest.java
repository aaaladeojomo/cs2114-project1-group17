package bunker;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

// -------------------------------------------------------------------------
/**
 * Tests the creation of a communication item for the EntertainmentItem class.
 * 
 * @author mniac
 * @version Sep 20, 2026
 */
class CommunicationItemTest
{

    // ~ Fields ................................................................

    private Item communicate;
    // ----------------------------------------------------------

    // ~ Constructors ..........................................................

    // ~Public Methods ........................................................

    /**
     * Sets up a communication item for the following tests.
     */
    @BeforeEach
    public void setUp()
    {
        communicate = new CommunicationItem("Radio", 5, 10);
    }


    // ----------------------------------------------------------
    /**
     * Tests the getName() method the CommunicationItem class inherits.
     */
    @Test
    public void testGetName()
    {
        assertEquals("Radio", communicate.getName());
    }


    /**
     * Tests the getWeight() method the CommunicationItem class inherits.
     */
    @Test
    public void testGetWeight()
    {
        assertEquals(5, communicate.getWeight());
    }


    /**
     * Tests the getType() method the CommunicationItem class inherits.
     */
    @Test
    public void testGetType()
    {
        assertEquals("Communication", communicate.getType());
    }


    /**
     * Tests the getPoints() method the CommunicationItem class inherits.
     */
    @Test
    public void testGetPoints()
    {
        assertEquals(10, communicate.getPoints());
    }
}
