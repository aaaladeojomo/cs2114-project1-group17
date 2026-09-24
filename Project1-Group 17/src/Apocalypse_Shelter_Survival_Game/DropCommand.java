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
        // if the item name is null or there is no item name given return false
        // and end progam
        if (itemName == null || itemName.isEmpty())
        {
            System.out.println("Drop what?");
            return false;
        }

        // store the players location so the items in the location can be looped
        // through
        Location currentLocation = player.getCurrentLocation();

        for (Item item : player.getInventory())
        {
            if (item.getName().equalsIgnoreCase(itemName))
            {
                // if we cant drop the item because it isnt in the players
                // inventory or its null then return false
                if (!player.removeItem(item))
                {
                    return false;
                }
                
                //add the item to the location after its dropped
                currentLocation.addItem(item);

                System.out.println("You dropped: " + itemName);
                return true;
            }
        }

        System.out.println("You do not have that item.");
        return false;
    }
}
