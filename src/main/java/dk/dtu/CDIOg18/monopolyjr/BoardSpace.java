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

   public Field getField() {
      return this.field;
   }

   public Token[] getTokens() {
      Token[] tokenArr = new Token[this.tokens.size()];

      this.tokens.toArray(tokenArr);
      
      return tokenArr;
   }

   public void addToken(Token token) {
      this.tokens.add(token);
   }

   public void removeToken(Token token) {
      this.tokens.remove(token);
   }
   
}
