import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
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

    public static void decodeFile(String filename) {
        try {
            Scanner scanner = new Scanner(new File(filename));

            while (scanner.hasNextLine()){
                String line = scanner.nextLine();

                String[] fields = line.split(",");
                Member member = new Member(LocalDate.parse(fields[1]),fields[2],fields[3],Gender.valueOf(fields[4]));

                if (!Boolean.parseBoolean(fields[5])){
                    member.getSubscription().changeSubscriptionType();
                }
                System.out.println(member + "" + member.getSubscription().isActive());


            }
            //exception
        } catch (FileNotFoundException e) {
            System.out.println("fejl");
        }
    }
}
