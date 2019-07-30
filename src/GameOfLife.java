import java.lang.Math;
import java.util.Arrays;

public class GameOfLife {

    public static char findChar(char[][] board, int i, int j){
        return board[i][j];
    }

    public static void playGame(char[][] board, int n){
        System.out.println("Playing the game...");
        int count = 0;
        char[] neighbours = new char[8];
        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){

                boolean canNW = (i-1 >= 0 && j-1 >= 0);
                boolean canN = (i-1 >= 0);
                boolean canNE = (i-1 >= 0 && j+1 < n);
                boolean canW = (j-1 >= 0);
                boolean canE = (j+1 < n);
                boolean canSW = (i+1 < n && j-1 >= 0);
                boolean canS = (i+1 < n);
                boolean canSE = (i+1 < n && j+1 < n);

                if (canNW){
                    char NW = findChar(board, (i-1),(j-1));
                    neighbours[0] = NW;
                }
                if (canN){
                    char N = findChar(board, (i-1),j);
                    neighbours[1] = N;
                }
                if (canNE){
                    char NE = findChar(board, (i-1),(j+1));
                    neighbours[2] = NE;
                }
                if (canW){
                    char W = findChar(board, i,(j-1));
                    neighbours[3] = W;
                }
                if (canE){
                    char E = findChar(board, i,(j+1));
                    neighbours[4] = E;
                }
                if (canSW){
                    char SW = findChar(board, (i+1),(j-1));
                    neighbours[5] = SW;
                }
                if (canS){
                    char S = findChar(board, (i+1),j);
                    neighbours[6] = S;
                }
                if (canSE){
                    char SE = findChar(board, (i+1),(j+1));
                    neighbours[7] = SE;
                }

                System.out.println(Arrays.toString(neighbours));
                //System.out.print(board[i][j]+" ");
            }
            //System.out.println("");
        }
    }

    public static void main(String[] args) {
        int n = 5;
        char[][] board = new char[n][n];

        int min = 1;
        int max = 100;
        int range = max-min + 1;

        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
                int rand = (int)(Math.random() * range) + min;
                if (rand % 2 == 0){
                    board[i][j] = 'X';
                    System.out.print(board[i][j]+" ");
                } else {
                    board[i][j] = 'O';
                    System.out.print(board[i][j]+" ");
                }
            }
            System.out.println("");
        }
    playGame(board, n);
    }
}
