import java.util.Scanner;

public class TicTacToe {

    static char[][] board = new char[3][3];
    static char currentPlayer = 'X';

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        initializeBoard();

        System.out.println("🎮 Welcome to Java Tic Tac Toe!");
        printBoard();

        while (true) {
            System.out.print("Player " + currentPlayer + " - Enter row and column (1-3): ");
            int row = sc.nextInt() - 1;
            int col = sc.nextInt() - 1;

            if (isValidMove(row, col)) {
                board[row][col] = currentPlayer;
                printBoard();

                if (isWinner()) {
                    System.out.println("🏆 Player " + currentPlayer + " wins!");
                    break;
                } else if (isDraw()) {
                    System.out.println("🤝 It's a draw!");
                    break;
                }

                switchPlayer();
            } else {
                System.out.println("⛔ Invalid move. Try again.");
            }
        }

        sc.close();
    }

    // Initialize empty board with spaces
    public static void initializeBoard() {
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                board[i][j] = ' ';
    }

    // Print the current board
    public static void printBoard() {
        System.out.println("-------------");
        for (int i = 0; i < 3; i++) {
            System.out.print("| ");
            for (int j = 0; j < 3; j++)
                System.out.print(board[i][j] + " | ");
            System.out.println("\n-------------");
        }
    }

    // Check for valid move
    public static boolean isValidMove(int row, int col) {
        return row >= 0 && row < 3 &&
               col >= 0 && col < 3 &&
               board[row][col] == ' ';
    }

    // Switch player turn
    public static void switchPlayer() {
        currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
    }

    // Check if current player won
    public static boolean isWinner() {
        for (int i = 0; i < 3; i++) {
            // Rows and columns
            if ((board[i][0] == currentPlayer &&
                 board[i][1] == currentPlayer &&
                 board[i][2] == currentPlayer) ||
                (board[0][i] == currentPlayer &&
                 board[1][i] == currentPlayer &&
                 board[2][i] == currentPlayer)) {
                return true;
            }
        }
        // Diagonals
        return (board[0][0] == currentPlayer &&
                board[1][1] == currentPlayer &&
                board[2][2] == currentPlayer) ||
               (board[0][2] == currentPlayer &&
                board[1][1] == currentPlayer &&
                board[2][0] == currentPlayer);
    }

    // Check for draw
    public static boolean isDraw() {
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                if (board[i][j] == ' ')
                    return false;
        return true;
    }
}
