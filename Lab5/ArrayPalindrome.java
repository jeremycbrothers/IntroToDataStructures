public class ArrayPalindrome {
    private int size;
    private ArrayStack s0;
    private ArrayStack s1;
    private ArrayStack s2;

    public ArrayPalindrome(int size) {
        this.size = size;
        s0 = new ArrayStack<String>(size);
        s1 = new ArrayStack<String>(size);
        s2 = new ArrayStack<String>(size);
    }

    public boolean isPalindrome(String word) { return false; }

    public static void TestCase(String word) {
        ArrayPalindrome arrayPalindrome = new ArrayPalindrome(3);
        boolean isPalindrome = arrayPalindrome.isPalindrome(word);
        
        PrintResults(isPalindrome);
    }

    public static void PrintResults(boolean isPalindrome) {
        if(isPalindrome)
            System.out.println(word + " is a palindrome!");
        else 
            System.out.println(word + " is not a palindrome!"); 
    }

    public static void main(Stringp[] args) {
        String word = "ack";
        TestCase(word);
        word = "Dennis Nell Edna Leon Nedra Anita Rolf Nora Alice Carol Leo Jane Reed Dena Dale Basil Rae Penny Lana Dave Denny Lena Ida Bernadette Ben Ray" +
                       "Lila Nina Jo Ira Mara Sara Mario Jan Ina Lily Arne Bette Dan Reba Diane Lynn Ed Eva Dana Lynne Pearl Isabel Ada Ned Dee Rena Joel Lora Cecil" + 
                       "Aaron Flora Tina Arden Noel and Ellen sinned";
        TestCase(word);
         word = "a";
        TestCase(word);
        word = "";
        TestCase(word);
        word = "Hair Smell";
        TestCase(word);
    }
}