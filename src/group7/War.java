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
public class War extends Game {

    public War() {
        this.name = "LET'S PLAY WAR!!!";
    }

    public String showRules() {
        return String.format("");
    }

    @Override
    public void play() {
        Scanner in = new Scanner(System.in);
        Soldier player1 = new Soldier();
        Soldier player2 = new Soldier();
        PlayerHand inPlay = new PlayerHand();
        PlayerHand p1hand = new PlayerHand();
        PlayerHand p2hand = new PlayerHand();
        DeckOf52 deck = new DeckOf52();
                
        players.add(player1);
        players.add(player2);

        System.out.print("[Player 1]" + "\n" + "Enter Name: ");
        player1.setName(in.nextLine());
        System.out.print("[Player 2]" + "\n" + "Enter Name: ");
        player2.setName(in.nextLine());
        
        System.out.println(deck);
        
        for (int i = 0; i < deck.getSize(); i++) {
            PlayingCard temp1 = (PlayingCard) deck.Cards().get(i);
            p1hand.addCard(temp1);
            deck.Cards().remove(i);

        }  
        for (int i = 0; i < deck.getSize(); i++) {
            PlayingCard temp2 = (PlayingCard) deck.Cards().get(i);
            p2hand.addCard(temp2);
        }  
        deck.Cards().clear();
                    
        System.out.println(p1hand);
        System.out.println(p2hand);

        while (p1hand.Cards().size() > 0 && p2hand.getSize() > 0) {
            boolean draw = false;

            while (draw == false) {
                System.out.print(player1.getName() + ", draw!? \n(Y/N): ");
                if (in.next().equalsIgnoreCase("y")) {
                    System.out.print(player2.getName() + ", draw!? \n(Y/N): ");
                    if (in.next().equalsIgnoreCase("y")) {
                        draw = true;
                    }
                }
            }

            PlayingCard p1draw = (PlayingCard) p1hand.play();
            PlayingCard p2draw = (PlayingCard) p2hand.play();

            inPlay.addCard(p1draw);
            inPlay.addCard(p2draw);

            System.out.println(player1.getName() + " DRAWS!: " + p1draw
                    + "\n" + player2.getName() + " DRAWS!: " + p2draw);

            int result = p1draw.compareTo(p2draw);

            switch (result) {
                case 0:
                    char again = 'n';
                    do {
                        p1draw = (PlayingCard) p1hand.play();
                        inPlay.addCard(p1draw);
                        p1draw = (PlayingCard) p1hand.play();
                        inPlay.addCard(p1draw);
                        System.out.println(player1.getName() + " DRAWS!: "
                                + "\n[blind draw]\n" + p1draw);

                        p2draw = (PlayingCard) p2hand.play();
                        inPlay.addCard(p2draw);
                        p2draw = (PlayingCard) p2hand.play();
                        inPlay.addCard(p2draw);
                        System.out.println(player2.getName() + " DRAWS!: "
                                + "\n[blind draw]\n" + p2hand.play());

                        int result1 = p1draw.compareTo(p2draw);
                        
                        switch (result1) {
                            case 0:
                                again = 'y';
                                break;

                            case 1:
                                System.out.println(player1.getName() + " takes the cake.");
                                p1hand.Cards().addAll(inPlay.Cards());
                                inPlay.Cards().clear();
                                again = 'n';
                                break;

                            case -1:
                                System.out.println(player1.getName() + " takes the cake.");
                                p2hand.Cards().addAll(inPlay.Cards());
                                inPlay.Cards().clear();
                                again = 'n';
                                break;
                        }
                    } while (again == 'y');
                    break;
                case 1:
                    System.out.println(player1.getName() + " takes the cake.");
                    p1hand.Cards().addAll(inPlay.Cards());
                    inPlay.Cards().clear();
                    break;
                case -1:
                    System.out.println(player2.getName() + " takes the cake.");
                    p2hand.Cards().addAll(inPlay.Cards());
                    inPlay.Cards().clear();
                    break;
            }
        
            System.out.println(player1.getName() + " Cards in Hand: " + p1hand.getSize()
                    + " " + player2.getName() + " Cards in Hand: " + p2hand.getSize());
        }

    }

    @Override
    public void declareWinner() {
        
    }
  

}
