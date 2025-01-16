import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ToList {
    public static void main(String[] args) {
        Stream<String> fruits = Stream.of("apple", "banana", "cherry", "date", "elderberry");

        // Collect the stream into a list
        List<String> fruitList = fruits.collect(Collectors.toList());

        // Print the resulting list
        System.out.println("List of fruits: " + fruitList);

        // Verify the list is mutable
        fruitList.add("fig");
        System.out.println("Updated list of fruits: " + fruitList);

    }
}
