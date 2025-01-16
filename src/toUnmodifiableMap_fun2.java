import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class toUnmodifiableMap_fun2 {
    public static void main(String[] args) {

        List<String> fruits = List.of("apple", "banana", "cherry", "date");

        // Collect to an unmodifiable map: fruit name as key, length as value
        Map<String, Integer> unmodifiableMap = fruits.stream()
                .collect(Collectors.toUnmodifiableMap(
                        fruit -> fruit,          // Key mapper: Use the fruit name as the key
                        String::length           // Value mapper: Use the length of the fruit name as the value
                ));

        // Print the unmodifiable map
        System.out.println("Unmodifiable map: " + unmodifiableMap);

        // Verify immutability
        try {
            unmodifiableMap.put("elderberry", 10);
        } catch (UnsupportedOperationException e) {
            System.out.println("Cannot modify the map as expected.");
        }

    }
}
