package dk.dtu.CDIOg18.monopolyjr.fields;

import dk.dtu.CDIOg18.monopolyjr.Bank;
import dk.dtu.CDIOg18.monopolyjr.Token;

public class Jail extends Field {

    public Jail(int index, String name) {
        super("GO TO JAIL", FieldType.JAIL);
    }

    @Override
    public void landOnField(Token token, Bank bank) {
       
    }


    
}
