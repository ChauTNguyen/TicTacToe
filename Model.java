public class Model {
    
    private int movesCounter;
    private String userSymbol;
    
    public Model() {
        movesCounter = 0;
    }
    
    public void setUserSymbol() {
        if (movesCounter % 2 == 1 ) {
            userSymbol = "X";
        } else {
            userSymbol = "O";
        }
    }
    
    public String getUserSymbol() {
        return userSymbol;
    }
    
    public void incrementMovesCounter() {
        movesCounter++;
    }
    
    public int getMovesCounter() {
        return movesCounter;
    }
}