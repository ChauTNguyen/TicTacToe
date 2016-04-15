import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

class Controller implements ActionListener {
    private Game game;
    private View view;

    /**
     * Overloaded constructor. Initializes the game and view, and
     * adds the action listeners to the buttons in view.
     * 
     * @param   an instance of the Game class.
     * @param   an instance of the View class.
     */
    public Controller(Game game, View view) {
        this.game = game;
        this.view = view;
        addActionListeners();
    }

    /**
     * Adds an action listener to every button.
     */
    private void addActionListeners() {
        for (int i = 0; i < view.buttons.length; i++) {
            view.buttons[i].addActionListener(this);
        }
    }

    /**
     * Increments the number of moves since the start of the game, and
     * sets the user symbol. It then finds out what x and y coordinates that button
     * corresponds to in the Game object.
     * Examples: button[0] would be Field[0][0]. button [1] would be Field[0][1].
     * button[5] would be Field[1][2].
     * 
     * It then sets the owner of the field in the Game object, and modifies the View buttons.
     * 
     * @param e     the action performed. In this game, it would be a mouse click.
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if (game.isGameOver() == false) {
            game.incrementTurnsCounter();
            game.setUserSymbol();
            
            int index = getMove((JButton) e.getSource());
            int x = getX(index); // row coordinate
            int y = getY(index); // column coordinate
            
            game.setFieldOwner(game.getUserSymbol(), x, y);
            
            // modifies the current display
            ((JButton) e.getSource()).setText((game.getUserSymbol()).toString());
            ((JButton) e.getSource()).setEnabled(false);
        }
    }
    
    /**
     * Returns the index of the current JButton.
     * 
     * @param button    the button that was clicked.
     * @return      the index of the JButton clicked.
     */
    private int getMove(JButton button) {
        int index = 0;
        for (int i = 0; i < 9; i++) {
            if (button == view.buttons[i]) {
                index = i;
            }
        }
        return index;
    }
    
    /**
     * Returns the x-coordinate that corresponds to the index.
     * 
     * @param index     the index of of the JButton
     * @return      the x-coordinate that corresponds to the index.
     */
    private int getX(int index) {
        if (0 <= index && index <= 2) {
            return 0;
        }
        if (3 <= index && index <= 5) {
            return 1;
        }
        if (6 <= index && index <= 8) {
            return 2;
        }
        return 0; // just to make sure all return paths work. I did the above because I think it'sm ore readable.
    }
    
    /**
     * Returns the y-coordinate that corresponds to the index.
     * 
     * @param index      the index of the JButton
     * @return      the y-coordinate that corresponds to the index.
     * 
     */
    public int getY(int index) {
        if (index == 0 || index == 3 || index == 6) {
            return 0;
        }
        if (index == 1 || index == 4 || index == 7) {
            return 1;
        }
        if (index == 2 || index == 5 || index == 8) {
            return 2;
        }
        return 0; // just to make sure all return paths work. I did the above because I think it'sm ore readable.
    }
    
    /**
     * Informs the user of the outcome of the game depending on if someone won or not.
     */
    public void informOutcome() {
        if (game.getDidSomeoneWin()) {
            view.informWin(game.getUserSymbol());
        } else {
            view.informTie();
        }
    }
}

