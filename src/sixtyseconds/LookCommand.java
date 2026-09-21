package sixtyseconds;

import java.util.ArrayList;

public class LookCommand
    implements Command
{
 
   


    public boolean execute(Player player)
    {
        Location lo = player.getCurrentLocation();
        if (lo == null)
        {
            System.out.print("You aren't in a valid location");
            return false;
        }
        
        System.out.println(lo.getDescription());
        
        ArrayList<Item> items = lo.getItems();
        if(items.isEmpty())
        {
            System.out.println("There are no Items here");
            
        }
        
        else
        {
            System.out.println("Items here: ");
            for (Item i in items)
            {
                System.out.println(i.getName() + ", ");
                
            }
            
            
        }
        
        return true;
}
}
