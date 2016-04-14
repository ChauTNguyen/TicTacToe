public class TicTacToe {
    public static void main(String[] args) {
        Game game = new Game();
        View view = new View();
        Controller controller = new Controller(game, view);

        while (!game.isGameOver()) {
            try {
                Thread.sleep(250);
            } catch(InterruptedException ex) {
                Thread.currentThread().interrupt();
            }
        }
        
        controller.informOutcome();
    }    
}