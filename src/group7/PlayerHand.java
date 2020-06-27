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
public class PlayerHand extends GroupOfCards {

    public void addCard(Card a) {
        cards.add(a);
    }

    public Card play() {
        Card draw = cards.get(0);
        cards.remove(0);
        return draw;
        
    }
    
}
