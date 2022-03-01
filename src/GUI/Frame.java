package GUI;
import javax.swing.*;

public class Frame extends JFrame {
    private final Panel panel;

    public Frame() {
        setSize(480, 720);
        setTitle("Brick Breaker");
        setUndecorated(false);
        setResizable(false);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
        this.panel = new Panel(this);
    }

    public Panel getPanel() {
        return panel;
    }
}
