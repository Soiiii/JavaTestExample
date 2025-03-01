public class CharSequenceTest {
    public static void main(String[] args) {
        CharSequenceTest test = new CharSequenceTest();
        test.compare();
        test.isEmpty();

    }
    public void compare() {
        CharSequence seq1 = "apple";
        CharSequence seq2 = "banana";
        CharSequence seq3 = "apple";
        CharSequence seq4 = "apples";
        CharSequence seq5 = "Apple";

        System.out.println("Comparing 'apple' and 'banana': " + CharSequence.compare(seq1, seq2));
        System.out.println("Comparing 'apple' and 'apple': " + CharSequence.compare(seq1, seq3));
        System.out.println("Comparing 'apple' and 'apples': " + CharSequence.compare(seq1, seq4));
        System.out.println("Comparing 'apple' and 'Apple': " + CharSequence.compare(seq1, seq5));
    }

    public void isEmpty() {
        CharSequence seq1 = "";
        CharSequence seq2 = "apple";
        CharSequence seq3 = new StringBuilder("");
        CharSequence seq4 = new StringBuffer("banana");

        System.out.println("Is seq1 empty? " + (seq1.length() == 0));
        System.out.println("Is seq2 empty? " + (seq2.length() == 0));
        System.out.println("Is seq3 empty? " + (seq3.length() == 0));
        System.out.println("Is seq4 empty? " + (seq4.length() == 0));
    }

}
