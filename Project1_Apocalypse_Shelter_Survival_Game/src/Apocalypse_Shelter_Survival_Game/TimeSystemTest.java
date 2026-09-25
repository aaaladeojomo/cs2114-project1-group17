package Apocalypse_Shelter_Survival_Game;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Tests the TimeSystem class, including command times
 * and the remaining game time.
 *
 * @author Yiqing Wang
 * @version 2026.09.24
 */
public class TimeSystemTest
{
    /**
     * Tests that the timer starts with 60 seconds.
     */
    @Test
    public void testInitialTime()
    {
        TimeSystem time = new TimeSystem();

        assertEquals(60, time.getRemainingTime());
        assertFalse(time.isTimeUp());
    }

    /**
     * Tests the time used by each command.
     */
    @Test
    public void testGetCommandTime()
    {
        TimeSystem time = new TimeSystem();

        assertEquals(5, time.getCommandTime("go"));
        assertEquals(3, time.getCommandTime("pick up"));
        assertEquals(2, time.getCommandTime("drop"));
        assertEquals(1, time.getCommandTime("inventory"));
        assertEquals(0, time.getCommandTime("look"));
        assertEquals(0, time.getCommandTime("help"));
        assertEquals(0, time.getCommandTime("hello"));
    }

    /**
     * Tests that command names are not case sensitive.
     */
    @Test
    public void testCommandTimeIgnoreCase()
    {
        TimeSystem time = new TimeSystem();

        assertEquals(5, time.getCommandTime("GO"));
        assertEquals(3, time.getCommandTime("PICK UP"));
        assertEquals(2, time.getCommandTime("Drop"));
    }

    /**
     * Tests using time.
     */
    @Test
    public void testUseTime()
    {
        TimeSystem time = new TimeSystem();

        time.useTime(5);

        assertEquals(55, time.getRemainingTime());
        assertFalse(time.isTimeUp());
    }

    /**
     * Tests when the timer reaches zero.
     */
    @Test
    public void testTimeUp()
    {
        TimeSystem time = new TimeSystem();

        time.useTime(60);

        assertEquals(0, time.getRemainingTime());
        assertTrue(time.isTimeUp());
    }

    /**
     * Tests when the timer goes below zero.
     */
    @Test
    public void testTimeBelowZero()
    {
        TimeSystem time = new TimeSystem();

        time.useTime(70);

        assertEquals(-10, time.getRemainingTime());
        assertTrue(time.isTimeUp());
    }
}
