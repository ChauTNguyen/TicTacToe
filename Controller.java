import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

class Controller implements ActionListener {

    private View view;
    private Model model;
    
    public Controller(Model model, View view) {
        this.model = model;
        this.view = view;
        addActionListeners();
    }
    
     private void addActionListeners() {
        for (int i = 0; i < view.buttons.length; i++) {
            view.buttons[i].addActionListener(this);
        }
    }
   
    @Override
    public void actionPerformed(ActionEvent e) {
        if (view.gameEnd == false) {
            model.incrementMovesCounter();
            model.setUserSymbol();
            ((JButton) e.getSource()).setText(model.getUserSymbol());
            ((JButton) e.getSource()).setEnabled(false);
        }
    }
    
    public void updateGameState() {
        if (model.getMovesCounter() == 9 || view.didSomeoneWin() == true) {
            view.gameEnd = true;
        }
    }
    
}

