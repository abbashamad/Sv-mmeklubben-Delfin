import java.time.LocalDate;
import java.util.Objects;
import java.util.Scanner;
import java.util.ArrayList;

public class MenuSystem {
    private MemberList memberList;
    public Scanner sc;

    public MenuSystem(MemberList memberList) {
        this.memberList = memberList;
        sc = new Scanner(System.in);
    }

    public void showMainMenu() {
        boolean running = true;

        while (running) {
            System.out.println("\n=== Hovedmenu ===");
            System.out.println("1. Medlemmer");
            System.out.println("2. Svømmeresultater");
            System.out.println("3. Kontingent og Økonomi");
            System.out.println("4. Luk programmet");
            System.out.print("Vælg: ");

            switch (sc.nextLine()) {
                case "1" -> ShowMemberMenu();
                case "2" -> ShowSwimtimeMenu();
                case "3" -> ShowAccountingMenu();
                case "4" -> running = false;
                default -> System.out.println("Invalid choice.");
            }



        }
    }


    public void ShowMemberMenu() {
        System.out.println("\n Medlemsorganisering");
        System.out.println("1. Opret nyt medlem");
        System.out.println("2. Vis eksisterende medlemmer");
        System.out.println("3. Ret i eksisterende medlemsinfo");
        System.out.println("4. Tilbage");
        System.out.print("Vælg: ");

        switch (sc.nextLine()) {
            case "1" -> CreateNewMember();
            case "2" -> System.out.println(memberList);
            case "3" -> EditMemberInfo();
            case "4" -> showMainMenu();
            default -> System.out.println("Forkert valg kammerat");

        }  }

    public void CreateNewMember() {
        System.out.print("Enter Name: ");
        String name = sc.nextLine();
        System.out.print("Enter Email: ");
        String email = sc.nextLine();
        System.out.print("Enter Birthday (YYYY-MM-DD): ");
        LocalDate birthday = LocalDate.parse(sc.nextLine());
        System.out.print("Enter gender (MALE/FEMALE): ");
        Gender gender = Gender.valueOf(sc.nextLine().toUpperCase());

        System.out.print("Elite swimmer? (Y/N): ");
        String answer = sc.next().toUpperCase();
        if (Objects.equals(answer, "Y")){
            memberList.addEliteToMemberList(birthday, email, name, gender);
            sc.nextLine();
        } else if (Objects.equals(answer, "N")){
            memberList.addMemberToMemberList(birthday, email, name, gender);
            sc.nextLine();
        } else {
            System.out.println("Fejl");
        }
    }

    public void EditMemberInfo() {

    }

    public void ShowSwimtimeMenu() {
        System.out.println("\n Svømmeresultater");
        System.out.println("1. Opret ny svømmetid");
        System.out.println("2. Se Statistik over top 5 Senior Svømmere");
        System.out.println("3. Se Statistik over top 5 Junior Svømmere");
        System.out.println("4. Tilbage til hovedmenu");
        System.out.print("Vælg: ");

        switch (sc.nextLine()) {
            case "1" -> CreateNewSwimResult();
            case "2" -> SeeTopJuniorSwimmers();
            case "3" -> SeeTopSeniorSwimmers();
            case "4" -> showMainMenu();
            default -> System.out.println("Forkert valg kammerat");
        }
    } public void CreateNewSwimResult() {
        System.out.print("Indtast Medlemsnummer/ID/Navn Eller whatevs ");
        int memberId = sc.nextInt();
        sc.nextLine();
        Member member = memberList.findMemberViaID(memberId);
        if (member == null) {
            System.out.println("Medlem ikke fundet!");
            return;
        }
        System.out.println("\n Vælg  Svømme-disciplin");
        System.out.println("1. CRAWL");
        System.out.println("2. BREASTSTROKE");
        System.out.println("3. BUTTERFLY");
        System.out.println("4. BACKCRAWL");
        String disciplineChoice = sc.nextLine();
        Discipline discipline;

        switch (disciplineChoice){
            case "1" -> discipline = Discipline.CRAWL;
            case "2" -> discipline = Discipline.BREASTSTROKE;
            case "3" -> discipline = Discipline.BUTTERFLY;
            case "4" -> discipline = Discipline.BACKCRAWL;
            default ->  {
                System.out.println("Forkert valg kammerat");
                return;    }
        }
        System.out.print("Indtast først antal minutter brugt ");
        int min = sc.nextInt();
        System.out.print("Indtast antal sekunder");
        int sec = sc.nextInt();
        System.out.print("Indtast antal millisekunder");
        int milSec = sc.nextInt();
        sc.nextLine();
        SwimTimer timer = new SwimTimer(min,sec,milSec);

        System.out.println("Indtast dato:");
        LocalDate date = LocalDate.parse(sc.nextLine());

        SwimResult result = new SwimResult(member, discipline, timer, date);

    }

    private void SeeTopSeniorSwimmers() {
        System.out.println("\n Vælg Svømme-disciplin");
        System.out.println("1.  Top 5 Crawl");
        System.out.println("2.  Top 5 Brystsvømning");
        System.out.println("3.  Top 5 Butterfly");
        System.out.println("4.  Top 5 Backcrawl");
        System.out.print("Vælg Disciplin: ");


        switch (sc.nextLine()) {
            case "1" -> TopFiveCrawlSenior();
            case "2" -> TopFiveBreastSenior();
            case "3" -> TopFiveButterflySenior();
            case "4" -> TopFiveBcrawlSenior();
            default -> System.out.println("Forkert valg kammerat");
        }
    }

    private void TopFiveBreastSenior() {

    }

    private void TopFiveCrawlSenior() {
    }

    private void TopFiveButterflySenior() {
    }

    private void TopFiveBcrawlSenior() {
    }

    public void SeeTopJuniorSwimmers() {
        System.out.println("\n Vælg Svømme-disciplin");
        System.out.println("1.  Top 5 Crawl");
        System.out.println("2.  Top 5 Brystsvømning");
        System.out.println("3.  Top 5 Butterfly");
        System.out.println("4.  Top 5 Backcrawl");
        System.out.print("Vælg Disciplin: ");


        switch (sc.nextLine()) {
            case "1" -> TopFiveCrawlJunior();
            case "2" -> TopFiveBreastJunior();
            case "3" -> TopFiveButterflyJunior();
            case "4" -> TopFiveBcrawlJunior();
            default -> System.out.println("Forkert valg kammerat");
        } }

    private void TopFiveButterflyJunior() {

    }

    private void TopFiveBcrawlJunior() {

    }

    private void TopFiveBreastJunior() {

    }

    private void TopFiveCrawlJunior() {

    }

    public void ShowAccountingMenu() {
    }



}