package dk.dtu.CDIOg18.monopolyjr;

public class Account {
    
    private double balance = 0;

    public Account(double balance) {
        setBalance(balance);
    }

    private void setBalance(double balance) {
         if(balance < 0) throw new IllegalArgumentException("Balance cannot be negative");
        this.balance = balance;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        if(amount < 0) throw new IllegalArgumentException("Amount cannot be negative");
        balance += amount;
    }

    /**
     * Withdraws money from the player's account. Always 
     * @param amount - Always supposed to be a positive value
     * @return true of the withdaw was successful and false if the player ends up with minus balance
     */
    public boolean withdraw(double amount) {
        if(amount < 0) throw new IllegalArgumentException("Amount cannot be negative");
        if(balance - amount < 0) {
            return false;
        }
        balance -= amount;
        return true;
    }

    public void payPlayer(Player player, double amount) {
        withdraw(amount);
        player.getAccount().deposit(amount);
    }
}
