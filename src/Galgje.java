import nl.saxion.app.SaxionApp;

import java.awt.*;
import java.util.ArrayList;

public class Galgje implements Runnable {
    public static void main(String[] args) {
        SaxionApp.start(new Galgje(), 640, 480);
    }

    public void backgroundColor() {
        SaxionApp.setBackgroundColor(new Color(112, 169, 207));

    }

    public void aardvark(){

        // Breedte en hoogte van het venster
        int schermBreedte = SaxionApp.getWidth();
        int schermHoogte = SaxionApp.getHeight();

        // Breedte en hoogte van de afbeelding
        int afbeeldingBreedte = 100;
        int afbeeldingHoogte = 100;

        // Plaatsing in de rechteronderhoek
        int xPositie = schermBreedte - afbeeldingBreedte - 10; // 10 pixels vanaf de rechterrand
        int yPositie = schermHoogte - afbeeldingHoogte - 10; // 10 pixels vanaf de onderrand

        SaxionApp.drawImage("BasicGame/Aardvark.png", xPositie, yPositie, afbeeldingBreedte, afbeeldingHoogte);
    }



    @Override
    public void run() {
        boolean opnieuwSpelen;
        do {
            backgroundColor();
            aardvark();
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
                    "database", "network", "processor", "operatingsystem", "security"
            };

            // Laat de speler een taal kiezen
            SaxionApp.printLine("Kies een taal (type 'Nederlands'(n) of 'English'(e)):");
            String taal = SaxionApp.readString(SaxionApp.SAXION_PINK).toLowerCase();

            // Kies de juiste woordenlijst en teksten
            String[] woorden;
            String vraagLetter, foutGok, goedGok, huidigWoord, aantalFoutenTekst, galgjeGefeliciteerd, galgjeGameOver;
            if (taal.equals("nederlands") || taal.equals("n")) {
                woorden = woordenNederlands;
                vraagLetter = "Raad een letter: ";
                foutGok = "Fout! De letter zit niet in het woord.";
                goedGok = "Goed gedaan! De letter zit in het woord.";
                huidigWoord = "Huidig woord: ";
                aantalFoutenTekst = "Aantal fouten: ";
                galgjeGefeliciteerd = "Gefeliciteerd! Je hebt het woord geraden: ";
                galgjeGameOver = "Game over! Het woord was: ";
            } else {
                woorden = woordenEngels;
                vraagLetter = "Guess a letter: ";
                foutGok = "Wrong! The letter is not in the word.";
                goedGok = "Well done! The letter is in the word.";
                huidigWoord = "Current word: ";
                aantalFoutenTekst = "Number of mistakes: ";
                galgjeGefeliciteerd = "Congratulations! You guessed the word: ";
                galgjeGameOver = "Game over! The word was: ";
            }

            // Kies een willekeurig woord
            String woord = woorden[SaxionApp.getRandomValueBetween(0,woorden.length )];

            // Variabelen voor het spel
            char[] geradenWoord = new char[woord.length()];
            for (int i = 0; i < geradenWoord.length; i++) {
                geradenWoord[i] = '_';
            }

            ArrayList<Character> fouteLetters = new ArrayList<>();
            int fouten = 0;
            int maximaleFouten = 6;
            boolean geraden = false;

            // Spel loop
            while (fouten < maximaleFouten && !geraden) {
                // Wis het scherm en toon de status
                SaxionApp.clear();
                SaxionApp.print("\n\n\n");
                SaxionApp.printLine(tekenGalgje(fouten));
                aardvark();
                SaxionApp.print(huidigWoord);
                toonWoord(geradenWoord);
                SaxionApp.printLine("\n" + aantalFoutenTekst + fouten + " / " + maximaleFouten);
                if (!fouteLetters.isEmpty()) {
                    SaxionApp.printLine("Foute letters: " + fouteLetters);
                }

                // Vraag een letter
                SaxionApp.print(vraagLetter);
                char letter = Character.toLowerCase(SaxionApp.readChar());

                // Controleer of de letter in het woord zit
                boolean goedGeraad = false;
                for (int i = 0; i < woord.length(); i++) {
                    if (woord.charAt(i) == letter) {
                        geradenWoord[i] = letter;
                        goedGeraad = true;
                    }
                }

                if (!goedGeraad) {
                    if (!fouteLetters.contains(letter)) {
                        fouteLetters.add(letter);
                        fouten++;
                    }
                    SaxionApp.printLine(foutGok);
                } else {
                    SaxionApp.printLine(goedGok);
                }

                // Controleer of het hele woord is geraden
                geraden = String.valueOf(geradenWoord).equals(woord);
            }

            // Spel beëindigen
            SaxionApp.clear();
            if (geraden) {
                SaxionApp.printLine("\n" + galgjeGefeliciteerd + woord);
            } else {
                SaxionApp.printLine("\n" + galgjeGameOver + woord);
            }

            // Vraag of de speler opnieuw wil spelen
            String opnieuwInput;
            do {
                if (taal.equals("nederlands") || taal.equals("n")) {
                    SaxionApp.printLine("\nWil je opnieuw spelen? (type 'ja' of 'nee'):");
                } else {
                    SaxionApp.printLine("\nDo you want to play again? (type 'yes' or 'no'):");
                }

                opnieuwInput = SaxionApp.readString(SaxionApp.SAXION_PINK).toLowerCase();

                // Check voor 'ja'/'nee' of 'yes'/'no'
                opnieuwSpelen = opnieuwInput.equals("ja") || opnieuwInput.equals("yes");

                if (!opnieuwSpelen && !(opnieuwInput.equals("nee") || opnieuwInput.equals("no"))) {
                    if (taal.equals("nederlands")) {
                        SaxionApp.printLine("Ongeldige invoer. Typ 'ja' of 'nee'.");
                    } else {
                        SaxionApp.printLine("Invalid input. Type 'yes' or 'no'.");
                    }
                }
            } while (!opnieuwSpelen && !(opnieuwInput.equals("nee") || opnieuwInput.equals("no")));

        } while (opnieuwSpelen); // Speel opnieuw als gewenst
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

    // Hulpmethode om het woord te tonen
    public static void toonWoord(char[] geradenWoord) {
        for (char letter : geradenWoord) {
            SaxionApp.print(letter + " ");
        }
    }
}