/**
 * SYST 17796 Project Base code.
 * Students can modify and extend to implement their game.
 * Add your name as an author and the date!
 */
package WarProject;

import java.util.ArrayList;
import java.util.Collections;

/**
 * A concrete class that represents any grouping of cards for a Game. HINT, you might want to subclass this more than
 * once. The group of cards has a maximum size attribute which is flexible for reuse.
 *
 * @author dancye
 * @author Paul Bonenfant Jan 2020
 * @author Piotr Wysocki 8/8/2020
 */
public class GroupOfCards {

    //The group of cards, stored in an ArrayList
    protected ArrayList cards = new ArrayList();
    
    /**
     * A method that will get the group of cards as an ArrayList
     *
     * @return the group of cards.
     */
    public ArrayList<Card> cards() {
        return this.cards;
    }

    public void shuffle() {
        Collections.shuffle(cards);
    }

    /**
     * @return the size of the group of cards
     */
    public int getSize() {
        return cards.size();
    }

   @Override
    public String toString(){
        
        String deck = ""; 
        int counter = 1;
        
        for(Object a: cards){
            deck += "\n" + "[" + counter + "] " + a.toString();
            counter++;
        }
        return deck;
   
    }
}
