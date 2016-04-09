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
        
        return false;
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