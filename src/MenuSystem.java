import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

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
        System.out.println("3. Ret i eksisterende medlemsinfo"); // HVAD SKAL VI RETTE? KUN AKTIV / PASSIV?
        System.out.println("4. Tilbage");
        System.out.print("Vælg: ");

        switch (sc.nextLine()) {
            case "1" -> CreateNewMember();
            case "2" -> System.out.println(memberList);
            case "3" -> EditMemberInfo();
            case "4" -> showMainMenu();
            default -> System.out.println("Forkert valg kammerat");

        }
    }

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
        String answer = sc.next();
        if (answer.equalsIgnoreCase("Y")) {
            memberList.addEliteToMemberList(birthday, email, name, gender);
            sc.nextLine();
        } else if (answer.equalsIgnoreCase("N")) {
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
    }

    public void CreateNewSwimResult() {
        System.out.print("Indtast Medlemsnummer/ID/Navn Eller whatevs ");
        int memberId = sc.nextInt();
        sc.nextLine();
        Member member = memberList.findMemberViaID(memberId);
        if (member == null) {
            System.out.println("Medlem ikke fundet!");
            return;
        } else if (!(member instanceof EliteMember)) {
            System.out.println("Medlem er ikke konkurrence svømmer");
            return;
        }
        EliteMember eliteMember = (EliteMember) member;

        System.out.println("Tast 1 for træning og 2 for stævne");
        int resultType = sc.nextInt();
        sc.nextLine();

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
        System.out.print("Indtast først antal minutter brugt ");
        int min = sc.nextInt();
        System.out.print("Indtast antal sekunder");
        int sec = sc.nextInt();
        System.out.print("Indtast antal millisekunder");
        int milSec = sc.nextInt();
        sc.nextLine();
        SwimTimer timer = new SwimTimer(min, sec, milSec);

        System.out.println("Indtast dato:");
        LocalDate date = LocalDate.parse(sc.nextLine());


        if (resultType == 1) {
            eliteMember.addSwimResultsToList(discipline, timer, date);
        } else if (resultType == 2) {
            System.out.print("Indtast antal placering");
            int placement = sc.nextInt();
            sc.nextLine();
            System.out.print("Indtast antal stævnets navn");
            String loacation = sc.nextLine();

            eliteMember.addCompSwimResultsToList(discipline, timer, date, placement, loacation);
        } else {
            System.out.println("Forkert valg kammerat");
            return;
        }
    }

    private void SeeTopSeniorSwimmers() {
        System.out.println("\n Vælg Svømme-disciplin");
        System.out.println("1.  Top 5 Crawl");
        System.out.println("2.  Top 5 Brystsvømning");
        System.out.println("3.  Top 5 Butterfly");
        System.out.println("4.  Top 5 Backcrawl");
        System.out.print("Vælg Disciplin: ");


        switch (sc.nextLine()) {
            case "1" -> TopFiveCrawl(AgeGroup.SENIOR);
            case "2" -> TopFiveBreast(AgeGroup.SENIOR);
            case "3" -> TopFiveButterfly(AgeGroup.SENIOR);
            case "4" -> TopFiveBcrawl(AgeGroup.SENIOR);
            default -> System.out.println("Forkert valg kammerat");
        }
    }

    public void SeeTopJuniorSwimmers() {
        System.out.println("\n Vælg Svømme-disciplin");
        System.out.println("1.  Top 5 Crawl");
        System.out.println("2.  Top 5 Brystsvømning");
        System.out.println("3.  Top 5 Butterfly");
        System.out.println("4.  Top 5 Backcrawl");
        System.out.print("Vælg Disciplin: ");


        switch (sc.nextLine()) {
            case "1" -> TopFiveCrawl(AgeGroup.JUNIOR);
            case "2" -> TopFiveBreast(AgeGroup.JUNIOR);
            case "3" -> TopFiveButterfly(AgeGroup.JUNIOR);
            case "4" -> TopFiveBcrawl(AgeGroup.JUNIOR);
            default -> System.out.println("Forkert valg kammerat");
        }
    }

    private void TopFiveButterfly(AgeGroup ageGroup) {
        memberList.top5ForDiscipline(ageGroup, Gender.MALE, Discipline.BUTTERFLY);

    }

    private void TopFiveBcrawl(AgeGroup ageGroup) {
        memberList.top5ForDiscipline(ageGroup, Gender.MALE, Discipline.BACKCRAWL);
    }

    private void TopFiveBreast(AgeGroup ageGroup) {
        memberList.top5ForDiscipline(ageGroup, Gender.MALE, Discipline.BREASTSTROKE);
    }

    private void TopFiveCrawl(AgeGroup ageGroup) {
        memberList.top5ForDiscipline(ageGroup, Gender.MALE, Discipline.CRAWL);
    }

    public void ShowAccountingMenu() {
        boolean running = true;

        while (running){
            System.out.println("=== Økonomimenu ===");
            System.out.println("1. Vis Samlet kontingentindkomst");
            System.out.println("2. Vis medlemmer i restance");
            System.out.println("3. Tilbage til hovedmenu");
            System.out.println("Vælg: ");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice){
                case 1:
                //Bruger MemberLists totalIncome-metode
                    System.out.println(memberList.totalIncome());
                    break;

                case 2:
                    //Hent alle medlemmer og filtrér med Economy.membersInArrears
                        List<Member> inArrears = memberList.getMembersInArrears();

                        if (inArrears.isEmpty()){
                            System.out.println("Der er ingen medlemmer i restance.");
                        }else {
                            System.out.println("Medlemmer i restance:");
                            for (Member m : inArrears){
                                System.out.println(m);
                            }
                        }
                        break;

                case 3:
                    running = false; //Tilbage til hovedmenu
                    break;
                default:
                    System.out.println("Ugyldigt valg, prøv igen.");


            }
        }

    }


}