package WarProject;

/**
 * Enum class for the playing card's value
 * 
 * @author Piotr Wysocki 8/8/2020
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

