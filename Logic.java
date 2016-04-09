public class Logic {
    
    public int movesCounter;
    public String userSymbol;
    boolean gameEnd;
    
    View view;
    
    public Logic(View view) {
        movesCounter = 0;
        this.view = view;
        gameEnd = false;
    }
    
    public boolean checkBoardForWin() {
        int x_sumDiagonalLR, x_sumDiagonalRL;
        x_sumDiagonalLR = x_sumDiagonalRL = 0;
        int x_sum_first_row, x_sum_second_row, x_sum_third_row;
        x_sum_first_row = x_sum_second_row = x_sum_third_row = 0;
        int x_sum_first_column, x_sum_second_column, x_sum_third_column;
        x_sum_first_column = x_sum_second_column = x_sum_third_column = 0;
        int o_sumDiagonalLR, o_sumDiagonalRL;
        o_sumDiagonalLR = o_sumDiagonalRL = 0;
        int o_sum_first_row, o_sum_second_row, o_sum_third_row;
        o_sum_first_row = o_sum_second_row = o_sum_third_row = 0;
        int o_sum_first_column, o_sum_second_column, o_sum_third_column;
        o_sum_first_column = o_sum_second_column = o_sum_third_column = 0;
        
        for (int i = 0; i < 3; i++) {
            if (view.buttons[i].getText() == "X")
                x_sum_first_row++;
            if (view.buttons[i].getText() == "O")
                o_sum_first_row++;
        }
        
        for (int i = 3; i < 6; i++) {
            if (view.buttons[i].getText() == "X")
                x_sum_second_row++;
            if (view.buttons[i].getText() == "O")
                o_sum_second_row++;
        }
        
        for (int i = 6; i < 9; i++) {
            if (view.buttons[i].getText() == "X")
                x_sum_third_row++;
            if (view.buttons[i].getText() == "O")
                o_sum_third_row++;
        }
        
        for (int i = 0; i < 9; i += 3) {
            if (view.buttons[i].getText() == "X")
                x_sum_first_column++;
            if (view.buttons[i].getText() == "O")
                o_sum_first_column++;
        }
        
        for (int i = 1; i < 9; i += 3) {
            if (view.buttons[i].getText() == "X")
                x_sum_second_column++;
            if (view.buttons[i].getText() == "O")
                o_sum_second_column++;
        }
        
        for (int i = 2; i < 9; i += 3) {
            if (view.buttons[i].getText() == "X")
                x_sum_third_column++;
            if (view.buttons[i].getText() == "O")
                o_sum_third_column++;
        }
        
        for (int i = 0; i < 9; i += 4) {
            if (view.buttons[i].getText() == "X")
                x_sumDiagonalLR++;
            if (view.buttons[i].getText() == "O")
                o_sumDiagonalLR++;
        }
        
        for (int i = 0; i < 9; i += 2) {
            if (view.buttons[i].getText() == "X")
                x_sumDiagonalRL++;
            if (view.buttons[i].getText() == "O")
                o_sumDiagonalRL++;
        }
        
        boolean someoneWon = false;
        
        if (x_sum_first_row == 3 || x_sum_second_row == 3 || x_sum_third_row == 3 ||
            x_sum_first_column == 3 || x_sum_second_column == 3 || x_sum_third_column == 3 ||
            x_sumDiagonalLR == 3 || x_sumDiagonalRL == 3)
            someoneWon = true;
        
        if (o_sum_first_row == 3 || o_sum_second_row == 3 || o_sum_third_row == 3 ||
            o_sum_first_column == 3 || o_sum_second_column == 3 || o_sum_third_column == 3 ||
            o_sumDiagonalLR == 3 || o_sumDiagonalRL == 3)
            someoneWon = true;
        
        return someoneWon;
    }
    
    public void setChoice() {
        if (movesCounter % 2 == 0 )
            userSymbol = "X";
        else
            userSymbol = "O";
    }
    
    public void incrementMovesCounter() { movesCounter++; }
    
    public void updateGameState() { 
        if (movesCounter == 9 || checkBoardForWin() == true)
            gameEnd = true;
    }
    
}