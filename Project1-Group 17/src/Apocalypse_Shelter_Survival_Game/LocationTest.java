package Apocalypse_Shelter_Survival_Game;

import static org.junit.jupiter.api.Assertions.*;
import bunker.Item;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

// -------------------------------------------------------------------------
/**
 *  Tests the Location class and the methods that reside in it.
 * 
 *  @author mniac
 *  @version Sep 20, 2026
 */
class LocationTest
{

    //~ Fields ................................................................

    private Location location1;
    private Location location2;
    private Item item1;
    // ----------------------------------------------------------
    
    //~ Constructors ..........................................................

    //~Public  Methods ........................................................

    /**
     * Sets up locations to be used in the following tests.
     */
    @BeforeEach
    public void setUp()
    {
        location1 = new Location("Kitchen");
        location2 = new Location("Living Room");
        item1 = new Item("Bread", 5, "Food", 10);
    }
    
    // ----------------------------------------------------------
    /**
     * Tests the getDescription() method from the Location class.
     */
    @Test
    public void testGetDescription()
    {
        assertEquals("Kitchen", location1.getDescription());
    }
    
    /**
     * Tests the getItems() method from the Location class when it's empty.
     */
    @Test
    public void testGetItemsEmpty()
    {
        assertTrue(location1.getItems().isEmpty());
    }
    
    /**
     * Tests the addItems() method from the Location class.
     */
    @Test
    public void testAddItems()
    {
        location1.addItem(item1);
        
        assertTrue(location1.getItems().contains(item1));
    }
    
    /**
     * Tests the removeItems() method from the Location class.
     */
    @Test
    public void testRemoveItem()
    {
        location1.addItem(item1);
        
        assertTrue(location1.getItems().contains(item1));
        
        location1.removeItem(item1);
        
        assertFalse(location1.getItems().contains(item1));
    }
    
    /**
     * Tests connecting two locations together.
     */
    @Test
    public void testConnectLocations()
    {
        location1.connectLocation("north", location2);
        
        assertSame(location2, location1.getConnectedLocation("north"));
    }
    
    /**
     * Tests that directions are not case sensitive.
     */
    @Test
    public void testConnectLocationsCaseInsensitve()
    {
        location1.connectLocation("north", location2);
        
        assertSame(location2, location1.getConnectedLocation("NORTH"));
    }
    
    /**
     * Tests that a different direction is not connected.
     */
    @Test
    public void testGetConnectedLocationInvalidDirection()
    {
        assertNull(location1.getConnectedLocation("souht"));
    }
    
    /**
     * Tests requesting a null direction.
     */
    @Test
    public void testGetConnectedLocationNull()
    {
        assertNull(location1.getConnectedLocation(null));
    }
}
