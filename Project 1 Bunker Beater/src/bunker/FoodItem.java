package bunker;

// -------------------------------------------------------------------------
/**
 * This class is for food items only. Food items give points depending on the
 * food.
 * 
 * @author mniac
 * @version Sep 18, 2026
 */
public class FoodItem
    extends Item
{

    // ----------------------------------------------------------
    /**
     * Create a new FoodItem object.
     * 
     * @param name
     *            The name of the food item.
     * @param weight
     *            The weight of the food item.
     * @param points
     *            The number of points the food item is worth.
     */
    // ~ Fields ................................................................

    // ~ Constructors ..........................................................

    public FoodItem(String name, int weight, int points)
    {
        super(name, weight, "Food", points);
    }
    // ~Public Methods ........................................................

}
