package kruispunt;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Tiko Huizinga - s4460898
 * @author Conny Blach - s4329872
*/
public class Zone implements Comparable<Zone>{
    private final int ID;
    private Boolean bezet = false;
    
    public Zone(int zoneID){
        ID = zoneID;
        
    }
    /**
     * Zolang de zone bezet is, moet de thread wachten. 
     * Daarna maakt het de zone bezet zodat andere auto's weten dat ze hem niet
     * kunnen reserveren.
     */
    public synchronized void rijOp() {
        while(bezet){
            try {
                wait();
            } catch (InterruptedException ex) {
                System.out.println("Wachten geïnterrupt");
            }
        }
        bezet = true;
        
        
    }
    
    /**
     * Geeft de zone weer vrij zodat andere auto's de zone kunnen reserveren.
     * Laat alle threads weten dat de zone vrijgegeven is.
     */
    public synchronized void rijAf(){
        bezet = false;
        notifyAll();
    }
    
    public Boolean getBezet(){
        return bezet;
    }
    
    public int getID(){
        return this.ID;
    }
    
    @Override
    public String toString(){
        return String.valueOf(ID);
    }
    
    /**
     * Vergelijkt deze zone met zone z op basis van ID.
     * @param z zone waarmee this vergeleken moet worden
     * @return 
     */
    @Override
    public int compareTo(Zone z) {
        if(this.ID>z.ID)
            return 1;
        else if (this.ID == z.ID)
            return 0;
        else
            return -1;
    }
    
}
