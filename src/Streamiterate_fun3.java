import java.util.function.Predicate;
import java.util.function.UnaryOperator;
import java.util.stream.Stream;

public class Streamiterate_fun3 {
    public static void main(String[] args) {

        Integer seed = 1;

        // Predicate to determine when to stop
        Predicate<Integer> hasNext = n -> n <= 10;

        // UnaryOperator to compute the next value
        UnaryOperator<Integer> next = n -> n + 1;

        // Create a Stream using Stream.iterate
        Stream<Integer> stream = Stream.iterate(seed, hasNext, next);

        // Print the values in the Stream
        stream.forEach(System.out::println);

    }
}
