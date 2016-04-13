public class TicTacToe {

    public static void main(String[] args) {
        Model model = new Model();
        View view = new View(model);
        Controller controller = new Controller(model, view);

        boolean run = true;
        while (run) {
            controller.updateGameState();
            if (view.isGameOver == true) {
                view.informOutcome();
                run = false;
            }
            
            // Slows down the program from running controller.updateGameState() too quickly
            try {
                Thread.sleep(250);
            } catch(InterruptedException ex) {
                Thread.currentThread().interrupt();
            }
        }
    }
    
}