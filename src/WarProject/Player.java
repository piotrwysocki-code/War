/**
 * SYST 17796 Project Base code.
 * Students can modify and extend to implement their game.
 * Add your name as an author and the date!
 */
package WarProject;

/**
 * A class that models each Player in the game. Players have an identifier,
 * which should be unique.
 *
 * @author dancye
 * @author Paul Bonenfant Jan 2020
 * @author Piotr Wysocki 8/8/2020
 */
public abstract class Player {

    private String username; //the unique name for this player profile
    private String password; //the password for this player profile

    /**
     * @return the player name
     */
    public String getUsername() {
        return username;
    }

    /**
     * Ensure that the playerID is unique
     *
     * @param name
     */
    public void setUsername(String name) {
        username = name;
    }
    
    /**
     * Sets the player's password
     * 
     * @param pass 
     */
    public void setPassword(String pass) {
        password = Troops.encrypt(pass);
    }
    
    /**
     * Gets the player's password
     * 
     * @return decrypted password
     */
    public String getPassword() {
        return Troops.decrypt(password);
    }

}
