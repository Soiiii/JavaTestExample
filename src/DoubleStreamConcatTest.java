import java.util.stream.DoubleStream;

public class DoubleStreamConcatTest {
    public static void main(String[] args) {
        // Initial value (seed)
        DoubleStream stream1 = DoubleStream.of(1.0, 2.0, 3.0);

        // 두 번째 DoubleStream 생성
        DoubleStream stream2 = DoubleStream.of(4.0, 5.0, 6.0);

        // DoubleStream.concat을 이용하여 두 스트림 병합
        DoubleStream concatenatedStream = DoubleStream.concat(stream1, stream2);

        // 결과 출력
        System.out.println("Concatenated Stream:");
        concatenatedStream.forEach(System.out::println);

        // 결과 검증 (배열로 변환하여 확인)
        double[] expected = {1.0, 2.0, 3.0, 4.0, 5.0, 6.0};
        double[] result = DoubleStream.concat(DoubleStream.of(1.0, 2.0, 3.0), DoubleStream.of(4.0, 5.0, 6.0)).toArray();

        boolean isCorrect = java.util.Arrays.equals(expected, result);
        System.out.println("Test Passed: " + isCorrect);

    }
}
