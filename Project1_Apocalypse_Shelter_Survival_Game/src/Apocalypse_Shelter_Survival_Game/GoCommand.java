package Apocalypse_Shelter_Survival_Game;

/**
 * Handles moving the player to a connected location
 * in the specified direction.
 *
 * @author Ayomide Alade-Ojomo
 * @version 2026.09.24
 */
public class GoCommand
{
    private String direction;

    /**
     * Creates a GoCommand for the specified direction.
     *
     * @param direction the direction in which the player wants to move
     */
    public GoCommand(String direction)
    {
        this.direction = direction;
    }

    /**
     * Attempts to move the player in the specified direction.
     * The direction must be north, south, east, or west,
     * and a connected location must exist in that direction.
     *
     * @param player the player who is moving
     * @return true if the player successfully moves to another location,
     *         otherwise false
     */
    public boolean execute(Player player)
    {
        Location currentLocation = player.getCurrentLocation();

        if (!direction.equalsIgnoreCase("north")
            && !direction.equalsIgnoreCase("south")
            && !direction.equalsIgnoreCase("east")
            && !direction.equalsIgnoreCase("west"))
        {
            System.out.println("I don't understand that direction.");
            return false;
        }

        Location nextLocation =
            currentLocation.getConnectedLocation(direction);

        if (nextLocation == null)
        {
            System.out.println("There is no room in that direction.");
            return false;
        }

        player.setCurrentLocation(nextLocation);
        System.out.println(nextLocation.getDescription());
        return true;
    }
}