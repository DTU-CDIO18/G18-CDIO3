package dk.dtu.CDIOg18.monopolyjr;

public abstract class Field {
    
    private Token[] tokens;
    private String name;
    private FieldType fieldType;

    public Field(String name, FieldType fieldType) {
        this.name = name;
        this.fieldType = fieldType;
    }

    public Token[] getTokens() {
        return tokens;
    }

    public String getName() {
        return name;
    }

    public FieldType getFieldType() {
        return fieldType;
    }

    public abstract void landOnField(Token token, Bank bank);

}
