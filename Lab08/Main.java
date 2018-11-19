public class Main {
    public static void main(String[] args) {
        LinkedDeque deck = new LinkedDeque<int[]>();
        deck.addFirst(1);
        deck.addFirst(2);
        deck.addFirst(3);
        deck.addFirst(4);
        deck.addLast(5);
        deck.addLast(6);
        deck.addLast(7);
        deck.addLast(8);
        deck.printForward();
        // deck.printBackward();
    }
}