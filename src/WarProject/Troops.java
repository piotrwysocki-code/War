package WarProject;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Class which holds the player information loaded from the file. All player accounts
 * are stored here.
 * 
 * @author Piotr Wysocki 8/8/2020
 */
public class Troops {

    private final static ArrayList<Soldier> troops = new ArrayList();

    public Troops(File file){
        
    }
    
    /**
     * returns the soldiers
     *
     * @return soldier list
     */
    public static final ArrayList<Soldier> getTroops() {
        return troops;
    }
    
    /**
     * Returns a specific soldier by name
     * 
     * @param name
     * @return soldier
     */
    public static final Soldier getSoldier(String name) {
        for (Soldier s : troops) {
            if (s.getUsername().equals(name)) {
                return s;
            }
        }
        return null;
    }
    
    /**
     * Adds a soldier to the list
     * 
     * @param s 
     */
    public static final void addSoldier(Soldier s) {
        troops.add(s);
    }
    
    /**
     * Method which loads the data from the file and creates soldier objects
     * respectively, then adds them to the soldier list.
     * 
     * @param file 
     */
    public static final void loadFromFile(File file) {
        if (file.exists()) {
            try {
                try (Scanner input = new Scanner(file)) {              
                    input.useDelimiter("\\|");
                    while (input.hasNextLine()) {
                        String s = input.nextLine();
 //                       System.out.println(s);
                        String[] values = s.split("\\|");
                        
                        String username = values[0];
                        String password = values[1];
                        int wins = Integer.valueOf(values[2]);
                        int losses = Integer.valueOf(values[3]);
                        
                        Soldier soldier = new Soldier(Troops.decrypt(username), password, wins, losses);
//                        System.out.println(soldier);
                        Troops.addSoldier(soldier);

                    }
                }
            } catch (FileNotFoundException ex) {
                System.out.println(ex.getMessage());
            }          
        }
    }
    
    /**
     * Writes the objects stored in the list to an external file
     * 
     * @param file
     * @throws FileNotFoundException
     * @throws IOException 
     */
    public static final void writeToFile(File file) throws FileNotFoundException, IOException {
        try (PrintWriter writer = new PrintWriter(new FileOutputStream(file, false))) {
            for (Soldier s : Troops.getTroops()) {
                writer.println(s.toFileString());

            }
        }

    }
    
    /**
     * Method which encrypts a given string
     * 
     * @param passwd
     * @return encrypted string
     */
    protected static final String encrypt(String passwd) {
        char[] pass = passwd.toCharArray();
        String encPass = "";
        for (int i = 0; i < pass.length; i++) {
            int key = 2;
            if (i % 2 == 0) {
                pass[i] += 1;
            } else {
                pass[i] += 2;
            }
            encPass += pass[i];
        }
        return encPass;
    }
    
    /**
     * Method which decrypts a given string
     * 
     * @param passwd
     * @return decypted string
     */
    protected static final String decrypt(String passwd) {
        char[] pass = passwd.toCharArray();
        String decPass = "";
        for (int i = 0; i < pass.length; i++) {
            int key = 2;
            if (i % 2 == 0) {
                pass[i] -= 1;
            } else {
                pass[i] -= 2;
            }
            decPass += pass[i];
        }
        return decPass;
    }

}
