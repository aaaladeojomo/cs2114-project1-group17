package sixtyseconds;
public class GoCommand
    extends Command
{
    //~ Fields ................................................................
    private String direction;
    //~ Constructors ..........................................................
    public GoCommand(String name, String direction)
    {
        super(name);
        this.direction = direction;
    }
    
    
    //~Public  Methods ........................................................

}
