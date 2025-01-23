import java.util.function.DoublePredicate;
import java.util.stream.DoubleStream;

public class DoubleStreamDropWhile {
    public static void main(String[] args) {
        DoubleStream stream = DoubleStream.of(1.0, 2.0, 3.0, 4.0, 5.0, 7.0);
        DoublePredicate predicate = n -> n < 6.0;

        stream = stream.dropWhile(predicate);
        stream.forEach(System.out::println);


    }
}
