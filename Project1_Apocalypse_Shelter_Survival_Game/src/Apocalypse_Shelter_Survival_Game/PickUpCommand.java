package Apocalypse_Shelter_Survival_Game;

/**
 * Handles picking up an item from the player's current location
 * and adding it to the player's inventory.
 *
 * @author Ayomide Alade-Ojomo
 * @version 2026.09.24
 */
public class PickUpCommand
{
    private String itemName;

    /**
     * Creates a PickUpCommand for the specified item.
     *
     * @param itemName the name of the item to pick up
     */
    public PickUpCommand(String itemName)
    {
        this.itemName = itemName;
    }

    /**
     * Attempts to pick up the specified item from the player's
     * current location. The item is added to the inventory if
     * it exists and the player has enough carrying capacity.
     *
     * @param player the player attempting to pick up the item
     * @return true if the item was successfully picked up,
     *         otherwise false
     */
    public boolean execute(Player player)
    {
        if (itemName == null || itemName.isEmpty())
        {
            System.out.println("Pick up what?");
            return false;
        }

        Location currentLocation = player.getCurrentLocation();

        for (Item item : currentLocation.getItems())
        {
            if (item.getName().equalsIgnoreCase(itemName))
            {
                if (!player.addItem(item))
                {
                    System.out.println("You cannot pick this up.");
                    return false;
                }

                currentLocation.removeItem(item);
                System.out.println("You picked up: " + itemName);
                return true;
            }
        }

        System.out.println("You cannot find that item here.");
        return false;
    }
}