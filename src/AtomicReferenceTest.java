import java.util.concurrent.atomic.AtomicReference;
import java.util.function.BinaryOperator;
import java.util.function.UnaryOperator;

public class AtomicReferenceTest {
    public static void main(String[] args) {
        System.out.println("=== AtomicReference Comprehensive Test ===\n");
        AtomicReferenceTest test = new AtomicReferenceTest();
        test.run();
    }

    public void run(){
        testBasicOperations();
        testCompareAndSet();
        testCompareAndExchange();
        testCompareAndExchangeAcquire();
        testCompareAndExchangeRelease();
        testGetAndSet();
        testGetAndUpdate();
        testUpdateAndGet();
        testGetAndAccumulate();
        testAccumulateAndGet();
        testGetVariants();
        testSetVariants();
        testWeakCompareAndSetVariants();
        testToString();
        testLazySet();

        System.out.println("\n=== All Tests Complete ===");
    }

    public void testBasicOperations() {
        System.out.println("--- Test 1: Basic Operations ---");

        // Constructor with no argument
        AtomicReference<String> ref1 = new AtomicReference<>();
        System.out.println("Default value: " + ref1.toString());

        // Constructor with initial value
        AtomicReference<String> ref2 = new AtomicReference<>("Initial");
        System.out.println("Initial value: " + ref2.get());

        // Set
        ref2.set("Updated");
        System.out.println("After set: " + ref2.get());

        System.out.println();
    }

    public void testCompareAndSet() {
        System.out.println("--- Test 2: CompareAndSet ---");

        AtomicReference<String> ref = new AtomicReference<>("Initial");

        // Successful CAS
        boolean success1 = ref.compareAndSet("Initial", "Updated");
        System.out.println("CAS (expect Initial): " + success1);
        System.out.println("Current value: " + ref.get());

        // Failed CAS
        boolean success2 = ref.compareAndSet("Initial", "Another");
        System.out.println("CAS (expect Initial again): " + success2);
        System.out.println("Current value: " + ref.get());

        System.out.println();
    }

    public void testCompareAndExchange() {
        System.out.println("--- Test 3: CompareAndExchange ---");

        AtomicReference<String> ref = new AtomicReference<>("Initial");

        // Successful exchange
        String prev1 = ref.compareAndExchange("Initial", "Updated");
        System.out.println("Previous value (expect match): " + prev1);
        System.out.println("Current value: " + ref.get());

        // Failed exchange
        String prev2 = ref.compareAndExchange("Initial", "Another");
        System.out.println("Previous value (no match): " + prev2);
        System.out.println("Current value: " + ref.get());

        System.out.println();
    }

    public void testCompareAndExchangeAcquire() {
        System.out.println("--- Test 4: CompareAndExchangeAcquire ---");

        AtomicReference<String> ref = new AtomicReference<>("Initial");
        String previousValue = ref.compareAndExchangeAcquire("Initial", "Updated-Acquire");
        System.out.println("Previous value: " + previousValue);
        System.out.println("Current value: " + ref.get());

        System.out.println();
    }

    public void testCompareAndExchangeRelease() {
        System.out.println("--- Test 5: CompareAndExchangeRelease ---");

        AtomicReference<String> ref = new AtomicReference<>("Initial");
        String previousValue = ref.compareAndExchangeRelease("Initial", "Updated-Release");
        System.out.println("Previous value: " + previousValue);
        System.out.println("Current value: " + ref.get());

        System.out.println();
    }

    public void testGetAndSet() {
        System.out.println("--- Test 6: GetAndSet ---");

        AtomicReference<String> ref = new AtomicReference<>("Initial");
        String previous = ref.getAndSet("Updated");
        System.out.println("Previous value: " + previous);
        System.out.println("Current value: " + ref.get());

        System.out.println();
    }

    public void testGetAndUpdate() {
        System.out.println("--- Test 7: GetAndUpdate ---");

        AtomicReference<Integer> ref = new AtomicReference<>(10);

        // UnaryOperator that doubles the value
        UnaryOperator<Integer> doubler = x -> x * 2;

        Integer previous = ref.getAndUpdate(doubler);
        System.out.println("Previous value: " + previous);
        System.out.println("Current value: " + ref.get());

        // Chain multiple updates
        ref.getAndUpdate(x -> x + 5);
        System.out.println("After adding 5: " + ref.get());

        System.out.println();
    }

    public void testUpdateAndGet() {
        System.out.println("--- Test 8: UpdateAndGet ---");

        AtomicReference<Integer> ref = new AtomicReference<>(10);

        // UnaryOperator that triples the value
        UnaryOperator<Integer> tripler = x -> x * 3;

        Integer newValue = ref.updateAndGet(tripler);
        System.out.println("New value (returned): " + newValue);
        System.out.println("Current value: " + ref.get());

        // Chain multiple updates
        ref.updateAndGet(x -> x - 10);
        System.out.println("After subtracting 10: " + ref.get());

        System.out.println();
    }

    public void testGetAndAccumulate() {
        System.out.println("--- Test 9: GetAndAccumulate ---");

        AtomicReference<Integer> ref = new AtomicReference<>(100);

        // BinaryOperator that adds two values
        BinaryOperator<Integer> adder = (x, y) -> x + y;

        Integer previous = ref.getAndAccumulate(50, adder);
        System.out.println("Previous value: " + previous);
        System.out.println("Current value (100 + 50): " + ref.get());

        // Try with multiplication
        BinaryOperator<Integer> multiplier = (x, y) -> x * y;
        previous = ref.getAndAccumulate(2, multiplier);
        System.out.println("Previous value: " + previous);
        System.out.println("Current value (150 * 2): " + ref.get());

        System.out.println();
    }

