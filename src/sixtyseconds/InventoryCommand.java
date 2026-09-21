package sixtyseconds;
public class InventoryCommand
    implements Command
{
    //~ Fields ................................................................

    //~ Constructors ..........................................................

    //~Public  Methods ........................................................
    public boolean execute(Player player)
    {
        ArrayList<Item> inv = player.getInventory();
        
        if (inv.isEmpty())
        {
            System.out.println("Your inventory is empty");
            
        }
        else
        {
            System.out.println("Your inventory: ")
            for (Item i : inv)
            {
                System.out.println("- " + i.getName() + "(weight: " + i.getWeight() + ")" );
            }
        }
        
        System.out.println("Remaining space: " + (player.getMaxWeight() - player.getCurrentWeight()));
        return true;
    }
}
