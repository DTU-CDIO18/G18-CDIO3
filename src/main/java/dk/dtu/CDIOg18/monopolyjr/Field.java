package dk.dtu.CDIOg18.monopolyjr;

public abstract class Field {
    
    private int index;
    private Token[] tokens;
    private String name;
    private FieldType fieldType;

    public Field(int index, String name, FieldType fieldType) {
        this.index = index;
        this.name = name;
        this.fieldType = fieldType;
    }

    public int getIndex() {
        return index;
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

    public abstract void landOnField(Token token);

}
