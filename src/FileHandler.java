import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Scanner;

public class FileHandler {
    public static void saveToCsvFile(String filename, List<Serializable> serializables) {
        try {
            PrintWriter writer = new PrintWriter(filename);

            for (Serializable s : serializables) {
                writer.write(s.serialize());
            }
            writer.close();

        } catch (IOException e) {
            System.out.println("fejl");
        }
    }

    public static void decodeFile(String filename, List<Member> memberList) {
        try {
            Scanner scanner = new Scanner(filename);

            while (scanner.hasNextLine()){


            }
            //exception
        } catch (RuntimeException e) {
            System.out.println("fejl");
        }
    }
}
