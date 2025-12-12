package delfin.mainsystem;

import delfin.enums.AgeGroup;
import delfin.enums.Discipline;
import delfin.exceptions.SwimTimeException;
import delfin.files.FileHandler;
import delfin.interfaces.Serializable;
import delfin.members.EliteMember;
import delfin.enums.Gender;
import delfin.members.Member;
import delfin.results.SwimTimer;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MenuSystem {
    /**
     * Displays and handles all menu functions
     *
     */
    private MemberList memberList;
    private Scanner sc;

    public MenuSystem(MemberList memberList) {
        this.memberList = memberList;
        sc = new Scanner(System.in);
    }


    /***
     * Displays main menu and handles all navigation until program ends by user input
     */
    public void showMainMenu() {
        boolean running = true;

        while (running) {
            System.out.println("\n=== Hovedmenu ===");
            System.out.println("1. Medlemmer");
            System.out.println("2. Holdssstatistik");
            System.out.println("3. Kontingent og Økonomi");
            System.out.println("4. Gem medlemsinformation");
            System.out.println("5. Luk programmet");
            System.out.print("Vælg: ");

            switch (sc.nextLine()) {
                case "1" -> ShowMemberMenu();
                case "2" -> ShowSwimtimeMenu();
                case "3" -> ShowAccountingMenu();
                case "4" -> saveAllToCsv();
                case "5" -> running = false;
                default -> System.out.println("Invalid choice.");
            }
        }
    }


    /**
     * Displays menu for member creation, viewing existing members and editing member info
     */
    private void ShowMemberMenu() {
        boolean running = true;

        while (running) {
            System.out.println("\n ===Member Menu===");
            System.out.println("1. Opret nyt medlem");
            System.out.println("2. Vis eksisterende medlemmer");
            System.out.println("3. Ret i eksisterende medlemsinfo");
            System.out.println("4. Søg efter medlem");
            System.out.println("5. Tilbage til hovedmenu");
            System.out.print("Vælg: ");

            switch (sc.nextLine()) {
                case "1" -> CreateNewMember();
                case "2" -> System.out.println(memberList);
                case "3" -> EditMemberInfo();
                case "4" -> showMemberById();
                case "5" -> running = false;
                default -> System.out.println("Forkert valg kammerat");
            }
        }
    }

    private void CreateNewMember() {
        System.out.print("Indtast Navn: ");
        String name = sc.nextLine();

        System.out.print("Indtast Email: ");
        String email = sc.nextLine().toUpperCase();

        System.out.print("Indtast fødselsdato (YYYY-MM-DD): ");
        String birthdayInput = sc.nextLine();
        LocalDate birthday;
        try {
            birthday = LocalDate.parse(birthdayInput);
        } catch (Exception e) {
            System.out.println("Forkert datoformat. Brug YYYY-MM-DD.");
            return;
        }

        System.out.print("Indtast køn (MALE/FEMALE): ");
        String genderInput = sc.nextLine().toUpperCase();
        Gender gender;
        try {
            gender = Gender.valueOf(genderInput);
        } catch (IllegalArgumentException e) {
            System.out.println("Ugyldigt køn. Brug MALE eller FEMALE.");
            return;
        }

        System.out.print("Er medlemmet EliteSvømmer? (Y/N): ");
        String answer = sc.next();

        //Decides member type
        if (answer.equalsIgnoreCase("Y")) {
            memberList.addEliteToMemberList(birthday, email, name, gender);
            System.out.println("\nEliteMedlem Tilføjet!");
        } else if (answer.equalsIgnoreCase("N")) {
            memberList.addMemberToMemberList(birthday, email, name, gender);
            System.out.println("\nMedlem Tilføjet!");
        } else {
            System.out.println("Fejl");
        }

        sc.nextLine();
    }

    /**
     * Updating existing member information via Member Menu
     */
    private void EditMemberInfo() {
        System.out.println("==Member Update==");
        System.out.println("* You can only change your name and email *");

        //Member to edit
        System.out.print("\nEnter Member ID: ");
        String idInput = sc.nextLine();
        int id;
        try {
            id = Integer.parseInt(idInput);
        } catch (NumberFormatException e) {
            System.out.println("Du skal indtaste et tal som ID.");
            return;
        }

        Member member = memberList.findMemberViaID(id);
        if (member == null) {
            System.out.println("Fejl: Intet medlem med dette ID eksisterer");
            sc.nextLine();//Clear buffer
            ShowMemberMenu();
            return;
        }

        System.out.printf("Du har valgt: %s, ID:%04d", member.getName(), member.getId());
        sc.nextLine();//Clear buffer

        //New Entry
        System.out.print("\nIndtast nyt navn (tryk Enter for at beholde nuværende): ");
        String newName = sc.nextLine();
        System.out.print("Indtast ny Email (tryk Enter for at beholde nuværende): ");
        String newEmail = sc.nextLine().toUpperCase();

        //Updates and displays change
        if (newName.isEmpty() && newEmail.isEmpty()) {
            System.out.println("Update Failed");
        } else {
            System.out.println("Update Successful");

        }

        member.updateMember(newName, newEmail);
    }


    /**
     * Displays Swim Results, option to creates new results, shows top 5 swimmers
     */
    private void ShowSwimtimeMenu() {
        System.out.println("\n Svømmeresultater Og Holdsinformation");
        System.out.println("1. Opret ny svømmetid");
        System.out.println("2. Se Statistik over top 5 Svømmere");
        System.out.println("3. Se hold");
        System.out.println("4. Tilbage til hovedmenu");
        System.out.print("Vælg: ");

        switch (sc.nextLine()) {
            case "1" -> CreateNewSwimResult();
            case "2" -> SeeTopSwimmers();
            case "3" -> showTeamMenu();
            case "4" -> showMainMenu();
            default -> System.out.println("Forkert valg kammerat");
        }
    }

    /**
     *
     * Creates New Swim Results for members that are Elite Swimmers
     */
    private void CreateNewSwimResult() {

        System.out.print("Indtast Medlemsnummer");
        int memberId = sc.nextInt();
        sc.nextLine();

        Member member = memberList.findMemberViaID(memberId);//Searches for member that matches the ID inputted

        if (member == null) {
            System.out.println("Medlem ikke fundet!");
            return;//Error if member does not exist
        } else if (!(member instanceof EliteMember)) {
            System.out.println("Medlem er ikke konkurrence svømmer");
            return;//Error if the member is a regular
        }
        EliteMember eliteMember = (EliteMember) member;

        System.out.println("Tast 1 for træning ellr 2 for stævne");//Checks if result is of training or competition
        int resultType = sc.nextInt();
        sc.nextLine();

        //Discipline Selection
        System.out.println("\n Vælg  Svømme-disciplin");
        System.out.println("1. CRAWL");
        System.out.println("2. BREASTSTROKE");
        System.out.println("3. BUTTERFLY");
        System.out.println("4. BACKCRAWL");

        String disciplineChoice = sc.nextLine();
        Discipline discipline;

        switch (disciplineChoice) {
            case "1" -> discipline = Discipline.CRAWL;
            case "2" -> discipline = Discipline.BREASTSTROKE;
            case "3" -> discipline = Discipline.BUTTERFLY;
            case "4" -> discipline = Discipline.BACKCRAWL;
            default -> {
                System.out.println("Forkert valg kammerat");
                return;
            }
        }

        SwimTimer timer;
        try {
            //Swim Time input
            System.out.print("Indtast først antal minutter brugt: ");
            int min = sc.nextInt();
            System.out.print("Indtast antal sekunder: ");
            int sec = sc.nextInt();
            System.out.print("Indtast antal millisekunder: ");
            int milSec = sc.nextInt();
            sc.nextLine();
            timer = new SwimTimer(min, sec, milSec);
        } catch (SwimTimeException e) {
            System.out.println(e.getMessage());
            return;
        }

        System.out.println("Indtast dato (YYYY-MM-DD): ");
        String dateInput = sc.nextLine();
        LocalDate date;
        try {
            date = LocalDate.parse(dateInput);
        } catch (Exception e) {
            System.out.println("Forkert datoformat. Brug YYYY-MM-DD.");
            return;
        }

        //Determines Result Type (1 for Training, 2 for competition's placement and event location)
        if (resultType == 1) {
            eliteMember.addSwimResultsToList(discipline, timer, date);
        } else if (resultType == 2) {
            System.out.print("Indtast antal placering: ");
            int placement = sc.nextInt();
            sc.nextLine();
            System.out.print("Indtast stævnets navn: ");
            String location = sc.nextLine();

            eliteMember.addCompSwimResultsToList(discipline, timer, date, placement, location);
        } else {
            System.out.println("Forkert valg kammerat");
        }
    }

    /**
     * Displays top 5 swim times for every discipline based on their age group and gender
     */

    //Age group and gender
    private void SeeTopSwimmers() {
        System.out.println("\n Vælg kategori: ");
        System.out.println("1.  Senior/Male ");
        System.out.println("2.  Senior/Female ");
        System.out.println("3.  Junior/Male ");
        System.out.println("4.  Junior/Female ");
        System.out.print("Vælg Division: ");


        switch (sc.nextLine()) {
            case "1" -> swimmerDiscipline(AgeGroup.SENIOR, Gender.MALE);
            case "2" -> swimmerDiscipline(AgeGroup.SENIOR, Gender.FEMALE);
            case "3" -> swimmerDiscipline(AgeGroup.JUNIOR, Gender.MALE);
            case "4" -> swimmerDiscipline(AgeGroup.JUNIOR, Gender.FEMALE);
            default -> System.out.println("Forkert valg kammerat");
        }
    }

    //Swim Discipline
    private void swimmerDiscipline(AgeGroup ageGroup, Gender gender) {

        System.out.println("\n Vælg kategori: ");
        System.out.println("1. Top 5 Crawl");
        System.out.println("2. Top 5 Brystsvømning");
        System.out.println("3. Top 5 Butterfly");
        System.out.println("4. Top 5 Backcrawl");
        System.out.print("Vælg Disciplin: ");

        switch (sc.nextLine()) {
            case "1" -> TopFiveCrawl(ageGroup, gender);
            case "2" -> TopFiveBreast(ageGroup, gender);
            case "3" -> TopFiveButterfly(ageGroup, gender);
            case "4" -> TopFiveBcrawl(ageGroup, gender);
            default -> System.out.println("Forkert valg kammerat");
        }
    }

    private void TopFiveCrawl(AgeGroup ageGroup, Gender gender) {
        System.out.println("\nDu har valgte: " + ageGroup + "/" + gender);
        System.out.println(Discipline.CRAWL);
        memberList.top5ToString(ageGroup, gender, Discipline.CRAWL);
    }

    private void TopFiveBreast(AgeGroup ageGroup, Gender gender) {
        System.out.println("\nDu har valgte: " + ageGroup + "/" + gender);
        System.out.println(Discipline.BREASTSTROKE);
        memberList.top5ToString(ageGroup, gender, Discipline.BREASTSTROKE);
    }

    private void TopFiveButterfly(AgeGroup ageGroup, Gender gender) {
        System.out.println("\nDu har valgte: " + ageGroup + "/" + gender);
        System.out.println(Discipline.BUTTERFLY);
        memberList.top5ToString(ageGroup, gender, Discipline.BUTTERFLY);
    }

    private void TopFiveBcrawl(AgeGroup ageGroup, Gender gender) {
        System.out.println("\nDu har valgte: " + ageGroup + "/" + gender);
        System.out.println(Discipline.BACKCRAWL);
        memberList.top5ToString(ageGroup, gender, Discipline.BACKCRAWL);
    }


    /**
     *
     * Menu to show members based on their
     */
    private void showTeamMenu() {
        System.out.println("\n Vælg Hold: ");
        System.out.println("1. Junior");
        System.out.println("2. Senior");
        System.out.print("Vælg: ");

        switch (sc.nextLine()) {
            case "1" -> showTeam(AgeGroup.JUNIOR);
            case "2" -> showTeam(AgeGroup.SENIOR);
            default -> System.out.println("Forkert valg");
        }
    }

    /**
     *
     * Shows elite members in teams based on their age group
     */

    private void showTeam(AgeGroup ageGroup) {
        //Printing team info
        System.out.println("==== SVØMMEKLUB DELFIN * " + ageGroup + " * TEAM =====");
        String s = String.format("%-5s %-15s %-25s %-20s %s", "ID", "NAME", "EMAIL", "STATUS", "GENDER") + "\n";
        s += "-".repeat(80);
        System.out.println(s);

        for (EliteMember m : memberList.sortTeamByAgeGroup(ageGroup)) {
            System.out.println(m.toStringGender());
        }
        ShowSwimtimeMenu(); //Goes back to previous menu
    }

    /**
     *
     * Displays accounting and handles subscriptions
     */

    private void ShowAccountingMenu() {
        boolean running = true;

        //Accounting Menu
        while (running) {
            System.out.println("=== Økonomimenu ===");
            System.out.println("1. Vis Samlet kontingentindkomst");
            System.out.println("2. Fremvis medlemmer i restance");
            System.out.println("3. Sæt abonnement som betalt");
            System.out.println("4. Skift Aktiv/passiv status");
            System.out.println("5. Tilbage til hovedmenu");
            System.out.println("Vælg: ");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    //Bruger MemberLists totalIncome-metode
                    System.out.println(memberList.totalIncome());
                    break;

                case 2:
                    //Hent alle medlemmer og filtrér med Economy.membersInArrears
                    List<Member> inArrears = memberList.getMembersInArrears();

                    if (inArrears.isEmpty()) {
                        System.out.println("Der er ingen medlemmer i restance.");
                    } else {
                        System.out.println("Medlemmer i restance:");
                        for (Member m : inArrears) {
                            System.out.println(m);
                        }
                    }
                    break;

                case 3:
                    System.out.println(" Indtast MedlemsID for at sætte kontingent som betalt");
                    int memberId = sc.nextInt();
                    sc.nextLine(); //Clearer mellemrum

                    Member member = memberList.findMemberViaID(memberId);
                    member.getSubscription().setHasArrears(false);
                    System.out.println(" Medlemmet er nu sat som at have betalt");
                    break;
                case 4:
                    System.out.println("Indtast MedlemsID for at ændre Active/Passive status:");
                    int statusId = sc.nextInt();
                    sc.nextLine(); // clear buffer

                    Member mStat = memberList.findMemberViaID(statusId);

                    if (mStat == null) {
                        System.out.println("Medlem ikke fundet.");
                        break;
                    }

                    System.out.println("\nNuværende status: " +
                            (mStat.getSubscription().isActive() ? "Aktiv" : "Passiv"));

                    System.out.println("Vælg ny status:");
                    System.out.println("1. Aktiv");
                    System.out.println("2. Passiv");
                    System.out.print("Valg: ");

                    int statusChoice = sc.nextInt();
                    sc.nextLine();

                    switch (statusChoice) {
                        case 1:
                            mStat.getSubscription().setIsActive(true);
                            System.out.println("Status ændret til Aktiv.");
                            break;

                        case 2:
                            mStat.getSubscription().setIsActive(false);
                            System.out.println("Status ændret til Passiv.");
                            break;

                        default:
                            System.out.println("Ugyldigt valg. Status ændres ikke.");
                    }
                    break;
                case 5:
                    running = false; //Tilbage til hovedmenu
                    break;

                default:
                    System.out.println("Ugyldigt valg, prøv igen.");


            }
        }

    }

    private void saveAllToCsv() {
        try {
            // Save Members
            List<Serializable> memberSerializables = new ArrayList<>(memberList.getMemberList());
            FileHandler.saveToCsvFile("MemberData.csv", memberSerializables);

            // Save Results
            List<Serializable> resultSerializables = new ArrayList<>();
            for (Member member : memberList.getMemberList()) {
                if (member instanceof EliteMember) {
                    resultSerializables.addAll(
                            ((EliteMember) member).getSwimResults()
                    );
                }
            }

            FileHandler.saveToCsvFile("SwimResultData.csv", resultSerializables);

        } catch (IOException e) {
            System.out.println("Fejl: " + e.getMessage());
        }
    }


    /**
     *
     * Search function for a single member
     */
    private void showMemberById() {
        System.out.print("Indtast medlems-ID: ");
        String input = sc.nextLine();
        int id;

        try {
            id = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            System.out.println("ID skal være et tal.");
            return;
        }

        Member m = memberList.findMemberViaID(id);
        if (m == null) {
            System.out.println("Medlemmet findes ikke");
        } else {
            String s = String.format("%-5s %-15s %-25s %-20s %s", "ID", "NAME", "EMAIL", "STATUS", "GENDER") + "\n";
            s += "-".repeat(80);
            System.out.println(s);
            System.out.println(m.toStringGender());

            if (m instanceof EliteMember) {
                System.out.println("\n" + String.format("%-5s %-12s %-15s %-14s %-12s %-11s %s", "ID", "NAVN", "DISCIPLIN", "TID", "DATO", "PLACERING", "STÆVNE"));
                System.out.println("-".repeat(85));
                System.out.println(((EliteMember) m).swimResultsToString());
            }
        }

    }
}
