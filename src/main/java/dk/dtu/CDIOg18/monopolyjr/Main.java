package dk.dtu.CDIOg18.monopolyjr;

import java.util.Scanner;
import java.util.Arrays;
import java.util.function.Function;
import java.io.StringWriter;
import java.io.PrintWriter;

import dk.dtu.CDIOg18.monopolyjr.fields.GoField;
import dk.dtu.CDIOg18.monopolyjr.fields.Jail;
import dk.dtu.CDIOg18.monopolyjr.fields.PropertyField;

public class Main {
    private static double START_BALANCE = 0;

    private static BoardSpace[] DEFAULT_BOARD_SPACE = new BoardSpace[] {
        // Bottom right
        new BoardSpace(new GoField("Go", 2)),
        
        // Bottom of board
        new BoardSpace(new PropertyField("Burger Joint", 1)),
        new BoardSpace(new PropertyField("Pizza House", 1)),
        new BoardSpace(null), // TODO: Implement chance space
        new BoardSpace(new PropertyField("Candy Store", 1)),
        new BoardSpace(new PropertyField("Ice Cream Parlour", 1)),
        
        // Bottom Left corner
        new BoardSpace(new Jail(0, "Jail")), // TODO: Rewrite `Jail` constructor

        // Left side
        new BoardSpace(new PropertyField("Museum", 2)),
        new BoardSpace(new PropertyField("Library", 2)),
        new BoardSpace(null), // Chance card
        new BoardSpace(new PropertyField("Skate Park", 2)),
        new BoardSpace(new PropertyField("Swimming Pool", 2)),

        // Top left corner
        new BoardSpace(null), // Free parking; literally does nothing, so whatever, i guess lmao

        // Top of board
        new BoardSpace(new PropertyField("Video Game Arcade", 3)),
        new BoardSpace(new PropertyField("Movie Theatre", 3)),
        new BoardSpace(null), // Chance card
        new BoardSpace(new PropertyField("Toy Store", 3)),
        new BoardSpace(new PropertyField("Pet Store", 3)),

        // Top right corner
        new BoardSpace(null), // TODO: Go to jail

        // Right side
        new BoardSpace(new PropertyField("Bowling Alley", 4)),
        new BoardSpace(new PropertyField("The Zoo", 4)),
        new BoardSpace(null), // Chance card
        new BoardSpace(new PropertyField("Park Place", 5)),
        new BoardSpace(new PropertyField("Boardwalk", 5)),
    };

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Bank bank = new Bank();

        int numPlayers = loopUntilValidInt(scanner, "How many players should play the game?: ");

        Player[] players = new Player[numPlayers];
        for (int i = 0; i < numPlayers; i++) {
            System.out.printf("Player %d:\n", i+1);

            String name = loopUntilValidString(scanner, "Enter name: ");
            int age = loopUntilValidInt(scanner, "Enter age: ");
            Token token = loopUntilValid(scanner, Token.class, "Choose token [cat, dog, car, boat]\n", s -> Token.valueOf(s.toUpperCase()));
            Account account = new Account(START_BALANCE);

            Player player = new Player(name, age, token, account);
            players[i] = player;

            System.out.println(); // Newline for easier readability
        }
 
        Board board = new Board(bank, DEFAULT_BOARD_SPACE.clone(), players);
        RaffleCup raffleCup = RaffleCup.createRaffleCup(2);

        int currentPlayerIndex = 0;

        printHelp();
        boolean running = true;
        String s = "";
        while (running) { // Initialize `s` to "" to please the compiler, and read a new line from stdout until `running` is not true
            Player currentPlayer = players[currentPlayerIndex];
            System.out.printf("%s's turn:\n", currentPlayer.getName());

            s = scanner.nextLine();

            switch (s.toLowerCase()) {
                case "q", "quit" -> running = false;

                case "h", "help" -> printHelp();

                case "r", "roll", "" -> {
                    int[] rolledDice = raffleCup.roll();
                    int rolledSum = Arrays.stream(rolledDice).sum();

                    System.out.printf("You rolled %d\n", rolledSum);

                    try { 
                        board.movePlayer(currentPlayer, rolledSum);
                        BoardSpace boardSpace = board.getPlayerBoardSpace(currentPlayer);

                        System.out.printf("You landed on %s\n", boardSpace.getField().getName());
                        if (boardSpace.getField() instanceof PropertyField) {
                            PropertyField propertyField = (PropertyField) boardSpace.getField();

                            if (propertyField.getOwner() == currentPlayer) {
                                System.out.printf("You own %s\n", propertyField.getName());
                            }
                            else {
                                System.out.printf("You paid %s %d money for landing on %s\n", propertyField.getOwner().getName(), propertyField.getPrice(), propertyField.getName());
                            }
                        }

                    } catch (PlayerOutOfMoneyException e) {
                        System.out.println(e.getMessage());
                        // System.out.printf("Player %s has run out of money\n", currentPlayer.getName());
                        System.out.println("GAME OVER"); // TODO: make red
                        running = false;
                    }
                }


            } 
        }
    }

    static private <T> T loopUntilValid(Scanner scanner, Class<T> type, String message, Function<String, T> converter) {
        while (true) {
            System.out.print(message);
            System.out.flush(); // Most stdout's are only flushed/"updated" on newline, so it's good to do it manually
            String input = scanner.nextLine();
            try {
                return converter.apply(input);
            } catch (Exception e) {
                System.out.println("Invalid input try again.\n"); // TODO: make red, customizeable error message, and possibly write to stderr instead??
            }         
        }
    }

    static private int loopUntilValidInt(Scanner scanner, String message) {
        return loopUntilValid(scanner, Integer.class, message, Integer::parseInt);
    }

    static private double loopUntilValidDouble(Scanner scanner, String message) {
        return loopUntilValid(scanner, Double.class, message, Double::parseDouble);
    }
    
    static private String loopUntilValidString(Scanner scanner, String message) {
        return loopUntilValid(scanner, String.class, message, str -> str);
    }
    
    static private void printHelp() {
        // TODO: make proper help
        StringWriter helpString = new StringWriter();
        PrintWriter writer = new PrintWriter(helpString, true);

        writer.println("\"h\" or \"help\" for help");
        writer.println("\"q\" or \"quit\" to quit the game");
        writer.println("\"r\" or \"roll\" to roll the dice");

        System.out.println(helpString.toString());
    }
}
