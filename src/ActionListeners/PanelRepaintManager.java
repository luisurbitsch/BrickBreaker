package ActionListeners;
import GUI.Panel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelRepaintManager implements ActionListener {
    private final Timer timer;
    private final Panel panel;

    public PanelRepaintManager(final Panel panel) {
        this.panel = panel;
        this.timer = new Timer(panel.getRepaintTime(), this);
        timer.start();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        panel.repaint();

    }

    public Panel getPanel() {
        return panel;
    }

    public Timer getTimer() {
        return timer;
    }
}
