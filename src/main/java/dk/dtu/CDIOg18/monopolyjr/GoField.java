package dk.dtu.CDIOg18.monopolyjr;

public class GoField extends PassableField {

    private final double fieldReward;

    public GoField(int index, String name, double fieldReward) {
        super(index, name, FieldType.START);
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
