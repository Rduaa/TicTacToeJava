import java.util.Scanner;

public class TicTacToe {
    private static final char [][] board = {{' ', ' ', ' '}, {' ', ' ', ' '}, {' ', ' ', ' '}};

    private static String player1Name, player2Name;
    private static char currentPlayer = 'X';
    public static void main(String[] args){

        getPlaersNames();

        while (true){
            printBoard();
            makeMove();
            if (isWinner()) {
                printBoard();
                System.out.println(playerName() +  " The Winner!");
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

        public static void getPlaersNames(){
        Scanner scanner = new Scanner(System.in);
            System.out.println("Hi TicTacToe Herro Enter Player 1 name: ");
            player1Name = scanner.nextLine();
            System.out.println("Hi TicTacToe Herro Enter Player 2 name: ");
            player2Name = scanner.nextLine();
        }

        private static String playerName() {
        return (currentPlayer == 'X' ) ?  player1Name : player2Name;
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
            System.out.print(playerName() + " Enter column number (0, 1, 2): ");
            row = scanner.nextInt();
            System.out.print(playerName() + " Enter column number (0, 1, 2): ");
            col = scanner.nextInt();
        } while (row < 0 || row >= 3 || col < 0 || col >= 3 || board[row][col] != ' ');
        board[row][col] = currentPlayer;
    }
// Switch player between 'X' and 'O'
    private static void switchPlayer() {
    currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
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
    return board[0][2] != ' ' && board[0][2] == board[1][1] && board[1][1] == board[2][0];
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
