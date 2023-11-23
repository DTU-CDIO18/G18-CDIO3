package dk.dtu.CDIOg18.monopolyjr;

public class Player {
    
    private String name;
    private int age;
    private Account account;

    public Player(String name, int age, Account account) {
        this.name = name;
        this.age = age;
        this.account = account;
    }

    public Account getAccount() {
        return account;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }
}
