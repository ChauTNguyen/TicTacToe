package chautnguyen.com.github.tictactoe.controller;

import chautnguyen.com.github.tictactoe.model.Game;
import chautnguyen.com.github.tictactoe.view.View;
import chautnguyen.com.github.tictactoe.view.ViewInterface;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class Controller implements ActionListener {
    private Game game;
    private ViewInterface view;
    
    /**
     * Overloaded constructor. Initializes the game and view, and
     * adds the action listeners to the buttons in view.
     * 
     * @param   an instance of the Game class.
     * @param   an instance of the View class.
     */
    public Controller() {
        this.game = new Game();
        this.view = new View();
        addActionListeners();
    }

    /**
     * Adds an action listener to every button.
     */
    private void addActionListeners() {
        for (int i = 0; i < ((View)view).getNumberOfButtons(); i++) {
            ((View)view).getButton(i).addActionListener(this);
        }
    }

    /**
     * Increments the number of moves since the start of the game, and
     * sets the user symbol. It then finds out what x and y coordinates that button
     * corresponds to in the Game object.
     * Examples: button[0] would be Field[0][0]. button [1] would be Field[0][1].
     * button[5] would be Field[1][2].
     * 
     * It then sets the owner of the field in the Game object, and modifies the View buttons.
     * 
     * @param e     the action performed. In this game, it would be a mouse click.
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if (!game.isGameOver()) {
            game.incTurnCounterAndSetUserSymbol();

            // The indices of the View JButton array is 0-8 while the
            // indices of the Game Field array
            // is a 2d 3x3 array, so I have to convert the index
            // into x- and y- coordinates.
            int indexOfViewButton = getJButtonIndex((JButton) e.getSource());

            game.setFieldOwner(game.getUserSymbol(),
                               getX(indexOfViewButton),  // row coordinate of 2d array
                               getY(indexOfViewButton)); // col coordinate of 2d array
            view.updateBoard(game.getUserSymbol(), (JButton) e.getSource());
        }
    }

    /**
     * Returns the index of the current JButton.
     * 
     * @param button    the button that was clicked.
     * @return      the [0-8] index of the JButton clicked.
     */
    private int getJButtonIndex(JButton button) {
        int buttonIndex = 0;
        for (int i = 0; i < 9; i++) {
            if (button == ((View)view).getButton(i)) {
                buttonIndex = i;
            }
        }
        return buttonIndex;
    }

    /**
     * Returns the x-coordinate that corresponds to the index.
     * 
     * @param index     the index of of the JButton
     * @return      the x-coordinate of the 2d array that corresponds to the [0-8] index.
     */
    private int getX(int index) {
        switch (index) {
            case 0:
            case 1:
            case 2: return 0;
            case 3:
            case 4:
            case 5: return 1;
        }
        return 2;
    }

    /**
     * Returns the y-coordinate that corresponds to the index.
     * 
     * @param index      the index of the JButton
     * @return      the y-coordinate of the 2d array that corresponds to the [0-8] index.
     */
    private int getY(int index) {
        switch (index) {
            case 0:
            case 3:
            case 6: return 0;
            case 1:
            case 4:
            case 7: return 1;
        }
        return 2;
    }

    /**
     * Informs the user of the outcome of the game.
     */
    public void informOutcome() {
        if (game.getDidSomeoneWin()) {
            view.informWin(game.getUserSymbol());
        } else {
            view.informTie();
        }
    }

    /**
     * Calls the isGameOver function in the Game class.
     * 
     * @return      returns true if game is over. Returns false if otherwise.
     */
    public boolean isGameOver() {
        return game.isGameOver();
    }
}