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
    Model model;
    boolean isGameOver;

    /**
     * Overloaded constructor.
     */
    public View(Model model) {
        super("tic-tac-toe");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        addComponentsToPane(getContentPane());
        pack();
        setVisible(true);

        this.model = model;
        isGameOver = false;

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
     * Check if someone has won the game.
     * 
     * @return      a boolean. True if someone has won. Otherwise, false.
     */
    public boolean didSomeoneWin() {
        int[] scores = evaluateBoard();
        boolean someoneWon = false;
        for (int i : scores) {
            if (i == 3 || i == -3)
                someoneWon = true;
        }
        return someoneWon;
    }

    /**
     * Evaluates the board, stores the values into an array, and returns it.
     * 
     * @return      an array containing the score of each possible win condition.
     */
    public int[] evaluateBoard() {
        int[] scores = {0,0,0,0,0,0,0,0};

        // Evaluate first row
        for (int i = 0; i < 3; i++) {
            if (buttons[i].getText() == "X") {
                scores[0]++;
            }
            if (buttons[i].getText() == "O") {
                scores[0]--;
            }
        }

        // Evaluate second row
        for (int i = 3; i < 6; i++) {
            if (buttons[i].getText() == "X") {
                scores[1]++;
            }
            if (buttons[i].getText() == "O") {
                scores[1]--;
            }
        }

        // Evaluate third row
        for (int i = 6; i < 9; i++) {
            if (buttons[i].getText() == "X") {
                scores[2]++;
            }
            if (buttons[i].getText() == "O") {
                scores[2]--;
            }
        }

        // Evaluate first column
        for (int i = 0; i < 9; i += 3) {
            if (buttons[i].getText() == "X") {
                scores[3]++;
            }
            if (buttons[i].getText() == "O") {
                scores[3]--;
            }
        }

        // Evaluate second column
        for (int i = 1; i < 9; i += 3) {
            if (buttons[i].getText() == "X") {
                scores[4]++;
            }
            if (buttons[i].getText() == "O") {
                scores[4]--;
            }
        }

        // Evaluate third column
        for (int i = 2; i < 9; i += 3) {
            if (buttons[i].getText() == "X") {
                scores[5]++;
            }
            if (buttons[i].getText() == "O") {
                scores[5]--;
            }
        }

        // Evaluate left-to-right diagonal
        for (int i = 0; i < 9; i += 4) {
            if (buttons[i].getText() == "X") {
                scores[6]++;
            }
            if (buttons[i].getText() == "O") {
                scores[6]--;
            }
        }

        // Evaluate right-to-left diagonal
        for (int i = 2; i < 7; i += 2) {
            if (buttons[i].getText() == "X") {
                scores[7]++;
            }
            if (buttons[i].getText() == "O") {
                scores[7]--;
            }
        }

        return scores;
    }
    
    /**
     * Informs the user whether the game is a tie, or if someone won.
     * If someone won, inform the user exactly which player won.
     */
    public void informOutcome() {
        if (didSomeoneWin() == true) {
            for (int i = 0; i < buttons.length; i++) {
                buttons[i].setEnabled(false);
            }
            JOptionPane.showMessageDialog(null, "Player " + model.getUserSymbol() + " has won!");
        } else {
            JOptionPane.showMessageDialog(null, "Tie!");
        }
    }

}