package bunker;

// -------------------------------------------------------------------------
/**
 * This class is for tool items only. Tool items give points depending on the
 * tool.
 * 
 * @author mniac
 * @version Sep 18, 2026
 */
public class ToolItem
    extends Item
{
    // ~ Fields ................................................................

    // ~ Constructors ..........................................................

    // ----------------------------------------------------------
    /**
     * Create a new ToolItem object.
     * 
     * @param name
     *            The name of the tool.
     * @param weight
     *            The weight of the tool.
     * @param points
     *            The number of points the tool is worth.
     */
    public ToolItem(String name, int weight, int points)
    {
        super(name, weight, "Tool", points);
    }
    // ~Public Methods ........................................................

}
