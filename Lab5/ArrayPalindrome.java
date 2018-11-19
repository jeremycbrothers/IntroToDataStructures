/**
 * @author: Jeremy Brothers
 * @version: 9/28/2018
 * Title: ArrayPalindrom.java
 * Description: Creates a stack structure of a fixed size
 *              and checks a strings to see if it's a palindrome 
 */

public class ArrayPalindrome {
    private int size;
    private ArrayStack s0;
    private ArrayStack s1;
    private ArrayStack s2;

    // Constructor to initialize private members
    public ArrayPalindrome(int size) {
        this.size = size;
        s0 = new ArrayStack<String>(size);
        s1 = new ArrayStack<String>(size);
        s2 = new ArrayStack<String>(size);
    }

    // Pushes the string into two stacks.
    // The second stack is then poped into a third stack.
    // Finally, the first and third stacks are compared.
    // Returns true if they equal. False otherwise.
    public boolean isPalindrome(String word) { 
        for(int i = 0; i < word.length(); i++) {
            s0.push(word.charAt(i));
            s1.push(word.charAt(i));
        }

        for(int i = 0; i < word.length(); i++) {
            s2.push(s1.pop());
        }

        return s0.equals(s2);
    }

    // Creates an instanct of the array palindrome class
    // Calls the isPalindrome function and prints the result.
    public static void TestCase(String word) {
        ArrayPalindrome arrayPalindrome = new ArrayPalindrome(word.length());
        boolean isPalindrome = arrayPalindrome.isPalindrome(word);
        
        PrintResults(isPalindrome, word);
    }

    // Prints the results of the test.
    public static void PrintResults(boolean isPalindrome, String word) {
        if(isPalindrome)
            System.out.println(word + "\nis a palindrome!");
        else 
            System.out.println(word + "\nis not a palindrome!"); 
    }

    public static void main(String[] args) {
        String word = "ackack";
        TestCase(word);
        word = "once ecno";
        TestCase(word);
         word = "a";
        TestCase(word);
        word = "";
        TestCase(word);
        word = "Hair Smell";
        TestCase(word);
    }
}