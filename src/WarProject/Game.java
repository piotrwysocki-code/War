/**
 * SYST 17796 Project Base code.
 * Students can modify and extend to implement their game.
 * Add your name as an author and the date!
 */
package WarProject;

import java.util.ArrayList;

/**
 * The class that models your game. You should create a more specific child of this class and instantiate the methods
 * given.
 *
 * @author dancye
 * @author Paul Bonenfant Jan 2020
 * @author Piotr Wysocki 8/8/2020
 */
public abstract class Game {

    protected String name;//the title of the game
    protected ArrayList<Player> players = new ArrayList();// the players of the game

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }
    
    public void setName(String name){
        this.name = name;
    }

    /**
     * @return the players of this game
     */
    public ArrayList<Player> getPlayers() {
        return players;
    }

    /**
     * @param p the players of this game
     */
    public void addPlayer(Player p) {
        players.add(p);
    }

    /**
     * Play the game. This might be one method or many method calls depending on your game.
     */
    public abstract void play();

    /**
     * When the game is over, use this method to declare and display a winning player.
     */
    public abstract void declareWinner();

}//end class
