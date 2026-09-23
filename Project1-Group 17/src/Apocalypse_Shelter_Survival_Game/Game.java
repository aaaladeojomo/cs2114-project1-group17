
package Apocalypse_Shelter_Survival_Game;

import java.util.Scanner;

/**
 * Controls the main game, including commands, time, rooms, and survival.
 *
 * @author Yiqing Wang
 * @version 2026.09.22
 */
public class Game
{
    private Player player;
    private TimeSystem timeSystem;

    /**
     * Initializes the player, time system, and game rooms.
     */
    public Game()
    {
        player = new Player();
        timeSystem = new TimeSystem();

        createRooms();
    }


    /**
     * Returns the introduction and available commands for the game.
     *
     * @return the welcome message
     */
    public String welcomeMessage()
    {
        return "It is a dark and stormy night.\n"
            + "You are sitting in your home office, desperately trying to finish "
            + "your CS 2114 homework. The radio is playing a boring and uneventful "
            + "midnight news broadcast in the background.\n\n"

            + "You stare at the complicated program in front of you. "
            + "Then you remember that you have two tests tomorrow.\n"

            + "You finally snap and scream in your head:\n"
            + "\"Destroy this world!\"\n\n"

            + "As if the universe heard your wish, the voice coming from the radio "
            + "suddenly turns into static.\n"

            + "Then, a person screams through the radio:\n"
            + "\"Due to unknown reasons, the asteroid MAX has suddenly changed its "
            + "trajectory! It is expected to collide with Earth in 60 seconds! "
            + "Everyone, evacuate immediately! Repeat, everyone, evacuate immediately! "
            + "The only way to survive is to escape to an underground shelter!\"\n\n"

            + "The radio goes silent.\n"

            + "You sit there in disbelief for a few seconds.\n"
            + "You curse under your breath. You were just trying to finish your "
            + "homework. Why did this have to happen tonight?\n\n"

            + "But there is no time to complain.\n" + "60 seconds.\n"
            + "That is all the time you have before MAX hits Earth.\n"
            + "You must find a way to reach the underground shelter before time runs out.\n\n"

            + "You have the following commands available:\n"
            + "- go [north/south/east/west] - Move to another room.\n"
            + "- look - Look around your current room.\n"
            + "- pick up [item] - Pick up an item.\n"
            + "- drop [item] - Drop an item.\n"
            + "- inventory - Check the items you are carrying.\n"
            + "- help - Display the available commands.\n\n"

            + "The countdown has begun. What will you do?";
    }


    /**
     * Starts the main game loop and processes player commands.
     */
    public void startGame()
    {
        Scanner scanner = new Scanner(System.in);

        System.out.println(welcomeMessage());
        System.out.println(
            "Time remaining: " + timeSystem.getRemainingTime() + " seconds");

        while (true)
        {
            System.out.print("\n> ");

            String input = scanner.nextLine().trim();

            if (input.isEmpty())
            {
                continue;
            }

            boolean gameOver = processCommand(input);

            if (gameOver)
            {
                break;
            }
        }

        scanner.close();
    }


