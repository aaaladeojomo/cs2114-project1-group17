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

        // return false if the direction that is input is not north south east
        // or west
        if (!direction.equalsIgnoreCase("north")
            && !direction.equalsIgnoreCase("south")
            && !direction.equalsIgnoreCase("east")
            && !direction.equalsIgnoreCase("west"))
        {
            System.out.println("I don't understand that direction.");
            return false;
        }

        // store the room in the direction we want to go to
        Location nextLocation = currentLocation.getConnectedLocation(direction);

        // if there is no room where we are trying to move return false
        if (nextLocation == null)
        {
            System.out.println("There is no room in that direction.");
            return false;
        }

        // if there is move the player to the next location and print its
        // description (return true)
        player.setCurrentLocation(nextLocation);

        System.out.println(nextLocation.getDescription());

        return true;
    }
}
