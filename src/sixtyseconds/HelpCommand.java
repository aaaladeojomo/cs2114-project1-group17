package sixtyseconds;
public class HelpCommand
    implements Command
{
    //~ Fields ................................................................

    //~ Constructors ..........................................................

    //~Public  Methods ........................................................
    public boolean execute()
    {
        System.out.println("Avalaible commands");
        System.out.println("LOOK");
        System.out.println("PICKUP <Item>");
        System.out.println("DROP <Item>");
        System.out.println("GO <Direction>");
        System.out.println("Inventory");
        System.out.println("HELP");
        return true;
    }
}
