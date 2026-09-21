package sixtyseconds;
public class PickUpCommand
    implements Command
{
    //~ Fields ................................................................
    private String itemName;
    //~ Constructors ..........................................................
    public PickUpCommand(String itemName)
    {
        this.itemName = itemName;
    }
    //~Public  Methods ........................................................

    public boolean execute(Player player)
    {
        if (itemName == null || itemName.isEmpty())
        {
            System.out.println("Pick up what?");
            return false;
        }
        
        boolean pickitup = player.pickup(itemName);
        
        if (!pickitup)
        {
            System.out.println("You cannot pick this up")
            return false;
        }
        
        else
        {
            System.out.println("You picked up: " + itemName);
            return true;
        }
    }
}
