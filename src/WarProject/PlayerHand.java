package WarProject;

import java.util.ArrayList;


/**
 * This class models a player's hand of cards
 * 
 * @author Piotr Wysocki 8/8/2020
 */
public class PlayerHand extends GroupOfCards {

    public void addCard(Card a) {
        cards.add(a);
    }
    
    /**
     * This method draws the top card from the player's hand
     * 
     * @return drawn card
     */
    public PlayingCard draw() {
        PlayingCard draw = (PlayingCard)cards.get(0);
        cards.remove(0);
        return draw;       
    }

    /**
     * This method performs a blind draw, two cards are drawn face down and
     * one card face up. 
     * 
     * @return ArrayList<PlayingCard>
     */
    public ArrayList<PlayingCard> blindDraw() {
        ArrayList<PlayingCard> blindDraw = new ArrayList();
        blindDraw.add((PlayingCard)cards.get(0));
        cards.remove(0);
        blindDraw.add((PlayingCard)cards.get(1));
        cards.remove(1);
        blindDraw.add((PlayingCard)cards.get(2));
        cards.remove(2);
        return blindDraw;
    }
    
}
