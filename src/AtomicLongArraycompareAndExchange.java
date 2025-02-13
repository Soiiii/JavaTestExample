import java.util.concurrent.atomic.AtomicLongArray;

public class AtomicLongArraycompareAndExchange {

    public static void main(String[] args) {


        AtomicLongArray atomicArray = new AtomicLongArray(new long[]{10, 20, 30});
        int index = 0;
        long expected = 10;
        long newValue = 50;

        long previousValue = atomicArray.compareAndExchange(index, expected, newValue);

        System.out.println("[compareAndExchange] Previous value: " + previousValue);
        System.out.println("[compareAndExchange] Current value: " + atomicArray.get(index));

    }
}