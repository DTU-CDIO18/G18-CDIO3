package dk.dtu.CDIOg18.monopolyjr.fields;

import dk.dtu.CDIOg18.monopolyjr.Bank;
import dk.dtu.CDIOg18.monopolyjr.Token;

public abstract class Field {
    
    private String name;
    private FieldType fieldType;

    public Field(String name, FieldType fieldType) {
        this.name = name;
        this.fieldType = fieldType;
    }

    public String getName() {
        return name;
    }

    public FieldType getFieldType() {
        return fieldType;
    }

    // TODO: I am not sure if this one is actually needed, but I will mark it and come back to it later
    public abstract void landOnField(Token token, Bank bank);

}
