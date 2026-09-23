package Apocalypse_Shelter_Survival_Game;

/**
 * Manages the game's count down timer and the amount of time used by each
 * command.
 *
 * @author Yiqing Wang
 * @version 2026.09.22
 */
public class TimeSystem
{
    private int remainingTime;

    /**
     * Initializes the game timer with 60 seconds.
     */
    public TimeSystem()
    {
        remainingTime = 60;
    }


    /**
     * Returns the amount of time remaining.
     *
     * @return the remaining time in seconds
     */
    public int getRemainingTime()
    {
        return remainingTime;
    }


    /**
     * Returns the amount of time required for a command.
     *
     * @param command
     *            the command entered by the player
     * @return the time used by the command in seconds
     */
    public int getCommandTime(String command)
    {
        if (command.equalsIgnoreCase("go"))
        {
            return 5;
        }
        if (command.equalsIgnoreCase("pick up"))
        {
            return 3;
        }
        if (command.equalsIgnoreCase("drop"))
        {
            return 2;
        }
        if (command.equalsIgnoreCase("inventory"))
        {
            return 1;
        }
        if (command.equalsIgnoreCase("look"))
        {
            return 0;
        }
        if (command.equalsIgnoreCase("help"))
        {
            return 0;
        }

        return 0;
    }


    /**
     * Subtracts the given amount of time from the remaining time.
     *
     * @param seconds
     *            the number of seconds to use
     */
    public void useTime(int seconds)
    {
        remainingTime -= seconds;
    }


    /**
     * Checks whether the time has reached zero.
     *
     * @return true if no time remains, otherwise false
     */
    public boolean isTimeUp()
    {
        return remainingTime <= 0;
    }
}
