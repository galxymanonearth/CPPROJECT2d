 

import java.awt.*;
import java.util.Random;

public class Player extends GameObject {
    Random r = new Random();

    public Player(int x, int y, ID id) {
        super(x, y, id);
    }

    @Override
    public void tick() {
        x += velX;
        y += velY;

        x = Game.clamp(x, 0, Game.WIDTH - 40);
        y = Game.clamp(y, 0, Game.HEIGHT - 64);
    }

    @Override
    public void render(Graphics g) {
        g.setColor((id == ID.Player) ? Color.white : Color.blue);
        g.fillRect(x, y, 32, 32);

    }

}
