package Apocalypse_Shelter_Survival_Game;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Tests the main game functions, including commands, time,
 * survival conditions, cellar entry, and final scoring.
 *
 * @author Yiqing Wang
 * @version 2026.09.24
 */
public class GameTest
{
    private InputStream originalIn;

    /**
     * Saves the original input stream before each test.
     */
    @BeforeEach
    public void setUp()
    {
        originalIn = System.in;
    }

    /**
     * Restores the original input stream after each test.
     */
    @AfterEach
    public void tearDown()
    {
        System.setIn(originalIn);
    }

    /**
     * Tests the welcome message for important game information
     * and available commands.
     */
    @Test
    public void testWelcomeMessage()
    {
        Game game = new Game();

        assertTrue(game.welcomeMessage().contains("60 seconds"));
        assertTrue(game.welcomeMessage().contains("go"));
        assertTrue(game.welcomeMessage().contains("pick up"));
    }

    /**
     * Tests an invalid command.
     */
    @Test
    public void testProcessCommandInvalid()
    {
        Game game = new Game();

        assertFalse(game.processCommand("hello"));
    }

    /**
     * Tests the go command with no direction.
     */
    @Test
    public void testProcessCommandGoWithoutDirection()
    {
        Game game = new Game();

        assertFalse(game.processCommand("go"));
    }

    /**
     * Tests the go command with an invalid direction.
     */
    @Test
    public void testProcessCommandInvalidDirection()
    {
        Game game = new Game();

        assertFalse(game.processCommand("go up"));
    }

    /**
     * Tests the go command when there is no room
     * in the requested direction.
     */
    @Test
    public void testProcessCommandNoExit()
    {
        Game game = new Game();

        assertFalse(game.processCommand("go south"));
    }

    /**
     * Tests successfully moving to the cellar and choosing
     * not to enter it.
     */
    @Test
    public void testProcessCommandGoToCellarNo()
    {
        Game game = new Game();

        System.setIn(
            new ByteArrayInputStream("no\n".getBytes()));

        assertFalse(game.processCommand("go north"));
    }

    /**
     * Tests successfully moving to the cellar and choosing
     * to enter it.
     */
    @Test
    public void testProcessCommandGoToCellarYes()
    {
        Game game = new Game();

        System.setIn(
            new ByteArrayInputStream("yes\n".getBytes()));

        assertTrue(game.processCommand("go north"));
    }

    /**
     * Tests the look command.
     */
    @Test
    public void testProcessCommandLook()
    {
        Game game = new Game();

        assertFalse(game.processCommand("look"));
    }

    /**
     * Tests picking up an item.
     */
    @Test
    public void testProcessCommandPickUp()
    {
        Game game = new Game();

        assertFalse(game.processCommand("pick up banana"));
    }

    /**
     * Tests the pick command without an item name.
     */
    @Test
    public void testProcessCommandPickUpWithoutItem()
    {
        Game game = new Game();

        assertFalse(game.processCommand("pick up"));
    }

    /**
     * Tests an incorrectly formatted pick command.
     */
    @Test
    public void testProcessCommandWrongPickCommand()
    {
        Game game = new Game();

        assertFalse(game.processCommand("pick banana"));
    }

    /**
     * Tests picking up an item with a different letter case.
     */
    @Test
    public void testProcessCommandPickUpIgnoreCase()
    {
        Game game = new Game();

        assertFalse(game.processCommand("PICK UP BANANA"));
    }

    /**
     * Tests picking up an item and then dropping it.
     */
    @Test
    public void testProcessCommandDrop()
    {
        Game game = new Game();

        assertFalse(game.processCommand("pick up banana"));
        assertFalse(game.processCommand("drop banana"));
    }

    /**
     * Tests dropping an item that is not in the inventory.
     */
    @Test
    public void testProcessCommandDropMissingItem()
    {
        Game game = new Game();

        assertFalse(game.processCommand("drop banana"));
    }

    /**
     * Tests the inventory command.
     */
    @Test
    public void testProcessCommandInventory()
    {
        Game game = new Game();

        assertFalse(game.processCommand("inventory"));
    }

    /**
     * Tests the help command.
     */
    @Test
    public void testProcessCommandHelp()
    {
        Game game = new Game();

        assertFalse(game.processCommand("help"));
    }

    /**
     * Tests the survival condition when the player has
     * no required supplies.
     */
    @Test
    public void testSurvivalFailure()
    {
        Game game = new Game();

        assertTrue(game.checkSurvivalCondition());
    }

