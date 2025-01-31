import java.io.*;
import java.nio.file.*;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Scans your source code files and replaces all System.out.println calls with SLF4J logging
 * Put in directory root
 * javac LogReplacer.java
 * java LogReplacer
 * 
 * @author tdiprima
 */
public class LogReplacer {
    private static final String LOGGER_DECLARATION = "import org.slf4j.Logger;\nimport org.slf4j.LoggerFactory;\n";
    private static final String LOGGER_INSTANCE = "    private static final Logger logger = LoggerFactory.getLogger(%s.class);\n";

    public static void main(String[] args) throws IOException {
        Path sourceDir = Paths.get("src/main/java"); // Modify as needed
        List<Path> javaFiles = Files.walk(sourceDir)
                                    .filter(p -> p.toString().endsWith(".java"))
                                    .collect(Collectors.toList());

        for (Path file : javaFiles) {
            processFile(file);
        }

        System.out.println("✔ All System.out.println calls have been replaced with SLF4J logging.");
    }

    private static void processFile(Path file) throws IOException {
        List<String> lines = Files.readAllLines(file);
        boolean modified = false;
        boolean hasLogger = lines.stream().anyMatch(line -> line.contains("LoggerFactory.getLogger"));

        String className = file.getFileName().toString().replace(".java", "");
        StringBuilder newContent = new StringBuilder();

        for (String line : lines) {
            String trimmedLine = line.trim();

            if (trimmedLine.startsWith("System.out.println")) {
                String logMessage = trimmedLine.replace("System.out.println(", "").replace(");", "").trim();
                String logLevel = determineLogLevel(logMessage);
                newContent.append(line.replace(trimmedLine, "logger." + logLevel + "(" + logMessage + ");")).append("\n");
                modified = true;
            } else {
                newContent.append(line).append("\n");
            }
        }

        if (modified) {
            if (!hasLogger) {
                newContent.insert(0, String.format(LOGGER_INSTANCE, className) + "\n");
                newContent.insert(0, LOGGER_DECLARATION + "\n");
            }
            Files.write(file, newContent.toString().getBytes());
        }
    }

    private static String determineLogLevel(String logMessage) {
        if (logMessage.contains("\"ERROR\"") || logMessage.toLowerCase().contains("error")) {
            return "error";
        } else if (logMessage.contains("\"WARN\"") || logMessage.toLowerCase().contains("warning")) {
            return "warn";
        } else if (logMessage.contains("\"DEBUG\"") || logMessage.toLowerCase().contains("debug")) {
            return "debug";
        }
        return "info";
    }
}
