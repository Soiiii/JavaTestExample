import java.util.function.DoublePredicate;
import java.util.stream.DoubleStream;

public class DoubleStreamTakeWhile {
    public static void main(String[] args) {
//        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9);
//        numbers.stream()
//                .takeWhile(n -> n < 5)
//                .forEach(System.out::println);
        DoubleStream stream = DoubleStream.of(1.0, 2.0, 3.0, 4.0, 5.0, 7.0);
        DoublePredicate predicate = n -> n < 6.0;

        stream = stream.takeWhile(predicate);
        stream.forEach(System.out::println);
    }
}
