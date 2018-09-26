/**
 * @author - Jeremy Brothers
 * @version - 9/10/2018
 * Title - Project1 Board
 * Description - This class generates a 2d array of cells. Each cell has a char used to daw to the terminal
 *               and a boolean that determines if a tile has been stepped on.
 */

import java.util.Random;

public class Board {
    /**
     * This cell class is used to simulate a room.
     */
    private static class Cell {
        private final char BOARDLINE;
        private boolean tileTouched;
        
        /**
         * This constructor defines the char used to 'draw' the tiles in 
         * a room. Also, sets the tileTouched to false.
         */
        public Cell() {
            BOARDLINE = '-';
            tileTouched = false;
        }

        /**
         * sets the tileTouched member to true.
         */
        public void TileTouched() { tileTouched = true; }

        /**
         * Returns the tileTouched member
         * @return (boolean) - tileTouched
         */
        public boolean GetTileTouched() { return tileTouched; }
    }

    private static final int DEFAULT_ROWS = 8;
    private static final int DEFAULT_COLUMS = 8;
    private Cell[][] board;

    /**
     * Initializes a 2d array of Cells using rows and columns as the size of the 2d array.
     * @param rows
     * @param columns
     */
    public Board( int rows, int columns ) {
        board = new Cell[ rows ][ columns ];
    }

    /**
     * if a Board is created without rows and columns, the default sized are used.
     */
    public Board() {
        this(DEFAULT_ROWS, DEFAULT_COLUMS);
    }

    /**
     * Initialses the each element in the board array to a new Cell object.
     */
    public void initializeBoard() {
        for (int i=0; i<board.length; i++)
            for (int j=0; j<board[i].length; j++)
                board[i][j] = new Cell();
    }

    /**
     * Takes an x/y coordinate and sets the tileTouched of that cell to true
     * @param x_coord - corrisponds to board[x]
     * @param y_coord - corrisponds to board[x][y]
     */
    public void setTileTouched(int x_coord, int y_coord) {
        if(!board[x_coord][y_coord].GetTileTouched())
            board[x_coord][y_coord].TileTouched();
    }

    /**
     * Looks through each element of the board array and returns true if 
     * every cell's tileTouched is true
     * @return allTouched (boolean) - a boolean that is only true when every element 
     *         in the board array's tileTouched is true.
     */
    public boolean AllTilesTouched() {
        boolean allTouched = true;
        for( int x = 0; x < board.length; x++ ) {
            for( int y = 0; y < board[x].length; y++ ) {
                allTouched = allTouched && board[x][y].GetTileTouched();
            }
        }
        return allTouched;
    }

    /**
     * Formats a room to draw the tiles in the room based on the size of the array
     * @return sb (stringBuilder) - a string builder object that stores the room as a single string.
     */
    public String FormatBoard() {
        StringBuilder sb = new StringBuilder();
        for( int x = 0; x < board.length; x++ ) {
            for( int y = 0; y < board[x].length; y++ ) {
                sb.append( board[x][y].BOARDLINE + " " );
            }
            sb.append( "\n" );
        }
        return sb.toString();
    }
}