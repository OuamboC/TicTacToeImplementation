public class GameBoard {
    private final char[][] grid; //2D array representing the game Board
    private final int rows; // Number of rows of the grid
    private final int cols; //Numbers of columns of the grid

    //Constructor to initialise the board of the game
    public GameBoard(int gameRows, int gameCols) {
        this.rows = gameRows;
        this.cols = gameCols;
        grid = new char[rows][cols];
        //Initialise the grid  with empty spaces
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                grid[i][j] = ' ';//empty spaces
            }
        }
    }

    //Method to print the current state of the grid
    public void printGrid() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                //Print out with a separator
                System.out.print(" | " + grid[i][j]);
            }
            //End of the row
            System.out.println(" |");
            //Print row separator
            /**
             * Each cell occupies 4 characters:
             *
             * Space (before the bar)
             *
             * Bar (|)
             *
             * Space (after the bar)
             *
             * Cell value (e.g., 'X' or 'O')
             *
             *
             * Separator length:
             *
             * For n columns, we want the separator to stretch across all these cells.
             *
             * For a 3-column example, I'd want enough dashes to span all cells, which is 3 columns * 4 characters = 12 characters.
             */
            System.out.println(new String(new char[cols * 4]).replace("\0", "-"));
        }
    }

    //Method to check if a move is valid
    public boolean isValidMove(int row, int col) {
        //Check if the position is within array and the cell is empty
        return row >= 0 && row < rows && col >= 0 && col < cols && grid[row][col] == ' ';
    }

    //method  to place a token on the board if the move is valid
    public void placeToken(int row, int col, char token) {
        if (isValidMove(row, col)) {
            //Place the token on the grid
            grid[row][col] = token;
        }
    }

    //Method to get the token at a specific position on the grid
    public char getToken(int row, int col) {
        //Return the token at the specifies position
        return grid[row][col];
    }
}
