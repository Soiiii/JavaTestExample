import java.util.stream.IntStream;

public class IntStreamDropWhile {
    public static void main(String[] args) {
        // Create an IntStream
        IntStream numbers = IntStream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        // Use dropWhile to skip numbers less than 5
        IntStream result = numbers.dropWhile(n -> n < 5);

        // Print the remaining numbers
        result.forEach(System.out::println);

//        IntStream intStream2 = IntStream.of(1, 2, 3, 4, 5, 7);
//        IntPredicate dropWhilePredicate = n -> n < 6;
//
//        intStream2 = intStream2.dropWhile(dropWhilePredicate);
//        intStream2.forEach(System.out::println);

    }
}
