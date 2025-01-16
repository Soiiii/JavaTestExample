import java.util.List;
import java.util.stream.Collectors;

public class ToUnmodifiableListTest {
    public static void main(String[] args) {
        // Test data
//        List<String> data = List.of("apple", "banana", "cherry", "date");
//
//        // Use toUnmodifiableList to collect the data into an unmodifiable list
//        List<String> unmodifiableList = data.stream()
//                .filter(fruit -> fruit.startsWith("a") || fruit.startsWith("b")) // Filter fruits starting with 'a' or 'b'
//                .collect(Collectors.toUnmodifiableList());
//
//        // Print the unmodifiable list
//        System.out.println("Unmodifiable list: " + unmodifiableList);
//
//        // Verify unmodifiable behavior (will throw an exception)
//        try {
//            unmodifiableList.add("elderberry");
//        } catch (UnsupportedOperationException e) {
//            System.out.println("Cannot modify the list: The list is unmodifiable as expected.");
//        }

        // Test data
        List<String> data = List.of("apple", "banana", "cherry", "date");

        // Use toUnmodifiableList to collect the data into an unmodifiable list
        List<String> unmodifiableList = data.stream()
                .collect(Collectors.toUnmodifiableList());

        // Print the unmodifiable list
        System.out.println("Unmodifiable list: " + unmodifiableList);

        // Verify unmodifiable behavior (will throw an exception)
        try {
            unmodifiableList.add("elderberry");
        } catch (UnsupportedOperationException e) {
            System.out.println("Cannot modify the list: The list is unmodifiable as expected.");
        }

    }
}
