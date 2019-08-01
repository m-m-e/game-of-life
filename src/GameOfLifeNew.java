import java.lang.Math;

public class GameOfLifeNew {

    public static void main(String[] args) throws InterruptedException {
        int n = 5;
        boolean[][] board = new boolean[n][n];

        //Random rnd = new Random();
        //rdn.nextBoolean();
        //change n in i to board.length and in j board[i].length
        //set number of times to print as an integer e.g. int defaultTimes = 500;
        //new function called 'createNewBoard'
        /*
        while (defaultTimes-- > 0) {
            board = playGame(board);
            printBoard(board);s
        }
        */
        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
                double rand = Math.random();
                if (rand <= 0.5){
                    board[i][j] = true;
                    System.out.print("X ");
                } else {
                    board[i][j] = false;
                    System.out.print("  ");
                }
            }
            System.out.println("");
        }
        boolean keepPlaying = true;
        for (int i = 0; i < 10 && keepPlaying; i++){
            board = playGame(board, n);
            printBoard(board, n, keepPlaying);
            checkBoard(board, n, keepPlaying);
            Thread.sleep(300);
        }

        // do...
        //playgame, printboard etc.
        // while (oldBoard == null || hasChanges(newBoard, oldBoard))
        //need currentBoard and oldBoard = null boolean[][]s
        /*
            !Arrays.deepEquals(currentBoard, oldBoard);
         */
    }

    public static boolean[][] playGame(boolean[][] board, int n){
        boolean[][] newBoard = new boolean[n][n];
            System.out.println("\nPlaying the game...");
            for (int i = 0; i < n; i++){
                for (int j = 0; j < n; j++){
                    /*new function for counting the neighbours => count living neighbours
                        let aliveNeighbours = 0;
                        for (int rowDiff = -1; rowDiff <= 1; rowdiff++){
                            for (int colDiff = -1; colDiff <= 1; coldiff++){
                                int row = currentRow + rowDiff;
                                int col = currentColumn + colDiff;

                                if (canAccess(board, row, col)){
                                    if (row != currentRow || col != currentColumn) OR this could be
                                    boolean isCurrentCell = row == currentRow && col == currentColumn
                                    {

                                    if (board[row][col]){
                                        aliveNeighbours++;
                                    }
                                }
                            }
                        }
                    */

                    /*
                    New function canAccess => receives matrix, i, j;
                        return i >=0 && j >=0 && i < matrix.length && j < matrix[i].length;
                     */
                    int count = 0;
                    for (int r = -1; r <=1; r++){
                        for (int c = -1; c <= 1; c++){
                            if ((i+r <0) ||
                                    (i+r > n-1) ||
                                    (j+c <0) ||
                                    (j+c > n-1)){
                                continue;
                            }
                            if (board[i+r][j+c] == true) {
                                count++;
                            }
                        }
                    }

                    /* instead of this logic...
                    boolean currentCellIsAlive = currentBoard[i][j]
                        if (currentCellIsAlive) {
                            newBoard[i][j] = (livingNeighboursCount == 2 || livingNeighboursCount == 3);
                        } else {
                            newBoard[i][j] = (livingNeighboursCount == 3);
                        }
                     */
                    if (board[i][j] == true) {
                        count--;
                    }
                    if (board[i][j] == true && count < 2){
                        newBoard[i][j] = false;
                    } else if (board[i][j] == true && (count == 2 || count == 3)){
                        newBoard[i][j] = true;
                    } else if (board[i][j] == true && count > 3){
                        newBoard[i][j] = false;
                    } else if (board[i][j] == false && count == 3){
                        newBoard[i][j] = true;
                    } else {
                        newBoard[i][j] = board[i][j];
                    }
                }
            }
        return newBoard;
    }

    //stops if all dead
    //stops if no changes

    public static boolean printBoard(boolean[][] board, int n, boolean keepPlaying){
        int aliveCount = 0;

        //Can use ternary operators!
        // System.out.print(board[i][j] ? 'X ' : '  ';

        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
                if (board[i][j] == true){
                    aliveCount++;
                    System.out.print("X ");
                } else {
                    System.out.print("  ");
                }
            }
            System.out.println("");
        }
        if (aliveCount == 0){
            keepPlaying = false;
        }
        return keepPlaying;
    }

    public static boolean checkBoard(boolean[][] board, int n, boolean keepPlaying){
        int changes = 0;
        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++) {
                /*if (board[i][j] != otherBoard[i][j]){
                return true;
                }*/
                if (j-1 >= 0 && board[j] != board[j-1]){
                    changes++;
                }
            }
        }
        System.out.println("changes: "+changes);
        if (changes > 0){
            return keepPlaying;
        } else {
            return !keepPlaying;
        }
    }
}
