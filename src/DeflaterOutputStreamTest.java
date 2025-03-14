import java.io.*;
import java.util.zip.*;

public class DeflaterOutputStreamTest {
    public static void main(String[] args) {
        try {
            // 1. 압축할 데이터 준비
            String text = "Hello, DeflaterOutputStream! This is a compression test.";
            byte[] input = text.getBytes("UTF-8"); // UTF-8 인코딩 명시적으로 지정
            System.out.println("Original Data: " + text);
            System.out.println("Original Data Size: " + input.length + " bytes");

            // 2. DeflaterOutputStream을 사용하여 압축
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            Deflater deflater = new Deflater(Deflater.BEST_COMPRESSION, true); // nowrap=true -> GZIP 헤더 제거
            DeflaterOutputStream deflaterOutputStream = new DeflaterOutputStream(
                    byteArrayOutputStream, deflater
            );

            deflaterOutputStream.write(input);  // 데이터를 압축 스트림에 기록
            deflaterOutputStream.finish(); // ✅ 압축을 확실히 마무리
            deflaterOutputStream.close(); // 스트림 닫기

            // 3. 압축된 데이터 확인
            byte[] compressedData = byteArrayOutputStream.toByteArray();
            System.out.println("Compressed Data Size: " + compressedData.length + " bytes");

            // 4. InflaterInputStream을 사용하여 압축 해제
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(compressedData);
            Inflater inflater = new Inflater(true); // ✅ Deflater에서 nowrap=true 설정했으므로 동일하게 맞춤
            InflaterInputStream inflaterInputStream = new InflaterInputStream(byteArrayInputStream, inflater);

            ByteArrayOutputStream decompressedOutputStream = new ByteArrayOutputStream();
            byte[] buffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = inflaterInputStream.read(buffer)) != -1) {
                decompressedOutputStream.write(buffer, 0, bytesRead);
            }

            inflaterInputStream.close();
            decompressedOutputStream.close();

            // 5. 압축 해제된 문자열 출력
            String decompressedText = new String(decompressedOutputStream.toByteArray(), "UTF-8"); // UTF-8 디코딩
            System.out.println("Decompressed Data: " + decompressedText);

            // 6. 압축 전후 데이터 비교
            boolean isEqual = text.equals(decompressedText);
            System.out.println("Original Data Equals Decompressed Data? " + isEqual);

            if (!isEqual) {
                System.err.println("🚨 압축 해제 후 데이터가 원본과 다릅니다! 🚨");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
