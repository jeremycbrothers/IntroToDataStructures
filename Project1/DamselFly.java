public class DamselFly{
    public static void main(String[] args){
        // Create several test cases to test RandomWalk
        TestCase( 3,3 );
        TestCase( 5,5 );
        TestCase( 8,8 );
        TestCase( 1,1 );
    }
    
    /**
     * The test case function creates an instance of RandomWalk and runs the simulation.
     * @param height - the number of rows in the room
     * @param width - the number of columns in the room
     */
    public static void TestCase(int height, int width) {
        RandomWalk walk = new RandomWalk( height, width );
        walk.RunBug();
    }
}