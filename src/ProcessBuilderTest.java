//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.stream.Collectors;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

public class ProcessBuilderTest {
//    public static Process start(String... commands) throws IOException {
//        ProcessBuilder processBuilder = new ProcessBuilder(commands);
//        processBuilder.redirectErrorStream(true);
//        return processBuilder.start();
//    }
//
//    public static List<Process> startPipeline(String[]... commandArrays) throws IOException {
//        List<Process> processes = new ArrayList<>();
//        Process prevProcess = null;
//
//        for (String[] commandArray : commandArrays) {
//            ProcessBuilder processBuilder = new ProcessBuilder(commandArray);
//            processBuilder.redirectErrorStream(true);
//
//            Process process = processBuilder.start();
//
//            if (prevProcess != null) {
//                transferStream(prevProcess, process);
//            }
//
//            processes.add(process);
//            prevProcess = process;
//        }
//        return processes;
//    }
//
//    private static void transferStream(Process from, Process to) {
//        new Thread(() -> {
//            try (BufferedReader reader = new BufferedReader(new InputStreamReader(from.getInputStream()));
//                 var writer = to.getOutputStream()) {
//                String line;
//                while ((line = reader.readLine()) != null) {
//                    writer.write((line + "\n").getBytes());
//                    writer.flush();
//                }
//            } catch (IOException ignored) {
//            }
//        }).start();
//    }
//
//    public static void printProcessOutput(Process process) throws IOException {
//        try (BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()))) {
//            String line;
//            while ((line = reader.readLine()) != null) {
//                System.out.println(line);
//            }
//        }
//    }
//
//    public static void main(String[] args) throws IOException, InterruptedException {
//        // Start a single process without List
//        Process process = start("echo", "Hello, ProcessBuilder!");
//        printProcessOutput(process);
//        process.waitFor();
//
//        // Start a pipeline without List
//        List<Process> pipelineProcesses = startPipeline(
//                new String[]{"echo", "Hello, World!"},
//                new String[]{"grep", "Hello"}
//        );
//
//        printProcessOutput(pipelineProcesses.get(pipelineProcesses.size() - 1));
//
//        for (Process p : pipelineProcesses) {
//            p.waitFor();
//        }
//    }




    /// ///////////////////////////////////////////////////////////

//    public static Process start(List<String> command) throws IOException {
//        ProcessBuilder processBuilder = new ProcessBuilder(command);
//        processBuilder.redirectErrorStream(true);
//        return processBuilder.start();
//    }
//
//    public static List<Process> startPipeline(List<List<String>> commands) throws IOException {
//        List<Process> processes = new ArrayList<>();
//        Process prevProcess = null;
//
//        for (List<String> command : commands) {
//            ProcessBuilder processBuilder = new ProcessBuilder(command);
//
//            processBuilder.redirectInput(ProcessBuilder.Redirect.PIPE);
//            processBuilder.redirectErrorStream(true);
//
//            Process process = processBuilder.start();
//
//            if (prevProcess != null) {
//                transferStream(prevProcess, process);
//            }
//
//            processes.add(process);
//            prevProcess = process;
//        }
//
//        return processes;
//    }
//
//    private static void transferStream(Process from, Process to) {
//        new Thread(() -> {
//            try (BufferedReader reader = new BufferedReader(new InputStreamReader(from.getInputStream()));
//                 var writer = to.getOutputStream()) {
//                String line;
//                while ((line = reader.readLine()) != null) {
//                    writer.write((line + "\n").getBytes());
//                    writer.flush();
//                }
//            } catch (IOException ignored) {
//            }
//        }).start();
//    }
//
//    public static void printProcessOutput(Process process) throws IOException {
//        try (BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()))) {
//            String line;
//            while ((line = reader.readLine()) != null) {
//                System.out.println(line);
//            }
//        }
//    }
//
//    public static void main(String[] args) throws IOException, InterruptedException {
//        List<String> command = List.of("echo", "Hello, ProcessBuilder!");
//        Process process = start(command);
//        printProcessOutput(process);
//        process.waitFor();
//
//        List<List<String>> pipelineCommands = new ArrayList<>();
//        pipelineCommands.add(List.of("echo", "Hello, World!"));
//        pipelineCommands.add(List.of("grep", "Hello"));
//
//        List<Process> pipelineProcesses = startPipeline(pipelineCommands);
//
//        printProcessOutput(pipelineProcesses.get(pipelineProcesses.size() - 1));
//
//        for (Process p : pipelineProcesses) {
//            p.waitFor();
//        }
//    }

