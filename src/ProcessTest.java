import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.stream.Stream;

public class ProcessTest {

        public static void main(String[] args) {
        try {
            Process process = new ProcessBuilder("ping", "-c", "4", "google.com").start();

            System.out.println("Process PID: " + process.pid());
            System.out.println("Supports Normal Termination? " + process.supportsNormalTermination());

            // Get process info
            ProcessHandle.Info info = process.info();
            System.out.println("Process Info: " + info);

            // Handle input, error, and output streams
            BufferedReader inputReader = process.inputReader();
            BufferedReader errorReader = process.errorReader();
            BufferedWriter outputWriter = process.outputWriter();

            // Read process output
            System.out.println("\n--- Process Output ---");
            inputReader.lines().forEach(System.out::println);

            // Read process error (if any)
            System.out.println("\n--- Process Error Output ---");
            errorReader.lines().forEach(System.out::println);

            // ProcessHandle and process relationships
            ProcessHandle processHandle = process.toHandle();
            System.out.println("Process Handle: " + processHandle);
            Stream<ProcessHandle> children = processHandle.children();
            Stream<ProcessHandle> descendants = processHandle.descendants();

            // Printing child processes
            System.out.println("\nChild Processes:");
            children.forEach(p -> System.out.println("Child PID: " + p.pid()));

            // Printing descendant processes
            System.out.println("\nDescendant Processes:");
            descendants.forEach(p -> System.out.println("Descendant PID: " + p.pid()));

            // Asynchronous process exit handling
            process.onExit().thenRun(() -> System.out.println("Process has exited."));

            // Wait for process to finish
            process.waitFor();
            System.out.println("Exit Value: " + process.exitValue());

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

}