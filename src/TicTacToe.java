import java.util.InputMismatchException;
import java.util.Scanner;

public class TicTacToe {
    private static char[][] board = {{' ', ' ', ' '}, {' ', ' ', ' '}, {' ', ' ', ' '}};

    private static String player1Name, player2Name;
    private static char currentPlayer = 'X';

    public static void main(String[] args) {

        getPlayersNames();
        initializeBoard();


        while (true) {
            printBoard();
            makeMove();
            if (isWinner()) {
                printBoard();
                System.out.println(playerName() + " The Winner!");
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


    public static void getPlayersNames() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Hi TicTacToe Herro Enter Player 1 name: ");
        player1Name = scanner.nextLine();
        System.out.println("Hi TicTacToe Herro Enter Player 2 name: ");
        player2Name = scanner.nextLine();
    }

    private static String playerName() {
        return (currentPlayer == 'X') ? player1Name : player2Name;
    }

    private static void initializeBoard() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the dimension of Board (e.g., 3 for 3x3): ");
        int dimension;

        while (true) {
            try {
                dimension = scanner.nextInt();
                if (dimension < 3) {
                    System.out.println("Dimension should be at least 3. Please enter again: ");
                } else {
                    break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid integer: ");
                scanner.next();
            }
        }


        board = new char[dimension][dimension];
        for (int i = 0; i < dimension; i++) {
            for (int j = 0; j < dimension; j++) {
                board[i][j] = ' ';
            }
        }
    }

    // Output of the playing field
    private static void printBoard() {
        System.out.print("  ");
        for (int i = 0; i < board.length; i++) {
            System.out.print(i + " ");
        }
        System.out.println();

        for (int i = 0; i < board.length; i++) {
            System.out.print(i + " ");
            for (int j = 0; j < board[i].length; j++) {
                System.out.print(board[i][j]);
                if (j < board[i].length - 1) {
                    System.out.print("|");
                }
            }
            System.out.println();
            if (i < board.length - 1) {
                for (int k = 0; k < board[i].length; k++) {
                    System.out.print("--");
                    if (k < board[i].length - 1) {
                        System.out.print("|");
                    }
                }
                System.out.println();
            }
        }
        System.out.println();
    }

    // player's move
    private static void makeMove() {
        Scanner scanner = new Scanner(System.in);
        int row;
        int col;
        while (true) {
            try {
                System.out.print(playerName() + ", Enter row number (0, 1, ..., " + (board.length - 1) + "): ");
                row = scanner.nextInt();
                System.out.print(playerName() + ", Enter column number (0, 1, ..., " + (board.length - 1) + "): ");
                col = scanner.nextInt();

                if (row < 0 || row >= board.length || col < 0 || col >= board.length || board[row][col] != ' ') {
                    System.out.println("Invalid move. Please enter valid coordinates.");
                } else {
                    break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter valid integers.");
                scanner.next();
            }
        }
        board[row][col] = currentPlayer;
    }

    // Switch player between 'X' and 'O'
    private static void switchPlayer() {
        currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
    }

    // Who win
    private static boolean isWinner() {
        for (int i = 0; i < board.length; i++) {
            if (board[i][0] != ' ' && checkRow(i) || board[0][i] != ' ' && checkColumn(i)) {
                return true;
            }
        }

        return board[0][0] != ' ' && checkDiagonal(0, 1) || board[0][board.length - 1] != ' ' && checkDiagonal(board.length - 1, -1);
    }

    private static boolean checkRow(int row) {
        for (int i = 1; i < board.length; i++) {
            if (board[row][i] != board[row][i - 1]) {
                return false;
            }
        }
        return true;
    }

    private static boolean checkColumn(int col) {
        for (int i = 1; i < board.length; i++) {
            if (board[i][col] != board[i - 1][col]) {
                return false;
            }
        }
        return true;
    }

    private static boolean checkDiagonal(int startCol, int colIncrement) {
        char startCell = board[0][startCol];
        for (int i = 1; i < board.length; i++) {
            int col = startCol + i * colIncrement;
            if (board[i][col] != startCell) {
                return false;
            }
        }
        return true;
    }

    private static boolean isBoardFull() {
        for (char[] chars : board) {
            for (char aChar : chars) {
                if (aChar == ' ') {
                    return false;
                }
            }
        }
        return true;
    }
}

