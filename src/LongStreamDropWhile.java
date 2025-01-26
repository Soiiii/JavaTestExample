import java.util.function.LongPredicate;
import java.util.stream.LongStream;

public class LongStreamDropWhile {
    public static void main(String[] args) {
        LongStream stream = LongStream.of(1L, 2L, 3L, 4L, 5L, 7L);
        LongPredicate predicate = n -> n < 6L;

        // dropWhile for LongStream
        System.out.println("dropWhile:");
        LongStream dropWhileStream = stream.dropWhile(predicate);
        dropWhileStream.forEach(System.out::println);


    }
}
