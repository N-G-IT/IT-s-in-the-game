import nl.saxion.app.SaxionApp;

import nl.saxion.app.interaction.GameLoop;
import nl.saxion.app.interaction.KeyboardEvent;
import nl.saxion.app.interaction.MouseEvent;

public class BasicGame implements GameLoop {

    public static void main(String[] args) {
        SaxionApp.startGameLoop(new BasicGame(), 1000, 775, 40);
    }

    int x,y;



    public void doStuff() {
        SaxionApp.printLine("Maka a choice:");
        SaxionApp.printLine("0 is close the game");
        SaxionApp.printLine("1 is the EN word list");
        SaxionApp.printLine("2 is the Nl word list");
        SaxionApp.print("Chose one of the above: ");

        int choice = SaxionApp.readInt();


        if (choice == 0) {

            // close game


        } else if (choice == 1) {

            // kies engelse woordenlijst

        } else if (choice == 2) {

            // kies nederlandese woordenlijst

        }

    }


    @Override
    public void init() {

    }

    @Override
    public void loop() {



    }

    @Override
    public void keyboardEvent(KeyboardEvent keyboardEvent) {




    }

    @Override
    public void mouseEvent(MouseEvent mouseEvent) {






    }
}






