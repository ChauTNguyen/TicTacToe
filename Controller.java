import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

class Controller implements ActionListener {
    private Game game;
    private View view;

    /**
     * Overloaded constructor. Initializes the game and view, and
     * adds the action listeners to the buttons in view.
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
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if (game.isGameOver() == false) {
            game.incrementTurnsCounter();
            game.setUserSymbol();
            int index = getMove((JButton) e.getSource());
            int x = 0; // row coordinate
            int y = 0; // column coordinate
            switch (index) {
                case 0: x = 0;
                        y = 0;
                        break;
                case 1: x = 0;
                        y = 1;
                        break;
                case 2: x = 0;
                        y = 2;
                        break;
                case 3: x = 1;
                        y = 0;
                        break;
                case 4: x = 1;;
                        y = 1;
                        break;
                case 5: x = 1;
                        y = 2;
                        break;
                case 6: x = 2;
                        y = 0;
                        break;
                case 7: x = 2;
                        y = 1;
                        break;
                case 8: x = 2;
                        y = 2;
                        break;
                default: break;
            }
            game.setFieldOwner(game.getUserSymbol(), x, y);
            ((JButton) e.getSource()).setText((game.getUserSymbol()).toString());
            ((JButton) e.getSource()).setEnabled(false);
        }
    }
    
    /**
     * Returns the index of the current JButton.
     */
    public int getMove(JButton button) {
        int index = 0;
        for (int i = 0; i < 9; i++) {
            if (button == view.buttons[i]) {
                index = i;
            }
        }
        return index;
    }

    /**
     * Informs the user of the outcome of the game depending on if someone won or not.
     */
    public void informOutcome() {
        if (game.getDidSomeoneWin()) {
            System.out.println(game.getDidSomeoneWin());
            System.out.println("Informing win.");
            view.informWin(game.getUserSymbol());
        } else {
            System.out.println("Informing tie.");
            game.printField();
            int[] scores = game.evaluateBoard();
            for (int score : scores) {
                System.out.print(score + " " );
            }
            view.informTie();
        }
    }
}

