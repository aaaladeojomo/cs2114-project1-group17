package bunker;

// -------------------------------------------------------------------------
/**
 * This class is for communication items only. Communication items give points
 * depending on the item.
 * 
 * @author mniac
 * @version Sep 20, 2026
 */
public class CommunicationItem
    extends Item
{
    // ----------------------------------------------------------
    /**
     * Create a new EntertainmentItem object.
     * 
     * @param name
     *            Name of the item.
     * @param weight
     *            Weight of the item.
     * @param points
     *            Number of points the item is worth.
     */
    // ~ Fields ................................................................

    // ~ Constructors ..........................................................

    public CommunicationItem(String name, int weight, int points)
    {
        super(name, weight, "Communication", points);
    }
    // ~Public Methods ........................................................

}
