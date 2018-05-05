import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class Separator {
  private static String filePath = "/Users/shubhaj/IdeaProjects/separator/src/main/resources/userData.txt";
  public static void main(String[] args) throws IOException {
    separate();
  }

  private static void separate() throws IOException {
    List<String> data = Files.readAllLines(Paths.get(filePath));
//    System.out.println(data);

  }
}
