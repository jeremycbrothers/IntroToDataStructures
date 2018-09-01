/**
 * @author: Jeremy Brothers
 * @version: 1/9/2018
 * Title: Lab2
 * Description: The main routing for reading a list of inventory items from a file, reformating it
 *              and wrting the output to a new output file.
 */

public class MainApp {
    public static void main(String[] args) {
        ValidateArgsLength(args);
        // Create an instance of the warehouse class
        Warehouse wareHouse = new Warehouse();
        // Read the file based on the 1st args element
        wareHouse.ReadInventoryFile(args[0]);
        // Create the output file based the 2nd args element
        wareHouse.WriteOutputFile(args[1]);
    }

    /**
     * This function validates that the correct number of parambers have been supplied to main.
     * @param args : a string array
     */
    public static void ValidateArgsLength(String[] args) {
        // Check the langth of the string array
        if (args.length < 2) {
            System.out.println("Too few arguments\n");
            System.exit(0);
        } else if (args.length > 2) {
            System.out.println("Too many arguments\n");
            System.exit(0);
        }
    }
}