package Apocalypse_Shelter_Survival_Game;

import Apocalypse_Shelter_Survival_Game.Location;
import java.util.ArrayList;

// -------------------------------------------------------------------------
/**
 * Creates a player with a maximum carry weight, an inventory,
 * and a current location.
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
     * Creates a new Player object with no current location,
     * an empty inventory, and a maximum weight of 50.
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
     * Gets the current location of the player.
     *
     * @return the current location
     */
    public Location getCurrentLocation()
    {
        return currentLocation;
    }

    /**
     * Sets the current location of the player.
     *
     * @param location the new current location
     */
    public void setCurrentLocation(Location location)
    {
        currentLocation = location;
    }

    /**
     * Gets the player's inventory.
     *
     * @return the player's inventory
     */
    public ArrayList<Item> getInventory()
    {
        return inventory;
    }

    /**
     * Gets the weight of the items currently carried by the player.
     *
     * @return the current weight
     */
    public int getCurrentWeight()
    {
        return currentWeight;
    }

    /**
     * Gets the remaining weight the player can carry.
     *
     * @return the remaining available weight
     */
    public int getRemainingWeight()
    {
        return maxWeight - currentWeight;
    }

    /**
     * Adds an item to the player's inventory if the item is not null
     * and does not exceed the remaining weight.
     *
     * @param item the item to add
     * @return true if the item was added, otherwise false
     */
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

    /**
     * Removes an item from the player's inventory.
     *
     * @param item the item to remove
     * @return true if the item was removed, otherwise false
     */
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