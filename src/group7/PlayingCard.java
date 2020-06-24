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
public class PlayingCard extends Card{
    
    protected Suit suit;
    protected Value value;

  
    
    public enum Suit{
        HEARTS, 
        CLUBS, 
        DIAMONDS, 
        SPADES
    }    
    
    public enum Value{ 
        ACE , 
        TWO, 
        THREE, 
        FOUR, 
        FIVE, 
        SIX, 
        SEVEN, 
        EIGHT,
        NINE, 
        TEN,
        JACK, 
        QUEEN,
        KING
    }
    
    public PlayingCard(Value a, Suit b){
        this.suit = b;
        this.value = a;
        
    }
    
     /**
     * Getting method of 'Value'
     * 
     * @return value
     */
    public Value getValue() {
        return this.value;
    }
    
    /**
     * Setter method of 'Value'
     * 
     * @param value
     */
    
    public void setValue(Value value) {
        this.value = value;
    }

        /**
     *Setter method for 'suit'
     * 
     * @param suit
     */
    public void setSuit(Suit suit) {
        this.suit = suit;

        }
    
    /**
     * Getter method for 'suit'
     * 
     * @return suit
     */
    public Suit getSuit() {
        return this.suit;
    }
    
    @Override
    public String toString(){
        
        return String.format("[" + value + " " + suit + "] ");
    
    }
    
}
