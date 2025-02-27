import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Enumeration;

public class ClassLoaderTest {
    public void testGetResource() {
        ClassLoader classLoader = ClassLoaderTest.class.getClassLoader();
        URL resourceUrl = classLoader.getResource("sample.txt");

        if (resourceUrl != null) {
            System.out.println("Resource found: " + resourceUrl);
        } else {
            System.out.println("Resource not found!");
        }
    }

    public void testGetResources() {
        ClassLoader classLoader = ClassLoaderTest.class.getClassLoader();
        try {
            Enumeration<URL> resources = classLoader.getResources("config.properties");

            if (resources.hasMoreElements()) {
                System.out.println("Found resources:");
                while (resources.hasMoreElements()) {
                    System.out.println(resources.nextElement());
                }
            } else {
                System.out.println("No resources found!");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void testGetResourceAsStream() {
        ClassLoader classLoader = ClassLoaderTest.class.getClassLoader();
        try (InputStream inputStream = classLoader.getResourceAsStream("sample.txt")) {
            if (inputStream == null) {
                System.out.println("Resource not found!");
                return;
            }

            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            String line;
            System.out.println("Reading resource content:");
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        ClassLoaderTest test = new ClassLoaderTest();
        test.testGetResource();
        test.testGetResources();
        test.testGetResourceAsStream();
    }
}
