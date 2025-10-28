
import java.util.*;
import java.util.function.DoubleConsumer;
import java.util.function.IntConsumer;
import java.util.function.LongConsumer;

public class SpliteratorsTest {
    public static void main(String[] args) {
        runAll();
    }

    public static void runAll() {
        try {
            System.out.println("\n--- Testing Spliterators ---");

            // 1. Empty Spliterators
            testEmptySpliterators();

//             2. Array Spliterators
            testArraySpliterators();

            // 3. Collection Spliterators
            testCollectionSpliterators();

            // 4. Iterator to Spliterator
            testIteratorToSpliterator();

            // 5. Spliterator to Iterator
            testSpliteratorToIterator();

            // 6. Unknown Size Spliterators
            testUnknownSizeSpliterators();

            // 7. Primitive Spliterators
            testPrimitiveSpliterators();

            System.out.println("\n--- Testing Spliterators Finished ---");

        } catch (Exception e) {
            System.err.println("--- Test failed ---");
            e.printStackTrace();
        }
    }

    private static void testEmptySpliterators() {
        System.out.println("\n=== Empty Spliterators ===");

        Spliterator<Object> emptySpliterator = Spliterators.emptySpliterator();
        System.out.println("emptySpliterator size: " + emptySpliterator.estimateSize());

        Spliterator.OfInt emptyIntSpliterator = Spliterators.emptyIntSpliterator();
        System.out.println("emptyIntSpliterator size: " + emptyIntSpliterator.estimateSize());

        Spliterator.OfLong emptyLongSpliterator = Spliterators.emptyLongSpliterator();
        System.out.println("emptyLongSpliterator size: " + emptyLongSpliterator.estimateSize());

        Spliterator.OfDouble emptyDoubleSpliterator = Spliterators.emptyDoubleSpliterator();
        System.out.println("emptyDoubleSpliterator size: " + emptyDoubleSpliterator.estimateSize());
    }

    private static void testArraySpliterators() {
        System.out.println("\n=== Array Spliterators ===");

        // Object array
        String[] stringArray = {"Apple", "Banana", "Cherry", "Date"};
        Spliterator<String> stringSpliterator = Spliterators.spliterator(stringArray, 0);
        System.out.println("String array spliterator size: " + stringSpliterator.estimateSize());
        System.out.print("Elements: ");
        stringSpliterator.forEachRemaining(s -> System.out.print(s + " "));
        System.out.println();

        // Object array with range
        Spliterator<String> rangeSpliterator = Spliterators.spliterator(stringArray, 1, 3, 0);
        System.out.print("Range [1,3) elements: ");
        rangeSpliterator.forEachRemaining(s -> System.out.print(s + " "));
        System.out.println();

        // int array
        int[] intArray = {10, 20, 30, 40, 50};
        Spliterator.OfInt intSpliterator = Spliterators.spliterator(intArray, 0);
        System.out.println("Int array spliterator size: " + intSpliterator.estimateSize());
        System.out.print("Elements: ");
        intSpliterator.forEachRemaining((IntConsumer) i -> System.out.print(i + " "));
        System.out.println();

        // long array
        long[] longArray = {100L, 200L, 300L};
        Spliterator.OfLong longSpliterator = Spliterators.spliterator(longArray, 0);
        System.out.print("Long array elements: ");
        longSpliterator.forEachRemaining((LongConsumer) l -> System.out.print(l + " "));
        System.out.println();

        // double array
        double[] doubleArray = {1.1, 2.2, 3.3, 4.4};
        Spliterator.OfDouble doubleSpliterator = Spliterators.spliterator(doubleArray, 0);
        System.out.print("Double array elements: ");
        doubleSpliterator.forEachRemaining((DoubleConsumer) d -> System.out.print(d + " "));
        System.out.println();
    }

    private static void testCollectionSpliterators() {
        System.out.println("\n=== Collection Spliterators ===");

        List<String> list = Arrays.asList("One", "Two", "Three", "Four", "Five");
        Spliterator<String> collectionSpliterator = Spliterators.spliterator(list, 0);

        System.out.println("Collection size: " + collectionSpliterator.estimateSize());
        System.out.println("Has SIZED characteristic: " +
                collectionSpliterator.hasCharacteristics(Spliterator.SIZED));

        System.out.print("Elements: ");
        collectionSpliterator.forEachRemaining(s -> System.out.print(s + " "));
        System.out.println();
    }

    private static void testIteratorToSpliterator() {
        System.out.println("\n=== Iterator to Spliterator ===");

        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        Iterator<Integer> iterator = numbers.iterator();
        Spliterator<Integer> spliterator = Spliterators.spliterator(iterator, 10, 0);

        System.out.println("Spliterator size: " + spliterator.estimateSize());
        System.out.print("First 5 elements: ");
        for (int i = 0; i < 5; i++) {
            if (spliterator.tryAdvance(n -> System.out.print(n + " "))) {
                // continue
            } else {
                break;
            }
        }
        System.out.println();

        int[] intArray = {10, 20, 30, 40, 50};
        Spliterator.OfInt intSpliterator = Spliterators.spliterator(intArray, 0);

        System.out.print("Int spliterator elements: ");
        while (intSpliterator.tryAdvance((int i) -> System.out.print(i + " "))) {
            // continue
        }
        System.out.println();

    }

