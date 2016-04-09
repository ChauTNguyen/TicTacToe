import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

class Controller implements ActionListener {

    View view;
    Logic logic;

    public Controller(Logic logic, View view) {
        this.logic = logic;
        this.view = view;
        addActionListeners();
    }

    private void addActionListeners() {
        for (int i = 0; i < view.buttons.length; i++)
            view.buttons[i].addActionListener(this);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (logic.gameEnd == false) {
            logic.setChoice();
            ((JButton) e.getSource()).setText(logic.userSymbol);
            logic.incrementMovesCounter();
        }
    }
    
}

