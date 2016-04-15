import java.awt.GridLayout;
import java.awt.Container;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JOptionPane;

class View extends JFrame {
    GridLayout grid = new GridLayout(3, 3);     // default grid-size for tic-tac-toe
    JButton[] buttons;                          // an array of the buttons (9 of them)    

    /**
     * Overloaded constructor.
     */
    public View() {
        super("tic-tac-toe");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        addComponentsToPane(getContentPane());
        pack();
        setVisible(true);

        getRootPane().setDefaultButton(buttons[4]);
        buttons[4].requestFocus();
    }

    /**
     * Adds the panel along with its buttons to the pane.
     */
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

    /**
     * Informs the user who won.
     */
    public void informWin(Symbol userSymbol) {
        for (int i = 0; i < buttons.length; i++) {
            buttons[i].setEnabled(false);
        }
        JOptionPane.showMessageDialog(null, "Player " + userSymbol.toString() + " has won!");
    }
    
    /**
     * Informs the user of the tie.
     */
    public void informTie() {
        JOptionPane.showMessageDialog(null, "Tie!");
    }
}