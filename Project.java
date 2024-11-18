import java.util.Scanner;

public class Project {
    static char[][] board = {
        {'1', '2', '3'},
        {'4', '5', '6'},
        {'7', '8', '9'}
    };
    
    static char currentPlayer = 'X';
    
    public static void main(String[] args) {
        int moves = 0;
        boolean isWinner = false;

        while (moves < 9 && !isWinner) {
            printBoard();
            playerMove();
            moves++;
            isWinner = checkWinner();
            if (!isWinner) {
                currentPlayer = (currentPlayer == 'X') ? 'O' : 'X'; // Switch player
            }
        }

        printBoard();
        if (isWinner) {
            System.out.println("Player " + currentPlayer + " wins!");
        } else {
            System.out.println("It's a draw!");
        }
    }

    public static void printBoard() {
        System.out.println("Current Board:");
        for (char[] row : board) {
            for (char cell : row) {
                System.out.print(cell + " ");
            }
            System.out.println();
        }
    }

    public static void playerMove() {
        Scanner scanner = new Scanner(System.in);
        int move;
        
        while (true) {
            System.out.println("Player " + currentPlayer + ", enter your move (1-9): ");
            move = scanner.nextInt();
            
            if (move < 1 || move > 9) {
                System.out.println("Invalid move! Please enter a number between 1 and 9.");
                continue;
            }
            
            int row = (move - 1) / 3;
            int col = (move - 1) % 3;
            
            if (board[row][col] != 'X' && board[row][col] != 'O') {
                board[row][col] = currentPlayer;
                break;
            } else {
                System.out.println("Cell already taken! Choose another.");
            }
        }
    }

    public static boolean checkWinner() {
        // Check rows, columns, and diagonals for a win
        for (int i = 0; i < 3; i++) {
            if ((board[i][0] == currentPlayer && board[i][1] == currentPlayer && board[i][2] == currentPlayer) ||
                (board[0][i] == currentPlayer && board[1][i] == currentPlayer && board[2][i] == currentPlayer)) {
                return true;
            }
        }
        
        // Check diagonals
        if ((board[0][0] == currentPlayer && board[1][1] == currentPlayer && board[2][2] == currentPlayer) ||
            (board[0][2] == currentPlayer && board[1][1] == currentPlayer && board[2][0] == currentPlayer)) {
            return true;
        }
        
        return false;
    }
}