package psc_tc_j_java_util;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class ZipOutputStreamTest {

//    public static void main(String[] args) {
//        String directoryPath = "/home/soyoung.baek/Downloads";
//        String zipFilePath = directoryPath + "/output.zip";
//
//        File dir = new File(directoryPath);
//        if (!dir.exists()) {
//            dir.mkdirs();
//        }
//
//        try (
//            FileOutputStream fos = new FileOutputStream(zipFilePath);
//            ZipOutputStream zos = new ZipOutputStream(fos)) {
//
//            ZipEntry entry = new ZipEntry("example.txt");
//            entry.setTime(System.currentTimeMillis());
//            zos.putNextEntry(entry);
//            zos.write("zip file".getBytes());
//            zos.closeEntry();
//
//            System.out.println("ZIP File Created at: " + zipFilePath);
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }




//    public static void main(String[] args) {
////            String zipFileName = "/Users/baeksoyoung/Downloads/output.zip";
//        String zipFileName = "output.zip";
//
//
//        try (FileOutputStream fos = new FileOutputStream(zipFileName);
//             ZipOutputStream zos = new ZipOutputStream(fos)) {
//
//            // First ZIP entry: file1.txt
//            ZipEntry entry1 = new ZipEntry("file1.txt");
//            zos.putNextEntry(entry1);
//            // Create a new writer for this entry
//            OutputStreamWriter writer1 = new OutputStreamWriter(zos, StandardCharsets.UTF_8);
//            writer1.write("Hello, this is file1 content written with a writer!");
//            // Flush to ensure data is written out; do not close the writer
//            writer1.flush();
//            zos.closeEntry();
//
//            // Second ZIP entry: file2.txt
//            ZipEntry entry2 = new ZipEntry("file2.txt");
//            zos.putNextEntry(entry2);
//            // Create a new writer for the new entry
//            OutputStreamWriter writer2 = new OutputStreamWriter(zos, StandardCharsets.UTF_8);
//            writer2.write("This is file2 content written with a writer!");
//            writer2.flush();
//            zos.closeEntry();
//
//            System.out.println("ZIP file created successfully: " + zipFileName);
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }





public static void main(String[] args) {
    ZipOutputStreamTest zipTest = new ZipOutputStreamTest();
    byte[] zipData = zipTest.createZipInMemory();
    System.out.println("ZIP data created in memory. Size: " + zipData.length + " bytes");
}

    public byte[] createZipInMemory() {
        try (ByteArrayOutputStream baos = new ByteArrayOutputStream();
             ZipOutputStream zos = new ZipOutputStream(baos)) {

            // First ZIP entry: file1.txt
            ZipEntry entry1 = new ZipEntry("file1.txt");
            zos.putNextEntry(entry1);
            OutputStreamWriter writer1 = new OutputStreamWriter(zos, StandardCharsets.UTF_8);
            writer1.write("Hello, this is file1 content written with a writer!");
            writer1.flush();
            zos.closeEntry();

            // Second ZIP entry: file2.txt
            ZipEntry entry2 = new ZipEntry("file2.txt");
            zos.putNextEntry(entry2);
            OutputStreamWriter writer2 = new OutputStreamWriter(zos, StandardCharsets.UTF_8);
            writer2.write("This is file2 content written with a writer!");
            writer2.flush();
            zos.closeEntry();

            // Ensure all data is written
            zos.finish();

            byte[] zipBytes = baos.toByteArray();
            System.out.println("Created in-memory ZIP file with " + zipBytes.length + " bytes.");

            // Write the in-memory ZIP bytes to a file
            Files.write(Paths.get("/home/soyoung.baek/Downloads/output.zip"), zipBytes);
            System.out.println("ZIP file written to: " + Paths.get("output.zip").toAbsolutePath());

            return baos.toByteArray();

        } catch (IOException e) {
            e.printStackTrace();
            return new byte[0]; // Return empty array on failure
        }
    }



}
