public class TicTacToeImplementation {
    public static void main(String[] args) {
        GamePlayer player1 = new GamePlayer("Player 1", 'X');
        GamePlayer player2 = new GamePlayer("Player 2", 'O');

        GameLogic game = new GameLogic(new GamePlayer[]{player1, player2});

        game.playGame();
    }
}