    /**
     * Processes a player's command and updates the game state and time.
     *
     * @param input
     *            the command entered by the player
     * @return true if the game should end, otherwise false
     */
    public boolean processCommand(String input)
    {
        String[] parts = input.split("\\s+", 2);

        String command = parts[0].toLowerCase();
        String argument = "";

        if (parts.length > 1)
        {
            argument = parts[1].trim();
        }

        boolean success = false;
        String commandName = command;

        if (command.equals("go"))
        {
            if (argument.isEmpty())
            {
                System.out.println("Go where?");
                return false;
            }

            GoCommand go = new GoCommand(argument);
            success = go.execute(player);
        }
        else if (command.equals("look"))
        {
            LookCommand look = new LookCommand();
            success = look.execute(player);
        }
        else if (command.equals("pick"))
        {
            if (argument.equalsIgnoreCase("up"))
            {
                argument = "";
            }
            else if (argument.toLowerCase().startsWith("up "))
            {
                argument = argument.substring(3).trim();
            }
            else
            {
                System.out.println("Did you mean: pick up [item]?");
                return false;
            }

            PickUpCommand pickUp = new PickUpCommand(argument);
            success = pickUp.execute(player);

            commandName = "pick up";
        }
        else if (command.equals("drop"))
        {
            DropCommand drop = new DropCommand(argument);
            success = drop.execute(player);
        }
        else if (command.equals("inventory"))
        {
            InventoryCommand inventory = new InventoryCommand();
            success = inventory.execute(player);
        }
        else if (command.equals("help"))
        {
            HelpCommand help = new HelpCommand();
            success = help.execute(player);
        }
        else
        {
            System.out.println("I don't understand that command.");
            return false;
        }

        if (!success)
        {
            return false;
        }

        int timeUsed = timeSystem.getCommandTime(commandName);

        timeSystem.useTime(timeUsed);

        /*
         * If the action uses up all the time or goes below zero, immediately
         * check the ending condition.
         */
        if (timeSystem.isTimeUp())
        {
            return checkEndingCondition();
        }

        System.out.println(
            "Time remaining: " + timeSystem.getRemainingTime() + " seconds");

        /*
         * If the player successfully enters the cellar, ask whether they want
         * to enter it now.
         */
        if (commandName.equalsIgnoreCase("go")
            && player.getCurrentLocation() == cellar)
        {
            return askEnterCellar();
        }

        return false;
    }


    public boolean askEnterCellar()
    {
        Scanner scanner = new Scanner(System.in);

        while (true)
        {
            System.out.print(
                "You have reached the cellar. "
                    + "Do you want to enter the cellar now? (yes/no): ");

            String answer = scanner.nextLine().trim();

            if (answer.equalsIgnoreCase("yes"))
            {
                return checkSurvivalCondition();
            }
            else if (answer.equalsIgnoreCase("no"))
            {
                return false;
            }
            else
            {
                System.out.println("Please enter yes or no.");
            }
        }
    }


    /**
     * Checks the result when the remaining game time reaches zero.
     *
     * @return true because the game ends when time runs out
     */
    public boolean checkEndingCondition()
    {

        if (player.getCurrentLocation() == cellar)
        {
            return checkSurvivalCondition();
        }

        System.out.println();
        System.out.println("You have no more time.");
        System.out.println("MAX has hit Earth.");
        System.out.println("Game over.");

        return true;
    }


    /**
     * Checks whether the player has the food, drink, and tool needed to
     * survive.
     *
     * @return true if the game ends after the survival check, otherwise false
     */
    public boolean checkSurvivalCondition()
    {
        boolean hasFood = false;
        boolean hasDrink = false;
        boolean hasTool = false;

        for (Item item : player.getInventory())
        {
            if (item.getType().equalsIgnoreCase("food"))
            {
                hasFood = true;
            }
            else if (item.getType().equalsIgnoreCase("drink"))
            {
                hasDrink = true;
            }
            else if (item.getType().equalsIgnoreCase("tool"))
            {
                hasTool = true;
            }
        }

        if (!hasFood || !hasDrink || !hasTool)
        {
            showSurvivalFailure(hasFood, hasDrink, hasTool);
            return true;
        }

        return calculateFinalScore();
    }


