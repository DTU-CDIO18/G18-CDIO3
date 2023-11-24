package dk.dtu.CDIOg18.monopolyjr;

public class PlayerOutOfMoneyException extends Exception {
    static String errorMessage = "Player %s is out of money :(";
    
    public PlayerOutOfMoneyException(Player player) {
        super(String.format(errorMessage, player.getName()));
    }
    
}