    public void testAccumulateAndGet() {
        System.out.println("--- Test 10: AccumulateAndGet ---");

        AtomicReference<Integer> ref = new AtomicReference<>(100);

        // BinaryOperator that subtracts
        BinaryOperator<Integer> subtractor = (x, y) -> x - y;

        Integer newValue = ref.accumulateAndGet(30, subtractor);
        System.out.println("New value (returned): " + newValue);
        System.out.println("Current value (100 - 30): " + ref.get());

        // Try with max function
        BinaryOperator<Integer> maxOp = (x, y) -> Math.max(x, y);
        newValue = ref.accumulateAndGet(50, maxOp);
        System.out.println("After max(70, 50): " + newValue);

        System.out.println();
    }

    public void testGetVariants() {
        System.out.println("--- Test 11: Get Variants ---");

        AtomicReference<String> ref = new AtomicReference<>("TestValue");

        System.out.println("get(): " + ref.get());
        System.out.println("getAcquire(): " + ref.getAcquire());
        System.out.println("getOpaque(): " + ref.getOpaque());
        System.out.println("getPlain(): " + ref.getPlain());

        System.out.println();
    }

    public void testSetVariants() {
        System.out.println("--- Test 12: Set Variants ---");

        AtomicReference<String> ref = new AtomicReference<>("Initial");
        System.out.println("Initial: " + ref.get());

        ref.setOpaque("Updated-Opaque");
        System.out.println("After setOpaque: " + ref.get());

        ref.setPlain("Updated-Plain");
        System.out.println("After setPlain: " + ref.get());

        ref.setRelease("Updated-Release");
        System.out.println("After setRelease: " + ref.get());

        System.out.println();
    }

    public void testWeakCompareAndSetVariants() {
        System.out.println("--- Test 13: WeakCompareAndSet Variants ---");

        // weakCompareAndSet (deprecated but still works)
        AtomicReference<String> ref1 = new AtomicReference<>("Initial");
        boolean updated1 = ref1.weakCompareAndSet("Initial", "Updated");
        System.out.println("weakCompareAndSet: " + updated1 + ", value: " + ref1.get());

        // weakCompareAndSetAcquire
        AtomicReference<String> ref2 = new AtomicReference<>("Initial");
        boolean updated2 = ref2.weakCompareAndSetAcquire("Initial", "Updated-Acquire");
        System.out.println("weakCompareAndSetAcquire: " + updated2 + ", value: " + ref2.get());

        // weakCompareAndSetPlain
        AtomicReference<String> ref3 = new AtomicReference<>("Initial");
        boolean updated3 = ref3.weakCompareAndSetPlain("Initial", "Updated-Plain");
        System.out.println("weakCompareAndSetPlain: " + updated3 + ", value: " + ref3.get());

        // weakCompareAndSetRelease
        AtomicReference<String> ref4 = new AtomicReference<>("Initial");
        boolean updated4 = ref4.weakCompareAndSetRelease("Initial", "Updated-Release");
        System.out.println("weakCompareAndSetRelease: " + updated4 + ", value: " + ref4.get());

        // weakCompareAndSetVolatile
        AtomicReference<String> ref5 = new AtomicReference<>("Initial");
        boolean updated5 = ref5.weakCompareAndSetVolatile("Initial", "Updated-Volatile");
        System.out.println("weakCompareAndSetVolatile: " + updated5 + ", value: " + ref5.get());

        System.out.println();
    }

    public void testToString() {
        System.out.println("--- Test 14: ToString ---");

        AtomicReference<String> ref1 = new AtomicReference<>("Hello");
        System.out.println("toString() with String: " + ref1.toString());

        AtomicReference<Integer> ref2 = new AtomicReference<>(42);
        System.out.println("toString() with Integer: " + ref2.toString());

        AtomicReference<Object> ref3 = new AtomicReference<>(null);
        System.out.println("toString() with null: " + ref3.toString());

        System.out.println();
    }

    public void testLazySet() {
        System.out.println("--- Test 15: LazySet ---");

        AtomicReference<String> ref = new AtomicReference<>("Initial");
        System.out.println("Before lazySet: " + ref.get());

        ref.lazySet("Lazy-Updated");
        System.out.println("After lazySet: " + ref.get());

        System.out.println();
    }

    // Additional complex scenarios
    public void testComplexScenarios() {
        System.out.println("--- Test 16: Complex Scenarios ---");

        // Counter with atomic updates
        AtomicReference<Integer> counter = new AtomicReference<>(0);
        for (int i = 0; i < 5; i++) {
            counter.updateAndGet(x -> x + 1);
        }
        System.out.println("Counter after 5 increments: " + counter.get());

        // String concatenation
        AtomicReference<String> text = new AtomicReference<>("Start");
        text.updateAndGet(s -> s + "-Middle");
        text.updateAndGet(s -> s + "-End");
        System.out.println("Text after concatenations: " + text.get());

        // Conditional update with accumulate
        AtomicReference<Integer> value = new AtomicReference<>(10);
        BinaryOperator<Integer> safeDivider = (x, y) -> y != 0 ? x / y : x;
        value.accumulateAndGet(2, safeDivider);
        System.out.println("After safe division by 2: " + value.get());

        System.out.println();
    }
}
