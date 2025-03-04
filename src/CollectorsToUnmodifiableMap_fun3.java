import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CollectorsToUnmodifiableMap_fun3 {
    public static void main(String[] args) {

        List<String> fruits = List.of("apple", "banana", "cherry", "apricot", "blueberry");

        // Collect to an unmodifiable map with a merge function for duplicate keys
        Map<Character, String> unmodifiableMap = fruits.stream()
                .collect(Collectors.toUnmodifiableMap(
                        fruit -> fruit.charAt(0),         // Key mapper: First character of the fruit
                        fruit -> fruit,                  // Value mapper: Full fruit name
                        (existing, replacement) -> existing + ", " + replacement // Merge function: Concatenate values
                ));

        // Print the unmodifiable map
        System.out.println("Unmodifiable map: " + unmodifiableMap);

        // Verify immutability
        try {
            unmodifiableMap.put('c', "cranberry");
        } catch (UnsupportedOperationException e) {
            System.out.println("Cannot modify the map as expected.");
        }
    }
}
