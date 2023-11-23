package dk.dtu.CDIOg18.monopolyjr.fields;

import dk.dtu.CDIOg18.monopolyjr.Bank;
import dk.dtu.CDIOg18.monopolyjr.Player;

public abstract class PassableField extends Field {

    public PassableField(String name, FieldType fieldType) {
        super(name, fieldType);
    }

    public abstract void fieldPassed(Player player, Bank bank);
    
}
