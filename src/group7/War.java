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
public class War extends Game implements Comparator {

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
        PlayerHand inPlayP1 = new PlayerHand();
        PlayerHand inPlayP2 = new PlayerHand();
        PlayerHand p1hand = new PlayerHand();
        PlayerHand p2hand = new PlayerHand();
        DeckOf52 deck = new DeckOf52();

        players.add(player1);
        players.add(player2);

        System.out.print("[Player 1]" + "\n" + "Enter Name: ");
        player1.setName(in.nextLine());
        System.out.print("[Player 2]" + "\n" + "Enter Name: ");
        player2.setName(in.nextLine());

        for (int i = 0; i < deck.getSize(); i++) {
            p1hand.addCard(deck.Cards().get(i));
            deck.Cards().remove(i);
            p2hand.addCard(deck.Cards().get(i));
        }

        deck.Cards().clear();

        int p1CardCount = p1hand.getSize();
        int p2CardCount = p2hand.getSize();

        while (p1CardCount > 0 && p2CardCount > 0) {
        
        System.out.print(player1.getName() + ", draw!? \n(Y/N): ");
        PlayingCard p1draw = p1hand.draw();
        inPlayP1.addCard(p1draw);
        System.out.println(player1.getName() + " DRAWS!: " + p1hand.draw());
        
        System.out.print(player2.getName() + ", draw!? \n(Y/N): ");
        PlayingCard p2draw = p2hand.draw();   
        inPlayP2.addCard(p2draw);
        System.out.println(player2.getName() + " DRAWS!: " + p2hand.draw());
          
            int result = compare(p1draw, p2draw);

            switch (result) {
                case 0:
                    char again = 'n';
                    do {
                        p1draw = p1hand.draw();//blind draw
                        inPlayP1.addCard(p1draw);
                        
                        p1draw = p1hand.draw();
                        inPlayP1.addCard(p1draw);
                        System.out.println(player1.getName() + " DRAWS!: "
                                + "\n[blind draw]\n" + p1draw);

                        p2draw = p2hand.draw();//blind draw
                        inPlayP2.addCard(p2draw);
                        
                        p2draw = p2hand.draw();
                        inPlayP2.addCard(p2draw);
                        System.out.println(player2.getName() + " DRAWS!: "
                                + "\n[blind draw]\n" + p2hand.draw());

                        int result1 = compare(p1draw, p2draw);
                        switch (result1) {
                            case 0:
                                again = 'y';
                                break;                             
                            case 1:
                                System.out.println(player1.getName() + " takes the cake.");
                                p1hand.Cards().addAll(inPlayP2.Cards());
                                inPlayP2.Cards().clear();
                                again = 'n';
                                break;                               
                            case -1:
                                System.out.println(player1.getName() + " takes the cake.");
                                p2hand.Cards().addAll(inPlayP1.Cards());
                                inPlayP1.Cards().clear();
                                again = 'n';
                                break;
                        }
                    } while (again == 'y');
                    break;                   
                case 1:
                    System.out.println(player1.getName() + " takes the cake.");
                    p1hand.Cards().add(p2draw);
                    break;                   
                case -1:
                    System.out.println(player2.getName() + " takes the cake.");
                    p2hand.Cards().add(p1draw);
                    break;
            }

                /*String again = "";
                do {
                    System.out.println("THIS MEANS WAR!!!!");

                    p1draw = p1hand.draw();
                    inPlayP1.addCard(p1draw);
                    p1draw = p1hand.draw();
                    inPlayP1.addCard(p1draw);
                    System.out.println(player1.getName() + " DRAWS!: "
                            + "\n[blind draw]\n" + p1draw);

                    p2draw = p2hand.draw();
                    inPlayP2.addCard(p2draw);
                    p2draw = p2hand.draw();
                    inPlayP2.addCard(p2draw);
                    System.out.println(player2.getName() + " DRAWS!: "
                            + "\n[blind draw]\n" + p2hand.draw());

                    int result1 = compare(p1draw, p2draw);

                    if (result1 > 0 || result1 < 0) {
                        result = result1;
                        again = null;
                    }
                    
                    System.out.println("Press [ENTER] to draw again");
                    again = in.next();

                } while (again != null);*/
        }

    }

    @Override
    public void declareWinner() {

    }

    @Override
    public int compare(PlayingCard o, PlayingCard p) {
        if (o.getValue().ordinal() == p.getValue().ordinal()) {
            return 0;
        } else if (o.getValue().ordinal() < p.getValue().ordinal()) {
            return -1;
        } else {
            return 1;
        }
    }

}
