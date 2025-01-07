import nl.saxion.app.SaxionApp;

import java.awt.*;
import java.util.ArrayList;


public class Galgje implements Runnable {
    public static void main(String[] args) {
        SaxionApp.start(new Galgje(), 640, 260);
    }

    public void backgroundColor() {
        SaxionApp.setBackgroundColor(new Color(112, 169, 207));
    }

    public void run() {
        backgroundColor();

        // Nederlandse en Engelse woordenlijsten
        String[] woordenNederlands = {
                "computer", "programmeren", "java", "galgje", "technologie",
                "internet", "ontwikkeling", "hardware", "software", "geheugen",
                "toetsenbord", "muis", "beeldscherm", "laptop", "spel",
                "database", "netwerk", "processor", "besturingssysteem", "veiligheid"
        };

        String[] woordenEngels = {
                "computer", "programming", "java", "hangman", "technology",
                "internet", "development", "hardware", "software", "memory",
                "keyboard", "mouse", "screen", "laptop", "game",
                "database", "network", "processor", "operating system", "security"
        };

        // Laat de speler kiezen
        SaxionApp.printLine("Kies een taal (type 'Nederlands' of 'English'):");
        String taal = SaxionApp.readString().toLowerCase();

        // Kies de juiste lijst
        String[] woorden;
        if (taal.equals("nederlands")) {
            woorden = woordenNederlands;
        } else if (taal.equals("english")) {
            woorden = woordenEngels;
        } else {
            SaxionApp.printLine("Ongeldige invoer. Standaard Nederlands gekozen.");
            woorden = woordenNederlands;
        }

        // Kies een willekeurig woord
        String woord = woorden[(int) (Math.random() * woorden.length)];

        // Rest van de code voor het spel...


        // Variabelen voor het spel
        char[] geradenWoord = new char[woord.length()];
        for (int i = 0; i < geradenWoord.length; i++) {
            geradenWoord[i] = '_';
        }
        int fouten = 0;
        int maximaleFouten = 6;
        boolean geraden = false;


        // Spel loop
        while (fouten < maximaleFouten && !geraden) {
            // Toon de status van het spel
            SaxionApp.printLine("\n\nGalgje: " + tekenGalgje(fouten));
            SaxionApp.print("Current word: ");
//          SaxionApp.printLine(geradenWoord);
            SaxionApp.printLine("jan");

            // Vraag een letter
            SaxionApp.print("Guess a letter: ");
            char letter = SaxionApp.readChar();


            // Controleer of de letter in het woord zit
            boolean goedGeraad = false;
            for (int i = 0; i < woord.length(); i++) {
                if (woord.charAt(i) == letter) {
                    geradenWoord[i] = letter;
                    goedGeraad = true;
                }
            }

            if (!goedGeraad) {
                fouten++;
                SaxionApp.printLine("Wrong! You now have " + fouten + " Wrong.");
            } else {
                SaxionApp.printLine("Well done!");
            }

            // Controleer of het hele woord is geraden
            geraden = String.valueOf(geradenWoord).equals(woord);
        }

        // Spel beëindigen
        if (geraden) {
            SaxionApp.printLine("\nCongratulations! You guest the word: " + woord);
        } else {
            SaxionApp.printLine("\nGame over! The word was: " + woord);
        }
    }

    // Hulpmethode om de galg te tekenen
    public static String tekenGalgje(int fouten) {
        String[] stages = {
                """
             -----
             |   |
                 |
                 |
                 |
                 |
            =======
            """,
                """
             -----
             |   |
             O   |
                 |
                 |
                 |
            =======
            """,
                """
             -----
             |   |
             O   |
             |   |
                 |
                 |
            =======
            """,
                """
             -----
             |   |
             O   |
            /|   |
                 |
                 |
            =======
            """,
                """
             -----
             |   |
             O   |
            /|\\ |
                 |
                 |
            =======
            """,
                """
             -----
             |   |
             O   |
            /|\\  |
            /    |
                 |
            =======
            """,
                """
             -----
             |   |
             O   |
            /|\\  |
            / \\  |
                 |
            =======
            """
        };
        return stages[fouten];
    }
}

