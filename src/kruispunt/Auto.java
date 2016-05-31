/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kruispunt;

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Tiko Huizinga - s4460898
 * @author Conny Blach - s4329872
*/
public class Auto implements Runnable{
    private final int ID;
    private Random r1;
    private Zone [] zones;
    
    
    
    public Auto(int id, Zone rechts, Zone rechtdoor, Zone links){
        ID = id;
        r1 = new Random();
        zones = new Zone [] {rechts, rechtdoor, links};
        
    }
    
    private int geefRichting(){
        System.out.println(r1.nextInt(3));
        return r1.nextInt(3);
    }
    

    @Override
    public void run() {
        while(true){
            //TODO run maken
        }
    }
    
}