    private static void testSpliteratorToIterator() {
        System.out.println("\n=== Spliterator to Iterator ===");

        int[] intArray = {100, 200, 300, 400, 500};
        Spliterator.OfInt spliterator = Spliterators.spliterator(intArray, 0);

        PrimitiveIterator.OfInt iterator = Spliterators.iterator(spliterator);
        System.out.print("Iterator elements: ");
        while (iterator.hasNext()) {
            System.out.print(iterator.nextInt() + " ");
        }
        System.out.println();

        // Generic spliterator to iterator
        String[] strArray = {"Alpha", "Beta", "Gamma"};
        Spliterator<String> strSpliterator = Spliterators.spliterator(strArray, 0);
        Iterator<String> strIterator = Spliterators.iterator(strSpliterator);

        System.out.print("String iterator elements: ");
        strIterator.forEachRemaining(s -> System.out.print(s + " "));
        System.out.println();
    }

    private static void testUnknownSizeSpliterators() {
        System.out.println("\n=== Unknown Size Spliterators ===");

        // Custom iterator with unknown size
        Iterator<String> customIterator = new Iterator<String>() {
            private int count = 0;
            public boolean hasNext() { return count < 3; }
            public String next() { return "Item-" + (++count); }
        };

        Spliterator<String> unknownSizeSpliterator =
                Spliterators.spliteratorUnknownSize(customIterator, 0);

        System.out.println("Unknown size (returns Long.MAX_VALUE): " +
                unknownSizeSpliterator.estimateSize());
        System.out.print("Elements: ");

        unknownSizeSpliterator.forEachRemaining(s -> System.out.print(s + " "));
        System.out.println();

        while (unknownSizeSpliterator.tryAdvance(s -> System.out.print(s + " "))) {
            // continue
        }
        System.out.println();

        int[] values = {5, 10, 15, 20};
        PrimitiveIterator.OfInt intIterator = java.util.Arrays.stream(values).iterator();

        Spliterator.OfInt unknownIntSpliterator =
                Spliterators.spliteratorUnknownSize(intIterator, 0);
        System.out.print("Unknown int elements: ");

        while (unknownIntSpliterator.tryAdvance((int i) -> System.out.print(i + " "))) {
            // continue
        }
        System.out.println();

    }

    private static void testPrimitiveSpliterators() {
        System.out.println("\n=== Primitive Spliterators ===");

        // Int spliterator with range
        int[] intArray = {10, 20, 30, 40, 50, 60, 70, 80};
        Spliterator.OfInt intRangeSpliterator =
                Spliterators.spliterator(intArray, 2, 6, Spliterator.SIZED | Spliterator.ORDERED);

        System.out.println("Int range [2,6) characteristics: " +
                intRangeSpliterator.characteristics());
        System.out.print("Elements: ");
        intRangeSpliterator.forEachRemaining((IntConsumer) i -> System.out.print(i + " "));
        System.out.println();

        // Long spliterator with range
        long[] longArray = {1000L, 2000L, 3000L, 4000L, 5000L};
        Spliterator.OfLong longRangeSpliterator =
                Spliterators.spliterator(longArray, 1, 4, 0);

        System.out.print("Long range [1,4) elements: ");
        longRangeSpliterator.forEachRemaining((LongConsumer) l -> System.out.print(l + " "));
        System.out.println();

        // Double spliterator with range
        double[] doubleArray = {1.5, 2.5, 3.5, 4.5, 5.5, 6.5};
        Spliterator.OfDouble doubleRangeSpliterator =
                Spliterators.spliterator(doubleArray, 0, 3, 0);

        System.out.print("Double range [0,3) elements: ");
        doubleRangeSpliterator.forEachRemaining((DoubleConsumer) d -> System.out.print(d + " "));
        System.out.println();

        // Test trySplit
        System.out.println("\n--- Testing trySplit ---");
        int[] bigArray = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        Spliterator.OfInt bigSpliterator = Spliterators.spliterator(bigArray, 0);

        Spliterator.OfInt splitPart = bigSpliterator.trySplit();
        if (splitPart != null) {
            System.out.print("Split part 1: ");
            splitPart.forEachRemaining((IntConsumer) i -> System.out.print(i + " "));
            System.out.println();

            System.out.print("Split part 2: ");
            bigSpliterator.forEachRemaining((IntConsumer) i -> System.out.print(i + " "));
            System.out.println();
        }

        // Test characteristics
        System.out.println("\n--- Testing Characteristics ---");
        int[] orderedArray = {1, 2, 3};
        Spliterator.OfInt orderedSpliterator = Spliterators.spliterator(
                orderedArray,
                Spliterator.SIZED | Spliterator.ORDERED | Spliterator.IMMUTABLE
        );

        System.out.println("Is SIZED: " +
                orderedSpliterator.hasCharacteristics(Spliterator.SIZED));
        System.out.println("Is ORDERED: " +
                orderedSpliterator.hasCharacteristics(Spliterator.ORDERED));
        System.out.println("Is IMMUTABLE: " +
                orderedSpliterator.hasCharacteristics(Spliterator.IMMUTABLE));
        System.out.println("Exact size if known: " +
                orderedSpliterator.getExactSizeIfKnown());
    }
}