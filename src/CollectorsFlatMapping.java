import java.util.List;
import java.util.stream.Collectors;

public class CollectorsFlatMapping {
    public static void main(String[] args) {
        List<List<String>> data = List.of(
                List.of("apple", "banana"),
                List.of("cherry"),
                List.of("date", "elderberry", "fig")
        );
        List<String> result = data.stream()
                .collect(Collectors.flatMapping(
                        List::stream,
                        Collectors.toList()
                ));
        System.out.println("Flattened list: " + result);
    }
}