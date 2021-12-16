
import gameIF.*;

public class Map {
    public static void printMap(Game game) {

        char[][] board = new char[game.getHeight()][game.getWidth()];



        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[row].length; col++) {
                Entity ent = game.getEntityAt(col, row);
                if (ent == null) {
                    board[row][col] = ('.');
                } else {
                    board[row][col] = (ent.getCode());
                }
                System.out.print(board[row][col] + " ");
            }

            System.out.println();

        }


    }
}