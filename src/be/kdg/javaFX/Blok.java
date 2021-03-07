package be.kdg.javaFX;


public enum Blok {
    //Geeft alle mogelijke blokken een naam en een aantal blokken (= punten)
    VORM0("Vorm: puntje", 1),
    VORM1("Vorm: vierkant (2x2)", 4),
    VORM2("Vorm: vierkant (3x3)", 9),
    VORM3("Vorm: kleine L", 3),
    VORM4("Vorm: grote L", 5),
    VORM5("Vorm: halve L", 4),
    VORM6("Vorm: T van links naar rechts", 4),
    VORM7("Vorm: T van rechts naar links", 4),
    VORM8("Vorm: T van boven naar onder", 4),
    VORM9("Vorm: T van onder naar boven", 4),
    VORM10("Vorm: Streep verticaal", 3),
    VORM11("Vorm: Streep horizontaal", 3),
    VORM12("Vorm: halve L1", 4),
    VORM13("Vorm: halve L2", 4),
    VORM14("Vorm: halve L3", 4),
    VORM15("Vorm: kleine streep 0", 2),
    VORM16("Vorm: kleine streep 1", 2),
    VORM17("Vorm: kleine L1", 3),
    VORM18("Vorm: kleine L2", 3),
    VORM19("Vorm: kleine L3", 3),
    VORM20("Vorm: grote L1", 5),
    VORM21("Vorm: grote L2", 5),
    VORM22("Vorm: grote L3", 5);

    String naam;
    int aantalBlokjes;
    String[][] vorm;

