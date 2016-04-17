public class TicTacToe {
    public static void main(String[] args) {        
        Controller controller = new Controller();

        while (!controller.isGameOver()) {
            try {
                Thread.sleep(250);
            } catch(InterruptedException ex) {
                Thread.currentThread().interrupt();
            }
        }
        
        controller.informOutcome();
    }    
}