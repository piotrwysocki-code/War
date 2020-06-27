/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package group7;

/**
 *
 * @author Asus X540LA
 */
public class DeckOf52 extends GroupOfCards{
    
    public DeckOf52(){
        newDeck();
    }
    
    public final void newDeck(){
        
        for (PlayingCard.Suit b: PlayingCard.Suit.values()) {
            for (Value a: Value.values()) {
                 PlayingCard addition = new PlayingCard(a, b);
                 cards.add(addition);
            }  
            shuffle();
        }
    }    
}
