package dk.dtu.CDIOg18.monopolyjr;

import java.util.ArrayList;

public class BoardSpace {
   private Field field;
   private ArrayList<Token> tokens;
   
   public BoardSpace(Field field) {
      this.field = field;
      this.tokens = new ArrayList<>();
   }

   public BoardSpace(Field field, Token tokens) {
      this.field = field;
      this.tokens = new ArrayList<>();

      for (Token token : this.tokens) {
         this.tokens.add(token);
      }
   }
}
