package dk.dtu.CDIOg18.monopolyjr;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

public class AccountTest {

    private final String playerName = "Johnny Test";
    private final int playerAge = 10;
    private final Token token = Token.BOAT;
    private final double startingBalance = 20;

    private Player player;

    public void setup() {
        Account account = new Account(startingBalance);
        player = new Player(playerName, playerAge, token, account);
    }

    @Test
    public void shouldNotGoInMinusWhenWithdrawAndShouldReturnFalse() {
        setup();
        // Test for "off by one error"
        assertFalse(player.getAccount().withdraw(startingBalance + 1));
        assertEquals(startingBalance, player.getAccount().getBalance());
    }

    @Test
    public void shouldNotReturnFalseWhenAccountIsZero() {
        setup();
        assertTrue(player.getAccount().withdraw(startingBalance));
    }

    @Test
    public void shouldNotAllowAccountDepositAndWithdrawWithNegativeInput() {
        setup();
        double negativeAmount = -1;
        assertThrows(IllegalArgumentException.class, () -> player.getAccount().withdraw(negativeAmount));
        assertThrows(IllegalArgumentException.class, () -> player.getAccount().deposit(negativeAmount));
        assertEquals(startingBalance, player.getAccount().getBalance());
    }
}
