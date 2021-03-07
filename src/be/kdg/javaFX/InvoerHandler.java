package be.kdg.javaFX;

import java.lang.reflect.Array;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;



public class InvoerHandler {

    public Blok[] blokKeuzes = new Blok[3];
    private Scanner kb = new Scanner(System.in);
    public Blok gekozenBlok;
    public int[] gekozenCoördinaten;
    static int bloknummer = 0;


    //Alle invoer wordt gevraagd aan de speler
    public void vraagInvoer(boolean laatsteBlokGeplaatst) {
        if (laatsteBlokGeplaatst) {
            toonBlokKeuzes();
            System.out.println("Invoer:");
            vraagBlok();
            gekozenCoördinaten = vraagCoördinaten();
            gekozenBlok = kiesBlok();
        } else
            gekozenCoördinaten = vraagCoördinaten();
    }

    //Vraagt de lengte van het veld
    public int vraagLengte(){
        int lengte = 0;
        Scanner kb = new Scanner(System.in);
        try{
            System.out.print("Lengte van het veld: ");
            lengte = kb.nextInt();
        }catch (Exception e){
            System.out.println("Geef een geldige lengte in!");
            return vraagLengte();
        }
        if (lengte < 3 || lengte > 20) {
            System.out.println("Minimum lengte: 3\nMaximum lengte: 20");
            return vraagLengte();
        }
        else
            return lengte;
    }

    //Toont een startmenu waar de speler kan selecteren wat er gebeurt
    public static void toonStartMenu(){
        Scanner kb = new Scanner(System.in);
        System.out.println("Selecteer wat je wil doen.");
        System.out.println("[start] [regels]");
        String keuze = kb.next();
        switch (keuze) {
            case "start":
                Veld.maakConsoleLeeg();
                Game.runGame();
                break;
            case "regels":
                System.out.println("PLAATS STEEDS 1 VAN DE MOGELIJKE BLOKKEN OP HET SPELBORD");
                System.out.println("ELKE GEPLAATSTE BLOK GEEFT EEN AANTAL PUNTEN");
                System.out.println("HET AANTAL PUNTEN IS GELIJK AAN HET AANTAL GEVULDE VAKJES DOOR DE GEPLAATSTE BLOK");
                System.out.println("BIJ ELKE VOLLE RIJ EN KOLOM KRIJG JE EXTRA PUNTEN");
                System.out.println("OM EEN ANDERE BLOK TE KIEZEN GEEF JE 0 IN ALS 1 VAN DE COORDINATEN");
                System.out.println("DE COORDINATEN BEGINNEN STEEDS MET (1,1), ZELFS ALS DAAR EEN LEGE BLOK STAAT");
                System.out.println("NA ELKE 3 BLOKKEN DIE JE HEBT GEPLAATST KOMEN ER 3 NIEUWE ");
                System.out.println("ALS ER GEEN MOGELIJKE ZETTEN MEER ZIJN VERLIES JE\n");
                toonStartMenu();
                break;
            default:
                System.out.println("Kies een geldige optie!\n");
                toonStartMenu();
                break;
        }
    }

    //Toont een eindmenu waar de speler kan selecteren wat er gebeurt
    public static void toonEindMenu(){
        ScoreHandler.resetScore();
        Scanner kb = new Scanner(System.in);
        System.out.print("\n[U bent verloren!]\n");
        System.out.println("Selecteer wat je wil doen.");
        System.out.println("[menu] [opnieuw]");
        String keuze = kb.next();
        switch (keuze) {
            case "menu":
                Veld.maakConsoleLeeg();
                toonStartMenu();
                break;
            case "opnieuw":
                Veld.maakConsoleLeeg();
                Game.runGame();
                break;
            default:
                System.out.println("Kies een geldige optie!\n");
                toonEindMenu();
                break;
        }
    }

    //Vraagt aan de speler welke blok hij wil plaatsen
    private void vraagBlok() {
        System.out.print("Kies Bloknummer [1, 2 of 3]: ");
        Scanner kb = new Scanner(System.in);
        try {
            bloknummer = 0;
            bloknummer = kb.nextInt();
        }
        catch (InputMismatchException e) {
            System.out.println("Geef een geldige blokkeuze in!");
        }
    }

    //Controleert of de geselecteerde blok nog niet is gebruikt en geeft deze terug
    private Blok kiesBlok() {
        if(bloknummer<=3 && bloknummer>0 && blokKeuzes[bloknummer-1] != null){
            gekozenBlok = blokKeuzes[bloknummer-1];
            //De gekozen blok wordt verwijdert
            blokKeuzes[bloknummer-1] = null;
        }
        //Als het bloknummer groter is dan 3 of kleiner dan 0 is het niet geldig
        else if(bloknummer>3 || bloknummer<=0){
            System.out.println("Selecteer een van de drie blokken!");
            vraagInvoer(true);
        }
        //Als de gekozen blok 'null' is, is het niet geldig
        else {
            System.out.println("Selecteer een blok die nog niet is gebruikt!");
            vraagInvoer(true);
        }
        return gekozenBlok;
    }

    //Vraagt de coordinaten aan de speler en geeft ze dan terug mee in een array
    private int[] vraagCoördinaten() {
        Scanner kb = new Scanner(System.in);
        int x = 0;
        int y = 0;
        try {
            System.out.print("X-coördinaat: ");
            x = kb.nextInt();
            x -= 1;
            System.out.print("Y-coördinaat: ");
            y = kb.nextInt();
            y -= 1;
        }
        catch (InputMismatchException e) {
            System.out.println("Geef een geldige coördinaat in!");
            vraagCoördinaten();
        }
        int[] coördinaten = {x, y};
        if ((x < Veld.lengte && x >= 0 ) && (y < Veld.lengte && y >= 0)){
            return coördinaten;
        }
        //Als de coördinaten 0,0 (wordt -1,-1) worden gegeven wordt een nieuwe blok gevraagd
        else if(x == -1 || y == -1) {
            vraagBlok();
        }
        //Als de coördinaten groter zijn dan de veldlengte komt er een foutmelding
        else
            System.out.println("Zorg dat de coördinaten niet groter/kleiner zijn dan het veld!");
        return vraagCoördinaten();
    }

    //Laat de drie blokken op het scherm zien waar de speler uit kan kiezen
    private void toonBlokKeuzes() {
        System.out.println("\nBlokken:");
        //Laat de drie blokken die je kan kiezen op het scherm zien
            for (int i = 0; i < 3; i++) {
                System.out.println("[Blok " + (i + 1) + "]");
                //Als de drie blokkeuzes nog leeg zijn worden ze gevuld
                if(blokKeuzes[0] == null && blokKeuzes[1] == null && blokKeuzes[2] == null){
                    for (int j = 0; j < 3; j++) {
                        blokKeuzes[j] = kiesWillekeurigeBlok();
                    }
                }
                //Als de blokkeuze niet leeg is, toon de blok dan
                if (blokKeuzes[i] != null)
                    blokKeuzes[i].toon();
                System.out.println();
            }
    }

    //Selecteert een willekeurige blokken
    private Blok kiesWillekeurigeBlok() {
        Blok[] blokken = Blok.values();
        Random getal = new Random();
        Blok blok = blokken[getal.nextInt(23)];
        return blok;
    }
}
