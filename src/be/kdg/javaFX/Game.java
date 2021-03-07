package be.kdg.javaFX;

/*
TODO
- highscore opslaan (txt file)
*/


public class Game {
    public static boolean isRunning = true;

    //Zorgt voor de start van het spel
    public static void main(String[] args) {
        InvoerHandler.toonStartMenu();
        runGame();
    }
    public static void runGame(){
        InvoerHandler invoerHandler = new InvoerHandler();
        //Maakt een nieuw veld met een lengte van x vakjes
        Veld veld = new Veld(invoerHandler.vraagLengte());
        veld.toonVeld();
        //Spel blijft spelen tot de speler verliest
        while(isRunning) {
            invoerHandler.vraagInvoer(veld.laatsteBlokGeplaatst);
            veld.plaatsBlok(invoerHandler.gekozenBlok, invoerHandler.gekozenCoördinaten, invoerHandler.blokKeuzes);
        }
    }
}
