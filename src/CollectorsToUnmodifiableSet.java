import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class CollectorsToUnmodifiableSet {
    public static void main(String[] args) {
        // Test data
        List<String> fruits = List.of("apple", "banana", "cherry", "date", "apple");

        // Collect to an unmodifiable set
        Set<String> unmodifiableSet = fruits.stream()
                .collect(Collectors.toUnmodifiableSet());

        // Print the unmodifiable set
        System.out.println("Unmodifiable set: " + unmodifiableSet);

        // Verify immutability
        try {
            unmodifiableSet.add("elderberry");
        } catch (UnsupportedOperationException e) {
            System.out.println("Cannot modify the set as expected.");
        }
    }
}
