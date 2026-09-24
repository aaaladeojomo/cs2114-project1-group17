package Apocalypse_Shelter_Survival_Game;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class InventoryCommandTest
{
    // ~ Fields ................................................................
    private InventoryCommand inv;
    private Player player;
    private Item item1;
    private Item item2;
    private Item item3;
    private String output;
    private ByteArrayOutputStream outContent;
    // ~ Constructors ..........................................................

    @BeforeEach
    public void setUp()
    {
        inv = new InventoryCommand();
        player = new Player();
        item1 = new Item("item1", 10, "food", 10);
        item2 = new Item("item2", 10, "water", 10);
        item3 = new Item("item3", 10, "tool", 10);

        outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
    }
    // ~Public Methods ........................................................


    @Test
    public void testExecuteEmpty()
    {
        inv.execute(player);
        String output = outContent.toString();

        // tests that execute lets the player know when their inventory is empty
        assertTrue(output.contains("Your inventory is empty."));

        System.setOut(System.out);
    }


    public void testExecute()
    {
        player.addItem(item1);
        player.addItem(item2);
        player.addItem(item3);

        inv.execute(player);
        String output = outContent.toString();
        // tests if execute outputs the items we have in our inventory as well
        // as the starting sentence "Your inventory: "
        assertTrue(output.contains("Your inventory: "));
        assertTrue(output.contains("item1"));
        assertTrue(output.contains("item2"));
        assertTrue(output.contains("item3"));

        System.setOut(System.out);

    }
}
