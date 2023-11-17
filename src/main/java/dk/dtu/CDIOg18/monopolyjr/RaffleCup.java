package dk.dtu.CDIOg18.monopolyjr;

public class RaffleCup {

    private Die[] dice;

    RaffleCup(Die[] dice) {
        this.dice = dice;
    }

    public int[] roll() {
        int[] diceResults = new int[dice.length];
        for (int i = 0; i < dice.length; i++) {
            diceResults[i] = dice[i].getFaceValue();
        }
        return diceResults;
    }
}