    /**
     * Tests the survival condition when the player has
     * food, drink, and a tool.
     */
    @Test
    public void testSurvivalSuccess()
    {
        Game game = new Game();

        game.processCommand("pick up banana");
        game.processCommand("pick up bottlewater");
        game.processCommand("pick up radio");

        assertTrue(game.checkSurvivalCondition());
    }

    /**
     * Tests the final score when the player does not
     * have an oven.
     */
    @Test
    public void testFinalScoreWithoutOven()
    {
        Game game = new Game();

        game.processCommand("pick up banana");
        game.processCommand("pick up bottlewater");
        game.processCommand("pick up radio");

        assertTrue(game.calculateFinalScore());
    }

    /**
     * Tests the final score when the player has an oven,
     * chicken, and steak.
     */
    @Test
    public void testFinalScoreWithOven()
    {
        Game game = new Game();

        /*
         * Pick up food, drink, and tool from the home office.
         */
        game.processCommand("pick up banana");
        game.processCommand("pick up bottlewater");
        game.processCommand("pick up radio");

        /*
         * Move to the cellar.
         */
        System.setIn(
            new ByteArrayInputStream("no\n".getBytes()));

        game.processCommand("go north");

        /*
         * Pick up the oven from the cellar.
         */
        game.processCommand("pick up oven");

        /*
         * Move from the cellar to the living room,
         * then from the living room to the kitchen.
         */
        game.processCommand("go west");
        game.processCommand("go north");

        /*
         * Pick up both types of meat to test the oven bonus.
         */
        game.processCommand("pick up chicken");
        game.processCommand("pick up steak");

        assertTrue(game.calculateFinalScore());
    }

    /**
     * Tests all combinations of missing survival supplies.
     */
    @Test
    public void testShowSurvivalFailure()
    {
        Game game = new Game();

        game.showSurvivalFailure(false, false, false);
        game.showSurvivalFailure(false, true, true);
        game.showSurvivalFailure(true, false, true);
        game.showSurvivalFailure(true, true, false);
    }

    /**
     * Tests displaying the final survival result.
     */
    @Test
    public void testShowFinalResult()
    {
        Game game = new Game();

        game.showFinalResult(30, 10, 40);
    }

    /**
     * Tests the ending condition when the player
     * is not in the cellar.
     */
    @Test
    public void testEndingConditionNotInCellar()
    {
        Game game = new Game();

        assertTrue(game.checkEndingCondition());
    }

    /**
     * Tests the ending condition when the player
     * is in the cellar.
     */
    @Test
    public void testEndingConditionInCellar()
    {
        Game game = new Game();

        System.setIn(
            new ByteArrayInputStream("no\n".getBytes()));

        game.processCommand("go north");

        assertTrue(game.checkEndingCondition());
    }

    /**
     * Tests entering the cellar and choosing no.
     */
    @Test
    public void testAskEnterCellarNo()
    {
        Game game = new Game();

        System.setIn(
            new ByteArrayInputStream("no\n".getBytes()));

        assertFalse(game.askEnterCellar());
    }

    /**
     * Tests entering an invalid answer and then choosing no.
     */
    @Test
    public void testAskEnterCellarInvalidThenNo()
    {
        Game game = new Game();

        System.setIn(
            new ByteArrayInputStream("maybe\nno\n".getBytes()));

        assertFalse(game.askEnterCellar());
    }

    /**
     * Tests entering the cellar and choosing yes.
     */
    @Test
    public void testAskEnterCellarYes()
    {
        Game game = new Game();

        System.setIn(
            new ByteArrayInputStream("yes\n".getBytes()));

        assertTrue(game.askEnterCellar());
    }

    /**
     * Tests the process command time limit by using
     * all 60 seconds with inventory commands.
     */
    @Test
    public void testProcessCommandTimeRunsOut()
    {
        Game game = new Game();

        boolean gameOver = false;

        for (int i = 0; i < 60; i++)
        {
            gameOver = game.processCommand("inventory");
        }

        assertTrue(gameOver);
    }

    /**
     * Tests the main game loop with an empty input line
     * followed by enough commands to end the game.
     */
    @Test
    public void testStartGame()
    {
        Game game = new Game();

        StringBuilder input = new StringBuilder();

        input.append("\n");

        for (int i = 0; i < 60; i++)
        {
            input.append("inventory\n");
        }

        System.setIn(
            new ByteArrayInputStream(input.toString().getBytes()));

        game.startGame();
    }
}