import java.util.Scanner;

public class TicTacToe {

    private static final char X = 'X';
    private static final char O = 'O';
    private static final char BLANK = '-';

    private static char[][] board = new char[3][3];
    private static int turn = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Initialize the board
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = BLANK;
            }
        }

        // Play the game
        while (true) {
            // Display the board
            displayBoard();

            // Get the player's move
            int row = scanner.nextInt() - 1;
            int col = scanner.nextInt() - 1;

            // Place the player's mark on the board
            board[row][col] = turn == 0 ? X : O;

            // Check for a winner
            if (checkWinner()) {
                // Game over!
                System.out.println("Player " + turn + " wins!");
                break;
            }

            // Switch turns
            turn = 1 - turn;
        }
    }

    private static void displayBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j]);
            }
            System.out.println();
        }
    }

    private static boolean checkWinner() {
        // Check for a row win
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == board[i][1] && board[i][1] == board[i][2] && board[i][0] != BLANK) {
                return true;
            }
        }

        // Check for a column win
        for (int j = 0; j < 3; j++) {
            if (board[0][j] == board[1][j] && board[1][j] == board[2][j] && board[0][j] != BLANK) {
                return true;
            }
        }

        // Check for a diagonal win
        if (board[0][0] == board[1][1] && board[1][1] == board[2][2] && board[0][0] != BLANK) {
            return true;
        }

        // Check for a diagonal win
        if (board[2][0] == board[1][1] && board[1][1] == board[0][2] && board[2][0] != BLANK) {
            return true;
        }

        // No winner yet
        return false;
    }
}
