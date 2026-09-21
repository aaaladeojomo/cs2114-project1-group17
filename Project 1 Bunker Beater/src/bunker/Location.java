package bunker;

import java.util.ArrayList;
import java.util.HashMap;

// -------------------------------------------------------------------------
/**
 * This class will create different locations that the player can move through.
 * There will also be items in these.
 * 
 * @author mniac
 * @version Sep 18, 2026
 */
public class Location
{
    // ~ Fields ................................................................

    private String description;
    private ArrayList<Item> items;
    private HashMap<String, Location> connectedLocations;

    // ----------------------------------------------------------
    /**
     * Create a new Location object.
     * 
     * @param description
     *            The description of the location.
     */
    // ~ Constructors ..........................................................

    public Location(String description)
    {
        this.description = description;
        this.items = new ArrayList<>();
        this.connectedLocations = new HashMap<>();
    }


    // ----------------------------------------------------------
    /**
     * Gets the description of the location.
     * 
     * @return description The description of the location.
     */
    // ~Public Methods ........................................................

    public String getDescription()
    {
        return description;
    }


    // ----------------------------------------------------------
    /**
     * Gets the list of items in the location.
     * 
     * @return items The list of items in the location.
     */
    public ArrayList<Item> getItems()
    {
        return items;
    }


    // ----------------------------------------------------------
    /**
     * Adds an item to the array list of the location.
     * 
     * @param item
     *            The item being added to the items list and then the location.
     */
    public void addItem(Item item)
    {
        items.add(item);
    }


    // ----------------------------------------------------------
    /**
     * Removes an item from the array list in the location.
     * 
     * @param item
     *            The item being removed from the items list and the location.
     */
    public void removeItem(Item item)
    {
        items.remove(item);
    }


    // ----------------------------------------------------------
    /**
     * Connects a neighboring location to the current one in a direction and
     * stores it in a map.
     * 
     * @param direction
     *            The direction of the neighboring room location
     * @param location
     *            The main location
     */
    public void connectLocation(String direction, Location location)
    {
        connectedLocations.put(direction.toUpperCase(), location);
    }


    // ----------------------------------------------------------
    /**
     * Gets the neighboring location to the current one.
     * 
     * @param direction
     *            The direction of the neighboring location.
     * @return the connected location.
     */
    public Location getConnectedLocation(String direction)
    {
        if (direction == null)
        {
            return null;
        }

        return connectedLocations.get(direction.toUpperCase());
    }
}
