package Apocalypse_Shelter_Survival_Game;

public class DropCommand
{
    private String itemName;

    public DropCommand(String itemName)
    {
        this.itemName = itemName;
    }

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
