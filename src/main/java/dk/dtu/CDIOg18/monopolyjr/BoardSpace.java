package dk.dtu.CDIOg18.monopolyjr;

import java.util.ArrayList;

import dk.dtu.CDIOg18.monopolyjr.fields.Field;

public class BoardSpace {
   private Field field;
   private ArrayList<Player> players;
   
   public BoardSpace(Field field) {
      this.field = field;
      this.players = new ArrayList<>();
   }

   public BoardSpace(Field field, Player[] players) {
      this.field = field;
      this.players = new ArrayList<>();

      for (Player player : players) {
         this.players.add(player);
      }
   }

   public Field getField() {
      return this.field;
   }

   public Player[] getPlayers() {
      Player[] playersArr = new Player[this.players.size()];

      this.players.toArray(playersArr);
      
      return playersArr;
   }

   public void addPlayer(Player player) {
      this.players.add(player);
   }

   public void removePlayer(Player player) {
      this.players.remove(player);
   }
   
}
