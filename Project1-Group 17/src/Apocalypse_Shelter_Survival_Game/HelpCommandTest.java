package Apocalypse_Shelter_Survival_Game;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class HelpCommandTest
{
    // ~ Fields ................................................................
    private HelpCommand help;
    private Player player;

    // ~ Constructors ..........................................................
    @BeforeEach
    public void setUp()
    {
        help = new HelpCommand();
        player = new Player();
    }
    // ~Public Methods ........................................................


    public void testExecute();

    {
        // tests that the help command returns true when called, after all the
        // commands are listed out
        assertTrue(help.execute(player));
    }
}
