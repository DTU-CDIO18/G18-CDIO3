package dk.dtu.CDIOg18.monopolyjr;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import dk.dtu.CDIOg18.monopolyjr.fields.*;

// Requirement:
//  * Move player around the board
//      - 
public class Board {
    private Bank bank;
    // private Field[] fields;
    private BoardSpace[] boardSpaces;

    /**
     * HashMap of the player, and their index on the board
     */
    private Map<Player, Integer> players;


    public Board(Bank bank, BoardSpace[] boardSpaces, Player[] players) {
        this.bank = bank;
        this.boardSpaces = boardSpaces;
        
        this.players = new HashMap<Player, Integer>();
        for (Player player : players) {
            // Each player's start index is 0
            this.players.put(player, 0);
        }
        
    } 

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();

        // TODO: Make a proper toString method

        return str.toString();
    }

    public void display() {
        System.out.println(this.toString());
    }

    public int getPlayerPos(Player player) {
        return this.players.get(player);
    }

    public BoardSpace getPlayerBoardSpace(Player player) {
        return this.boardSpaces[this.players.get(player)];
    }

    public void movePlayer(Player player, int numSpaces) throws PlayerOutOfMoneyException {
        int playerIndex = this.players.get(player);

        PassableField[] passedPassableFields = this.passedPassableFields(playerIndex, numSpaces);
        for (PassableField passableField : passedPassableFields) {
            passableField.fieldPassed(player, this.bank);
        }

        int playerNewIndex = (playerIndex + numSpaces) % this.boardSpaces.length;
        this.players.replace(player, playerNewIndex);

        Field boardSpace = this.boardSpaces[playerNewIndex].getField();
        if (boardSpace instanceof PropertyField) {
            PropertyField propertyField = (PropertyField) boardSpace;

            if (!propertyField.hasOwner()) {
                buyField(player, propertyField);
            }
            else {
                payFieldOwner(player, propertyField);

            }
        }

    }

    private PassableField[] passedPassableFields(int start, int numSpaces) {
        // Loop over the array in a circular manner
        // i.e when at the end of the array, start over at the start until the itterator `i` is fulfilled
        // Adapted from: https://stackoverflow.com/questions/8651965/java-array-traversal-in-circular-manner
        ArrayList<PassableField> passableFields = new ArrayList<>();
        for (int i = 0, arrIdx = start; i < numSpaces; i++, arrIdx = ((start + i) % this.boardSpaces.length)) {
            if (this.boardSpaces[arrIdx].getField() instanceof PassableField) {
                passableFields.add((PassableField) this.boardSpaces[arrIdx].getField());
            } 
        }

        PassableField[] passableFieldArr = new PassableField[passableFields.size()];
        passableFields.toArray(passableFieldArr);

        return passableFieldArr;
    }

    /**
     * @return returns true if field is bought, and false if field is already owned
     */
    private void buyField(Player player, PropertyField propertyField) throws PlayerOutOfMoneyException {
        double price = propertyField.getPrice();

        if (player.getAccount().getBalance() < price)
            throw new PlayerOutOfMoneyException(player);
        
        this.bank.takeMoney(player.getAccount(), price);
        propertyField.setOwner(player);
    }

    private void payFieldOwner(Player player, PropertyField propertyField) throws PlayerOutOfMoneyException {
        double price = propertyField.getPrice();

        if (player.getAccount().getBalance() < price) 
            throw new PlayerOutOfMoneyException(player);

        this.bank.takeMoney(player.getAccount(), price);
        this.bank.giveMoney(propertyField.getOwner().getAccount(), price);

    }

    public static void main(String[] args) {
        Bank bank = new Bank();

        BoardSpace[] boardSpaces = new BoardSpace[] {
            new BoardSpace(new GoField("Go", 10)),
            new BoardSpace(null),
            new BoardSpace(new PropertyField("Test", 5)),
            new BoardSpace(new PropertyField("Test2", 2)),
            new BoardSpace(new Jail(0, "Jail")),
        };

        Player[] players = new Player[] {
            new Player("Lars",  10, Token.BOAT, new Account(0)),
            new Player("Karl",  23, Token.CAR , new Account(0)),
            new Player("John",   0, Token.CAT , new Account(0)),
            new Player("Benny", 99, Token.DOG , new Account(0)), 
        };

        Board board = new Board(bank, boardSpaces, players);

        board.display();
    }
}