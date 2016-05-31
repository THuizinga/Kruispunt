
package kruispunt;

/**
 * @author Tiko Huizinga - s4460898
 * @author Conny Blach - s4329872
*/

/**
 * We hebben auto's a0..a3 en zones z0..z3
 * Opdracht1:
 * Stel a0 wil links en a2 wil links. 
 * Als ze allebei eerst hun dichtsbijzijnde zone reserveren (z0 en z2 resp.),
 * daarna de zone voor rechtdoor (z1 en z3 resp.)
 * en daarna de zone het verst van zich af willen reserveren (z2 en z0 resp.),
 * dan treedt er een deadlock op omdat z2 al gereserveerd is door a2 en
 * z0 al gereserveerd voor a0. Nu zullen de auto's oneindig lang op elkaar
 * wachten. Dit is een deadlock.
 * 
 * Opdracht 2:
 * Als de auto's de zones reserveren op volgorde van hun ID (0,1,2,3), van klein
 * naar groot, dan zal dit niet optreden.
 */

public class Main {
    
    public Main(){
        Zone z0 = new Zone(0);
        Zone z1 = new Zone(1);
        Zone z2 = new Zone(2);
        Zone z3 = new Zone(3);
        
        Auto a0 = new Auto(0, z0, z1, z2);
        Auto a1 = new Auto(0, z1, z2, z3);
        Auto a2 = new Auto(0, z2, z3, z0);
        Auto a3 = new Auto(0, z3, z0, z1);
    }
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        new Main();
    }
    
}
