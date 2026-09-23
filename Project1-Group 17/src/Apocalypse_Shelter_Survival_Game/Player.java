package Apocalypse_Shelter_Survival_Game;

import Apocalypse_Shelter_Survival_Game.Location;
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

    public Player()
    {
        currentLocation = null;
        inventory = new ArrayList<>();
        currentWeight = 0;
        maxWeight = 50;
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
    public void setCurrentLocation(Location location)
    {
        currentLocation = location;
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

    public int getRemainingWeight()
    {
        return maxWeight - currentWeight;
    }

 
    public boolean addItem(Item item)
    {
        if (item == null)
        {
            return false;
        }

        if (item.getWeight() > getRemainingWeight())
        {
            return false;
        }

        inventory.add(item);
        currentWeight += item.getWeight();

        return true;
    }
    
    public boolean removeItem(Item item)
    {
        if (item == null || !inventory.contains(item))
        {
            return false;
        }

        inventory.remove(item);
        currentWeight -= item.getWeight();

        return true;
    }
}
   