    /// ///////////////////////////////////////////////////////////


//    public static Process start(List<String> command) throws IOException {
//        ProcessBuilder processBuilder = new ProcessBuilder(command);
//        processBuilder.redirectErrorStream(true);
//        return processBuilder.start();
//    }
//
//    public static List<Process> startPipeline(List<List<String>> commands) throws IOException {
//        List<Process> processes = new ArrayList<>();
//        Process prevProcess = null;
//
//        for (List<String> command : commands) {
//            ProcessBuilder processBuilder = new ProcessBuilder(command);
//            processBuilder.redirectInput(ProcessBuilder.Redirect.PIPE);
//            processBuilder.redirectErrorStream(true);
//            Process process = processBuilder.start();
//
//            if (prevProcess != null) {
//                transferStream(prevProcess, process);
//            }
//
//            processes.add(process);
//            prevProcess = process;
//        }
//        return processes;
//    }
//
//    private static void transferStream(Process from, Process to) {
//        new Thread(() -> {
//            try (BufferedReader reader = new BufferedReader(new InputStreamReader(from.getInputStream()));
//                 var writer = to.getOutputStream()) {
//                String line;
//                while ((line = reader.readLine()) != null) {
//                    writer.write((line + "\n").getBytes());
//                    writer.flush();
//                }
//            } catch (IOException ignored) {
//            }
//        }).start();
//    }
//
//    public static void printProcessOutput(Process process) throws IOException {
//        try (BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()))) {
//            String line;
//            while ((line = reader.readLine()) != null) {
//                System.out.println(line);
//            }
//        }
//    }
//
//    public static void main(String[] args) throws IOException, InterruptedException {
//        // Using new ArrayList<>
//        List<String> command = new ArrayList<>();
//        command.add("echo");
//        command.add("Hello, ProcessBuilder!");
//        Process process = start(command);
//        printProcessOutput(process);
//        process.waitFor();
//
//        // Using Arrays.asList()
//        List<List<String>> pipelineCommands = new ArrayList<>();
//        pipelineCommands.add(new ArrayList<>(Arrays.asList("echo", "Hello, World!")));
//        pipelineCommands.add(new ArrayList<>(Stream.of("grep", "Hello").collect(Collectors.toList())));
//
//        List<Process> pipelineProcesses = startPipeline(pipelineCommands);
//        printProcessOutput(pipelineProcesses.get(pipelineProcesses.size() - 1));
//
//        for (Process p : pipelineProcesses) {
//            p.waitFor();
//        }
//    }
//    public static void main(String[] args) throws IOException, InterruptedException{
//        List<ProcessBuilder> processBuilders = new ArrayList<>();
//
//        processBuilders.add(new ProcessBuilder(Arrays.asList("echo", "Hello, Pipeline!")));
//        processBuilders.add(new ProcessBuilder(Arrays.asList("grep", "Hello")));
//
//        Process processT = processBuilders.getFirst().start();
//        List<Process> processes = ProcessBuilder.startPipeline(processBuilders);
//
//        printProcessOutput(processes.get(processes.size() - 1));
//        for (Process process : processes) {
//            process.waitFor();
//        }
//
//    }
//
//    private static void printProcessOutput(Process process) throws IOException {
//        try (BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()))) {
//            String line;
//            while ((line = reader.readLine()) != null) {
//                System.out.println(line);
//            }
//        }
//    }


        public static void main(String[] args) {
            try {
                ProcessBuilder process1 = new ProcessBuilder("echo", "Hello, World!");
                ProcessBuilder process2 = new ProcessBuilder("grep", "Hello");
                List<Process> processes = ProcessBuilder.startPipeline(List.of(process1, process2));

                Process lastProcess = processes.get(processes.size() - 1);
                try (BufferedReader reader = new BufferedReader(new InputStreamReader(lastProcess.getInputStream()))) {
                    String line;
                    while ((line = reader.readLine()) != null) {
                        System.out.println("Output: " + line);
                    }
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
}

