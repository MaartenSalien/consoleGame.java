package be.kdg.javaFX;

public class ScoreHandler {
    public static int score;
    public static int highScore;

    //Verhoogt de score met een meegegeven hoeveelheid
    public static void verhoogScore(int aantal){
        score += aantal;
        if (score > highScore)
            highScore = score;
    }

    //Toont de (high)score
    public static void toon(){
        System.out.println("Highscore: " + highScore);
        System.out.println("Score: " + score);
    }

    //Reset de core naar 0
    public static void resetScore(){
        score = 0;
    }
}
