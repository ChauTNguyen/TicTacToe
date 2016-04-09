import java.awt.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;

class View extends JFrame {
    
    GridLayout grid = new GridLayout(3, 3);
    JButton[] buttons;
    Model model;
    boolean gameEnd;
    
    public View(Model model) {
        super("tic-tac-toe");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        addComponentsToPane(getContentPane());
        pack();
        setVisible(true);
        this.model = model;
        gameEnd = false;
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
    
    public boolean checkBoardForWin() {
        int x_sum_first_row, x_sum_second_row, x_sum_third_row,
            x_sum_first_column, x_sum_second_column, x_sum_third_column,
            x_sumDiagonalLR, x_sumDiagonalRL;
        
        x_sum_first_row = x_sum_second_row = x_sum_third_row
        = x_sum_first_column = x_sum_second_column = x_sum_third_column
        = x_sumDiagonalLR = x_sumDiagonalRL = 0;
        
        int o_sum_first_row, o_sum_second_row, o_sum_third_row,
            o_sum_first_column, o_sum_second_column, o_sum_third_column,
            o_sumDiagonalLR, o_sumDiagonalRL;
            
        o_sum_first_row = o_sum_second_row = o_sum_third_row
        = o_sum_first_column = o_sum_second_column = o_sum_third_column
        = o_sumDiagonalLR = o_sumDiagonalRL = 0;
        
        for (int i = 0; i < 3; i++) {
            if (buttons[i].getText() == "X")
                x_sum_first_row++;
            if (buttons[i].getText() == "O")
                o_sum_first_row++;
        }
        
        for (int i = 3; i < 6; i++) {
            if (buttons[i].getText() == "X")
                x_sum_second_row++;
            if (buttons[i].getText() == "O")
                o_sum_second_row++;
        }
        
        for (int i = 6; i < 9; i++) {
            if (buttons[i].getText() == "X")
                x_sum_third_row++;
            if (buttons[i].getText() == "O")
                o_sum_third_row++;
        }
        
        for (int i = 0; i < 9; i += 3) {
            if (buttons[i].getText() == "X")
                x_sum_first_column++;
            if (buttons[i].getText() == "O")
                o_sum_first_column++;
        }
        
        for (int i = 1; i < 9; i += 3) {
            if (buttons[i].getText() == "X")
                x_sum_second_column++;
            if (buttons[i].getText() == "O")
                o_sum_second_column++;
        }
        
        for (int i = 2; i < 9; i += 3) {
            if (buttons[i].getText() == "X")
                x_sum_third_column++;
            if (buttons[i].getText() == "O")
                o_sum_third_column++;
        }
        
        for (int i = 0; i < 9; i += 4) {
            if (buttons[i].getText() == "X")
                x_sumDiagonalLR++;
            if (buttons[i].getText() == "O")
                o_sumDiagonalLR++;
        }
        
        for (int i = 2; i < 7; i += 2) {
            if (buttons[i].getText() == "X")
                x_sumDiagonalRL++;
            if (buttons[i].getText() == "O")
                o_sumDiagonalRL++;
        }
        
        boolean someoneWon = false;
        
        if (x_sum_first_row == 3 || x_sum_second_row == 3 || x_sum_third_row == 3 ||
            x_sum_first_column == 3 || x_sum_second_column == 3 || x_sum_third_column == 3 ||
            x_sumDiagonalLR == 3 || x_sumDiagonalRL == 3 ||
            o_sum_first_row == 3 || o_sum_second_row == 3 || o_sum_third_row == 3 ||
            o_sum_first_column == 3 || o_sum_second_column == 3 || o_sum_third_column == 3 ||
            o_sumDiagonalLR == 3 || o_sumDiagonalRL == 3)
            someoneWon = true;
        
        return someoneWon;
    }
    
    public void updateGameState() { 
        if (model.movesCounter == 9 || checkBoardForWin() == true)
            gameEnd = true;
    }
    
    public void endGame() {
        for (int i = 0; i < buttons.length; i++)
            buttons[i].setEnabled(false);
    }
    
}