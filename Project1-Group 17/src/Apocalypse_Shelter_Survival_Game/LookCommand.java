package Apocalypse_Shelter_Survival_Game;

public class LookCommand
{
    public boolean execute(Player player)
    {
        Location currentLocation = player.getCurrentLocation();

        System.out.println(currentLocation.getDescription());

        if (currentLocation.getItems().isEmpty())
        {
            System.out.println("There are no items here.");
        }
        else
        {
            System.out.println("Items here:");

            for (Item item : currentLocation.getItems())
            {
                System.out.println(
                    "- " + item.getName() + ": " + item.getWeight() + " lb");
            }
        }

        return true;
    }
}