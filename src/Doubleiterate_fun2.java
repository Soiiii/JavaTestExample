import java.util.function.DoublePredicate;
import java.util.function.DoubleUnaryOperator;
import java.util.stream.DoubleStream;

public class Doubleiterate_fun2 {
    public static void main(String[] args) {
        // Initial value (seed)
        double seed = 1.0;
        DoublePredicate hasNext = n -> n < 10.0;
        DoubleUnaryOperator next = n -> n * 1.5;
        DoubleStream stream = DoubleStream.iterate(seed, next);
        stream.limit(10).forEach(System.out::println);
        System.out.println("@@@");

    }
}
