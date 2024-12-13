import nl.saxion.app.SaxionApp;
import nl.saxion.app.interaction.GameLoop;
import nl.saxion.app.interaction.KeyboardEvent;
import nl.saxion.app.interaction.MouseEvent;

import java.text.BreakIterator;
import java.util.ArrayList;

public class BasicGame implements GameLoop {

    private boolean initialized = false; // Voor éénmalige initialisatie
    private int x, y;

    public static void main(String[] args) {
        SaxionApp.startGameLoop(new BasicGame(), 1000, 775, 40);
    }

    @Override
    public void init() {
        // Laad achtergrondafbeelding
        SaxionApp.drawImage("IMG_3813.png", 0, 0, 1000, 775);
    }

    @Override
    public void loop() {
        doStuff();
        if (!initialized) {
            init();
            initialized = true;
        }

    }

    public void doStuff() {
        SaxionApp.drawText("Maak een keuze:",80,18,24);
        SaxionApp.drawText("0 is sluit het spel",80,48,22);
        SaxionApp.drawText("1 is de Engelse woordenlijst",80,78,22);
        SaxionApp.drawText("2 is de Nederlandse woordenlijst",80,108,22);
        SaxionApp.drawText("Kies een optie: ",80,138,22);

        int choice = SaxionApp.readInt();
        SaxionApp.drawText("Input received: " + choice, 80, 200, 22);


        if (choice == 0) {
            SaxionApp.drawText("Spel wordt gesloten.",80,168,22);
            System. exit(0); // Sluit het programma
        } else if (choice == 1) {
            SaxionApp.drawText("Engelse woordenlijst wordt gekozen.",80,168,22);
        } else if (choice == 2) {
            String woord = woordenlijstnl();
            SaxionApp.drawText("Gekozen woord: " + woord,80,168,22);
        } else {
            SaxionApp.drawText("Ongeldige keuze. Probeer opnieuw.",80,168,22);
        }
    }

    @Override
    public void keyboardEvent(KeyboardEvent keyboardEvent) {
        // Event-afhandeling voor toetsenbord
    }

    @Override
    public void mouseEvent(MouseEvent mouseEvent) {
        // Event-afhandeling voor muis
    }

    // Nederlandse woordenlijst & random woord kiezen
    public String woordenlijstnl() {
        ArrayList<String> woorden = new ArrayList<>();
        woorden.add("Avontuur");
        woorden.add("Zandloper");
        woorden.add("Muzieknoot");
        return woorden.get(SaxionApp.getRandomValueBetween(0, woorden.size()-1));
    }

    // Engelse woordenlijst & random woord kiezen
    public String woordenlijsteng() {
        ArrayList<String> words = new ArrayList<>();
        words.add("Apple");
        words.add("Car");
        words.add("House");
        return words.get(SaxionApp.getRandomValueBetween(0, words.size()-1));
    }
}


