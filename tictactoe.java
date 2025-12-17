import java.util.Scanner;

public class TicTacToeGame {

    public static class Player {
        private String name;
        private char symbol;

        public Player(String name, char symbol) {
            this.name = name;
            this.symbol = symbol;
        }

        public String getName() {
            return name;
        }

        public char getSymbol() {
            return symbol;
        }
    }

    public static class Game {
        private char[][] board;
        private Player player1;
        private Player player2;
        private Player currentPlayer;
        private boolean isGameOver;

   
        public Game(Player player1, Player player2) {
            this.board = new char[3][3]; 
            this.player1 = player1;
            this.player2 = player2;
            this.currentPlayer = player1;
            this.isGameOver = false;

            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    board[i][j] = ' ';
                }
            }
        }

        public void displayBoard() {
            System.out.println("-------------");
            for (int i = 0; i < 3; i++) {
                System.out.print("| ");
                for (int j = 0; j < 3; j++) {
                    System.out.print(board[i][j] + " | ");
                }
                System.out.println();
                System.out.println("-------------");
            }
        }

        public void makeMove(int row, int col) {
            if (row >= 0 && row < 3 && col >= 0 && col < 3 && board[row][col] == ' ') {
                board[row][col] = currentPlayer.getSymbol();
            } else {
                System.out.println("Invalid move. Try again.");
            }
        }

        public boolean checkWin() {
     
            for (int i = 0; i < 3; i++) {
                if ((board[i][0] == currentPlayer.getSymbol() && board[i][1] == currentPlayer.getSymbol() && board[i][2] == currentPlayer.getSymbol()) ||
                    (board[0][i] == currentPlayer.getSymbol() && board[1][i] == currentPlayer.getSymbol() && board[2][i] == currentPlayer.getSymbol())) {
                    return true;
                }
            }

            if ((board[0][0] == currentPlayer.getSymbol() && board[1][1] == currentPlayer.getSymbol() && board[2][2] == currentPlayer.getSymbol()) ||
                (board[0][2] == currentPlayer.getSymbol() && board[1][1] == currentPlayer.getSymbol() && board[2][0] == currentPlayer.getSymbol())) {
                return true;
            }

            return false;
        }

        public boolean checkDraw() {
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (board[i][j] == ' ') {
                        return false; 
                    }
                }
            }
            return true; 
        }

        public void switchPlayer() {
            currentPlayer = (currentPlayer == player1) ? player2 : player1;
        }

        public void play() {
            Scanner scanner = new Scanner(System.in);

            while (!isGameOver) {
                displayBoard();
                System.out.println(currentPlayer.getName() + "'s turn (" + currentPlayer.getSymbol() + ")");
                System.out.print("Enter row (0, 1, or 2): ");
                int row = scanner.nextInt();
                System.out.print("Enter column (0, 1, or 2): ");
                int col = scanner.nextInt();

                makeMove(row, col);

                if (checkWin()) {
                    displayBoard();
                    System.out.println(currentPlayer.getName() + " wins!");
                    isGameOver = true;
                } else if (checkDraw()) {
                    displayBoard();
                    System.out.println("It's a draw!");
                    isGameOver = true;
                } else {
                    switchPlayer();
                }
            }

            scanner.close();
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter Player 1's name: ");
        String player1Name = scanner.nextLine();
        Player player1 = new Player(player1Name, 'X');

        System.out.print("Enter Player 2's name: ");
        String player2Name = scanner.nextLine();
        Player player2 = new Player(player2Name, 'O');

        Game game = new Game(player1, player2);
        game.play();

        scanner.close();
    }
}