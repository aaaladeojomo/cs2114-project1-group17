package Apocalypse_Shelter_Survival_Game;

public class InventoryCommand
{
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
