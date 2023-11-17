package dk.dtu.CDIOg18.monopolyjr;

public class PropertyField extends Field {

    private Player owner;
    private double price;

    public PropertyField(int index, String name, double price) {
        super(index, name, FieldType.PROPERTY);
        this.price = price;
    }

    @Override
    public void landOnField(Token token, Bank bank) {
        Player player = token.getPlayer();
        if(hasOwner()) {
           player.getAccount().payPlayer(owner, price);
            return;
        }
        setOwner(player);
    }

    public boolean hasOwner() {
        return owner != null;
    }

    public void setOwner(Player player) {
        if(hasOwner()) {
            return;
        }
        owner = player;
    }

    public Player getOwner() {
        return owner;
    }
    
    public double getPrice() {
        return price;
    }
}
