import java.util.Scanner;

public class PlayerInterface {

  private static final boolean PEEK = true;
  private Scanner input;
  private Board gameBoard;
  
  /**
  * constructor - connects the user to the keyboard
  */
  public PlayerInterface() {
    input = new Scanner(System.in);
  }
  
  /**
  * runs the game
  */ 
  public void run() {
    System.out.println("Hi! Welcome to MineSweeper!");
    System.out.print("Would you like to play a game? (y/n): ");
    char response = input.nextLine().toLowerCase().charAt(0);
    while (response == 'y') {
      gameBoard = new Board();
      gameBoard.initializeBoard();
      gameBoard.placeMines();
      if (playGame())
        System.out.println("You win!");
      else
        System.out.println("Boom! You lose.");
      System.out.println("Thank you for playing MineSweeper."); 
      System.out.print("Would you like to play another game? (y/n): ");
      response = input.nextLine().toLowerCase().charAt(0);
    }
  }
  
  private boolean playGame() {
      boolean continueGame = true;
      while (continueGame) {
        System.out.println(gameBoard.formatBoard(!PEEK));
        peekOrNoPeek();
        continueGame = queryCell() && !gameWon();
      }
      return gameWon();
  }

  private void peekOrNoPeek() {
    System.out.print("Would you like to peek? (y/n): ");
    char response = input.nextLine().toLowerCase().charAt(0);
    if (response == 'y')
      System.out.println(gameBoard.formatBoard(PEEK));      
  }

  /* 
  * returns true if user makes correct guess, false otherwise
  */
  private boolean queryCell() {
    System.out.print("Please enter a row number: ");
    int row = input.nextInt();
    System.out.print("Please enter a column number: ");
    int column = input.nextInt();
    input.nextLine();
    System.out.print("Does row " + row + " and column " + column 
                        + " contain a mine? (y/n): ");
    char response = input.nextLine().toLowerCase().charAt(0);
    return gameBoard.checkForMine(row, column, response);
  }

  
  private boolean gameWon() {
    return gameBoard.getGuessedMines() == gameBoard.getNumberOfMines();
  }
}