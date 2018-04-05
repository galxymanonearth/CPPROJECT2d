 

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyInput extends KeyAdapter {

    private Handler handler;

    public KeyInput(Handler handler) {
        this.handler = handler;
    }

    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();

        for (GameObject gObj : handler.object) {
            //key events for 1
            if (gObj.getId() == ID.Player) {
                if (key == KeyEvent.VK_W) gObj.setVelY(-5);
                if (key == KeyEvent.VK_S) gObj.setVelY(5);
                if (key == KeyEvent.VK_A) gObj.setVelX(-5);
                if (key == KeyEvent.VK_D) gObj.setVelX(5);

            }
        }
    }

    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();
        for (GameObject gObj : handler.object) {
            //key events for 1
            if (gObj.getId() == ID.Player) {
                if (key == KeyEvent.VK_W) gObj.setVelY(0);
                if (key == KeyEvent.VK_S) gObj.setVelY(0);
                if (key == KeyEvent.VK_A) gObj.setVelX(0);
                if (key == KeyEvent.VK_D) gObj.setVelX(0);

            }
        }
        if (key == KeyEvent.VK_ESCAPE)
            System.exit(0);

    }
}

