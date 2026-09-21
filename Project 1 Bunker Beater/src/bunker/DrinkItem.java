package bunker;

// -------------------------------------------------------------------------
/**
 * This class is for drink items only. Drink items give points depending on the
 * drink.
 * 
 * @author mniac
 * @version Sep 18, 2026
 */
public class DrinkItem
    extends Item
{
    // ----------------------------------------------------------
    /**
     * Create a new DrinkItem object.
     * 
     * @param name
     *            The name of the drink.
     * @param weight
     *            The weight of the drink.
     * @param points
     *            The number of points the drink is worth.
     */
    // ~ Fields ................................................................

    // ~ Constructors ..........................................................

    public DrinkItem(String name, int weight, int points)
    {
        super(name, weight, "Drink", points);
    }
    // ~Public Methods ........................................................

}
