import java.lang.Math;
import java.util.Arrays;

public class GameOfLifeNew {

    public static int counter;
    public static int findChar(int[][] board, int i, int j){
        return board[i][j];
    }

    public static void playGame(int[][] board, int n){
        if (counter < 20) {
            System.out.println("\nPlaying the game...");
            int[][] newBoard = new int[n][n];
            for (int i = 0; i < n; i++){
                for (int j = 0; j < n; j++){
                    int count = 0;
                    for (int r = -1; r <=1; r++){
                        for (int c = -1; c <= 1; c++){
                            if ((i+r <0) ||
                                    (i+r > n-1) ||
                                    (j+c <0) ||
                                    (j+c > n-1)){
                                continue;
                            }
                            count += board[i+r][j+c];
                        }
                    }
                    count -= board[i][j];
                    if (board[i][j] == 1 && count < 2){
                        newBoard[i][j] = 0;
                    } else if (board[i][j] == 1 && (count == 2 || count == 3)){
                        newBoard[i][j] = 1;
                    } else if (board[i][j] == 1 && count > 3){
                        newBoard[i][j] = 0;
                    } else if (board[i][j] == 0 && count == 3){
                        newBoard[i][j] = 1;
                    } else {
                        newBoard[i][j] = board[i][j];
                    }
                }
            }
            printBoard(newBoard, n);
            counter++;
            playGame(newBoard, n);
        }
    }

    public static void printBoard(int[][] board, int n){
        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
                if (board[i][j] == 1){
                    System.out.print("X ");
                } else {
                    System.out.print("O ");
                }
            }
            System.out.println("");
        }
    }

    public static void main(String[] args) {
        int n = 10;
        int[][] board = new int[n][n];

        int min = 1;
        int max = 100;
        int range = max-min + 1;

        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
                int rand = (int)(Math.random() * range) + min;
                if (rand % 2 == 0){
                    board[i][j] = 1;
                    System.out.print("X ");
                } else {
                    board[i][j] = 0;
                    System.out.print("O ");
                }
            }
            System.out.println("");
        }
        playGame(board, n);
    }
}
