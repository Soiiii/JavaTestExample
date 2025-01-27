import java.util.function.UnaryOperator;
import java.util.stream.Stream;

public class Streamiterate_fun2 {
    public static void main(String[] args) {
        int seed = 1;

        // Function to generate the next value
        UnaryOperator<Integer> next = n -> n * 2;

        // Stream.iterate with 2 parameters
        Stream<Integer> stream = Stream.iterate(seed, next);

        // Limit the stream for demonstration and print
        stream.limit(5).forEach(System.out::println);

        System.out.println("@@@");
    }
}
