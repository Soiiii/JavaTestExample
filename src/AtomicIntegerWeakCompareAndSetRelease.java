import java.util.concurrent.atomic.AtomicIntegerArray;

public class AtomicIntegerWeakCompareAndSetRelease {
    public static void main(String[] args) {
        AtomicIntegerArray atomicArray = new AtomicIntegerArray(new int[]{10, 20, 30});

        int index = 1;       // Target index
        int expected = 20;   // Expected value at index 1
        int newValue = 50;   // New value to set

        // Perform weakCompareAndSetAcquire
        boolean isUpdated = atomicArray.weakCompareAndSetAcquire(index, expected, newValue);

        // Print results
        System.out.println("Update successful? " + isUpdated);
        System.out.println("New value at index " + index + ": " + atomicArray.get(index));


    }
}
