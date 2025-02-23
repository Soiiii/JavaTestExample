
import java.io.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.nio.charset.StandardCharsets;

public class ZipInputStreamTest {
    private ZipInputStream zipInputStream;

    public ZipInputStreamTest(String zipFilePath) {
        try {
            FileInputStream fis = new FileInputStream(zipFilePath);
            this.zipInputStream = new ZipInputStream(fis);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Read all bytes from the current entry
    public void readAllBytes() {
        try {
            ZipEntry entry = zipInputStream.getNextEntry();
            if (entry != null) {
                byte[] allBytes = zipInputStream.readAllBytes();
                System.out.println("readAllBytes() called. Data: " + new String(allBytes, StandardCharsets.UTF_8));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Read N bytes from the current entry
    public void readNBytes(int n) {
        try {
            ZipEntry entry = zipInputStream.getNextEntry();
            if (entry != null) {
                byte[] nBytes = zipInputStream.readNBytes(n);
                System.out.println("readNBytes(int) called. Data: " + new String(nBytes, StandardCharsets.UTF_8));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Read a single byte
    public void readSingleByte() {
        try {
            ZipEntry entry = zipInputStream.getNextEntry();
            if (entry != null) {
                int singleByte = zipInputStream.read();
                System.out.println("read() called. Byte: " + singleByte);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Read N bytes into a buffer with offset and length
    public void readNBytesWithBuffer(int bufferSize, int offset, int length) {
        try {
            ZipEntry entry = zipInputStream.getNextEntry();
            if (entry != null) {
                byte[] buffer = new byte[bufferSize];
                int bytesRead = zipInputStream.readNBytes(buffer, offset, length);
                System.out.println("readNBytes(byte[], int, int) called. Bytes read: " + bytesRead);
                System.out.println("Data: " + new String(buffer, offset, bytesRead, StandardCharsets.UTF_8));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void close() {
        try {
            zipInputStream.close();
            System.out.println("ZipInputStream closed.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
//        String zipFilePath = "/Users/baeksoyoung/Downloads/output.zip";
        String zipFilePath = "/Users/baeksoyoung/Downloads";
// String zipFilePath = "/home/soyoung.baek/Downloads/test_file.zip";
        File file = new File(zipFilePath);
        if (!file.exists()) {
            System.err.println("Error: File " + zipFilePath + " does not exist!");
            return;
        }
        System.out.println("File Exists.");

        ZipInputStreamTest zipTest = new ZipInputStreamTest(zipFilePath);
        zipTest.readAllBytes();
        zipTest.readNBytes(10);
        zipTest.readSingleByte();
        zipTest.readNBytesWithBuffer(1024, 0, 20);
        zipTest.close();
    }

//    public static void main(String[] args) {
//        String directoryPath = "/home/soyoung.baek/Downloads";
//        String zipFilePath = directoryPath + "/test_file.zip";
//
//        // Check if ZIP file exists before reading
//        File zipFile = new File(zipFilePath);
//        if (!zipFile.exists()) {
//            System.err.println("Error: ZIP file does not exist -> " + zipFilePath);
//            return;
//        }
//
//        try (
//                FileInputStream fis = new FileInputStream(zipFilePath);
//                ZipInputStream zis = new ZipInputStream(fis, StandardCharsets.UTF_8)) {
//
//            ZipEntry entry;
//            while ((entry = zis.getNextEntry()) != null) {
//                System.out.println("Reading Entry: " + entry.getName());
//
//                byte[] fileContent = zis.readAllBytes();
//                String content = new String(fileContent, StandardCharsets.UTF_8);
//
//                System.out.println("File Content: " + content);
//
//                zis.closeEntry();
//            }
//
//            System.out.println("ZIP file reading completed.");
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }


}
