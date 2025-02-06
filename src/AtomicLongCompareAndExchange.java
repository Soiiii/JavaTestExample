import java.util.concurrent.atomic.AtomicIntegerArray;
import java.util.concurrent.atomic.AtomicLong;

public class AtomicLongCompareAndExchange {

    private static final AtomicIntegerArray atomicArray = new AtomicIntegerArray(5);

    public static void main(String[] args) throws InterruptedException {
        AtomicLong atomicLong = new AtomicLong(10);
        System.out.println("atomicLong: " + atomicLong);

        long expectedValue = 20;
        long newValue = 20;

        long previousValue = atomicLong.compareAndExchange(expectedValue, newValue);

        System.out.println("Previous value: " + previousValue);
        System.out.println("Current value: " + atomicLong.get());
    }
}