import javax.swing.JOptionPane;

public class TicTacToe {

    public static void main(String[] args) {
        Model model = new Model();
        View view = new View(model);
        Controller controller = new Controller(model, view);

        boolean run = true;
        while (run) {
            view.updateGameState();
            if (view.gameEnd == true) {
                view.endGame();
                JOptionPane.showMessageDialog(null, "Player " + model.userSymbol + " has won!");
                run = false;
            }
            try {
                Thread.sleep(250);
            } catch(InterruptedException ex) {
                Thread.currentThread().interrupt();
            }
        }
    }
    
}