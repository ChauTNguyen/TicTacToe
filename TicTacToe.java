public class TicTacToe {

    public static void main(String[] args) {
        View view = new View();
        Logic logic = new Logic(view);
        Controller controller = new Controller(logic, view);

        boolean run = true;
        while (run) {
            logic.updateGameState();
            if (logic.gameEnd == true) {
                view.endGame();
                run = false;
            }
            System.out.println(logic.gameEnd);
            try {
                Thread.sleep(500);
            } catch(InterruptedException ex) {
                Thread.currentThread().interrupt();
            }
        }
    }
    
}