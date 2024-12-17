import nl.saxion.app.SaxionApp;

import java.util.ArrayList;
import java.util.Scanner;

public class Galgje {
    public static void main(String[] args) {
        // Woordenlijst
        String[] woorden = {"computer", "programmeren", "java", "galgje", "technologie"};
        String woord = woorden[(int) (Math.random() * woorden.length)];

        // Variabelen voor het spel
        char[] geradenWoord = new char[woord.length()];
        for (int i = 0; i < geradenWoord.length; i++) {
            geradenWoord[i] = '_';
        }
        int fouten = 0;
        int maximaleFouten = 6;
        boolean geraden = false;

        Scanner scanner = new Scanner(System.in);

        // Spel loop
        while (fouten < maximaleFouten && !geraden) {
            // Toon de status van het spel
            System.out.println("\nGalgje: " + tekenGalgje(fouten));
            System.out.print("Huidige woord: ");
            System.out.println(geradenWoord);

            // Vraag een letter
            System.out.print("Raad een letter: ");
            char letter = scanner.nextLine().toLowerCase().charAt(0);

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
                System.out.println("Verkeerd! Je hebt nu " + fouten + " fout(en).");
            } else {
                System.out.println("Goed gedaan!");
            }

            // Controleer of het hele woord is geraden
            geraden = String.valueOf(geradenWoord).equals(woord);
        }

        // Spel beëindigen
        if (geraden) {
            System.out.println("\nGefeliciteerd! Je hebt het woord geraden: " + woord);
        } else {
            System.out.println("\nGame over! Het woord was: " + woord);
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

