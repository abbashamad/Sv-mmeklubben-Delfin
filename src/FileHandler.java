import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.Scanner;

public class FileHandler {
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
            System.out.println("Fejl: " + e.getMessage());
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
                    decodeMember(memberList, i, fields);
                    scanner.nextLine();
                } else {
                    decodeEliteMember(memberList, i, fields);

                    while (!(line = scanner.nextLine()).isEmpty()) {
                        fields = line.split(",");
                        if (fields[0].equals("training")) {
                            decodeSwimResult(memberList, i, fields);
                        } else {
                            decodeCompetitionResult(memberList, i, fields);
                        }
                    }

                }

            }
        } catch (FileNotFoundException e) {
            System.out.println("Fejl: " + e.getMessage());
        }
    }

    private static void decodeMember(MemberList memberList, int i, String[] fields) {
        memberList.addMemberToMemberList(LocalDate.parse(fields[1]), fields[2], fields[3], Gender.valueOf(fields[4]));

        memberList.findMemberViaID(i).getSubscription().changeSubscriptionType(Boolean.parseBoolean(fields[5]));
        memberList.findMemberViaID(i).getSubscription().setHasArrears(Boolean.parseBoolean(fields[6]));
    }

    private static void decodeEliteMember(MemberList memberList, int i, String[] fields) {
        memberList.addEliteToMemberList(LocalDate.parse(fields[1]), fields[2], fields[3], Gender.valueOf(fields[4]));

        memberList.findMemberViaID(i).getSubscription().changeSubscriptionType(Boolean.parseBoolean(fields[5]));
        memberList.findMemberViaID(i).getSubscription().setHasArrears(Boolean.parseBoolean(fields[6]));
    }

    private static void decodeSwimResult(MemberList memberList, int i, String[] fields) {
        EliteMember eliteMember = (EliteMember) memberList.findMemberViaID(i);
        eliteMember.addSwimResultsToList(Discipline.valueOf(fields[1]), SwimTimer.parse(fields[2]), LocalDate.parse(fields[3]));
    }

    private static void decodeCompetitionResult(MemberList memberList, int i, String[] fields) {
        EliteMember eliteMember = (EliteMember) memberList.findMemberViaID(i);
        eliteMember.addCompSwimResultsToList(Discipline.valueOf(fields[1]), SwimTimer.parse(fields[2]), LocalDate.parse(fields[3]), Integer.parseInt(fields[4]), fields[5]);
    }

}
