import java.util.concurrent.atomic.AtomicIntegerArray;

public class AtomicIntegerWeakCompareAndSetRelease {
    public static void main(String[] args) {
        AtomicIntegerArray atomicArray = new AtomicIntegerArray(new int[]{10, 20, 30, 40, 50});

        int index = 2;
        int expectedValue = 30;
        int newValue = 60;

        // Attempt to update using weakCompareAndSetRelease
        boolean isUpdated = atomicArray.weakCompareAndSetRelease(index, expectedValue, newValue);

        System.out.println("Update successful? " + isUpdated);
        System.out.println("New value at index " + index + ": " + atomicArray.get(index));


    }
}
