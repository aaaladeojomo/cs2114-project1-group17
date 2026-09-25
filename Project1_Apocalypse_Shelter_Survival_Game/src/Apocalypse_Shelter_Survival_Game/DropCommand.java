package Apocalypse_Shelter_Survival_Game;

/**
 * Handles dropping an item from the player's inventory
 * into the player's current location.
 *
 * @author Ayomide Alade-Ojomo
 * @version 2026.09.24
 */
public class DropCommand
{
    private String itemName;

    /**
     * Creates a DropCommand for the specified item.
     *
     * @param itemName the name of the item to drop
     */
    public DropCommand(String itemName)
    {
        this.itemName = itemName;
    }

    /**
     * Attempts to remove the specified item from the player's
     * inventory and place it in the current location.
     *
     * @param player the player dropping the item
     * @return true if the item was successfully dropped,
     *         otherwise false
     */
    public boolean execute(Player player)
    {
        if (itemName == null || itemName.isEmpty())
        {
            System.out.println("Drop what?");
            return false;
        }

        Location currentLocation = player.getCurrentLocation();

        for (Item item : player.getInventory())
        {
            if (item.getName().equalsIgnoreCase(itemName))
            {
                if (!player.removeItem(item))
                {
                    return false;
                }

                currentLocation.addItem(item);
                System.out.println("You dropped: " + itemName);
                return true;
            }
        }

        System.out.println("You do not have that item.");
        return false;
    }
}