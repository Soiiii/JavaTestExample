import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.zip.Deflater;
import java.util.zip.Inflater;

public class Deflater_Inflater_Test {

    public static void main(String[] args) {

        try {
            String originalText = "This is a test text for compression in Java!";
            byte[] originalData = originalText.getBytes(StandardCharsets.UTF_8);
            System.out.println("Original size: " + originalData.length + " bytes");
            System.out.println("Original text: " + originalText);

            Deflater deflater = new Deflater();
            deflater.setInput(originalData);
            deflater.finish();

            byte[] compressedData = new byte[1024];
            int compressedSize = deflater.deflate(compressedData);
            deflater.end();
            System.out.println("Compressed size: " + compressedSize + " bytes");
            System.out.println("Compressed data (hex): " + Arrays.toString(Arrays.copyOf(compressedData, compressedSize)));

            System.out.print("Compressed data (hex): ");
            for (int i = 0; i < compressedSize; i++) {
                System.out.printf("%02X ", compressedData[i]);
            }
            System.out.println();

            Inflater inflater = new Inflater();
            inflater.setInput(compressedData, 0, compressedSize);

            byte[] decompressedData = new byte[1024];
            int decompressedSize = inflater.inflate(decompressedData);
            inflater.end();

            if (decompressedSize == 0) {
                System.out.println("Inflater failed: " + inflater.getRemaining() + " bytes remaining, finished: " + inflater.finished());
            }

            String decompressedText = new String(decompressedData, 0, decompressedSize, StandardCharsets.UTF_8);
            System.out.println("Decompressed size: " + decompressedSize + " bytes");
            System.out.println("Decompressed text: " + decompressedText);

            if (originalText.equals(decompressedText)) {
                System.out.println("Test successful: the data was compressed and decompressed correctly!");
            } else {
                System.out.println("Error: the decompressed data does not match the original!");
            }

        } catch (Exception e) {
            System.err.println("Error during the test: " + e.getMessage());
            e.printStackTrace();
        }    }

}
