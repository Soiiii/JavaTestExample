import java.util.stream.DoubleStream;

public class DoubleStreammapMulti {
    public static void main(String[] args) {
//        DoubleStream doubleStream = DoubleStream.of(1.0, 2.0, 3.0, 4.0, 5.0);
//        DoubleStream.of(1.0, 2.0, 3.0)
//                .mapMulti((value, consumer) -> consumer.accept(value))
//                .forEach(System.out::println);

        DoubleStream stream = DoubleStream.of(1.0, 2.0, 3.0, 4.0, 5.0);

        // Use mapMulti to create a new stream
        DoubleStream resultStream = stream.mapMulti((value, consumer) -> {
            // For each value, add the square and the cube to the stream
            consumer.accept(value * value); // Square
            consumer.accept(value * value * value); // Cube
        });

        // Print the resulting values
        resultStream.forEach(System.out::println);

    }
}
