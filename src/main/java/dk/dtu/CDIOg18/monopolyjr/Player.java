package dk.dtu.CDIOg18.monopolyjr;

public class Player {
    
    private String name;
    private int age;
    private Account account;
    private Token token;

    public Player(String name, int age, Token token, Account account) {
        this.name = name;
        this.age = age;
        this.token = token;
        this.account = account;
    }

    public Account getAccount() {
        return account;
    }

    public Token getToken() {
        return this.token;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }
}
