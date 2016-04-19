package chautnguyen.com.github.tictactoe.model;

import chautnguyen.com.github.tictactoe.model.Board;
import chautnguyen.com.github.tictactoe.model.Field.Symbol;

/**
 * The logic of the game.
 */
public class Game {
    private Board board;
    private int turnsCounter; // the number of turns since the start of the game
    private Symbol userSymbol; // the current Symbol of the player
    private boolean didSomeoneWin; // to check if a player won or if it was a tie

    /**
     * Default constructor.
     * 
     * Initializes the gameGrid array with 9 Field objects and the other
     * to their appropriate values.
     */
    public Game() {
        board = new Board();
        
        turnsCounter = 0;
        userSymbol = Symbol.NONE;
        didSomeoneWin = false;
    }

    /**
     * Sets the symbol of a specific field.
     * 
     * @param x     the value for the x-coordinate of the Field
     * @param y     the value for the y-coordinate of the Field
     */
    public void setFieldOwner(Symbol userSymbol, int x, int y) {
        board.setFieldOwner(userSymbol, x, y);
    }

    /**
     * Returns the owner of a specific field.
     * Note: I used this just for testing.
     * 
     * @param x     the value for the x-coordinate of the Field
     * @param y     the value for the y-coordinate of the Field
     * @return      the owner of the Field as a Symbol
     */
    public Symbol getFieldOwner(int x, int y) {
        return board.getFieldOwner(x, y);
    }

    /**
     * Prints the field.
     * Note: I used this just for testing.
     */
    public void printField() {
        System.out.println("---PRINTING FIELD---");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(getFieldOwner(i, j) + " ");
            }
            System.out.println();
        }
    }
    
    /**
     * Evaluates the board to see if the game is over, and then checks if the number of turns is maxed out at 9.
     * If both are not true, return false;
     * 
     * @return      returns true is game is over. Returns false if otherwise.
     */
    public boolean isGameOver() {
        int[] scores = board.evaluateBoard();
        
        for (int score : scores) {
            if (score == 3 || score == -3) {
                didSomeoneWin = true;
                return true;
            }
        }
        
        if (turnsCounter == 9) {
            return true;
        }
        
        return false; // if both of the above conditions don't apply, game is not over
    }
    
    /**
     * Increments the number of turns.
     */
    public void incrementTurnsCounter() {
        turnsCounter++;
    }
    
    /**
     * Returns the number of turns since the start of the game.
     * 
     * @return      the number of turns since the start of the game.
     */
    public int getTurnsCounter() {
        return turnsCounter;
    }
    
    /**
     * Sets the user symbol to a Symbol depending on whether the number of turns is even or odd.
     */
    public void setUserSymbol() {
        if (turnsCounter % 2 == 1) {
            userSymbol = Symbol.values()[0];
        } else {
            userSymbol = Symbol.values()[1];
        }
    }
    
    /**
     * Returns the current user symbol.
     * 
     * @return      the current user symbol.
     */
    public Symbol getUserSymbol() {
        return userSymbol;
    }
    
    /**
     * Returns true if a player has won the game. Otherwise, false.
     * 
     * @return      true if a player has won the game. Otherwise, return false.
     */
    public boolean getDidSomeoneWin() {
        return didSomeoneWin;
    }
}