import java.util.Scanner;

public class TicTacToe {
    private static char [][] board = {{' ', ' ', ' '}, {' ', ' ', ' '}, {' ', ' ', ' '}};
    private static char Player = 'X';
    public static void main(String[] args){
        while (true){
            printBoard();
            makeMove();
            if (isWinner()) {
                printBoard();
                System.out.println("Player " + Player + " The Winner!");
                break;
            }
            if (isBoardFull()) {
                printBoard();
                System.out.println("Draw!");
                break;
            }
            switchPlayer();
        }

    }

  // Output of the playing field
        private static void printBoard() {
        System.out.println("  0 1 2");
            for (int i = 0; i < 3; i++) {
                System.out.print(i + " ");
                for (int j = 0; j < 3; j++) {
                    System.out.print(board[i][j]);
                    if (j < 2) {
                        System.out.print("|");
                    }
                }
                System.out.println();
                if (i < 2) {
                    System.out.println("  -----");
                }
            }
            System.out.println();
    }
    // player's move
    private static void makeMove() {
        Scanner scanner = new Scanner(System.in);
        int row, col;
        do {
            System.out.print("Player " + Player + ", Enter column number (0, 1, 2): ");
            row = scanner.nextInt();
            System.out.print("Player " + Player + ", Enter column number (0, 1, 2): ");
            col = scanner.nextInt();
        } while (row < 0 || row >= 3 || col < 0 || col >= 3 || board[row][col] != ' ');
        board[row][col] = Player;
    }
// Switch player between 'X' and 'O'
    private static void switchPlayer() {
    Player = (Player == 'X') ? 'O' : 'X';
}
// Who win
private static boolean isWinner() {
    for (int i = 0; i < 3; i++) {
        if (board[i][0] != ' ' && board[i][0] == board[i][1] && board[i][1] == board[i][2]) {
            return true;
        }
        if (board[0][i] != ' ' && board[0][i] == board[1][i] && board[1][i] == board[2][i]) {
            return true;
        }
    }
    if (board[0][0] != ' ' && board[0][0] == board[1][1] && board[1][1] == board[2][2]) {
        return true;
    }
    if (board[0][2] != ' ' && board[0][2] == board[1][1] && board[1][1] == board[2][0]) {
        return true;
    }
    return false;
}
// Checking for a draw
    private static boolean isBoardFull() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == ' ') {
                    return false;
                }
            }
        }
        return true;
    }
}
