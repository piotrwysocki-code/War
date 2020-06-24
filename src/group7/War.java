/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package group7;
import java.util.Scanner;
/**
 *
 * @author Asus X540LA
 */
public class War extends Game implements Comparator{
    
    public War(){
        this.name = "THIS IS WAR!!!";
    }
    
    public String showRules(){
        return String.format("");
    }
    
    @Override
    public void play(){
        Scanner in = new Scanner(System.in);
        Soldier player1 = new Soldier();
        Soldier player2 = new Soldier();
        players.add(player1);
        players.add(player2);
        
        System.out.print("[Player 1]" + "\n" + "Enter Name: ");
        player1.setName(in.nextLine());
        System.out.print("[Player 2]" + "\n" + "Enter Name: ");
        player2.setName(in.nextLine());
               
        DeckOf52 deck = new DeckOf52();
            
        PlayerHand p1hand = new PlayerHand();
        PlayerHand p2hand = new PlayerHand();
              
        for(int i = 0; i < deck.getSize(); i++){
            p1hand.addCard(deck.Cards().get(i));
            deck.Cards().remove(i);
            p2hand.addCard(deck.Cards().get(i));
        }        
        
        deck.Cards().clear();
       
  
        boolean ready = false;
        
        while(ready == false){
            System.out.print(player1.getName() + ", are you ready!? \n(Y/N): ");
                if(in.next().equalsIgnoreCase("y")){
                    System.out.print(player2.getName() + ", are you ready!? \n(Y/N): ");
                        if(in.next().equalsIgnoreCase("y")){
                           ready = true; 
                        }                     
                }
        }
        
        PlayingCard p1draw = p1hand.draw();
        PlayingCard p2draw = p2hand.draw();
        
        System.out.println(player1.getName() + " DRAWS!: " + p1hand.draw() 
                + "\n" + player2.getName() + " DRAWS!: " + p2hand.draw());
        /*System.out.println(deck.toString());        
        System.out.println(p1hand.toString());      
        System.out.println(p2hand.toString());*/
        
        int roundWinner = compare(p1draw, p2draw);
        
        switch (roundWinner){
            case 0:
                break;
            case 1:
                break;
            case 2:
                break;
        }      
        
    }
    
    @Override
    public void declareWinner(){
        
    }
    
    @Override
    public int compare(PlayingCard o, PlayingCard p){
        if(o.getValue().ordinal() == p.getValue().ordinal()){
            return 0;
        }else if(o.getValue().ordinal() < p.getValue().ordinal()){
            return -1;
        }else{
            return 1;
        }
    }
   
    
}
