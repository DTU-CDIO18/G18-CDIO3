package dk.dtu.CDIOg18.monopolyjr.fields;

import dk.dtu.CDIOg18.monopolyjr.Bank;
import dk.dtu.CDIOg18.monopolyjr.Player;

public class GoField extends PassableField {

    private final double fieldReward;

    public GoField(String name, double fieldReward) {
        super(name, FieldType.START);
        this.fieldReward = fieldReward;
    }

    @Override
    public void landOnField(Player player, Bank bank) {
        givePlayerReward(player, bank);
    }

    @Override
    public void fieldPassed(Player player, Bank bank) {
        givePlayerReward(player, bank);
    }

    private void givePlayerReward(Player player, Bank bank) {
        // FIXME - The money should be given from the bank
        player.getAccount().deposit(fieldReward);
    }
    
}
