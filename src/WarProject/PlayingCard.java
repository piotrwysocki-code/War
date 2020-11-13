package WarProject;

/**
 * This class models a classic playing card
 * 
 * @author Piotr Wysocki 8/8/2020
 */
public final class PlayingCard extends Card {
    
    protected Suit suit;
    protected Value value;    
       
    public PlayingCard(Value a, Suit b){
        this.suit = b;
        this.value = a;
        
    }
    
     /**
     * Getter method of 'Value'
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
        
        return String.format("[" + value + " | " + suit + "]");
    
    }
    
    /**
     * method used to compare two playing cards
     * 
     * @param o
     * @return int
     */
    public int compareTo(Object o) {
        PlayingCard test = (PlayingCard)o;
        if (this.getValue().getIntValue() == test.getValue().getIntValue()) {
            return 0;
        } else if (this.getValue().getIntValue() < test.getValue().getIntValue()) {
            return -1;
        } else {
            return 1;
        }
    }
     
}
