package Apocalypse_Shelter_Survival_Game;

// -------------------------------------------------------------------------
/**
 * This class is for items of specific weight, name, points, and type.
 * 
 * @author mniac
 * @version Sep 18, 2026
 */
public class Item
{
    // ~ Fields ................................................................

    private String name;
    private int weight;
    private String type;
    private int points;

    // ----------------------------------------------------------
    /**
     * Create a new Item object.
     * 
     * @param name
     *            The name of the item.
     * @param weight
     *            The weight (in pounds) of the object.
     * @param type
     *            The type of item it is (tool, food, water)
     * @param points
     *            The number of points the item is worth for the final score.
     */
    // ~ Constructors ..........................................................

    public Item(String name, int weight, String type, int points)
    {
        this.name = name;
        this.weight = weight;
        this.type = type;
        this.points = points;
    }
    // ----------------------------------------------------------
    /**
     * Place a description of your method here.
     * @return name the name of the item.
     */
    // ~Public Methods ........................................................

    public String getName()
    {
        return name;
    }
    
    // ----------------------------------------------------------
    /**
     * Place a description of your method here.
     * @return weight the weight of the item.
     */
    public int getWeight()
    {
        return weight;
    }
    
    // ----------------------------------------------------------
    /**
     * Place a description of your method here.
     * @return type the type of item it is.
     */
    public String getType()
    {
        return type;
    }
    
    // ----------------------------------------------------------
    /**
     * Place a description of your method here.
     * @return points the number of points the item is worth.
     */
    public int getPoints()
    {
        return points;
    }
}
