import java.util.stream.DoubleStream;

public class DoubleStreammapMulti {
    public static void main(String[] args) {
        DoubleStream doubleStream = DoubleStream.of(1.0, 2.0, 3.0, 4.0, 5.0);
        DoubleStream.of(1.0, 2.0, 3.0)
                .mapMulti((value, consumer) -> consumer.accept(value))
                .forEach(System.out::println);

    }
}
