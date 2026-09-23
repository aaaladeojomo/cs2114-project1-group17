package Apocalypse_Shelter_Survival_Game;

public class HelpCommand
{
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
