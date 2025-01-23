import java.util.function.DoublePredicate;
import java.util.function.DoubleUnaryOperator;
import java.util.stream.DoubleStream;

public class Doubleiterate_fun3 {
    public static void main(String[] args) {
        double seed = 1.0;
        DoublePredicate hasNext = n -> n < 10.0;
        DoubleUnaryOperator next = n -> n * 1.5;
        DoubleStream stream = DoubleStream.iterate(seed, hasNext, next);
        stream.forEach(System.out::println);
        System.out.println("@@@");

    }
}
