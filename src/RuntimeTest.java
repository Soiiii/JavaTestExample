public class RuntimeTest {
    public static void main(String[] args) {
        Runtime.Version version = Runtime.version();
        System.out.println("Java Runtime Version: " + version);
        System.out.println("Major Version: " + version.feature());
        System.out.println("Minor Version: " + version.interim());
        System.out.println("Security Patch: " + version.update());
        System.out.println("Build Number: " + version.build().orElse(-1));
    }
}
