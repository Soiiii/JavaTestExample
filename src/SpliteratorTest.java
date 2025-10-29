import java.util.*;
import java.util.function.Consumer;
import java.util.function.DoubleConsumer;
import java.util.function.IntConsumer;
import java.util.function.LongConsumer;

public class SpliteratorTest {
    public static void runAll() {
        try {
            System.out.println("\n--- Testing Spliterator Interface ---");

            testBasicSpliteratorMethods();
            testSpliteratorCharacteristics();
            testSpliteratorTrySplit();
            testSpliteratorTraversal();
            testPrimitiveSpliterators();
            testConsumerOverloads();

            System.out.println("\n--- Testing Spliterator Interface Finished ---");

        } catch (Exception e) {
            System.err.println("--- Test failed ---");
            e.printStackTrace();
        }
    }

    private static void testBasicSpliteratorMethods() {
        System.out.println("\n=== Basic Spliterator Methods ===");

        List<String> list = Arrays.asList("A", "B", "C", "D", "E");
        Spliterator<String> spliterator = list.spliterator();

        System.out.println("estimateSize: " + spliterator.estimateSize());
        System.out.println("getExactSizeIfKnown: " + spliterator.getExactSizeIfKnown());
        System.out.println("characteristics: " + spliterator.characteristics());
    }

    private static void testSpliteratorCharacteristics() {
        System.out.println("\n=== Spliterator Characteristics ===");

        Integer[] array = {1, 2, 3, 4, 5};
        Spliterator<Integer> spliterator = Spliterators.spliterator(
                array,
                Spliterator.SIZED | Spliterator.ORDERED | Spliterator.IMMUTABLE | Spliterator.NONNULL
        );

        System.out.println("SIZED: " + spliterator.hasCharacteristics(Spliterator.SIZED));
        System.out.println("ORDERED: " + spliterator.hasCharacteristics(Spliterator.ORDERED));
        System.out.println("DISTINCT: " + spliterator.hasCharacteristics(Spliterator.DISTINCT));
        System.out.println("SORTED: " + spliterator.hasCharacteristics(Spliterator.SORTED));
        System.out.println("NONNULL: " + spliterator.hasCharacteristics(Spliterator.NONNULL));
        System.out.println("IMMUTABLE: " + spliterator.hasCharacteristics(Spliterator.IMMUTABLE));
        System.out.println("CONCURRENT: " + spliterator.hasCharacteristics(Spliterator.CONCURRENT));
        System.out.println("SUBSIZED: " + spliterator.hasCharacteristics(Spliterator.SUBSIZED));

        boolean isSorted = spliterator.hasCharacteristics(Spliterator.SORTED);
        if (isSorted) {
            try {
                Comparator<? super Integer> comparator = spliterator.getComparator();
                System.out.println("Comparator: " + comparator);
            } catch (Exception e) {
                System.out.println("getComparator threw: " + e.getClass().getSimpleName());
            }
        } else {
            System.out.println("Not SORTED, skipping getComparator test");
        }
    }

    private static void testSpliteratorTrySplit() {
        System.out.println("\n=== Spliterator trySplit ===");

        // Generic spliterator
        Integer[] array = {1, 2, 3, 4, 5, 6, 7, 8};
        Spliterator<Integer> spliterator = Spliterators.spliterator(array, 0);

        System.out.println("Original size: " + spliterator.estimateSize());
        Spliterator<Integer> split = spliterator.trySplit();

        if (split != null) {
            System.out.println("Split part 1 size: " + split.estimateSize());
            System.out.println("Split part 2 size: " + spliterator.estimateSize());

            System.out.print("Split part 1: ");
            split.forEachRemaining(i -> System.out.print(i + " "));
            System.out.println();

            System.out.print("Split part 2: ");
            spliterator.forEachRemaining(i -> System.out.print(i + " "));
            System.out.println();
        }

        // Primitive spliterator
        int[] intArray = {1, 2, 3, 4, 5, 6, 7, 8};
        Spliterator.OfInt intSpliterator = Spliterators.spliterator(intArray, 0);
        Spliterator.OfInt intSplit = intSpliterator.trySplit();

        if (intSplit != null) {
            System.out.print("Int split part 1: ");
            intSplit.forEachRemaining((IntConsumer) i -> System.out.print(i + " "));
            System.out.println();

            System.out.print("Int split part 2: ");
            intSpliterator.forEachRemaining((IntConsumer) i -> System.out.print(i + " "));
            System.out.println();
        }
    }

    private static void testSpliteratorTraversal() {
        System.out.println("\n=== Spliterator Traversal ===");

        // forEachRemaining
        String[] array1 = {"Apple", "Banana", "Cherry"};
        Spliterator<String> spliterator1 = Spliterators.spliterator(array1, 0);
        System.out.print("forEachRemaining: ");
        spliterator1.forEachRemaining(s -> System.out.print(s + " "));
        System.out.println("\nSize after forEachRemaining: " + spliterator1.estimateSize());

        // tryAdvance
        List<Integer> list = Arrays.asList(10, 20, 30, 40, 50);
        Spliterator<Integer> spliterator2 = list.spliterator();
        System.out.print("tryAdvance: ");
        while (spliterator2.tryAdvance(i -> System.out.print(i + " ")));
        System.out.println("\ntryAdvance on exhausted: " +
                spliterator2.tryAdvance(i -> System.out.print(i + " ")));
    }

