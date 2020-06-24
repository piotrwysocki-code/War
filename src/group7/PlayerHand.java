/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package group7;

import java.util.ArrayList;

/**
 *
 * @author Asus X540LA
 */
public class PlayerHand extends DeckOf52 {

    public void addCard(Card a) {
        cards.add(a);
    }

    public ArrayList<Card> getHand() {
        return cards;
    }
    
    public int cardCount(){
        return cards.size();
    }

    public PlayingCard draw() {
        PlayingCard draw = (PlayingCard)cards.get(0);
        return draw;
        
    }
    
    public Card blindDraw() {
        return cards.get(0);
    }
   /*@Override
    public String toString(){
        
        String deck = ""; 
        int counter = 1;
        
        for(Card a: cards){
            deck += "\n" + "[" + counter + "] " ;
            counter++;
        }
        return deck;
    }*/
}
