import nl.saxion.app.SaxionApp;

import java.awt.*;
import java.util.ArrayList;


public class Galgje implements Runnable {
    public static void main(String[] args) {
        SaxionApp.start(new Galgje(), 640, 480);
    }


    public void run(){

        SaxionApp.setBackgroundColor(new Color(112, 169, 207));
        // Woordenlijst
        String[] woorden = {"programmeren"};
        String woord = woorden[(int) (Math.random() * woorden.length)];

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
            SaxionApp.print("Huidige woord: ");
            SaxionApp.printLine(geradenWoord);

            // Vraag een letter
            SaxionApp.print("Raad een letter: ");
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
                SaxionApp.printLine("Verkeerd! Je hebt nu " + fouten + " fout(en).");
            } else {
                SaxionApp.printLine("Goed gedaan!");
            }

            // Controleer of het hele woord is geraden
            geraden = String.valueOf(geradenWoord).equals(woord);
        }

        // Spel beëindigen
        if (geraden) {
            SaxionApp.printLine("\nGefeliciteerd! Je hebt het woord geraden: " + woord);
        } else {
            SaxionApp.printLine("\nGame over! Het woord was: " + woord);
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
            /|\\  |
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

