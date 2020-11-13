package WarProject;

/**
 * This class represents a deck of 52 playing cards
 * 
 * @author Piotr Wysocki 8/8/2020
 */
public final class DeckOf52 extends GroupOfCards{
    
    public DeckOf52(){
        generateDeck();
    }
    
    /**
     * This method generates a shuffled deck of 52 playing cards
     */
    public void generateDeck(){
        
        for (Suit b: Suit.values()) {
            for (Value a: Value.values()) {
                 PlayingCard addition = new PlayingCard(a, b);
                 cards.add(addition);
            }  
            shuffle();
        }
    }
}
