import java.util.concurrent.atomic.AtomicIntegerArray;
import java.util.concurrent.atomic.AtomicLong;

public class AtomiclongSetOpaque {

    private static final AtomicIntegerArray atomicArray = new AtomicIntegerArray(5);

    public static void main(String[] args) throws InterruptedException {
        AtomicLong atomicLong = new AtomicLong(10);
        atomicLong.setOpaque(20); // Write with relaxed (opaque) semantics
        System.out.println("Value after setOpaque: " + atomicLong.get());
    }
}