import java.util.concurrent.atomic.AtomicIntegerArray;

public class AtomicIntegerCompareAndExchange {
    public static void main(String[] args) {
        AtomicIntegerArray atomicArray = new AtomicIntegerArray(new int[]{10, 20, 30, 40, 50});

        int index = 1;
        int expectedValue = 20;
        int newValue = 99;

        // Perform compareAndExchange operation
        int previousValue = atomicArray.compareAndExchange(index, expectedValue, newValue);

        System.out.println("Previous value: " + previousValue);
        System.out.println("Updated value at index " + index + ": " + atomicArray.get(index));

    }
}
