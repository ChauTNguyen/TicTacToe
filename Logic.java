public class Logic {
    
    public int movesCounter;
    public String userSymbol;
    
    View view;
    
    public Logic(View view) {
        movesCounter = 0;
        this.view = view;
    }
    
    public boolean checkBoardForWin() {
        
        return false;
    }
    
    public void setChoice() {
        if (movesCounter % 2 == 0 )
            userSymbol = "X";
        else
            userSymbol = "O";
    }
    
    public void incrementMovesCounter() { movesCounter++; }
    
    public void updateGame() { 
        if (movesCounter == 8 || checkBoardForWin() == true) view.endGame();
    }
    
}