    /**
     * Displays the supplies missing from the player's inventory.
     *
     * @param hasFood
     *            whether the player has food
     * @param hasDrink
     *            whether the player has a drink
     * @param hasTool
     *            whether the player has a tool
     */
    public
        void
        showSurvivalFailure(boolean hasFood, boolean hasDrink, boolean hasTool)
    {
        System.out.println();
        System.out.println(
            "You reached the shelter, but you are missing some supplies.");

        String missing = "";

        if (!hasFood)
        {
            missing += "food";
        }

        if (!hasDrink)
        {
            if (!missing.isEmpty())
            {
                missing += " and ";
            }

            missing += "drink";
        }

        if (!hasTool)
        {
            if (!missing.isEmpty())
            {
                missing += " and ";
            }

            missing += "tool";
        }

        System.out.println("You are missing: " + missing + ".");

        if (!hasFood)
        {
            System.out.println("Without food, you eventually starve to death.");
        }

        if (!hasDrink)
        {
            System.out.println("Without water, you eventually die of thirst.");
        }

        if (!hasTool)
        {
            System.out.println(
                "Without a tool, you have no way to get news from the outside "
                + "world or entertain yourself.");
            System.out.println(
                "You develop claustrophobia.");
        }

        System.out.println("Game over.");
    }


    /**
     * Calculates the player's final score using item points and bonuses.
     *
     * @return true because the game ends after the final score is calculated
     */
    public boolean calculateFinalScore()
    {
        Points points = new Points();

        int itemPoints = points.calculatePoints(player.getInventory());

        int bonusPoints = 0;

        boolean hasOven = false;

        for (Item item : player.getInventory())
        {
            if (item.getName().equalsIgnoreCase("oven"))
            {
                hasOven = true;
                break;
            }
        }

        if (hasOven)
        {
            for (Item item : player.getInventory())
            {
                if (item.getName().equalsIgnoreCase("chicken")
                    || item.getName().equalsIgnoreCase("steak"))
                {
                    bonusPoints += 5;
                }
            }
        }

        int finalScore = itemPoints + bonusPoints;

        showFinalResult(itemPoints, bonusPoints, finalScore);

        return true;
    }


    /**
     * Displays the final survival result and score.
     *
     * @param itemPoints
     *            the points from the player's items
     * @param bonusPoints
     *            the bonus points earned
     * @param finalScore
     *            the player's final score
     */
    public void showFinalResult(int itemPoints, int bonusPoints, int finalScore)
    {
        System.out.println();
        System.out.println("==============================");
        System.out.println("       SURVIVAL SUCCESS!");
        System.out.println("==============================");

        System.out.println();
        System.out.println("You made it to the underground shelter.");

        System.out
            .println("You have enough food, drink, and tools to survive.");

        System.out.println();
        System.out.println("Item points: " + itemPoints);
        System.out.println("Oven and meat bonus: " + bonusPoints);
        System.out.println("Final score: " + finalScore);

        System.out.println();

        System.out.println("You survived!");
        System.out.println("Game over.");
    }

    private Location cellar;

