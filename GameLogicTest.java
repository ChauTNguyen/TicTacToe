public class GameLogicTest {
    public static void main(String[] args) {
        /* Below are a bunch of test cases to help me design
         * and construct my Game clas.
         */
        Field testField = new Field();
        System.out.println(testField.getOwner());     // NONE? true
        
        Game game = new Game();
        System.out.println(game.getFieldOwner(1, 1)); // NONE? true
        System.out.println(game.getFieldOwner(0, 0)); // NONE? true
        
        // SETTERS
        game.setFieldOwner(Symbol.values()[0], 0, 0);
        System.out.println(game.getFieldOwner(0, 0)); // X?
        
        System.out.println();
        
        // Let's check the first row if X wins.
        game.setFieldOwner(Symbol.values()[0], 0, 1);
        game.setFieldOwner(Symbol.values()[0], 0, 2);
        
        game.printField();
        System.out.println("First row win? : " + game.isGameOver());
        
        game.setFieldOwner(Symbol.values()[2], 0, 1); // clear
        System.out.println();
        
        // Let's check the second row for a draw.
        game.setFieldOwner(Symbol.values()[0], 1, 0);
        game.setFieldOwner(Symbol.values()[0], 1, 1);
        game.setFieldOwner(Symbol.values()[1], 1, 2);
        
        game.printField();
        System.out.println("Second row win? : " + game.isGameOver());
        
        game.setFieldOwner(Symbol.values()[2], 1, 1); // clear
        System.out.println();
        
        // Let's check the third row if O wins.
        game.setFieldOwner(Symbol.values()[1], 2, 0);
        game.setFieldOwner(Symbol.values()[1], 2, 1);
        game.setFieldOwner(Symbol.values()[1], 2, 2);
        
        game.printField();
        System.out.println("Third row win? : " + game.isGameOver());     
        
        game.setFieldOwner(Symbol.values()[2], 2, 1);
        System.out.println();
        
        game.printField();
        System.out.println("Is game over:? : " + game.isGameOver());
        
        System.out.println();
        
        // Let's check the left to right diagonal.
        game.setFieldOwner(Symbol.values()[0], 1, 1);
        game.setFieldOwner(Symbol.values()[0], 2, 2);
                
        game.printField();
        System.out.println("Left to right diagonal win? : " + game.isGameOver());
    }
}