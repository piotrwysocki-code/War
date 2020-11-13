package WarProject;

/**
 * Enum for the playing card's suit
 * 
 * @author Piotr Wysocki 8/8/2020
 */
public enum Suit {
    HEARTS("HEARTS"),
    CLUBS("CLUBS"),
    DIAMONDS("DIAMNONDS"),
    SPADES("SPADES");

    private final String suit;

    Suit(String s) {
        suit = s;
    }

    public String getName() {
        return suit;
    }
}
