import java.util.concurrent.atomic.AtomicLongArray;

public class AtomicLongArrayweakCompareAndSetAcquire {

    public static void main(String[] args)  {

        AtomicLongArray atomicArray = new AtomicLongArray(new long[]{10, 20, 30});
        int index = 0;
        long expected = 10;
        long update = 50;

        boolean updated = atomicArray.weakCompareAndSetAcquire(index, expected, update);

        System.out.println("Updated: " + updated);
        System.out.println("Current value: " + atomicArray.get(index));

    }
}