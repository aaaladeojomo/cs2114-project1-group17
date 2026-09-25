package Apocalypse_Shelter_Survival_Game;

/**
 * Displays the player's current inventory and weight information.
 *
 * @author Ayomide Alade-Ojomo
 * @version 2026.09.24
 */
public class InventoryCommand
{
    /**
     * Displays the items in the player's inventory and the player's
     * current and remaining weight.
     *
     * @param player the player whose inventory is displayed
     * @return true after the inventory information is displayed
     */
    public boolean execute(Player player)
    {
        if (player.getInventory().isEmpty())
        {
            System.out.println("Your inventory is empty.");
        }
        else
        {
            System.out.println("Your inventory:");

            for (Item item : player.getInventory())
            {
                System.out.println(
                    "- " + item.getName() + ": " + item.getWeight() + " lb");
            }
        }

        System.out.println(
            "Current weight: " + player.getCurrentWeight() + " lb");

        System.out.println(
            "Remaining weight: " + player.getRemainingWeight() + " lb");

        return true;
    }
}