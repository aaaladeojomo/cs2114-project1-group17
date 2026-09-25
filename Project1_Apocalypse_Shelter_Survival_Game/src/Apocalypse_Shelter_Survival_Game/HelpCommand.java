package Apocalypse_Shelter_Survival_Game;

/**
 * Displays the list of commands available to the player.
 *
 * @author Ayomide Alade-Ojomo
 * @version 2026.09.24
 */
public class HelpCommand
{
    /**
     * Displays the available commands and their descriptions.
     *
     * @param player the player using the command
     * @return true after the help information is displayed
     */
    public boolean execute(Player player)
    {
        System.out.println("Available commands:");
        System.out.println("- go: Move to another room.");
        System.out.println("- look: Look around the current room.");
        System.out.println("- pick up: Pick up an item.");
        System.out.println("- drop: Drop an item.");
        System.out.println("- inventory: Check your inventory.");
        System.out.println("- help: Show available commands.");
        return true;
    }
}
