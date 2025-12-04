import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class FileHandler {
    //    public static void saveToCsvFile(String filename, List<Serializable> serializables)
    public static void saveToCsvFile(String filename, MemberList serializables) {
        try {
            PrintWriter writer = new PrintWriter(filename);

            int i = 0;

            for (Serializable member : serializables.getMemberList()) {
                i++;
                writer.write(member.serialize());
                if (member instanceof EliteMember) {
                    for (Serializable swimResult : ((EliteMember) member).getSwimResults()){
                        writer.write(swimResult.serialize());
                    }
                }
            }
            writer.close();

        } catch (IOException e) {
            System.out.println("fejl");
        }
    }

    public static void decodeFile(String filename,MemberList memberList) {
        try {
            Scanner scanner = new Scanner(new File(filename));

            int i = 0;
            while (scanner.hasNextLine()) {
                i++;

                String line = scanner.nextLine();
                String[] fields = line.split(",");

                if (fields[0].equals("member")){
                    memberList.addMemberToMemberList(LocalDate.parse(fields[1]), fields[2], fields[3], Gender.valueOf(fields[4]));
                }else {

                }

                if (!Boolean.parseBoolean(fields[5])) {
                    memberList.findMemberViaID(i).getSubscription().changeSubscriptionType();
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("fejl");
        }
    }
}
