import java.util.Scanner;

public class PlayerInterface {

  private static final boolean PEEK = true;
  private static final int LARGESTSIZE = 20;
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
      initializeGame();
      if (playGame())
        System.out.println("You win!");
      else {
        System.out.println("Boom! You lose.");
        System.out.println(gameBoard.formatBoard(PEEK));
      }
      System.out.println("Thank you for playing MineSweeper."); 
      System.out.print("Would you like to play another game? (y/n): ");
      response = input.nextLine().toLowerCase().charAt(0);
    }
  }

  private void initializeGame() {
      int boardSize = getBoardSize();
      int numberOfMines = getNumberOfMines(boardSize);
      gameBoard = new Board(boardSize, numberOfMines);
      gameBoard.initializeBoard();
      gameBoard.placeMines();
  }

  private int getBoardSize() {
    String prompt = "Enter a board size: ";
    String error = "Invalid board size.";
    return getANumber(prompt, LARGESTSIZE, error);
  }
  
  private int getNumberOfMines(int boardSize) {
    String prompt = "Enter the number of mines: ";
    String error = "Invalid number of mines.";
    return getANumber(prompt, boardSize*boardSize, error);
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
    int row = getRowNumber();
    int column = getColumnNumber();
    System.out.print("Does row " + row + " and column " + column 
                        + " contain a mine? (y/n): ");
    char response = input.nextLine().toLowerCase().charAt(0);
    return gameBoard.checkForMine(row, column, response);
  }

  private int getRowNumber() {
    String prompt = "Please enter a row number: ";
    String error = "Invalid row number.";
    return getANumber(prompt, gameBoard.size(), error);
  }

  private int getColumnNumber() {
    String prompt = "Please enter a column number: ";
    String error = "Invalid column number.";
    return getANumber(prompt, gameBoard.size(), error);
  }

  private int getANumber(String prompt, int maxSize, String error) {
    int size = 0;
    System.out.print(prompt);
    String entry = input.nextLine().trim();
    if (isNumber(entry)) size = Integer.parseInt(entry);
    while (size < 1 || size > maxSize) {
      System.out.println(error);
      System.out.print(prompt);
      entry = input.nextLine().trim();
      if (isNumber(entry)) size = Integer.parseInt(entry);
    }
    return size;
  }

  private boolean isNumber(String item) {
    for (int i=0; i<item.length(); i++)
      if (!Character.isDigit(item.charAt(i)))
        return false;
    return true;
  }

  private boolean gameWon() {
    return gameBoard.getGuessedMines() == gameBoard.getNumberOfMines();
  }
}