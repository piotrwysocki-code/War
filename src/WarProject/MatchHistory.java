package WarProject;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * This class represents a match history object which stores game records for a
 * specific player of a game.
 * 
 * @author Piotr Wysocki 8/8/2020
 */
public class MatchHistory {

    protected ArrayList<GameRecord> history = new ArrayList();

    public MatchHistory() {
        
    }
    
    /**
     * A constructor which accepts a file as a parameter and loads the data
     * into the array list using the loadFromFile(file) method 
     * 
     * @param file 
     */
    public MatchHistory(File file) {
        loadFromFile(file);
    }
    
    /**
     * Method which returns the record stored at the given index
     * 
     * @param index
     * @return history.get(index)
     */
    public GameRecord get(int index){
        return history.get(index);
    }
    
    /**
     * Method which returns the size of the history list
     * 
     * @return history.size();
     */
    public int size(){
        return history.size();
    }
    
    /**
     * This method adds a GameRecord object to the history list
     * 
     * @param GameRecord
     */
    public void add(GameRecord r) {
        history.add(r);
    }
    
    /**
     * Loads the match history data stored in the file to the array list
     * 
     * @param file 
     */
    public void loadFromFile(File file) {
        if (file.exists()) {
            try {
                Scanner input = new Scanner(file);
                input.useDelimiter("\\|");
                while (input.hasNextLine()) {
                    String s = input.nextLine();
                    String[] values = s.split("\\|");

                    String name = values[0];
                    String opp = values[1];
                    String wol = values[2];
                    GameRecord record = new GameRecord(name, opp, wol);

                    history.add(record);
                }
                input.close();
            } catch (FileNotFoundException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }
    
    /**
     * Writes the data stored in the history array list into an external file
     * 
     * @param file
     * @throws FileNotFoundException
     * @throws IOException 
     */
    public void writeToFile(File file) throws FileNotFoundException, IOException {
        try (PrintWriter writer = new PrintWriter(new FileOutputStream(file, true))) {
            for (GameRecord r : history) {
                writer.println(r.toFileString());

            }
        }

    }
    
    /**
     * Returns the given match history for a specified player
     * 
     * @param name
     * @return data
     */
    public MatchHistory getPlayerHistory(String name) {
        MatchHistory data = new MatchHistory();
        for (GameRecord r : history) {
            if (r.getPlayerName().equals(name)) {
                data.add(r);
            }
        }
        return data;
    }
    
    @Override
    public String toString(){
        String data = "";
        for(GameRecord r : history){
            data += r;
        }
        return data;
    }

}
