/**
 * One field of the game grid.
 */
class Field {
    private Symbol owner;

    Field() {
        owner = Symbol.values()[2];
    }

    public Symbol getOwner() {
        return owner;
    }

    public void setOwner(Symbol owner) {
        this.owner = owner;
    }

    @Override
    public String toString() {
        if (owner == Symbol.values()[0]) {
            return "X";
        } else if (owner == Symbol.values()[1]) {
            return "O";
        } else {
            return "NONE";
        }
    }
}

/**
 * A representation of an owner of a field.
 */
enum Symbol {
    X, O, NONE
}

/**
 * The logic of the game.
 */
public class Game {
    private Field[][] gameGrid;
    private int turnsCounter; // the number of turns since the start of the game
    private Symbol userSymbol; // the current Symbol of the player
    private boolean didSomeoneWin; // to check if a player won or if it was a tie

    /**
     * Default constructor.
     * 
     * Initializes the gameGrid array with 9 Field objects and the other
     * to their appropriate values.
     */
    Game() {
        gameGrid = new Field[3][3];
        turnsCounter = 0;
        userSymbol = Symbol.values()[2];
        didSomeoneWin = false;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                gameGrid[i][j] = new Field();
            }
        }
    }

    /**
     * Sets the symbol of a specific field.
     * 
     * @param x     the value for the x coordinate of the Field
     * @param y     the value for the y coordinate of the Field
     */
    public void setFieldOwner(Symbol owner, int x, int y) {
        gameGrid[x][y].setOwner(owner);
    }

    /**
     * Returns the owner of a specific field.
     * Note: I'm using this just for testing.
     * 
     * @param x     the value for the x coordinate of the Field
     * @param y     the value for the y coordinate of the Field
     */
    public Symbol getFieldOwner(int x, int y) {
        return gameGrid[x][y].getOwner();
    }

    /**
     * Prints the field.
     * Note: I'm using this just for testing.
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
     */
    public boolean isGameOver() {
        int[] scores = evaluateBoard();
        for (int score : scores) {
            if (score == 3 || score == -3) {
                didSomeoneWin = true;
                System.out.println("didSomeoneWin: " + didSomeoneWin);
                return true;
            }
        }
        
        if (turnsCounter == 9) {
            return true;
        }
        
        return false;
    }

    /**
     * Evaluates the board, stores the values into an array, and returns it.
     * 
     * @return      an array containing the score of each possible win condition.
     */
    public int[] evaluateBoard() {
        int[] scores = new int[8];

        // evaluate the first row
        for (int i = 0; i < 3; i++) {
            if (gameGrid[0][i].getOwner() == Symbol.values()[0]) {
                scores[0]++;
            }
            if (gameGrid[0][i].getOwner() == Symbol.values()[1]) {
                scores[0]--;
            }
        }

        // evaluate the second row
        for (int i = 0; i < 3; i++) {
            if (gameGrid[1][i].getOwner() == Symbol.values()[0]) {
                scores[1]++;
            }
            if (gameGrid[1][i].getOwner() == Symbol.values()[1]) {
                scores[1]--;
            }
        }

        // evaluate the third row
        for (int i = 0; i < 3; i++) {
            if (gameGrid[2][i].getOwner() == Symbol.values()[0]) {
                scores[2]++;
            }
            if (gameGrid[2][i].getOwner() == Symbol.values()[1]) {
                scores[2]--;
            }
        }

        // evaluate the first column
        for (int i = 0; i < 3; i++) {
            if (gameGrid[i][0].getOwner() == Symbol.values()[0]) {
                scores[3]++;
            }
            if (gameGrid[i][0].getOwner() == Symbol.values()[1]) {
                scores[3]--;
            }
        }

        // evaluate the second column
        for (int i = 0; i < 3; i++) {
            if (gameGrid[i][1].getOwner() == Symbol.values()[0]) {
                scores[4]++;
            }
            if (gameGrid[i][1].getOwner() == Symbol.values()[1]) {
                scores[4]--;
            }
        }

        // evaluate the third column
        for (int i = 0; i < 3; i++) {
            if (gameGrid[i][2].getOwner() == Symbol.values()[0]) {
                scores[5]++;
            }
            if (gameGrid[i][2].getOwner() == Symbol.values()[1]) {
                scores[5]--;
            }
        }

        // evaluate the left-to-right diagonal
        for (int i = 0; i < 3; i++) {
            if (gameGrid[i][i].getOwner() == Symbol.values()[0]) {
                scores[6]++;
            }
            if (gameGrid[i][i].getOwner() == Symbol.values()[1]) {
                scores[6]--;
            }
        }

        // evaluate the right-to-left diagonal
        for (int i = 0; i < 3; i++) { // rows
            for (int j = 0; j < 3; j++) { // columns
                if (i + j == 2) {
                    if (gameGrid[i][j].getOwner() == Symbol.values()[0]) {
                        scores[7]++;
                    }
                    if (gameGrid[i][j].getOwner() == Symbol.values()[1]) {
                        scores[7]--;
                    }
                }
            }
        }

        return scores;
    }
    
    /**
     * Increments the number of turns.
     */
    public void incrementTurnsCounter() {
        turnsCounter++;
    }
    
    /**
     * Returns the number of turns since the start of the game.
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
     */
    public Symbol getUserSymbol() {
        return userSymbol;
    }
    
    /**
     * Returns true if someone has won the game. Otherwise, false.
     */
    public boolean getDidSomeoneWin() {
        return didSomeoneWin;
    }
}