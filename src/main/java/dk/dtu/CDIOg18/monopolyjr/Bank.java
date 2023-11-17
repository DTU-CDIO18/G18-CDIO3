package dk.dtu.CDIOg18.monopolyjr;

public class Bank {

    public Bank() {
    }

    public boolean takeMoney(Account account, double amount) {
        return account.withdraw(amount);
    }

    public void giveMoney(Account account, double amount) { 
        account.deposit(amount);
    }
}