    /**
     * Creates the game rooms, connects the rooms, adds items, and sets the
     * player's starting location.
     */
    public void createRooms()
    {
        Location kitchen = new Location(
            "You walk into the kitchen and open the refrigerator. "
                + "Inside, there are some chicken thighs, a piece of steak "
                + "and a box of milk that you bought a few days ago.\n"
                + "\"High protein,\" you think.\n"
                + "You stare at the meat for a moment.\n"
                + "\"But I can't exactly cosplay as a caveman and eat raw meat.\"");

        Location bedroom = new Location(
            "You walk into the bedroom and look at your soft, comfortable bed.\n"
                + "\"If only this were all just a dream,\" you think.\n"
                + "You stare at your pillow for a moment.\n"
                + "\"Maybe I should bring my pillow. At least I could get some sleep "
                + "in the shelter.\"\n"
                + "On the nightstand, there is a bottle of Powerade.\n"
                + "You look at it suspiciously.\n"
                + "\"An energy drink? Maybe this will give me enough energy to face "
                + "the end of the world.\"");

        Location homeoffice = new Location(
            "You stand in the middle of the home office. "
                + "The radio is still screaming through a storm of static.\n"
                + "\"Oh no! Oh no! We're doomed!\" the radio screams.\n"
                + "On your desk, there are a bunch of bananas. They are your usual breakfast.\n"
                + "Next to them sits a large bottle of Smartwater.\n"
                + "You look at the bottle and think:\n"
                + "\"If I drink enough Smartwater, maybe I'll become smarter.\"\n"
                + "You glance at the clock.\n"
                + "\"Hopefully, smarter comes before the asteroid.\"");

        Location restroom = new Location(
            "You walk into the restroom. Next to the toilet sits a bucket of water "
                + "that you were planning to use for watering the plants.\n"
                + "You stare at it for a moment.\n"
                + "\"Maybe I should bring some extra water,\" you think.\n"
                + "Then a basic survival fact suddenly comes to mind:\n"
                + "\"How long can a person even survive without water? Three days? Maybe less?\"\n"
                + "You look at the bucket again.\n"
                + "\"I'd rather not find out.\"");

        Location livingroom = new Location(
            "You enter the living room and look around for anything that might be useful.\n"
                + "On the table, there is an open bag of chips. You recognize it immediately - "
                + "it is the vinegar-flavored Lay's you opened last week while watching the game.\n"
                + "\"Not bad. My favorite,\" you think.\n"
                + "On the couch, there is also a bag of French bread that you have no idea "
                + "when you bought. It looks incredibly hard and stale.\n"
                + "\"Maybe I can use it for self-defense,\" you think.");

        cellar = new Location(
            "The lights near the cellar flicker ominously.\n"
                + "\"Finally! If I hide in the cellar, I might actually survive!\" you think.\n"
                + "Near the cellar, there is a pile of random junk covered in dust. "
                + "Among the mess, you spot a small old oven and a hammer.\n"
                + "You stare at the hammer.\n"
                + "\"If only I were Thor. I could smash that asteroid and save the world.\"\n"
                + "You pause for a moment.\n"
                + "\"After saving the world, do you think I could finally get out of my "
                + "CS 2114 homework?\"\n" + "You sigh.\n"
                + "\"Probably not.\"");

        // Connect rooms
        cellar.connectLocation("north", bedroom);
        bedroom.connectLocation("south", cellar);

        cellar.connectLocation("south", homeoffice);
        homeoffice.connectLocation("north", cellar);

        cellar.connectLocation("west", livingroom);
        livingroom.connectLocation("east", cellar);

        livingroom.connectLocation("west", restroom);
        restroom.connectLocation("east", livingroom);

        livingroom.connectLocation("north", kitchen);
        kitchen.connectLocation("south", livingroom);

        // Restroom
        Item water = new Item("water", 5, "drink", -10);
        restroom.addItem(water);

        // Living room
        Item chips = new Item("chips", 1, "food", 5);

        Item bread = new Item("bread", 2, "food", 5);

        livingroom.addItem(chips);
        livingroom.addItem(bread);

        // Kitchen
        Item steak = new Item("steak", 2, "food", 10);

        Item chicken = new Item("chicken", 2, "food", 10);

        Item milk = new Item("milk", 2, "drink", 5);

        kitchen.addItem(steak);
        kitchen.addItem(chicken);
        kitchen.addItem(milk);

        // Bedroom
        Item powerade = new Item("powerade", 2, "drink", 10);

        Item pillow = new Item("pillow", 3, "tool", 5);

        bedroom.addItem(powerade);
        bedroom.addItem(pillow);

        // Home office
        Item banana = new Item("banana", 1, "food", 5);

        Item bottlewater = new Item("bottlewater", 2, "drink", 10);

        Item radio = new Item("radio", 3, "tool", 10);

        homeoffice.addItem(banana);
        homeoffice.addItem(bottlewater);
        homeoffice.addItem(radio);

        // Cellar
        Item oven = new Item("oven", 20, "tool", 15);

        Item hammer = new Item("hammer", 5, "tool", 15);

        cellar.addItem(oven);
        cellar.addItem(hammer);

        // Starting location
        player.setCurrentLocation(homeoffice);
    }
}
