package dk.dtu.CDIOg18.monopolyjr;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;

public class AccountTest {
    
    private final String playerName = "Johnny Test";
    private final int playerAge = 10;
    private final Token token = Token.BOAT;
    private final double startingBalance = 20;

    private Player player;

    @BeforeEach
    public void setup() {
        Account account = new Account(startingBalance);
        player = new Player(playerName, playerAge, token, account);
    }

    public void shouldNotGoInMinusWhenWithdrawAndShouldReturnFalse() {
        // Test for "off by one error"
        assertFalse(player.getAccount().withdraw(startingBalance - 1));
        assertEquals(0, player.getAccount().getBalance());
    }

    public void shouldNotReturnFalseWhenAccountIsZero() {
        assertTrue(player.getAccount().withdraw(startingBalance));
    }

    public void shouldNotAllowAccountDepositAndWithdrawWithNegativeInput() {
        double negativeAmount = -10;
        player.getAccount().deposit(negativeAmount);
        assertEquals(player.getAccount(), startingBalance);
        player.getAccount().withdraw(negativeAmount);
        assertEquals(player.getAccount(), startingBalance);
    }
}
