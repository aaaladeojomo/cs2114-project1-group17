package Apocalypse_Shelter_Survival_Game;

public class InventoryCommand
{
    public boolean execute(Player player)
    {
        // check if the playerss inventory is empty, if it is output that its
        // empty
        if (player.getInventory().isEmpty())
        {
            System.out.println("Your inventory is empty.");
        }
        else
        {

            System.out.println("Your inventory:");

            // if its not empty loop through all the items in the player
            // inventory
            for (Item item : player.getInventory())
            {
                // get the names of each item and put it in a string that shows
                // all items weights and names
                System.out.println(
                    "- " + item.getName() + ": " + item.getWeight() + " lb");
            }
        }

        // tell the player the weight of the items being carried and the
        // remaining weight that can carry
        System.out
            .println("Current weight: " + player.getCurrentWeight() + " lb");

        System.out.println(
            "Remaining weight: " + player.getRemainingWeight() + " lb");

        return true;
    }
}
