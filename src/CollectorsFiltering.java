import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.filtering;

public class CollectorsFiltering {
    public static void main(String[] args) {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);
        Predicate<Integer> greaterThanThree = num -> num > 3;
        List<Integer> result = numbers.stream()
                .collect(filtering(greaterThanThree, Collectors.toList()));
        System.out.println("Filtered numbers: " + result);
    }
}