package Apocalypse_Shelter_Survival_Game;

public class PickUpCommand
{
    private String itemName;

    public PickUpCommand(String itemName)
    {
        this.itemName = itemName;
    }


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
