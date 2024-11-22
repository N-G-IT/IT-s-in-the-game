import nl.saxion.app.SaxionApp;

import nl.saxion.app.interaction.GameLoop;
import nl.saxion.app.interaction.KeyboardEvent;
import nl.saxion.app.interaction.MouseEvent;

public class BasicGame implements GameLoop {


    int x,y;


    public static void main(String[] args) {
        SaxionApp.startGameLoop(new BasicGame(), 1000, 1000, 40);
    }

    @Override
    public void init() {
        x = 500;
        y = 500;
    }

    @Override
    public void loop() {
        SaxionApp.drawCircle(x,y,100);
    }

    @Override
    public void keyboardEvent(KeyboardEvent keyboardEvent) {

        if (keyboardEvent.isShiftDown()){
            SaxionApp.clear();
        }



    }

    @Override
    public void mouseEvent(MouseEvent mouseEvent) {
        x = mouseEvent.getX();
        y = mouseEvent.getY();





    }
}






