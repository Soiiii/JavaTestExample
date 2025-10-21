import java.time.Duration;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.temporal.ChronoUnit;
import java.time.temporal.Temporal;

public class DurationTest {
    public static void main(String[] args) {
        runAll();
    }

    public static void runAll() {
        try {
            Period period = Period.ofDays(20);
            LocalDateTime base = LocalDateTime.of(2025, 9, 24, 10, 0);

            Duration d48h = Duration.ofHours(48);
            Duration dNeg  = Duration.ofSeconds(-3, 500_000_000);

            System.out.println("d48h: " + d48h);
            System.out.println("dNeg: " + dNeg);
            System.out.println("d48h.isPositive(): " + d48h.isPositive());
            System.out.println("d48h.isZero():     " + d48h.isZero());
            System.out.println("dNeg.isNegative(): " + dNeg.isNegative());
            System.out.println("dNeg.getNano():    " + dNeg.getNano());

            Duration dCustom = d48h.withSeconds(123).withNanos(456_000_000);
            System.out.println("withSeconds(123).withNanos(456000000): " + dCustom);

            Duration dOfSecAdj = Duration.ofSeconds(1, 2_200_000_000L);
            System.out.println("ofSeconds(1, 2_200_000_000) = " + dOfSecAdj);

            System.out.println("\n=== plus / minus (TemporalUnit 포함) ===");
            System.out.println("d48h.plus(1, HOURS):   " + d48h.plus(1, java.time.temporal.ChronoUnit.HOURS));
            System.out.println("d48h.plus(24, HOURS): " + d48h.plus(24, ChronoUnit.HOURS));
            System.out.println("d48h.plusMinutes(90):  " + d48h.plusMinutes(90));
            System.out.println("d48h.plusMillis(2500): " + d48h.plusMillis(2500));
            System.out.println("d48h.plusNanos(999):   " + d48h.plusNanos(999));
            System.out.println("d48h.minus(3, HOURS):  " + d48h.minus(3, ChronoUnit.HOURS));
            System.out.println("d48h.minusSeconds(10): " + d48h.minusSeconds(10));
            System.out.println("d48h.minusMillis(1):   " + d48h.minusMillis(1));
            System.out.println("d48h.minusNanos(5):    " + d48h.minusNanos(5));

            Temporal added   = d48h.addTo(base);
            Temporal subtracted = d48h.subtractFrom(base);
            System.out.println("base:                      " + base);
            System.out.println("d48h.addTo(base):          " + added);
            System.out.println("d48h.subtractFrom(base):   " + subtracted);

            System.out.println("d48h.multipliedBy(3):      " + d48h.multipliedBy(3));
            System.out.println("d48h.dividedBy(4):         " + d48h.dividedBy(4));
            Duration twoHours = Duration.ofHours(2);
            System.out.println("d48h.dividedBy(PT2H):      " + d48h.dividedBy(twoHours));

            System.out.println("dNeg.negated():            " + dNeg.negated());
            System.out.println("dNeg.abs():                " + dNeg.abs());

            Duration sample = Duration.ofDays(2).plusHours(5).plusMinutes(7).plusSeconds(9).plusNanos(123_456_789);
            System.out.println("sample:                    " + sample);
            System.out.println("toDays():                  " + sample.toDays());
            System.out.println("toHours():                 " + sample.toHours());
            System.out.println("toMinutes():               " + sample.toMinutes());
            System.out.println("toSeconds():               " + sample.toSeconds());
            System.out.println("toMillis():                " + sample.toMillis());
            System.out.println("toNanos():                 " + sample.toNanos());
            System.out.println("toDaysPart():              " + sample.toDaysPart());
            System.out.println("toHoursPart():             " + sample.toHoursPart());
            System.out.println("toMinutesPart():           " + sample.toMinutesPart());
            System.out.println("toSecondsPart():           " + sample.toSecondsPart());
            System.out.println("toMillisPart():            " + sample.toMillisPart());
            System.out.println("toNanosPart():             " + sample.toNanosPart());

            Duration precise = Duration.ofSeconds(12, 987_654_321);
            System.out.println("precise:                   " + precise);
            System.out.println("precise.truncatedTo(SECONDS): " + precise.truncatedTo(ChronoUnit.SECONDS));

            Duration a = Duration.ofMinutes(5);
            Duration b = Duration.ofSeconds(300);
            System.out.println("a.compareTo(b):            " + a.compareTo(b));
            System.out.println("a.equals(b):               " + a.equals(b));

        } catch (Exception e) {
            System.err.println("--- Test failed ---");
            e.printStackTrace();
        }
    }
}