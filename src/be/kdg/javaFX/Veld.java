package be.kdg.javaFX;

import java.util.Arrays;

class Veld {
    public static final String legeBlok =  "¤ ";
    public static final String volleBlok = "■ ";
    String[][] veld;
    static int lengte;
    public boolean laatsteBlokGeplaatst = true;

    //Maakt een veld van 'lengte' op 'lengte'
    public Veld(int lengte) {
        this.lengte = lengte;
        veld = new String[lengte][lengte];
        maakVeldLeeg();
    }

    //Vult een veld met lege blokken
    public void maakVeldLeeg(){
        for (String[] rij : veld) {
            Arrays.fill(rij, legeBlok);
        }
    }

    //Plaatst een blok op de gegeven coordinaten
    public void plaatsBlok(Blok blok, int[] coordinaten, Blok[] blokKeuzes) {
        if (isBlokPlaatsbaar(blok, coordinaten)) {
            for (int i = 0; i < blok.vorm.length; i++) {
                for (int j = 0; j < blok.vorm[i].length; j++) {
                    //Vult het veld met het blokje
                    if (blok.vorm[i][j].equals(volleBlok)){
                        veld[coordinaten[1]+i][coordinaten[0]+j] = blok.vorm[i][j];
                    }
                }
            }
            ScoreHandler.verhoogScore(blok.aantalBlokjes);
            laatsteBlokGeplaatst = true;
            //Kijkt na of er rijen en kolommen vol zijn
            checkRijen();
            checkKolommen();
            if (isSpelerVerloren(blokKeuzes)) {
                Game.isRunning = false;
            }
            maakConsoleLeeg();
        }
        else {
            System.out.println("De blok is niet plaatsbaar!");
            laatsteBlokGeplaatst = false;
        }
        //Laat het veld zien
        toonVeld();
    }

    //Kijkt of een blok geplaatst kan worden
    private boolean isBlokPlaatsbaar(Blok blok, int[] coördinaten){
        for (int i = 0; i < blok.vorm.length; i++) {
            for (int j = 0; j < blok.vorm[i].length; j++) {
                int x = coördinaten[0];
                int y = coördinaten[1];
                //Als de lengte van een blok plus de coordinaat groter is dan veldlengte zou de blok uit het veld gaan
                if ((blok.vorm[i].length + x) > lengte || (blok.vorm.length + y) > lengte)
                    return false;
                //Als er ergens een vakje vol is, kan het blokje niet geplaatst worden
                if (veld[y + i][x + j].equals(Veld.volleBlok) && blok.vorm[i][j].equals(Veld.volleBlok)){
                    return false;
                }
            }
        }
        return true;
    }

    //Controleert of er nog een mogelijke zet is voor de speler
    private boolean isSpelerVerloren(Blok[] blokkeuzes){
        for (Blok blokkeuze : blokkeuzes) {
            if (blokkeuze != null) {
                //Voor elk van de coördinaten wordt gekeken of er nog een blok zou kunnen geplaatst worden
                for (int x =0; x<Veld.lengte; x++){
                    for (int y =0; y<Veld.lengte; y++){
                        int[] coordinaat = {x,y};
                        //Als de blok plaatstbaar is is de speler nog niet verloren
                        if (isBlokPlaatsbaar(blokkeuze, coordinaat)){
                            return false;
                        }
                    }
                }
            }
        }
        //Als alle blokken gebruikt zijn is de speler nog niet verloren maar moeten er nieuwe blokken op het scherm
        if (blokkeuzes[0] == null && blokkeuzes[1] == null && blokkeuzes[2] == null)
            return false;
        //Als er geen blokken in het veld meer zouden passen is de speler verloren
        toonVeld();
        InvoerHandler.toonEindMenu();
        return true;
    }

    //Kijkt of er een rij vol is
    private void checkRijen(){
        boolean volleLijn = false;
        int rijNummer = 0;
        for(int i = 0; i < veld.length; i++){
            for(int j = 0; j < veld[i].length; j++){
                //Kijkt elk vakje na of er een volle blok staat
                if (veld[i][j].equals(Veld.volleBlok)){
                    volleLijn = true;
                    rijNummer = i;
                }
                //Als er een vakje in de rij niet vol is, is het geen vollelijn
                else {
                    volleLijn = false;
                    break;
                }
            }
            if (volleLijn){
                maakRijLeeg(rijNummer);
            }
        }
    }

    //Kijkt of er een kolom vol is
    private void checkKolommen(){
        boolean volleLijn = false;
        int kolomNummer =0;
        for(int i = 0; i < veld.length; i++){
            for(int j = 0; j < veld[i].length; j++){
                //Kijkt elk vakje na of er een volle blok staat
                if (veld[j][i].equals(Veld.volleBlok)){
                    volleLijn = true;
                    kolomNummer = i;
                }
                //Als er een vakje in de kolom niet vol is, is het geen vollelijn
                else {
                    volleLijn = false;
                    break;
                }
            }
            if (volleLijn){
                maakKolomLeeg(kolomNummer);
            }
        }
    }

    //Maakt alle volle vakjes van een rij terug leeg
    private void maakRijLeeg(int rijNummer){
        int kolomNummer = 0;
        //Gaat de meegegeven rij blokje per blokje leeg maken
        while (kolomNummer < veld.length) {
            this.veld[rijNummer][kolomNummer] = Veld.legeBlok;
            kolomNummer++;
        }
        ScoreHandler.verhoogScore(10);
    }

    //Maakt alle volle vakjes van een kolom terug leeg
    private void maakKolomLeeg(int kolomNummer){
        int rijNummer = 0;
        //Gaat de meegegeven kolom blokje per blokje leeg maken
        while (rijNummer < veld.length) {
            this.veld[rijNummer][kolomNummer] = Veld.legeBlok;
            rijNummer++;
        }
        ScoreHandler.verhoogScore(10);
    }

    //Maakt de console leeg (door witruimte)
    public static void maakConsoleLeeg(){
        for (int i=0; i<50; i++) {
            System.out.println();
        }
    }

    //toont het veld op het scherm
    public  void toonVeld(){
        System.out.println("Veld:");
        for (String[] rij : this.veld) {
            for (String blok : rij) {
                //Voor elke rij, elke blok: laat de inhoud zien
                System.out.print(blok + " ");
            }
            System.out.println();
        }
        //Laat onder het veld de score zien
        ScoreHandler.toon();
    }
}
