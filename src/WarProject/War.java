package WarProject;

import static WarProject.Main.isNumeric;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * This class models a war card game and contains all required function
 * to play the game.
 * 
 * @author Piotr Wysocki 8/8/2020
 */
public class War extends Game{

    private final ArrayList<Soldier> player = new ArrayList<>();
    
    private PlayerHand inPlay = new PlayerHand();

    DeckOf52 deck = new DeckOf52();

    public War() {
        this.name = "LET'S PLAY WAR!!!";
    }
    
    /**
     * The main function of the game, game continues until one player
     * runs out of cards, or 100 rounds are reached
     */
    @Override
    public void play() {
        
        System.out.println(name);

        deck = new DeckOf52();

        for (int i = 0; i < deck.getSize(); i++) {
            PlayingCard temp1 = (PlayingCard) deck.cards().get(i);
            player.get(0).getHand().addCard(temp1);
            deck.cards().remove(i);
        }
        for (int i = 0; i < deck.getSize(); i++) {
            PlayingCard temp2 = (PlayingCard) deck.cards().get(i);
            player.get(1).getHand().addCard(temp2);
        }
        deck.cards().clear();
                
        int count = 1;
       
        do{ 
            Scanner input = new Scanner(System.in);
            System.out.println("Round " + count + " begin? (Enter 'y')");
            
            String cont = input.next();
            
            PlayingCard roundDraw1 = player.get(0).getHand().draw();
            PlayingCard roundDraw2 = player.get(1).getHand().draw();
            
            System.out.println(player.get(0).getUsername() + " drew: " + roundDraw1 
                    + "\n" + player.get(1).getUsername() + " drew: " + roundDraw2);
            
            inPlay.addCard(roundDraw1);
            inPlay.addCard(roundDraw2);
            

            switch (roundDraw1.compareTo(roundDraw2)) {         
                case 0:
                    PlayingCard blindCard1;
                    PlayingCard blindCard2;
                    do{
                        ArrayList<PlayingCard> blind1 = player.get(0).getHand().blindDraw();
                        ArrayList<PlayingCard> blind2 = player.get(1).getHand().blindDraw();
                        blindCard1 = blind1.get(0);
                                
                        blindCard2 = blind2.get(1);
                        System.out.println("*War Round* \n 2 cards face down, 1 face up");
                        System.out.println(player.get(0).getUsername() + " drew: [x][x]"
                                + blind1.get(0)
                                + "\n" + player.get(1).getUsername() + " drew: [x][x]" 
                                + blind2.get(0));

                        inPlay.cards().addAll(blind1);
                        inPlay.cards().addAll(blind2);
                        
                        count++;
                    }while(blindCard1.compareTo(blindCard2) == 0);
                    break;
                case -1:
                    System.out.println(player.get(1).getUsername() + " won the round");
                    player.get(1).getHand().cards().addAll(inPlay.cards());
                    System.out.println(player.get(0).getUsername() + " has " + player.get(0).getHand().cards().size() + " cards");
                    System.out.println(player.get(1).getUsername() + " has " + player.get(1).getHand().cards().size() + " cards");
                    inPlay.cards().clear();
                    count++;
                    break;
                default:
                    System.out.println(player.get(0).getUsername() + " won the round");
                    player.get(0).getHand().cards().addAll(inPlay.cards());
                    System.out.println(player.get(0).getUsername() + " has " + player.get(0).getHand().cards().size() + " cards");
                    System.out.println(player.get(1).getUsername() + " has " + player.get(1).getHand().cards().size() + " cards");
                    inPlay.cards().clear();
                    count++;
                    break;
            }
            
        }while(player.get(0).getHand().cards().size() > 0 && player.get(1).getHand().cards().size() > 0 && count < 101);
        
        declareWinner();
        
    }
    
