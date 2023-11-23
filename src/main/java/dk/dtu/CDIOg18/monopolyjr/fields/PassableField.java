package dk.dtu.CDIOg18.monopolyjr.fields;

import dk.dtu.CDIOg18.monopolyjr.Bank;
import dk.dtu.CDIOg18.monopolyjr.Token;

public abstract class PassableField extends Field {

    public PassableField(String name, FieldType fieldType) {
        super(name, fieldType);
    }

    public abstract void fieldPassed(Token token, Bank bank);
    
}
