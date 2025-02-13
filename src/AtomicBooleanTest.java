import java.util.concurrent.atomic.AtomicBoolean;

public class AtomicBooleanTest {

    public static void main(String[] args) {
        AtomicBooleanTest atomicBooleanTest = new AtomicBooleanTest();
        AtomicBooleanTest test = new AtomicBooleanTest();
//        test.compareAndSet();
//        test.compareAndExchange();
//        test.compareAndExchangeAcquire();
//        test.compareAndExchangeRelease();
//        test.getAcquire();
//        test.getOpaque();
//        test.getPlain();
        test.weakCompareAndSet();
        test.weakCompareAndSetAcquire();
        test.weakCompareAndSetPlain();
        test.weakCompareAndSetRelease();
        test.weakCompareAndSetVolatile();
//        test.setOpaque();
//        test.setPlain();
//        test.setRelease();

    }

    private AtomicBoolean atomicBoolean = new AtomicBoolean(false);

    public void compareAndSet() {
        boolean expectedValue = false;
        boolean newValue = false;
        boolean updated = atomicBoolean.compareAndSet(expectedValue, newValue);
        int result = updated ? 1 : 0;
        System.out.println("[compareAndSet] Updated? " + result);
        System.out.println("[compareAndSet] Current value: " + (atomicBoolean.get() ? 1 : 0));
    }

    public void compareAndExchange() {
        boolean previousValue = atomicBoolean.compareAndExchange(false, true);
        System.out.println("[compareAndExchange] Previous value: " + previousValue);
        System.out.println("[compareAndExchange] Current value: " + atomicBoolean.get());
    }

    public void compareAndExchangeAcquire() {
        boolean previousValue = atomicBoolean.compareAndExchangeAcquire(true, false);
        System.out.println("[compareAndExchangeAcquire] Previous value: " + previousValue);
        System.out.println("[compareAndExchangeAcquire] Current value: " + atomicBoolean.get());
    }

    public void compareAndExchangeRelease() {
        boolean previousValue = atomicBoolean.compareAndExchangeRelease(false, true);
        System.out.println("[compareAndExchangeRelease] Previous value: " + previousValue);
        System.out.println("[compareAndExchangeRelease] Current value: " + atomicBoolean.get());
    }

    public void getAcquire() {
        boolean acquireValue = atomicBoolean.getAcquire();
        System.out.println("[getAcquire] Value: " + acquireValue);
    }

    public void getOpaque() {
        boolean opaqueValue = atomicBoolean.getOpaque();
        System.out.println("[getOpaque] Value: " + opaqueValue);
    }

    public void getPlain() {
        boolean plainValue = atomicBoolean.getPlain();
        System.out.println("[getPlain] Value: " + plainValue);
    }

    public void weakCompareAndSet() {
        boolean updated = atomicBoolean.weakCompareAndSet(false, true);
        System.out.println("[weakCompareAndSet] Updated? " + updated);
        System.out.println("[weakCompareAndSet] Current value: " + atomicBoolean.get());
    }

    public void weakCompareAndSetAcquire() {
        boolean updated = atomicBoolean.weakCompareAndSetAcquire(true, false);
        System.out.println("[weakCompareAndSetAcquire] Updated? " + updated);
        System.out.println("[weakCompareAndSetAcquire] Current value: " + atomicBoolean.get());
    }

    public void weakCompareAndSetPlain() {
        boolean updated = atomicBoolean.weakCompareAndSetPlain(false, true);
        System.out.println("[weakCompareAndSetPlain] Updated? " + updated);
        System.out.println("[weakCompareAndSetPlain] Current value: " + atomicBoolean.get());
    }

    public void weakCompareAndSetRelease() {
        boolean updated = atomicBoolean.weakCompareAndSetRelease(true, false);
        System.out.println("[weakCompareAndSetRelease] Updated? " + updated);
        System.out.println("[weakCompareAndSetRelease] Current value: " + atomicBoolean.get());
    }

    public void weakCompareAndSetVolatile() {
        boolean updated = atomicBoolean.weakCompareAndSetVolatile(false, true);
        System.out.println("[weakCompareAndSetVolatile] Updated? " + updated);
        System.out.println("[weakCompareAndSetVolatile] Current value: " + atomicBoolean.get());
    }

    public void setOpaque() {
        atomicBoolean.setOpaque(false);
        System.out.println("[setOpaque] Current value: " + atomicBoolean.get());
    }

    public void setPlain() {
        atomicBoolean.setPlain(true);
        System.out.println("[setPlain] Current value: " + atomicBoolean.get());
    }

    public void setRelease() {
        atomicBoolean.setRelease(false);
        System.out.println("[setRelease] Current value: " + atomicBoolean.get());
    }
}
