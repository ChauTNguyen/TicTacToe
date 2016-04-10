import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

class Controller implements ActionListener {

    View view;
    Model model;
    
    public Controller(Model model, View view) {
        this.model = model;
        this.view = view;
        addActionListeners();
    }

    private void addActionListeners() {
        for (int i = 0; i < view.buttons.length; i++)
            view.buttons[i].addActionListener(this);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (view.gameEnd == false) {
            model.setChoice();
            ((JButton) e.getSource()).setText(model.userSymbol);
            model.incrementMovesCounter();
            ((JButton) e.getSource()).setEnabled(false);
        }
    }
    
}

