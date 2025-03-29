import java.util.stream.IntStream;

public class CharSequenceTest {
    public static void main(String[] args) {
        MyCharSequence cs1 = new MyCharSequence("");
        MyCharSequence cs2 = new MyCharSequence("Hello, world!");

        // isEmpty()
        System.out.println("cs1 is empty? " + cs1.isEmpty());
        System.out.println("cs2 is empty? " + cs2.isEmpty());

        // length()
        System.out.println("cs2 length: " + cs2.length());

        // charAt()
        if (cs2.length() > 7) {
            char ch = cs2.charAt(7);
            System.out.println("Character at index 7 in cs2: " + ch);
        }

        // subSequence()
        CharSequence sub = cs2.subSequence(0, 5);
        System.out.println("Subsequence (0~5): " + sub);

        // compare(CharSequence, CharSequence)
        MyCharSequence a = new MyCharSequence("apple");
        MyCharSequence b = new MyCharSequence("banana");
        MyCharSequence c = new MyCharSequence("apple");

        int result1 = CharSequence.compare(a, b);
        int result2 = CharSequence.compare(a, c);

        System.out.println("Compare 'apple' vs 'banana': " + result1);
        System.out.println("Compare 'apple' vs 'apple': " + result2);

        // Use a CharSequence that supports chars/codePoints directly
        CharSequence sb = new StringBuilder("Hi Test");

        // chars()
        System.out.println("Characters (chars):");
        IntStream charsStream = sb.chars();
        charsStream.forEach(ch -> System.out.print((char) ch + " "));

        cs2.chars().forEach(ch -> System.out.print((char) ch + " "));

        System.out.println();

        // codePoints()
        System.out.println("Characters (codePoints):");
        IntStream codePointsStream = sb.codePoints();
        codePointsStream.forEach(cp -> System.out.print(Character.toChars(cp)));

        cs2.codePoints().forEach(cp -> System.out.print(Character.toChars(cp)));

        System.out.println();

    }

    public static class MyCharSequence implements CharSequence {
        private final String data;

        public MyCharSequence(String data) {
            this.data = data;
        }

        @Override
        public int length() {
            return data.length();
        }

        @Override
        public char charAt(int index) {
            return data.charAt(index);
        }

        @Override
        public CharSequence subSequence(int start, int end) {
            return new MyCharSequence(data.substring(start, end));
        }

        @Override
        public String toString() {
            return data;
        }

        public boolean isEmpty() {
            return data.isEmpty();
        }
    }
}

