package KeyListeners;

import GUI.Panel;
import GameComponents.MovingDirections;
import GameComponents.Player;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class PlayerKeyListener implements KeyListener {
    private final Player player;

    public PlayerKeyListener(final Panel panel, final Player player) {
        panel.addKeyListener(this);
        this.player = player;
    }

    @Override
    public void keyTyped(KeyEvent keyEvent) {

    }

    @Override
    public void keyPressed(KeyEvent keyEvent) {
        if (keyEvent.getKeyCode() == KeyEvent.VK_LEFT) {
            player.setMovingDirection(MovingDirections.LEFT);
        } else if (keyEvent.getKeyCode() == KeyEvent.VK_RIGHT) {
            player.setMovingDirection(MovingDirections.RIGHT);
        }
    }

    @Override
    public void keyReleased(KeyEvent keyEvent) {
        player.setMovingDirection(MovingDirections.NEUTRAL);
    }

    public Player getPlayer() {
        return player;
    }
}
