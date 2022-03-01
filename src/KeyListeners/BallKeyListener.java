package KeyListeners;
import GUI.Panel;
import GameComponents.Ball;
import GameComponents.BallStatuses;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class BallKeyListener implements KeyListener {
    private final Ball ball;

    public BallKeyListener(final Panel panel, final Ball ball) {
        panel.addKeyListener(this);
        this.ball = ball;
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent keyEvent) {
        if (keyEvent.getKeyCode() == KeyEvent.VK_SPACE) {
            ball.setBallStatus(BallStatuses.MOVING);
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    public Ball getBall() {
        return ball;
    }
}