    /**
     * Method which declares the victor and updates the game records/match history
     */
    @Override
    public void declareWinner() {
        
        File historyFile = new File("history.txt");
        
        try {
            player.get(0).getHistory().writeToFile(historyFile);
        } catch (IOException ex) {
            System.out.println("(Write History) Error: File Not Found");
        }
    
        if(player.get(0).getHand().cards().size() > player.get(1).getHand().cards().size()){
            System.out.println(player.get(0).getUsername() + " is the winner!!");
            GameRecord record0 = new GameRecord(player.get(0).getUsername(), player.get(1).getUsername(), "victory");
            GameRecord record1 = new GameRecord(player.get(1).getUsername(), player.get(0).getUsername(), "loss");
            player.get(0).getHistory().add(record0);
            player.get(1).getHistory().add(record1);
            try {
                player.get(0).getHistory().writeToFile(historyFile);
            } catch (IOException ex) {
                System.out.println("Couldn't write player1 history");
            }
            try {
                player.get(1).getHistory().writeToFile(historyFile);
            } catch (IOException ex) {
                System.out.println("Couldn't write player2 history");
            }
        }else{
            System.out.println(player.get(1).getUsername() + " is the winner!!");        
            GameRecord record0 = new GameRecord(player.get(1).getUsername(), player.get(0).getUsername(), "victory");
            GameRecord record1 = new GameRecord(player.get(0).getUsername(), player.get(1).getUsername(), "loss");
            player.get(0).getHistory().add(record0);
            player.get(1).getHistory().add(record1);
            try {
                player.get(0).getHistory().writeToFile(historyFile);
            } catch (IOException ex) {
                System.out.println("Couldn't write player1 history");
            }
            try {
                player.get(1).getHistory().writeToFile(historyFile);
            } catch (IOException ex) {
                System.out.println("Couldn't write player2 history");
            }
        }
    }
    
    /**
     * returns one of the players
     * 
     * @param n
     * @return soldier
     */
    public Soldier getPlayer(int n) {
        if (n - 1 == 0) {
            return player.get(0);
        } else {
            return player.get(1);
        }
    }
    
    /**
     * Method that allows a user to log in to the game
     * also displays the recent match history and player stats
     */
    public void logIn() {
        File playersFile = new File("troops.txt");

        if (playersFile.exists()) {
            Troops.loadFromFile(playersFile);
        }

        boolean portal = false;

        File historyFile = new File("history.txt");
        
        MatchHistory history = new MatchHistory(historyFile);

        Soldier soldier = new Soldier();
 
        Scanner input = new Scanner(System.in);
        
        do {
            System.out.println("\n[Log In]");
            boolean valid = false;
            do {
                System.out.print("Username: ");
                String username = input.next();
                soldier = Troops.getSoldier(username);
               
                if (soldier == null) {
                    System.out.println("That account doesn't exist");
                 
                } else {
                    System.out.print("Password: ");
                    String password1 = input.next();
                    if (soldier.getPassword().equals(Troops.encrypt(password1))) {
                        System.out.println("Welcome back, " + soldier.getUsername());
                        soldier.pullMatchHistory(history);
                        System.out.println(soldier.getStats());
                        player.add(soldier);

                        portal = true;
                        valid = true;

                    } else {
                        System.out.println("Incorrect password");
                    }
                }
            } while (valid == false);
        } while (portal == false);

        boolean valid1 = false;
        do {
            System.out.println("Make a selection: \n1. Ready Up \n2. View Recent Matches");
            String choice = input.next();
            if (isNumeric(choice)) {
                if (Integer.parseInt(choice) == 1 || Integer.parseInt(choice) == 2) {
                    int readyOrNot = Integer.parseInt(choice);
                    switch (readyOrNot) {
                        case 1:
                            System.out.println(soldier.getUsername() + " is ready");
                            valid1 = true;
                            break;
                        case 2:
                            if(soldier.getHistory().size() > 0){                              
                                for(int i = 0; i < soldier.getHistory().size(); i++){               
                                        System.out.println(i + 1 + ".\n" + soldier.getHistory().get(i).toString());                                 
                                        break;                                   
                                }
                                System.out.println(soldier.getUsername() + " is ready");
                                valid1 = true;
                            }else{
                                System.out.println("You have no recent matches");
                            }
                    }       
                } else {
                    System.out.println("Invalid Entry: Please enter either '1' or '2'");
                }
            } else {
                System.out.println("Invalid Entry: Please enter a number");
            }
        } while (valid1 == false);

    }
    
    /**
     * Method which allows the user to sign up to the game.
     */
    public void signUp() {
        File playersFile = new File("troops.txt");

        if (playersFile.exists()) {
            Troops.loadFromFile(playersFile);
        }
        
        Scanner input = new Scanner(System.in);
        System.out.println("[Sign Up]");
        String username;
        boolean valid = false;
        do {
            System.out.print("Username: ");
            username = input.next();
            Soldier temp = Troops.getSoldier(username);
            if (temp != null) {
                System.out.println("That username already exists, pick another one");
            } else {
                valid = true;
            }
        } while (valid == false);

        System.out.print("Password: ");
        String password = input.next();
        Soldier soldier = new Soldier(username, password);
        Troops.addSoldier(soldier);
        try {
            Troops.writeToFile(playersFile);
        } catch (IOException ex) {
            System.out.println("(Sign Up) Error: File Not Found");
        }

        player.add(soldier);
    }
}



