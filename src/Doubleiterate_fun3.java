import java.util.function.DoublePredicate;
import java.util.function.DoubleUnaryOperator;
import java.util.stream.DoubleStream;

public class Doubleiterate_fun3 {
    public static void main(String[] args) {
        double seed = 1.0;

        // Condition to keep generating values (less than 10.0)
        DoublePredicate hasNext = n -> n < 10.0;

        // Operation to generate the next value (multiply by 1.5)
        DoubleUnaryOperator next = n -> n * 1.5;

        // Generate the stream
        DoubleStream stream = DoubleStream.iterate(seed, hasNext, next);

        // Re-create the stream since streams cannot be reused
        stream.forEach(System.out::println);

        System.out.println("@@@");

    }
}
