package bunker;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

// -------------------------------------------------------------------------
/**
 *  A test class to test the ToolItem class.
 * 
 *  @author mniac
 *  @version Sep 20, 2026
 */
class ToolItemTest
{

    //~ Fields ................................................................

    private Item tool;
    // ----------------------------------------------------------
    
    //~ Constructors ..........................................................

    //~Public  Methods ........................................................

    /**
     * Set up for the following test methods.
     */
    @BeforeEach
    public void setUp()
    {
        tool = new ToolItem("Hammer", 7, 3);
    }
    
    // ----------------------------------------------------------
    /**
     * Tests the getName() method.
     */
    @Test
    public void testGetName()
    {
        assertEquals("Hammer", tool.getName());
    }
    
    // ----------------------------------------------------------
    /**
     * Tests the getWeight() method.
     */
    @Test
    public void testGetWeight()
    {
        assertEquals(7, tool.getWeight());
    }
    
    /**
     * Tests the getType() method.
     */
    @Test
    public void testGetType()
    {
        assertEquals("Tool", tool.getType());
    }
    
    /**
     * Tests the getPoints() method.
     */
    @Test
    public void testGetPoints()
    {
        assertEquals(3, tool.getPoints());
    }
}
