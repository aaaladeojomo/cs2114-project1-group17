package Apocalypse_Shelter_Survival_Game;

import java.util.ArrayList;

// -------------------------------------------------------------------------
/**
 * Creates a point system that will combine points from the items that are
 * collected.
 * 
 * @author mniac
 * @version Sep 19, 2026
 */
public class Points
{
    // ~ Fields ................................................................

    private int totalPoints;

    // ----------------------------------------------------------
    /**
     * Create a new Points object.
     */
    // ~ Constructors ..........................................................

    public Points()
    {
        totalPoints = 0;
    }


    // ----------------------------------------------------------
    /**
     * Calculates the number of points the player has by combining the number of
     * points each item is worth in the player's inventory.
     * 
     * @param inventory
     * @return totalPoints the total number of points the player has.
     */
    // ~Public Methods ........................................................

    public int calculatePoints(ArrayList<Item> inventory)
    {
        int points = 0;
        
        if (inventory == null)
        {
            totalPoints = 0;
            return totalPoints;
        }

        for (Item item : inventory)
        {
            points += item.getPoints();
        }

        totalPoints = points;
        return totalPoints;
    }


    // ----------------------------------------------------------
    /**
     * Gets the total points the player currently has.
     * 
     * @return totalPoints the points the player currently has.
     */
    public int getTotalPoints()
    {
        return totalPoints;
    }
}
