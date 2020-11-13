package WarProject;

/**
 * This class models a game record to be stored in the match history
 * 
 * @author Piotr Wysocki 8/8/2020
 */
public class GameRecord {
    
    private String playerName;
    private String opponent;
    private String result;
    
    /**
     * Constructor that initializes playerName, opponent, and result
     * 
     * @param playerName
     * @param opp
     * @param wol 
     */
    public GameRecord(String playerName, String opp, String wol) {
        this.playerName = playerName;
        opponent = opp;
        result = wol;
    }
    
    /**
     * Getter method for the opponent's name
     * 
     * @return opponent name
     */
    public String getOpponent() {
        return opponent;
    }
    
    /**
     * Setter method for the opponents name
     * 
     * @param opponent 
     */
    public void setOpponent(String opponent) {
        this.opponent = opponent;
    }
    
    /**
     * Setter method for the player's name
     * 
     * @param name 
     */
    public void setPlayerName(String name){
        playerName = name;
    }
    
    /**
     * Getter method for the player's name
     * 
     * @return player name
     */
    public String getPlayerName(){
        return playerName;
    }
    
    /**
     * Formats the game record object to a file appropriate string
     * 
     * @return 
     */
    public String toFileString() {
        return  playerName + "|" + opponent + "|" + result;
    }
    
    @Override
    public String toString(){       
        return "Player: " + playerName + "\nOpponent: " + opponent + "\nResult: " + result + "\n";
    }
    
    
    
    
    

}
