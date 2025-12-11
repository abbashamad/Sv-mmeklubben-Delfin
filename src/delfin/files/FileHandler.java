package delfin.files;

import delfin.mainsystem.MemberList;
import delfin.interfaces.Serializable;
import delfin.enums.Discipline;
import delfin.members.EliteMember;
import delfin.enums.Gender;
import delfin.members.Member;
import delfin.results.SwimTimer;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;


public class FileHandler {

    /**
     *
     * Saving .csv files
     *
     * @param filename      : name of file
     * @param serializables : members in serialised formats
     */
    public static void saveToCsvFile(String filename, List<Serializable> serializables) throws FileNotFoundException {

        PrintWriter writer = new PrintWriter("src/delfin/files/" + filename);//Updated filepath

        for (Serializable serializable : serializables) {
            writer.write(serializable.serialize());
        }
        writer.close();


    }

    /**
     * Reading .csv files
     *
     * @param filename:   name of file
     * @param memberList: list of members in .csv
     */
    public static void decodeFile(String filename, MemberList memberList) {
        try {
            Scanner scanner = new Scanner(new File("src/delfin/files/" + filename));//Also updated filepath

            String line;
            String[] fields;


            while (scanner.hasNextLine()) {

                line = scanner.nextLine();
                fields = line.split(",");

                if (fields[0].equals("member")) {
                    decodeMember(memberList, fields);
                } else if (fields[0].equals("elite")) {
                    decodeEliteMember(memberList, fields);
                } else if (fields[0].equals("training")) {
                    decodeSwimResult(memberList, fields);
                } else if (fields[0].equals("comp")) {
                    decodeCompetitionResult(memberList, fields);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Fejl: " + e.getMessage());
        }
    }

    private static void decodeMember(MemberList memberList, String[] fields) {
        Member member = new Member(LocalDate.parse(fields[1]), fields[2], fields[3], Gender.valueOf(fields[4]));

        member.getSubscription().setIsActive(Boolean.parseBoolean(fields[5]));
        member.getSubscription().setHasArrears(Boolean.parseBoolean(fields[6]));

        memberList.addMemberToMemberList(member);
    }

    private static void decodeEliteMember(MemberList memberList, String[] fields) {
        EliteMember member = new EliteMember(LocalDate.parse(fields[1]), fields[2], fields[3], Gender.valueOf(fields[4]));

        member.getSubscription().setIsActive(Boolean.parseBoolean(fields[5]));
        member.getSubscription().setHasArrears(Boolean.parseBoolean(fields[6]));

        memberList.addMemberToMemberList(member);
    }

    private static void decodeSwimResult(MemberList memberList, String[] fields) {
        EliteMember eliteMember = (EliteMember) memberList.findMemberViaID(Integer.parseInt(fields[1]));
        eliteMember.addSwimResultsToList(Discipline.valueOf(fields[2]), SwimTimer.parse(fields[3]), LocalDate.parse(fields[4]));
    }

    private static void decodeCompetitionResult(MemberList memberList, String[] fields) {
        EliteMember eliteMember = (EliteMember) memberList.findMemberViaID(Integer.parseInt(fields[1]));
        eliteMember.addCompSwimResultsToList(Discipline.valueOf(fields[2]), SwimTimer.parse(fields[3]), LocalDate.parse(fields[4]), Integer.parseInt(fields[5]), fields[6]);
    }

}
