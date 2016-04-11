import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

class Controller implements ActionListener {

    private View view;
    private Model model;
    
    /*
     * Overloaded constructor. Initializes the model and view, and
     * adds the action listeners to the buttons in view.
     */
    public Controller(Model model, View view) {
        this.model = model;
        this.view = view;
        addActionListeners();
    }
    
    /*
     * Adds an action listener to every button.
     */
    private void addActionListeners() {
        for (int i = 0; i < view.buttons.length; i++) {
            view.buttons[i].addActionListener(this);
        }
    }
   
    /*
     * Increments the number of moves since the start of the game,
     * sets the user symbol, sets the text of the button to that user symbol,
     * and then disables the button.
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if (view.isGameOver == false) {
            model.incrementMovesCounter();
            model.setUserSymbol();
            ((JButton) e.getSource()).setText(model.getUserSymbol());
            ((JButton) e.getSource()).setEnabled(false);
        }
    }
    
    /*
     * Checks if the number of moves is maxed out, or if someone has won the game already.
     */
    public void updateGameState() {
        if (model.getMovesCounter() == 9 || view.didSomeoneWin() == true) {
            view.isGameOver = true;
        }
    }
    
}

