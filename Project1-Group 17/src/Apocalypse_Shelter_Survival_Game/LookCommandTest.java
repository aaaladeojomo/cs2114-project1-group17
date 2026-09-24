package Apocalypse_Shelter_Survival_Game;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class LookCommandTest
{
    // ~ Fields ................................................................
    private LookCommand look;
    private Player player;
    private Location loc;
    private Item item1;
    private Item item2;
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

        outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

    }
    // ~Public Methods ........................................................

    @Test
    public void testExecuteNoItems()
    {
        look.execute(player);
        String output = outContent.toString();

        // tests that the expected output is true when there are no items in our
        // location
        assertTrue(output.contains("There are no items here."));

        System.setOut(System.out);

    }

    @Test
    public void testExecute()
    {

        loc.addItem(item1);
        loc.addItem(item2);

        look.execute(player);
        String output = outContent.toString();

        // tests that execute returns true for all the items inside of the
        // location
        assertTrue(output.contains("item1"));
        assertTrue(output.contains("item2"));

        System.setOut(System.out);

    }
}
