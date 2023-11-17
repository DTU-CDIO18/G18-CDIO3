package dk.dtu.CDIOg18.monopolyjr.fields;

import dk.dtu.CDIOg18.monopolyjr.Bank;
import dk.dtu.CDIOg18.monopolyjr.Player;
import dk.dtu.CDIOg18.monopolyjr.Token;

public class GoField extends PassableField {

    private final double fieldReward;

    public GoField(String name, double fieldReward) {
        super(name, FieldType.START);
        this.fieldReward = fieldReward;
    }

    @Override
    public void landOnField(Token token, Bank bank) {
        givePlayerReward(token.getPlayer(), bank);
    }

    @Override
    public void fieldPassed(Token token, Bank bank) {
        givePlayerReward(token.getPlayer(), bank);
    }

    private void givePlayerReward(Player player, Bank bank) {
        // FIXME - The money should be given from the bank
        player.getAccount().deposit(fieldReward);
    }
    
}
