import java.io.*;
import java.nio.charset.Charset;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Stream;

public class ProcessTest {
    public static void main(String[] args) {
        try {
            Process process = new ProcessBuilder("echo", "Hello, World!").start();
            ProcessTest processTest = new ProcessTest(process);

            System.out.println("PID: " + processTest.pid());
            System.out.println("Process Handle: " + processTest.toHandle());
            System.out.println("Process Info: " + processTest.info());

            BufferedReader reader = processTest.inputReader();
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println("Output: " + line);
            }

            process.waitFor();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }


    private final Process process;

    public ProcessTest(Process process) {
        this.process = process;
    }

    public boolean supportsNormalTermination() {
        throw new UnsupportedOperationException(this.getClass() + ".supportsNormalTermination() not supported");
    }

    public CompletableFuture<Process> onExit() {
        return process.onExit();
    }

    public final BufferedReader errorReader() {
        return new BufferedReader(new InputStreamReader(process.getErrorStream()));
    }

    public final BufferedReader errorReader(Charset charset) {
        return new BufferedReader(new InputStreamReader(process.getErrorStream(), charset));
    }

    public final BufferedReader inputReader() {
        return new BufferedReader(new InputStreamReader(process.getInputStream()));
    }

    public final BufferedReader inputReader(Charset charset) {
        return new BufferedReader(new InputStreamReader(process.getInputStream(), charset));
    }

    public final BufferedWriter outputWriter() {
        return new BufferedWriter(new OutputStreamWriter(process.getOutputStream()));
    }

    public final BufferedWriter outputWriter(Charset charset) {
        return new BufferedWriter(new OutputStreamWriter(process.getOutputStream(), charset));
    }

    public ProcessHandle.Info info() {
        return process.info();
    }

    public long pid() {
        return process.pid();
    }

    public ProcessHandle toHandle() {
        return process.toHandle();
    }

    public Stream<ProcessHandle> children() {
        return process.children();
    }

    public Stream<ProcessHandle> descendants() {
        return process.descendants();
    }
}