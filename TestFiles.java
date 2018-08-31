import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class TestFiles {
    public static void main( String[] args ) {
        CheckArgsLength( args );
        ReadInputFromFile( args );
    }
    
    static void CheckArgsLength( String[] args ) {
        if ( args.length < 2 ) {
            System.out.println(
                "Error : \'Too few parameters.\'"
            );
            System.exit(0);
        }
    }

    static void ReadInputFromFile(String[] fileName) {
        File input = new File( fileName[0] );
        Scanner reader = null;

        try {
            reader = new Scanner( input );
            OutputToFile(fileName[1], input, reader);
        } catch ( FileNotFoundException e ) {
            System.out.println(
                "Error Reading: File not found. Exiting..."
            );
            System.exit(0);
        }
    }

    static void OutputToFile(
        String outputName, File input, Scanner reader
    ) {
        PrintWriter output = null;

        try {
            output = new PrintWriter( outputName );
            WriteOutput(output, reader);
        } catch ( FileNotFoundException e ) {
            System.out.println(
                "Output error: File not found. Exiting..."
                );
            }
        
        reader.close();
        output.close();
    }
     
    static void WriteOutput(
        PrintWriter output, Scanner reader
    ) {
        double total = 0.0;
        double value = 0.0;

        while( reader.hasNextDouble() ) {
            value = reader.nextDouble();
            output.printf( "Value: %8.2f\n", value );
            total += value;
        }

        output.printf("Total: %8.2f\n", total);
    }
}
