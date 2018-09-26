/**
 * @author - Jeremy Brothers
 * @version - 9/10/2018
 * Title - Project1 RandomWalk
 * Description - This class takes a width and height and generates a 2d array.
 *               A virtual bug is placed in a tile based on RNG.
 *               Finally, the number of steps to touch every tile in the array. 
 */

import java.util.Random;

public class RandomWalk {
    private Board room = null;
    private int height = 0;
    private int width = 0;
    private int stepsTaken = 0;

    /**
     * Constructor to initialize the classes width and height and the room 2d array.
     * @param height - the number of rows in the 2d array
     * @param width = the number of columns in the 2s array
     */
    public RandomWalk(int height, int width) {
        this.height = height;
        this.width = width;

        room = new Board(height, width);
    }

    /**
     * Runs the simulation
     */
    public void RunBug() {
        room.initializeBoard();
        placeBugInRoom();
        System.out.print(room.FormatBoard());
    }

    /**
     * Uses the random class to generate a number no greater than the width - 1 and
     * height - 1. This ensures that they'll never generate a number outside the array bounds.
     */
    private void placeBugInRoom() {
        Random gen = new Random();
        int x_coordinate = gen.nextInt(width);
        int y_coordinate = gen.nextInt(height);

        calculateNextStep(gen, x_coordinate, y_coordinate);
    }
    
    /**
     * Calculates the next step the bug can take. If a possible move exists,
     * the bug 'moves' to the new locaiont.
     * @param gen - a random number generator
     * @param x_coordinate - the x coordinate that dietermines an element in room
     * @param y_coordinate - the y coordinate that dietermines an element in room
     */
    private void calculateNextStep(Random gen, int x_coordinate, int y_coordinate) {
        int nextXStep = 0;
        int nextYStep = 0;
        
        // Set the tile to touched first, so no element is skippeed.
        room.setTileTouched(x_coordinate, y_coordinate);
        
        // Generate the next possible move
        nextXStep = generateNumber(gen, x_coordinate);
        nextYStep = generateNumber(gen, y_coordinate);
        
        // If the next move coordinates is (0,0), the bug does not move. Or, if the coordinate is(|1|,|1|),
        // the bug would move diagonally.
        if(!(nextXStep == 0 && nextYStep == 0) || !(Math.abs(nextXStep) == 1 && Math.abs(nextYStep) == 1)) {
            x_coordinate += nextXStep;
            y_coordinate += nextYStep;
            stepsTaken++;
        }
        
        // Check each tile in the room. Call calculateNextSteup until all tiles are touched.
        if(!room.AllTilesTouched()) {
            calculateNextStep(gen, x_coordinate, y_coordinate);
        } else System.out.println("all done " + stepsTaken); // Print the number of steps the bug took.
    }

    /**
     *  This function generates a number for a x/y coordinate used to determine which direction 
     * the bug can move.
     * @param gen - a random number generator
     * @param coordinate - an x or y coordinate
     * @return nextStep (int) - a number used to move the bug in a direction
     */
    private int generateNumber(Random gen, int coordinate) {
        int nextStep = 0;

        if(coordinate == 0)
            nextStep = gen.nextInt(2);
        else if(coordinate == height - 1)
            nextStep = gen.nextInt(2) - 1;
        else
            nextStep = gen.nextInt(3) - 1;
        
        return nextStep;
    }
}