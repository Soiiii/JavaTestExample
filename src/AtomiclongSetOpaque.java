import java.util.concurrent.atomic.AtomicIntegerArray;

public class AtomiclongSetOpaque {

    private static final AtomicIntegerArray atomicArray = new AtomicIntegerArray(5);

    public static void main(String[] args) throws InterruptedException {
        AtomicIntegerArray atomicArray = new AtomicIntegerArray(5);
        atomicArray.setOpaque(2, 42);
        int value = atomicArray.get(2);
        System.out.println("Value at index 2: " + value);
    }
}