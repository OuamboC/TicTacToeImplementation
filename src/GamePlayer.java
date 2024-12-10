import java.util.Scanner;

public class GamePlayer {
    private String name; //Name of the player
    private char token; //Token for the player ('O' OR 'X')

    //Constructor to initialise the player
    public GamePlayer(String gameName, char gameToken) {
        this.name = gameName;
        this.token = gameToken;
    }

    //Method to get the name of the player
    public String getName() {
        return this.name;
    }

    //Method to get the token of the player
    public char getToken() {
        return this.token;
    }

    //Method to allow the player to make a move

    public int[] makeMove() {
        Scanner scanner = new Scanner(System.in);
        System.out.println(name + ",enter your move as two numbers separated by a space (row col)." +
                " Example: 1 1 for the second row and second column: ");
        int row = scanner.nextInt();
        int col = scanner.nextInt();
        return new int[]{row, col};
    }

}
