
import java.util.*;
import java.util.ResourceBundle.Control;

public class ResourceBundleTest {
    public static void main(String[] args) {
        Locale defaultLocale = Locale.getDefault();
        Locale korean = Locale.KOREAN;
        ClassLoader loader = ResourceBundleTest.class.getClassLoader();
        Control defaultControl = Control.getControl(Control.FORMAT_DEFAULT);

        System.out.println("1. getBundle(String baseName)");
        ResourceBundle bundle1 = ResourceBundle.getBundle("messages");
        printBundle(bundle1);

        System.out.println("\n2. getBundle(String baseName, Locale locale)");
        ResourceBundle bundle2 = ResourceBundle.getBundle("messages", korean);
        printBundle(bundle2);

        System.out.println("\n3. getBundle(String baseName, Locale locale, ClassLoader loader)");
        ResourceBundle bundle3 = ResourceBundle.getBundle("messages", korean, loader);
        printBundle(bundle3);

        System.out.println("\n4. getBundle(String baseName, Locale locale, ResourceBundle.Control control)");
        ResourceBundle bundle4 = ResourceBundle.getBundle("messages", korean, defaultControl);
        printBundle(bundle4);

        System.out.println("\n5. getBundle(String baseName, Locale locale, ClassLoader loader, ResourceBundle.Control control)");
        ResourceBundle bundle5 = ResourceBundle.getBundle("messages", korean, loader, defaultControl);
        printBundle(bundle5);
    }

    private static void printBundle(ResourceBundle bundle) {
        try {
            String greeting = bundle.getString("greeting");
            String farewell = bundle.getString("farewell");

            System.out.println("Greeting: " + greeting);
            System.out.println("Farewell: " + farewell);
        } catch (MissingResourceException e) {
            System.out.println("Missing key: " + e.getKey());
        }
    }
}
