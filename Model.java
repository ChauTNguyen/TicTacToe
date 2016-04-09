public class Model {
    
    public int movesCounter;
    public String userSymbol;
    
    public Model() {
        movesCounter = 0;
    }
    
    public void setChoice() {
        if (movesCounter % 2 == 0 )
            userSymbol = "X";
        else
            userSymbol = "O";
    }
    
    public void incrementMovesCounter() { movesCounter++; }
    
}