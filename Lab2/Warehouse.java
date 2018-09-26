/**
 * @author: Jeremy Brothers
 * @version: 1/9/2018
 * Assignment: Lab 2
 * Description: This class reads inventory data from a text file. 
 *              Then it stores each record in an array list of type InventoryItem.
 *              Finally it loops through the array list and writes the contents to text file.          
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Warehouse {
    private ArrayList<InventoryItem> list = null;
    private File file = null;
    private Scanner input = null;
    private PrintWriter writer = null;
    private String itemName = "";
    private int unit = 0;
    private int quantity = 0;
    private double price = 0.0;

    // A constructor to initalize the array list.
    public Warehouse() {
        list = new ArrayList<InventoryItem>();
    }

    /**
     * This function accepts a string as a parameter that represents an .txt file.
     * While the file contains lines with data, each data point for the inventory item is
     * passed into a new array list item.
     * 
     * @param fileName : The name of the file that the scanner will read. 
     */
    public void ReadInventoryFile( String fileName ) { 
        try {
            // Create a new file and scanner object so that a file can be read.
            file = new File( fileName );
            input = new Scanner( file );

            // Loop until there are no more lines the scanner can read.
            while ( input.hasNextLine() ) {
                // if has next is character, assign the whole line to itemName
                if( input.hasNext() )
                    itemName = input.nextLine();
                // Assign unit, price, and quantity in this order.
                if( input.hasNextInt() )
                    unit = input.nextInt();
                if( input.hasNextDouble() )
                    price = input.nextDouble();
                if( input.hasNextInt() )
                    quantity = input.nextInt();
                
                list.add(new InventoryItem(itemName, unit, price, quantity));

                // Without this check, duplicate list items may be created.
                if(input.hasNextLine())
                    input.nextLine();
            }
        } catch ( FileNotFoundException e ) {
            System.out.println("File not found.");
            System.exit(0);
        } finally { input.close(); }
    }

    /**
     * This function creates a file based on the outputFile paramter.
     * The function loops through every element int the inventoryItem array list
     * and prints a new line containing the element data.
     * 
     * @param outputFile : the name of the created file
     */
    public void WriteOutputFile(String outputFile) {
        try{
            writer = new PrintWriter( outputFile );
            
            writer.println(
                "Description         | Stock Unit         | Unit Price         | Quantity\n" +
                "-------------------------------------------------------------------------"
            );

            // For each item in the array list, assign each getter from InventoryItem and print the values to the output file.
            for(InventoryItem item : list)
            {
                itemName = item.GetItemDescription();
                unit = item.GetStockUnit();
                price = item.GetUnitPrice();
                quantity = item.GetStockQuantity();
                writer.println( String.format( "%-20s %-20s %-20s %-20s", itemName, unit, price, quantity ) );
            }

            
        } catch ( FileNotFoundException e ) {
            System.out.println( "Output error: File not found. Exiting... ");
            System.exit(0);
        } finally { writer.close(); }
     }
}