    private static void testPrimitiveSpliterators() {
        System.out.println("\n=== Primitive Spliterators ===");

        // OfInt
        System.out.println("--- OfInt ---");
        int[] intArray = {1, 2, 3, 4, 5};
        Spliterator.OfInt intSplit = Spliterators.spliterator(intArray, 0);

        System.out.println("estimateSize: " + intSplit.estimateSize());
        System.out.println("getExactSizeIfKnown: " + intSplit.getExactSizeIfKnown());
        System.out.println("SIZED: " + intSplit.hasCharacteristics(Spliterator.SIZED));

        System.out.print("Elements: ");
        intSplit.forEachRemaining((IntConsumer) i -> System.out.print(i + " "));
        System.out.println();

        // OfLong
        System.out.println("\n--- OfLong ---");
        long[] longArray = {100L, 200L, 300L, 400L};
        Spliterator.OfLong longSplit = Arrays.spliterator(longArray);

        System.out.println("estimateSize: " + longSplit.estimateSize());
        System.out.print("First 2 via tryAdvance: ");
        longSplit.tryAdvance((long v) -> System.out.print(v + " "));
        longSplit.tryAdvance((long v) -> System.out.print(v + " "));
        System.out.println();

        System.out.print("Remaining: ");
        longSplit.forEachRemaining((LongConsumer) v -> System.out.print(v + " "));
        System.out.println();

        // OfDouble
        System.out.println("\n--- OfDouble ---");
        double[] doubleArray = {1.1, 2.2, 3.3, 4.4};
        Spliterator.OfDouble doubleSplit = Arrays.spliterator(doubleArray);

        System.out.println("estimateSize: " + doubleSplit.estimateSize());
        System.out.print("Elements: ");
        doubleSplit.forEachRemaining((DoubleConsumer) d -> System.out.print(d + " "));
        System.out.println();
    }

    private static void testConsumerOverloads() {
        System.out.println("\n=== Consumer Overloads (Primitive vs Boxed) ===");

        // OfInt: IntConsumer vs Consumer<Integer>
        System.out.println("--- OfInt ---");
        int[] intArray = {10, 20, 30};

        Spliterator.OfInt intSplit1 = Spliterators.spliterator(intArray, 0);
        System.out.print("forEachRemaining(IntConsumer): ");
        intSplit1.forEachRemaining((IntConsumer) i -> System.out.print(i + " "));
        System.out.println();

        Spliterator.OfInt intSplit2 = Spliterators.spliterator(intArray, 0);
        System.out.print("forEachRemaining(Consumer<Integer>): ");
        intSplit2.forEachRemaining((Consumer<Integer>) i -> System.out.print(i + " "));
        System.out.println();

        Spliterator.OfInt intSplit3 = Spliterators.spliterator(intArray, 0);
        System.out.print("tryAdvance(IntConsumer): ");
        while (intSplit3.tryAdvance((IntConsumer) i -> System.out.print(i + " ")));
        System.out.println();

        Spliterator.OfInt intSplit4 = Spliterators.spliterator(intArray, 0);
        System.out.print("tryAdvance(Consumer<Integer>): ");
        while (intSplit4.tryAdvance((Consumer<Integer>) i -> System.out.print(i + " ")));
        System.out.println();

        // OfLong: LongConsumer vs Consumer<Long>
        System.out.println("\n--- OfLong ---");
        long[] longArray = {100L, 200L};

        Spliterator.OfLong longSplit1 = Spliterators.spliterator(longArray, 0);
        System.out.print("forEachRemaining(LongConsumer): ");
        longSplit1.forEachRemaining((LongConsumer) l -> System.out.print(l + " "));
        System.out.println();

        Spliterator.OfLong longSplit2 = Spliterators.spliterator(longArray, 0);
        System.out.print("forEachRemaining(Consumer<Long>): ");
        longSplit2.forEachRemaining((Consumer<Long>) l -> System.out.print(l + " "));
        System.out.println();

        // OfDouble: DoubleConsumer vs Consumer<Double>
        System.out.println("\n--- OfDouble ---");
        double[] doubleArray = {1.5, 2.5};

        Spliterator.OfDouble doubleSplit1 = Spliterators.spliterator(doubleArray, 0);
        System.out.print("forEachRemaining(DoubleConsumer): ");
        doubleSplit1.forEachRemaining((DoubleConsumer) d -> System.out.print(d + " "));
        System.out.println();

        Spliterator.OfDouble doubleSplit2 = Spliterators.spliterator(doubleArray, 0);
        System.out.print("forEachRemaining(Consumer<Double>): ");
        doubleSplit2.forEachRemaining((Consumer<Double>) d -> System.out.print(d + " "));
        System.out.println();

        System.out.println("\nNote: tryAdvance(Consumer<T>) for primitives requires");
        System.out.println("complex boxing wrapper - tested only for forEachRemaining");
    }
}