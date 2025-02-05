import java.util.concurrent.atomic.AtomicIntegerArray;

public class AtomicIntegerSetOpaque {
    public static void main(String[] args) {
        AtomicIntegerArray atomicArray = new AtomicIntegerArray(5);

        // Using setOpaque to set a value at index 2
        atomicArray.setOpaque(2, 42);

        // Retrieve the value normally
        int value = atomicArray.get(2);

        System.out.println("Value at index 2: " + value);
    }
}