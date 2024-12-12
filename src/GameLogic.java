public class GameLogic {
    private final GameBoard board ; // instance class for GameBoard
    private final  GamePlayer[] players; // array representing the players
    private int currentPlayerIndex; // Index for players

    //Constructor to initialise the players and game board
    public GameLogic(GamePlayer[] gamePlayers){
        this.players = gamePlayers;
        this.board = new GameBoard(3,3);
        this.currentPlayerIndex = 0;
    }
    //Method to switch players
    public void switchPlayer(){
        if(currentPlayerIndex == 0) {
            currentPlayerIndex = 1;
        }else {
            currentPlayerIndex = 0;
        }
    }
    //Method to check if there is a winner
    public boolean checkWinner(int row, int col){
        //Get current player's token
        char token = players[currentPlayerIndex].getToken();
        //Check Horizontal Line
        /**
         * Start Row : row ( This is the starting row for the check . It's the row where the last token was placed)
         * startCol :0 ( This is the starting column for the check. Using 0 means the check will start at the beginning of the row)
         * StepRow : 0 (This indicates the row step for each iteration. Using 0 means the check will not move up or down , so it remains  in the same row)
         * StepCol: 1 ( This indicates the column step for each iteration .Using 1 means the check will move right by one column each time , so checking horizontally)
         * token: This is the token being checked (either 'x' or 'O')
         */
        if (checkLine(row,0,0,1,token)){
            return true;
        }
        // Check Vertically
        /**
         * Start Row: 0 (The check starts at the first row (index 0))
         * startCol: col (The check starts at the column where the token was placed.)
         * stepRow: 1 (Each iteration moves one step down the rows)
         * stepCol: 0 (The column index remains the same so checking vertically)
         * token: This is the token being checked (either 'x' or 'O')
         */
        if (checkLine(0, col, 1, 0, token)) {
            return true;
        }
        // Check Diagonally (Top-left to bottom-right)
        /**
         * Start Row: 0 (The check starts at the first row (index 0))
         * startCol: 0 (The check starts at the first column (index 0))
         * stepRow: 1 (Each iteration moves one step down the rows)
         * stepCol: 1 (Each iteration moves one step to the right)
         * token: This is the token being checked (either 'x' or '0')
         */
        if (checkLine(0, 0, 1, 1, token)) {
            return true;
        }
        /**
         * Start Row: 0 (The check starts at the first row (index 0))
         * startCol: 2 (The check starts at the last column of the grid (index 2) for a 3x3 grid)
         * stepRow: 1 (Each iteration moves one step down the rows) * stepCol: -1 (Each iteration moves one step to the left)
         * token: This is the token being checked (either 'O' or 'X')
         */
        // Check Diagonally (Top-right to bottom-left)
        if (checkLine(0, 2, 1, -1, token)) {
            return true;
        }
        //No winner found
        return false;
    }
    //Method to check if there is a winner
    private boolean checkLine( int startRow, int startCol, int stepRow, int stepCol, char token){
        //Initialise count to track consecutive tokens
        int count = 0 ;
        for( int i = 0; i < 3 ;i++){
            //Calculate the current row and column based on the start position and step values
            int row = startRow +i *stepRow;
            int col = startCol +i * stepCol;
            //check if within bounds and if the token are the same
            if (row < 3 && col < 3 && board.getToken(row,col) == token){
                count++;
                //if there are 3 consecutive matching tokens , return true indicating a win
                if(count == 3) {
                    return true;
                }
            }else {
                //Reset count if the token doesn't match
                count = 0;
            }
        }
        //Return false if no winning condition is met
        return false;
    }
    //Method to allow the players to play the game
    public void playGame(){
        //Welcome messages
        System.out.println("Welcome to Tic-Tac-Toe (also known as Noughts and Crosses) on a 3x3 grid!");
        System.out.println("The rules are basic:");
        System.out.println("\nPlayers: The game is for two players. One player is 'X' and the other is 'O'.");
        System.out.println("\nGoal: The main objective is to be the first player to get three of their tokens (either 'X' or 'O') in a row, column, or diagonal.");
        System.out.println("\nGame Play:");
        System.out.println("Players take turns to place their mark in an empty cell of the 3x3 grid.");
        System.out.println("'X' typically goes first, though this can be decided differently based on mutual agreement.");
        System.out.println("\nHow to Win: \nA player wins by placing three of their tokens in a row, column, or diagonal.");
        System.out.println(" - Row: Three consecutive marks horizontally.");
        System.out.println(" - Column: Three consecutive marks vertically.");
        System.out.println(" - Diagonal: Three consecutive marks diagonally.");
        System.out.println("\nGoodLuck!!!!!");

        //  Main game loop
        while (true) {
            //Print the current state of the game Board
            board.printGrid();
            //Get the current player's move
            int [] move = players[currentPlayerIndex].makeMove();
            int row = move[0]; // First element representing the row
            int col = move [1]; // Second element representing the column

            //Validate and place the token if valid
            if ( board.isValidMove(row,col)) {
                board.placeToken(row, col , players[currentPlayerIndex].getToken());

                //Check for a winner after the move
                if(checkWinner(row, col)) {
                    //Print the Board to show the final state
                    board.printGrid();
                    System.out.println("Player: " + players[currentPlayerIndex].getName() + " Wins!!!!!!");
                    //Exit the game loop if there is a winner
                    break;
                }
                //Switch to next Player
                switchPlayer();
            }else{
                //Inform the player of an invalid move and prompt them to ty again
                System.out.println("Invalid move.Try again");
            }
        }
    }

}
