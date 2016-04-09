public class TicTacToe {
    
    public static void main(String[] args) {
        View view = new View();
        Logic logic = new Logic(view);
        Controller controller = new Controller(logic, view);
    }
    
}