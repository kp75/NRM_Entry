import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Arrays;

public class Utility {
	
	public static void Utilitylog(String logFile, String testResult) throws IOException {
		
	final Path path = Paths.get(logFile + ReferralEntry.fileSeparator + "logFile.txt");
    Files.write(path, Arrays.asList(testResult), StandardCharsets.UTF_8,
        Files.exists(path) ? StandardOpenOption.APPEND : StandardOpenOption.CREATE);
		}
	

	

	

}
