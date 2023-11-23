package dk.dtu.CDIOg18.monopolyjr.fields;

import dk.dtu.CDIOg18.monopolyjr.Bank;
import dk.dtu.CDIOg18.monopolyjr.Player;

public class PropertyField extends Field {

    private Player owner;
    private double price;

    public PropertyField(String name, double price) {
        super(name, FieldType.PROPERTY);
        this.price = price;
    }

    @Override
    public void landOnField(Player player, Bank bank) {
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
