package bunker;

import java.util.ArrayList;

// -------------------------------------------------------------------------
/**
 * Creates a player with a max carry weight, an inventory, and a start location.
 * 
 * @author mniac
 * @version Sep 19, 2026
 */
public class Player
{
    // ~ Fields ................................................................

    private Location currentLocation;
    private ArrayList<Item> inventory;
    private int currentWeight;
    private int maxWeight;

    // ----------------------------------------------------------
    /**
     * Create a new Player object.
     * 
     * @param startingLocation
     *            The start location of the Player.
     * @param maxWeight
     *            The max weight the player can carry.
     */
    // ~ Constructors ..........................................................

    public Player(Location startingLocation, int maxWeight)
    {
        this.currentLocation = startingLocation;
        this.maxWeight = maxWeight;
        this.currentWeight = 0;
        this.inventory = new ArrayList<>();
    }
    // ----------------------------------------------------------

    // ~Public Methods ........................................................


    /**
     * Gets the location the player is in
     * 
     * @return currentLocation
     */
    public Location getCurrentLocation()
    {
        return currentLocation;
    }


    /**
     * Gets the inventory of the player
     * 
     * @return inventory
     */
    public ArrayList<Item> getInventory()
    {
        return inventory;
    }


    /**
     * Gets the weight the player is currently holding
     * 
     * @return currentWeight
     */
    public int getCurrentWeight()
    {
        return currentWeight;
    }


    /**
     * Gets the max weight the player can hold
     * 
     * @return maxWeight
     */
    public int getMaxWeight()
    {
        return maxWeight;
    }


    /**
     * Method for the player to pick up an item if it doesn't go over their max
     * weight and then removes it from the location and adds it to their
     * inventory.
     * 
     * @param itemName
     *            is the item being picked up.
     * @return true if can pick up the item, false if they can't.
     */
    public boolean pickup(String itemName)
    {
        if (currentLocation == null || itemName == null)
        {
            return false;
        }

        for (Item item : currentLocation.getItems())
        {
            if (item.getName().equalsIgnoreCase(itemName))
            {
                if (currentWeight + item.getWeight() > maxWeight)
                {
                    return false;
                }

                inventory.add(item);
                currentLocation.removeItem(item);
                currentWeight += item.getWeight();

                return true;
            }
        }
        return false;
    }


    /**
     * Drops an item from the players inventory and adds it to the location.
     * 
     * @param itemName
     *            is the item being dropped.
     * @return true if they can drop the item, false if they can't.
     */
    public boolean drop(String itemName)
    {
        if (itemName == null || currentLocation  == null)
        {
            return false;
        }

        for (int i =0; i < inventory.size(); i++)
        {
            Item item = inventory.get(i);
            
            if (item.getName().equalsIgnoreCase(itemName))
            {
                inventory.remove(i);
                currentLocation.addItem(item);
                currentWeight -= item.getWeight();

                return true;
            }
        }
        return false;
    }


    // ----------------------------------------------------------
    /**
     * Moves the player to the location in the desired direction.
     * 
     * @param direction
     *            The direction the player is moving to.
     * @return True if they can move that direction, false if they can't.
     */
    public boolean move(String direction)
    {
        if (currentLocation == null || direction == null)
        {
            return false;
        }

        Location newLocation = currentLocation.getConnectedLocation(direction);

        if (newLocation == null)
        {
            return false;
        }

        currentLocation = newLocation;
        return true;
    }
}
