import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.Module;
import java.net.URL;
import java.util.Enumeration;
import java.util.Optional;
import java.util.stream.Stream;

public class ClassLoaderTest {
    public static void main(String[] args) {

        ClassLoaderTest test = new ClassLoaderTest();
//        test.getResource();
//        test.getResources();
//        test.getResourceAsStream();
        test.getClassLoaderName();
        test.checkParallelCapable();
//        test.getUnnamedModule();
//        test.getDefinedPackage();
//        test.getDefinedPackages();
//        test.getPlatformClassLoader();
//        test.findResources();

    }
    public void getResource() {
        ClassLoader classLoader = ClassLoaderTest.class.getClassLoader();
        URL resourceUrl = classLoader.getResource("sample.txt");

        if (resourceUrl != null) {
            System.out.println("Resource found: " + resourceUrl);
        } else {
            System.out.println("Resource not found!");
        }
    }

    public void getResources() {
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

    public void getResourceAsStream() {
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

    // 3. isRegisteredAsParallelCapable()
    public void checkParallelCapable() {
        ClassLoader classLoader = ClassLoaderTest.class.getClassLoader();
        boolean isParallelCapable = classLoader.isRegisteredAsParallelCapable();
        System.out.println("Is registered as parallel capable: " + isParallelCapable);
    }

    // 4. getUnnamedModule()
    public void getUnnamedModule() {
        ClassLoader classLoader = ClassLoaderTest.class.getClassLoader();
        Module unnamedModule = classLoader.getUnnamedModule();
        System.out.println("Unnamed Module: " + unnamedModule.getName());
    }

    // 5. getDefinedPackage(String arg0)
    public void getDefinedPackage() {
        ClassLoader classLoader = ClassLoaderTest.class.getClassLoader();
        Package pkg = classLoader.getDefinedPackage("java.lang");
        if (pkg != null) {
            System.out.println("Defined package: " + pkg.getName());
        } else {
            System.out.println("Package not found!");
        }
    }

    // 6. getDefinedPackages()
    public void getDefinedPackages() {
        ClassLoader classLoader = ClassLoaderTest.class.getClassLoader();
        Package[] packages = classLoader.getDefinedPackages();
        System.out.println("Defined Packages:");
        for (Package pkg : packages) {
            System.out.println(pkg.getName());
        }
    }

    // 7. getPlatformClassLoader()
    public void getPlatformClassLoader() {
        ClassLoader platformClassLoader = ClassLoader.getPlatformClassLoader();
        System.out.println("Platform ClassLoader: " + platformClassLoader);
    }

    // 8. resources(String name)
    public void findResources() {
        ClassLoader classLoader = ClassLoaderTest.class.getClassLoader();
        Stream<URL> resourceStream = classLoader.resources("META-INF/MANIFEST.MF");

        System.out.println("Resources found:");
        resourceStream.forEach(System.out::println);
    }

    // 9. getName()
    public void getClassLoaderName() {
        ClassLoader classLoader = ClassLoaderTest.class.getClassLoader();
        Optional<String> name = Optional.ofNullable(classLoader.getName());
        System.out.println("ClassLoader Name: " + name.orElse("Unnamed ClassLoader"));
    }
}
