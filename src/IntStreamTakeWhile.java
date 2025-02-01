import java.util.function.IntPredicate;
import java.util.stream.IntStream;

public class IntStreamTakeWhile {
    public static void main(String[] args) {
        IntStream intStream1 = IntStream.of(1, 2, 3, 4, 5, 7);
        IntPredicate takeWhilePredicate = n -> n < 6;

        intStream1 = intStream1.takeWhile(takeWhilePredicate);
        intStream1.forEach(System.out::println);

    }
}
