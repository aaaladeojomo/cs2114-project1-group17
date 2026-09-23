package Apocalypse_Shelter_Survival_Game;

public class GoCommand
{
    private String direction;

    public GoCommand(String direction)
    {
        this.direction = direction;
    }

    public boolean execute(Player player)
    {
        Location currentLocation = player.getCurrentLocation();

        if (!direction.equalsIgnoreCase("north")
            && !direction.equalsIgnoreCase("south")
            && !direction.equalsIgnoreCase("east")
            && !direction.equalsIgnoreCase("west"))
        {
            System.out.println("I don't understand that direction.");
            return false;
        }

        Location nextLocation =
            currentLocation.getConnectedLocation(direction);

        if (nextLocation == null)
        {
            System.out.println("There is no room in that direction.");
            return false;
        }

        player.setCurrentLocation(nextLocation);

        System.out.println(nextLocation.getDescription());

        return true;
    }
}