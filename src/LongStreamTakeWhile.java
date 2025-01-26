import java.util.function.LongPredicate;
import java.util.stream.LongStream;

public class LongStreamTakeWhile {
    public static void main(String[] args) {
        LongStream stream = LongStream.of(1L, 2L, 3L, 4L, 5L, 7L);
        LongPredicate predicate = n -> n < 6L;

        stream = LongStream.of(1L, 2L, 3L, 4L, 5L, 7L);

        // takeWhile for LongStream
        System.out.println("\ntakeWhile:");
        LongStream takeWhileStream = stream.takeWhile(predicate);
        takeWhileStream.forEach(System.out::println);

    }
}
