import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
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
                    for (Serializable swimResult : ((EliteMember) member).getSwimResults()) {
                        writer.write(swimResult.serialize());
                    }
                }
                writer.write("\n");
            }
            writer.close();

        } catch (IOException e) {
            System.out.println("fejl");
        }
    }

    public static void decodeFile(String filename, MemberList memberList) {
        try {
            Scanner scanner = new Scanner(new File(filename));

            String line;
            String[] fields;

            int i = 0;
            while (scanner.hasNextLine()) {
                i++;

                line = scanner.nextLine();
                fields = line.split(",");

                if (fields[0].equals("member")) {
                    memberList.addMemberToMemberList(LocalDate.parse(fields[1]), fields[2], fields[3], Gender.valueOf(fields[4]));
                    scanner.nextLine();
                } else {
                    memberList.addEliteToMemberList(LocalDate.parse(fields[1]), fields[2], fields[3], Gender.valueOf(fields[4]));
                    while (!(line = scanner.nextLine()).isEmpty()) {
                        fields = line.split(",");
                        if (fields[0].equals("training")) {
                            EliteMember eliteMember = (EliteMember) memberList.findMemberViaID(i);
                            String[] swimTime = fields[2].split(":");
                            eliteMember.addSwimResultsToList(Discipline.valueOf(fields[1]), new SwimTimer(Integer.parseInt(swimTime[0]), Integer.parseInt(swimTime[1]), Integer.parseInt(swimTime[2])), LocalDate.parse(fields[3]));
                        } else {
                            EliteMember eliteMember = (EliteMember) memberList.findMemberViaID(i);
                            String[] swimTime = fields[2].split(":");
                            eliteMember.addCompSwimResultsToList(Discipline.valueOf(fields[1]), new SwimTimer(Integer.parseInt(swimTime[0]), Integer.parseInt(swimTime[1]), Integer.parseInt(swimTime[2])), LocalDate.parse(fields[3]), Integer.parseInt(fields[4]), fields[5]);
                        }
                    }

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
