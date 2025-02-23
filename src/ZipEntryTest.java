import java.time.LocalDateTime;
import java.util.zip.ZipEntry;

public class ZipEntryTest {

    public static void main(String[] args) {

        ZipEntryTest test = new ZipEntryTest();
        test.setTimeLocalExample();
        test.getTimeLocalExample();
    }

        // Method to set time using LocalDateTime
        public void setTimeLocalExample () {
        try {
            // Create a ZIP entry
            ZipEntry entry = new ZipEntry("example.txt");

            // Set time using LocalDateTime
            LocalDateTime now = LocalDateTime.now();
            entry.setTimeLocal(now);

            // Print the set time
            System.out.println("setTimeLocal(LocalDateTime) called. Time set: " + now);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

        // Method to get time using LocalDateTime
        public void getTimeLocalExample () {
//        try {
//            // Create a ZIP entry
//            ZipEntry entry = new ZipEntry("example.txt");
//
//            // Set an initial time
//            LocalDateTime initialTime = LocalDateTime.of(2024, 2, 19, 15, 30);
//            entry.setTimeLocal(initialTime);
//
//            // Get the time using getTimeLocal()
//            LocalDateTime retrievedTime = entry.getTimeLocal();
//            System.out.println("getTimeLocal() called. Retrieved time: " + retrievedTime);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
            ZipEntry entry = new ZipEntry("example.txt");
            LocalDateTime time = LocalDateTime.of(2025, 2, 19, 15, 30); // Ensure valid month
            entry.setTimeLocal(time);
            System.out.println("Stored LocalDateTime: " + entry.getTimeLocal());

        }


//    public static void main(String[] args) {
//
//        ZipEntry entry = new ZipEntry("example.txt");
//
//        long currentTimeMillis = System.currentTimeMillis();
//        entry.setTime(currentTimeMillis);
//
//        LocalDateTime localDateTime = entry.getTimeLocal();
//
//        System.out.println("Zip Entry Name: " + entry.getName());
//        System.out.println("Timestamp (milliseconds): " + currentTimeMillis);
//        System.out.println("LocalDateTime: " + localDateTime);
//    }




    // sample 1
//    public static void main(String[] args) {
//        String directoryPath = "/Users/baeksoyoung/Downloads";
//        String zipFilePath = directoryPath + "/output.zip";
//
//        // Create directory if it does not exist
//        File dir = new File(directoryPath);
//        if (!dir.exists()) {
//            dir.mkdirs();  // Creates the directory and all necessary parent directories
//        }
//
//        try (FileOutputStream fos = new FileOutputStream(zipFilePath);
//             ZipOutputStream zos = new ZipOutputStream(fos)) {
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

        // use
//        ZipEntry entry = new ZipEntry("example.txt");
//        long currentTimeMillis = System.currentTimeMillis();
//        entry.setTime(currentTimeMillis);
//        LocalDateTime localDateTime = entry.getTimeLocal();
//        System.out.println("Zip Entry Name: " + entry.getName());
//        System.out.println("Timestamp (milliseconds): " + currentTimeMillis);
//        System.out.println("LocalDateTime: " + localDateTime);

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