    Blok(String naam, int aantalBlokjes){
        this.naam = naam;
        this.aantalBlokjes = aantalBlokjes;

        //Maakt voor elke blok een vorm
        switch (naam){
            case "Vorm: puntje":
                this.vorm = new String[][]{
                        {Veld.volleBlok}
                };
                break;
            case "Vorm: vierkant (2x2)":
                this.vorm = new String[][]{
                        {Veld.volleBlok, Veld.volleBlok},
                        {Veld.volleBlok, Veld.volleBlok}
                };
                break;
            case "Vorm: vierkant (3x3)":
                this.vorm = new String[][]{
                        {Veld.volleBlok, Veld.volleBlok, Veld.volleBlok},
                        {Veld.volleBlok, Veld.volleBlok, Veld.volleBlok},
                        {Veld.volleBlok, Veld.volleBlok, Veld.volleBlok}
                };
                break;
            case "Vorm: kleine L":
                this.vorm = new String[][]{
                        {Veld.volleBlok, Veld.legeBlok},
                        {Veld.volleBlok, Veld.volleBlok}
                };
                break;
            case "Vorm: grote L":
                this.vorm = new String[][]{
                        {Veld.volleBlok, Veld.legeBlok, Veld.legeBlok},
                        {Veld.volleBlok, Veld.legeBlok, Veld.legeBlok},
                        {Veld.volleBlok, Veld.volleBlok, Veld.volleBlok}
                };
                break;
            case "Vorm: halve L":
                this.vorm = new String[][]{
                        {Veld.volleBlok, Veld.legeBlok},
                        {Veld.volleBlok, Veld.legeBlok},
                        {Veld.volleBlok, Veld.volleBlok}
                };
                break;
            case "Vorm: T van links naar rechts":
                this.vorm = new String[][]{
                        {Veld.volleBlok, Veld.legeBlok},
                        {Veld.volleBlok, Veld.volleBlok},
                        {Veld.volleBlok, Veld.legeBlok}
                };
                break;
            case "Vorm: T van rechts naar links":
                this.vorm = new String[][]{
                        {Veld.legeBlok, Veld.volleBlok},
                        {Veld.volleBlok, Veld.volleBlok},
                        {Veld.legeBlok, Veld.volleBlok}
                };
                break;
            case "Vorm: T van boven naar onder":
                this.vorm = new String[][]{
                        {Veld.volleBlok, Veld.volleBlok, Veld.volleBlok},
                        {Veld.legeBlok, Veld.volleBlok, Veld.legeBlok}
                };
                break;
            case "Vorm: T van onder naar boven":
                this.vorm = new String[][]{
                        {Veld.legeBlok, Veld.volleBlok, Veld.legeBlok},
                        {Veld.volleBlok, Veld.volleBlok, Veld.volleBlok}
                };
                break;
            case "Vorm: Streep verticaal":
                this.vorm = new String[][]{
                        {Veld.volleBlok},
                        {Veld.volleBlok},
                        {Veld.volleBlok}
                };
                break;
            case "Vorm: Streep horizontaal":
                this.vorm = new String[][]{
                        {Veld.volleBlok, Veld.volleBlok, Veld.volleBlok}
                };
                break;
            case "Vorm: halve L1":
                this.vorm = new String[][]{
                        {Veld.legeBlok, Veld.legeBlok, Veld.volleBlok},
                        {Veld.volleBlok, Veld.volleBlok, Veld.volleBlok}
                };
                break;
            case "Vorm: halve L2":
                this.vorm = new String[][]{
                        {Veld.legeBlok, Veld.volleBlok},
                        {Veld.legeBlok, Veld.volleBlok},
                        {Veld.volleBlok, Veld.volleBlok}
                };
                break;
            case "Vorm: halve L3":
                this.vorm = new String[][]{
                        {Veld.volleBlok, Veld.volleBlok, Veld.volleBlok},
                        {Veld.legeBlok, Veld.legeBlok, Veld.volleBlok}
                };
                break;
            case "Vorm: kleine streep 0":
                this.vorm = new String[][]{
                        {Veld.volleBlok, Veld.volleBlok}
                };
                break;
            case "Vorm: kleine streep 1":
                this.vorm = new String[][]{
                        {Veld.volleBlok},
                        {Veld.volleBlok}
                };
                break;
            case "Vorm: kleine L1":
                this.vorm = new String[][]{
                        {Veld.legeBlok, Veld.volleBlok},
                        {Veld.volleBlok, Veld.volleBlok}
                };
                break;
            case "Vorm: kleine L2":
                this.vorm = new String[][]{
                        {Veld.volleBlok, Veld.volleBlok},
                        {Veld.volleBlok, Veld.legeBlok}
                };
                break;
            case "Vorm: kleine L3":
                this.vorm = new String[][]{
                        {Veld.volleBlok, Veld.volleBlok},
                        {Veld.legeBlok, Veld.volleBlok}
                };
                break;
            case "Vorm: grote L1":
                this.vorm = new String[][]{
                        {Veld.legeBlok, Veld.legeBlok, Veld.volleBlok},
                        {Veld.legeBlok, Veld.legeBlok, Veld.volleBlok},
                        {Veld.volleBlok, Veld.volleBlok, Veld.volleBlok}
                };
                break;
            case "Vorm: grote L2":
                this.vorm = new String[][]{
                        {Veld.volleBlok, Veld.volleBlok, Veld.volleBlok},
                        {Veld.volleBlok, Veld.legeBlok, Veld.legeBlok},
                        {Veld.volleBlok, Veld.legeBlok, Veld.legeBlok}
                };
                break;
            case "Vorm: grote L3":
                this.vorm = new String[][]{
                        {Veld.volleBlok, Veld.volleBlok, Veld.volleBlok},
                        {Veld.legeBlok, Veld.legeBlok, Veld.volleBlok},
                        {Veld.legeBlok, Veld.legeBlok, Veld.volleBlok}
                };
                break;
        }
    }

    //Toont de vorm van een blok
    public void toon() {
        for (int i = 0; i < vorm.length; i++) {
            for (int j = 0; j < vorm[i].length; j++) {
                System.out.print(vorm[i][j]);
            }
            System.out.println();
        }
    }
}
