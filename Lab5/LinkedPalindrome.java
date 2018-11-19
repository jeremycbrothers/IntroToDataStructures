/**
 * @author: Jeremy Brothers
 * @version: 9/28/2018
 * Title: LinkedPalindrome
 * Description: Checks if the data stroed in LinkedStack
 *              is a palindrome
 */

public class LinkedPalindrome {
    private LinkedStack s0;
    private LinkedStack s1;
    private LinkedStack s2;

    // Constructor that initializes the private members.
    public LinkedPalindrome() {
        s0 = new LinkedStack<String>();
        s1 = new LinkedStack<String>();
        s2 = new LinkedStack<String>();
    }

    // pushes the string into two linkedStack instances.
    // Then, the s2 stack is poped and the value is pushed into
    // a third stack.
    // Returns true if the 1st and 3rd stacks equal.
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

    // Creates an instance of linked palindrome and tests the
    // word given.
    public static void TestCase(String word) {
        LinkedPalindrome arrayPalindrome = new LinkedPalindrome();
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