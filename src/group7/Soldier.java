/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package group7;

/**
 *
 * @author Asus X540LA
 */
public class Soldier extends Player{
    private int wins = 0;
    
    public void setWins(int wins){
        this.wins = wins;
    }
    
    public int getWins(){
        return wins;
    }
           
    @Override
    public String toString(){
        return this.getName();
    }
   
    
}
