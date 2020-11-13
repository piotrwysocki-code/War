package WarProject;

/**
 * This class models the player of the war game, or a soldier
 * 
 * @author Piotr Wysocki 8/8/2020
 */
public class Soldier extends Player {

    protected PlayerHand hand = new PlayerHand();

    private int wins = 0;
    private int losses = 0;
    private final double winPercent = wins > 0 ?(wins / wins + losses) * 100 : 0;
    private MatchHistory history = new MatchHistory();

    public Soldier() {

    }

    /**
     * A constructor that allows you to set the player's unique ID(username) and
     * password
     *
     * @param username the unique ID to assign to this player.
     * @param password associated with the profile
     * @param wins
     * @param losses
     */
    public Soldier(String username, String password, int wins, int losses) {
        this.setWins(wins);
        this.setLosses(losses);
        super.setUsername(username);
        super.setPassword(password);
    }
    
    /**
     * Constructor that sets the soldiers name and password
     * 
     * @param username
     * @param password 
     */
    public Soldier(String username, String password) {
        super.setUsername(username);
        super.setPassword(password);
    }
    
    /**
     * Method which returns the player's match history
     * 
     * @return player's match history
     */
    public MatchHistory getHistory(){
        return history;
    }
    
    /**
     * loads the specific player's match history
     * 
     * @param m 
     */
    public void pullMatchHistory(MatchHistory m){
        history = m.getPlayerHistory(super.getUsername());
    }
    
    /**
     * returns the player's hand
     * 
     * @return hand
     */
    public PlayerHand getHand() {
        return hand;
    }
    
    /**
     * sets the player's number of wins
     * 
     * @param wins 
     */
    public void setWins(int wins) {
        this.wins = wins;
    }
    
    /**
     * returns the player's number of wins
     * 
     * @return wins
     */
    public int getWins() {
        return wins;
    }
    
    /**
     * returns the player's win percentage
     * 
     * @return win percentage 
     */
    public String getWinPercent() {
        return String.format("%.2f", winPercent);
    }
    
    /**
     * returns the player's losses
     * 
     * @return number of losses
     */
    public int getLosses() {
        return losses;
    }
    
    /**
     * sets the players number of losses
     * 
     * @param l 
     */
    public void setLosses(int l) {
        losses = l;
    }
     
    /**
     * formats the object to a file string
     * 
     * @return 
     */
    public String toFileString() {
        return Troops.encrypt(super.getUsername()) + "|" + Troops.encrypt(super.getPassword())
                + "|" + wins + "|" + losses ;
    }
    
    /**
     * returns the players statistics
     * 
     * @return stats
     */
    public String getStats() {
        String stats = "Wins: " + wins + " Losses: " + losses + " Win Rate: "
                + getWinPercent() + "%";
        return stats;
    }
    
        @Override
    public String toString() {
        return getUsername() + " " + Troops.encrypt(getPassword());
    }

}
