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
      int boardSize = getBoardSize();
      int numberOfMines = getNumberOfMines(boardSize);
      gameBoard = new Board(boardSize, numberOfMines);
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

  private int getBoardSize() {
    int size = 0;
    System.out.println("What size board would you like?");
    System.out.print("Enter a number from 1 to " + LARGESTSIZE + ": ");
    String entry = input.nextLine().trim();
    if (isNumber(entry)) size = Integer.parseInt(entry);
    while (size < 1 || size > LARGESTSIZE) {
      System.out.println("Invalid board size.");
      System.out.print("Enter a number from 1 to " + LARGESTSIZE + ": ");
      entry = input.nextLine().trim();
      if (isNumber(entry)) size = Integer.parseInt(entry);
    }
    return size;
  }
  
  private int getNumberOfMines(int boardSize) {
    int size = 0;
    System.out.print("Enter the number of mines: ");
    String entry = input.nextLine().trim();
    if (isNumber(entry)) size = Integer.parseInt(entry);
    while (size < 1 || size > boardSize * boardSize) {
      System.out.println("Invalid number of mines.");
      System.out.print("Enter the number of mines: ");
      entry = input.nextLine().trim();
      if (isNumber(entry)) size = Integer.parseInt(entry);
    }
    return size;
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
    int row = 0;
    System.out.print("Please enter a row number: ");
    String entry = input.nextLine().trim();
    if (isNumber(entry)) row = Integer.parseInt(entry);
    while (row < 1 || row > gameBoard.size()) {
      System.out.println("Invalid row number.");
      System.out.print("Please enter a row number: ");
      entry = input.nextLine().trim();
      if (isNumber(entry)) row = Integer.parseInt(entry);
    }
    return row;
  }

  private int getColumnNumber() {
    int column = 0;
    System.out.print("Please enter a column number: ");
    String entry = input.nextLine().trim();
    if (isNumber(entry)) column = Integer.parseInt(entry);
    while (column < 1 || column > gameBoard.size()) {
      System.out.println("Invalid column number.");
      System.out.print("Please enter a column number: ");
      entry = input.nextLine().trim();
      if (isNumber(entry)) column = Integer.parseInt(entry);
    }
    return column;
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