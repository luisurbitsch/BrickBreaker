package GUI;
import ActionListeners.PanelRepaintManager;
import GameComponents.Ball;
import GameComponents.LevelLoader;
import GameComponents.Player;
import KeyListeners.BallKeyListener;
import KeyListeners.PlayerKeyListener;
import javax.swing.*;
import java.awt.*;


public class Panel extends JPanel {
    private final int repaintTime = 5;
    private final Player player;
    private final Ball ball;


    public Panel(final Frame frame) {
        setSize(frame.getContentPane().getWidth(), frame.getContentPane().getHeight());
        setBackground(Color.darkGray);
        setFocusable(true);
        setRequestFocusEnabled(true);
        this.player = new Player(this);
        this.ball = new Ball(this, player);
        new PanelRepaintManager(this);
        new PlayerKeyListener(this, player);
        new BallKeyListener(this, ball);
        frame.add(this);
        setVisible(true);
        LevelLoader.loadObstacles(this);
    }

    @Override
    public void paint(final Graphics graphics) {
        requestFocus(true);
        super.paint(graphics);

        player.display(graphics);
        player.move();

        ball.display(graphics);
        ball.move();

        LevelLoader.displayObstacles(graphics);
        LevelLoader.reloadObstacles(this);



    }

    public int getRepaintTime() {
        return repaintTime;
    }
}
