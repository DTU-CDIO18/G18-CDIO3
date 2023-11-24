package dk.dtu.CDIOg18.monopolyjr;

public class RaffleCup {

    private Die[] dice;

    public RaffleCup(Die[] dice) {
        this.dice = dice;
    }

    public int[] roll() {
        int[] diceResults = new int[dice.length];
        for (int i = 0; i < dice.length; i++) {
            diceResults[i] = dice[i].getFaceValue();
        }
        return diceResults;
    }

    public static RaffleCup createRaffleCup(int numDice) {
        Die[] dice = new Die[numDice];

        for (int i = 0; i < dice.length; i++) {
            dice[i] = new Die();
        }

        return new RaffleCup(dice);
    }
}
