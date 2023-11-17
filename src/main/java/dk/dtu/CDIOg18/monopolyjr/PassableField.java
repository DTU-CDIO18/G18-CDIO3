package dk.dtu.CDIOg18.monopolyjr;

public abstract class PassableField extends Field {

    public PassableField(int index, String name, FieldType fieldType) {
        super(index, name, fieldType);
    }

    public abstract void fieldPassed(Token token, Bank bank);
    
}
