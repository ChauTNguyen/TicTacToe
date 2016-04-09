import java.awt.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;

class View extends JFrame {
    GridLayout grid = new GridLayout(3, 3);
    JButton[] buttons;
    
    public View() {
        super("tic-tac-toe");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        addComponentsToPane(getContentPane());
        pack();
        setVisible(true);
    }

    public void addComponentsToPane(final Container pane) {
        final JPanel panel = new JPanel();
        panel.setLayout(grid);        
        panel.setPreferredSize(new Dimension(300, 300));
        
        buttons = new JButton[9];
        
        for (int i = 0; i < buttons.length; i++) {
            buttons[i] = new JButton();
            buttons[i].getPreferredSize();
            panel.add(buttons[i]);
        }
        
        pane.add(panel);
    }
    
    public void endGame() {
        for (int i = 0; i < buttons.length; i++)
            buttons[i].setEnabled(false);
    }
}