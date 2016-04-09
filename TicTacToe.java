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
                run = false;
            }
            System.out.println(view.gameEnd);
            try {
                Thread.sleep(500);
            } catch(InterruptedException ex) {
                Thread.currentThread().interrupt();
            }
        }
    }
    
}