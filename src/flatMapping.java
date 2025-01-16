import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.flatMapping;

public class flatMapping {
    public static void main(String[] args) {
        // Test data
        List<List<String>> data = List.of(
                List.of("apple", "banana"),
                List.of("cherry"),
                List.of("date", "elderberry", "fig")
        );

        // Use flatMapping to flatten the nested lists into a single list
        List<String> result = data.stream()
                .collect(flatMapping(
                        List::stream, // Mapper: Convert each list into a stream
                        Collectors.toList() // Downstream collector: Collect into a list
                ));

        // Print the result
        System.out.println("Flattened list: " + result);

    }
}