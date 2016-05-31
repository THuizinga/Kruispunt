/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kruispunt;

import java.util.Random;

/**
 * @author Tiko Huizinga - s4460898
 * @author Conny Blach - s4329872
*/
public class Auto implements Runnable{
    private final int ID;
    private Random r1;
    
    
    
    public Auto(int id){
        ID = id;
    }
    
    private int geefRichting(){
        return r1.nextInt() % 3;
    }
    
    private void reserveerZones(){
        
    }

    @Override
    public void run() {
        while(true){
            
        }
    }
    
}
