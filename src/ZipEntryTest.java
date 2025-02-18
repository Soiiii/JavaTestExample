import java.time.LocalDateTime;
import java.util.zip.ZipEntry;

public class ZipEntryTest {

    public static void main(String[] args) {

        ZipEntry entry = new ZipEntry("example.txt");

        long currentTimeMillis = System.currentTimeMillis();
        entry.setTime(currentTimeMillis);

        LocalDateTime localDateTime = entry.getTimeLocal();

        System.out.println("Zip Entry Name: " + entry.getName());
        System.out.println("Timestamp (milliseconds): " + currentTimeMillis);
        System.out.println("LocalDateTime: " + localDateTime);
    }
//    public static void main(String[] args) {
//        ZipEntry entry = new ZipEntry("example.txt");
//
//        // Set time
//        entry.setTime(System.currentTimeMillis());
//        System.out.println("Entry:" + entry);
//
//        // Get LocalDateTime
//        LocalDateTime time = getTimeLocal(entry);
//        System.out.println("Local Time: " + time);
//    }




    // sample 1
//    public static void main(String[] args) {
//        String zipFileName = "output.zip";
//
//        try (FileOutputStream fos = new FileOutputStream(zipFileName); ZipOutputStream zos = new ZipOutputStream(fos)) {
//            ZipEntry entry = new ZipEntry("example.txt");
//            entry.setTime(System.currentTimeMillis());
//            zos.putNextEntry(entry);
//            zos.write("zip file".getBytes());
//            zos.closeEntry();
//
//            System.out.println("ZIP File Created: " + zipFileName);
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }


    // sample 2
//    public static void main(String[] args) {
//        try (ByteArrayOutputStream baos = new ByteArrayOutputStream();
//             ZipOutputStream zos = new ZipOutputStream(baos)) {
//
//            ZipEntry entry = new ZipEntry("example.txt");
//            entry.setTime(System.currentTimeMillis());
//            zos.putNextEntry(entry);
//            zos.write("zip file content".getBytes());
//            zos.closeEntry();
//
//            System.out.println("ZIP file created in memory!");
//
//            byte[] zipBytes = baos.toByteArray();
//            System.out.println("ZIP Size: " + zipBytes.length + " bytes");
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
}
