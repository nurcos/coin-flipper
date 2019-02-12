package Game;


import java.util.Random;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

public class Coin {
    private Face face;
    private int heads;
    private int tails;
    
    public Coin(){
        heads = 0;
        tails = 0;
    }

    public Face getFace() {
        return face;
    }
    
    public int getHeads(){
        return heads;
    }
    
    public int getTails(){
        return tails;
    }
    
    public void flip(){
        int flip = new Random().nextInt(2);
        
        if(flip == 0){
            face = Face.HEADS;
            heads++;
        }
        else{
            face = Face.TAILS;
            tails++;
        }
    }
    
    public void flip(int amount){
        heads = 0;
        tails = 0;
        for(int i = 0; i < amount; i++){
            flip();
        }
    }
    
    @Override
    public String toString(){
        return "Heads: " + heads + "\nTails: " + tails;
    }
    
}
