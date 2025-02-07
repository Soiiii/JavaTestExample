import java.util.List;
import java.util.stream.Collectors;

public class CollectorsTeeing {
    public static void main(String[] args) {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);

        // Teeing collector: Calculate sum and average of the list
        var result = numbers.stream()
                .collect(Collectors.teeing(
                        Collectors.summingInt(Integer::intValue),       // First collector: Sum of numbers
                        Collectors.averagingDouble(Integer::doubleValue), // Second collector: Average of numbers
                        (sum, avg) -> "Sum: " + sum + ", Average: " + avg // Merger function: Combine results
                ));

        // Print the result
        System.out.println(result); // Output: Sum: 21, Average: 3.5

    }
}