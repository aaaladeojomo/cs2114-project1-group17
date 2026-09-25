package Apocalypse_Shelter_Survival_Game;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Tests the HelpCommand class and verifies that the help command
 * executes successfully.
 *
 * @author Ayomide Alade-Ojomo
 * @version 2026.09.24
 */
public class HelpCommandTest
{
    private HelpCommand help;
    private Player player;

    /**
     * Sets up a HelpCommand and Player before each test.
     */
    @BeforeEach
    public void setUp()
    {
        help = new HelpCommand();
        player = new Player();
    }

    /**
     * Tests that the help command executes successfully.
     */
    @Test
    public void testExecute()
    {
        assertTrue(help.execute(player));
    }
}
