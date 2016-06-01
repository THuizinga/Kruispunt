package kruispunt;

import java.util.Arrays;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Tiko Huizinga - s4460898
 * @author Conny Blach - s4329872
 */
public class Auto implements Runnable {

    private final int ID;
    private Random r1;
    private Zone[] zones;

    /**
     * Maakt een auto aan en zet de zones en ID goed.
     *
     * @param id
     * @param rechts
     * @param rechtdoor
     * @param links
     */
    public Auto(int id, Zone rechts, Zone rechtdoor, Zone links) {
        ID = id;
        r1 = new Random();
        zones = new Zone[]{rechts, rechtdoor, links};

    }

    /**
     * Geef een willekeurig getal tussen 0 en 2 die de richting voorstelt
     *
     * @return
     */
    private int geefRichting() {
        return r1.nextInt(3);
    }

    private void printGebeurtenis(int i) {
        if (i == 0) {
            System.out.println("Auto " + this + " is rechtsaf gegaan");
        } else if (i == 1) {
            System.out.println("Auto " + this + " is rechtdoor gegaan");
        } else {
            System.out.println("Auto " + this + " is linksaf gegaan");
        }

    }

    @Override
    public String toString() {
        return String.valueOf(ID);
    }

    /**
     * De zone's die gereserveerd moeten worden worden in een array gezet en
     * gesorteerd op hun ID. De auto begint met 1 tot 2 seconde rondjes rijden
     * en komt dan bij het kruispunt aan. Elke zone wordt om de beurt
     * gereserveerd. Dan wordt elke zone om de beurt weer vrijgegeven en wordt
     * er geprint welke richting de auto op is gegaan. Daarna begint dit weer
     * opnieuw.
     */
    @Override
    public void run() {
        while (true) {
            try {
                int richting = geefRichting();
                Zone[] nodig = Arrays.copyOf(zones, richting + 1);
                Arrays.sort(nodig);
                Thread.sleep(r1.nextInt(3000) + 3000);
                for (int i = 0; i <= richting; i++) {
                    nodig[i].rijOp();
                    System.out.println("Auto " + this + " reserveert: " + nodig[i]);
                }
                for (int i = 0; i <= richting; i++) {
                    nodig[i].rijAf();
                }
                printGebeurtenis(richting);
            } catch (InterruptedException ex) {
                System.out.println("Sleep interrupted..");
            }

        }
    }

}
