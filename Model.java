public class Model {
    
    private int movesCounter; // number of moves since start of the game
    private String userSymbol; // "X" or "O"
    
    /**
     * Default constructor. Sets the number of moves to 0.
     */
    public Model() {
        movesCounter = 0;
    }
    
    /**
     * Sets the user symbol to "X" or "O" depending on the number of moves
     * since the start of the game. "X" for odd turns, "O" for even.
     */
    public void setUserSymbol() {
        if (movesCounter % 2 == 1 ) {
            userSymbol = "X";
        } else {
            userSymbol = "O";
        }
    }
    
    /**
     * Returns the current symbol "X" or "O".
     * 
     * @return the user symbol
     */
    public String getUserSymbol() {
        return userSymbol;
    }
    
    /**
     * Increments the number of moves since the start of the game.
     */
    public void incrementMovesCounter() {
        movesCounter++;
    }
    
    /**
     * Returns the number of moves since the start of the game.
     * 
     * @return the number of moves since the start of the game
     */
    public int getMovesCounter() {
        return movesCounter;
    }
    
}