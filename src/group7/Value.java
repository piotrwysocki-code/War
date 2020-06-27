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
public enum Value {
        TWO(2), 
        THREE(3), 
        FOUR(4), 
        FIVE(5), 
        SIX(6), 
        SEVEN(7), 
        EIGHT(8),
        NINE(8), 
        TEN(9),
        JACK(10), 
        QUEEN(11),
        KING(12),
        ACE(13),;
        
        private final int intValue;
        
        Value(int value){
           intValue = value;
        }
        
        public int getIntValue(){
            return intValue;
        }
       
    }

