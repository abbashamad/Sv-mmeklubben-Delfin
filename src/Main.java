import java.time.LocalDate;

public class Main {

    public static void main(String[] args) {

        MemberList list = new MemberList();



        list.addEliteToMemberList(LocalDate.of(2011, 11, 5), "KASPER@RR", "KASPER", Gender.MALE);
        EliteMember e0 = (EliteMember) list.findMemberViaID(1);
        e0.addCompSwimResultsToList(Discipline.CRAWL, new SwimTimer(1, 3, 82), LocalDate.of(2011, 9, 10), 1, "Horsens");

        list.addEliteToMemberList(LocalDate.of(2012, 3, 12), "ANNA@RR", "Anna", Gender.FEMALE);
        EliteMember e1 = (EliteMember) list.findMemberViaID(2);
        e1.addCompSwimResultsToList(Discipline.CRAWL, new SwimTimer(0, 58, 32), LocalDate.of(2012, 5, 20), 1, "Aarhus");

        list.addEliteToMemberList(LocalDate.of(2013, 7, 2), "MADS@RR", "Mads", Gender.MALE);
        EliteMember e2 = (EliteMember) list.findMemberViaID(3);
        e2.addCompSwimResultsToList(Discipline.BACKCRAWL, new SwimTimer(1, 4, 12), LocalDate.of(2013, 9, 14), 2, "Odense");

        list.addEliteToMemberList(LocalDate.of(2014, 1, 8), "LIVA@RR", "Liva", Gender.FEMALE);
        EliteMember e3 = (EliteMember) list.findMemberViaID(4);
        e3.addCompSwimResultsToList(Discipline.BREASTSTROKE, new SwimTimer(1, 16, 45), LocalDate.of(2014, 4, 18), 3, "Horsens");

        list.addEliteToMemberList(LocalDate.of(2015, 11, 22), "TOBIAS@RR", "Tobias", Gender.MALE);
        EliteMember e4 = (EliteMember) list.findMemberViaID(5);
        e4.addCompSwimResultsToList(Discipline.BUTTERFLY, new SwimTimer(1, 2, 27), LocalDate.of(2016, 2, 10), 1, "Vejle");

        list.addEliteToMemberList(LocalDate.of(2016, 6, 18), "SARA@RR", "Sara", Gender.FEMALE);
        EliteMember e5 = (EliteMember) list.findMemberViaID(6);
        e5.addCompSwimResultsToList(Discipline.CRAWL, new SwimTimer(0, 55, 91), LocalDate.of(2016, 9, 3), 1, "Aalborg");

        list.addEliteToMemberList(LocalDate.of(2016, 8, 5), "EMIL@RR", "Emil", Gender.MALE);
        EliteMember e6 = (EliteMember) list.findMemberViaID(7);
        e6.addCompSwimResultsToList(Discipline.BREASTSTROKE, new SwimTimer(1, 18, 33), LocalDate.of(2007, 1, 22), 4, "Silkeborg");

        list.addEliteToMemberList(LocalDate.of(2017, 4, 19), "FREJA@RR", "Freja", Gender.FEMALE);
        EliteMember e7 = (EliteMember) list.findMemberViaID(8);
        e7.addCompSwimResultsToList(Discipline.BACKCRAWL, new SwimTimer(1, 7, 55), LocalDate.of(2009, 6, 11), 2, "Skanderborg");

        list.addEliteToMemberList(LocalDate.of(2018, 9, 27), "MALTHE@RR", "Malthe", Gender.MALE);
        EliteMember e8 = (EliteMember) list.findMemberViaID(9);
        e8.addCompSwimResultsToList(Discipline.BUTTERFLY, new SwimTimer(1, 3, 88), LocalDate.of(1950, 12, 9), 3, "Horsens");

        list.addEliteToMemberList(LocalDate.of(2019, 2, 13), "NANNA@RR", "Nanna", Gender.FEMALE);
        EliteMember e9 = (EliteMember) list.findMemberViaID(10);
        e9.addCompSwimResultsToList(Discipline.CRAWL, new SwimTimer(1, 1, 72), LocalDate.of(1950, 4, 6), 5, "Fredericia");

        list.addEliteToMemberList(LocalDate.of(2020, 3, 7), "JAKOB@RR", "Jakob", Gender.MALE);
        EliteMember e10 = (EliteMember) list.findMemberViaID(11);
        e10.addCompSwimResultsToList(Discipline.BREASTSTROKE, new SwimTimer(1, 20, 15), LocalDate.of(1953, 6, 20), 6, "Sønderborg");

        list.addEliteToMemberList(LocalDate.of(2020, 5, 30), "ALMA@RR", "Alma", Gender.FEMALE);
        EliteMember e11 = (EliteMember) list.findMemberViaID(12);
        e11.addCompSwimResultsToList(Discipline.BUTTERFLY, new SwimTimer(1, 4, 60), LocalDate.of(1960, 10, 2), 2, "Aarhus");

        list.addEliteToMemberList(LocalDate.of(2021, 12, 3), "LAURITS@RR", "Laurits", Gender.MALE);
        EliteMember e12 = (EliteMember) list.findMemberViaID(13);
        e12.addCompSwimResultsToList(Discipline.CRAWL, new SwimTimer(0, 57, 43), LocalDate.of(1932, 2, 12), 1, "Kolding");

        list.addEliteToMemberList(LocalDate.of(2000, 4, 14), "SOFIE@RR", "Sofie", Gender.FEMALE);
        EliteMember e13 = (EliteMember) list.findMemberViaID(14);
        e13.addCompSwimResultsToList(Discipline.BACKCRAWL, new SwimTimer(1, 6, 5), LocalDate.of(1945, 7, 1), 2, "Horsens");

        list.addEliteToMemberList(LocalDate.of(2023, 1, 9), "VICTOR@RR", "Victor", Gender.MALE);
        EliteMember e14 = (EliteMember) list.findMemberViaID(15);
        e14.addCompSwimResultsToList(Discipline.BUTTERFLY, new SwimTimer(1, 2, 90), LocalDate.of(2018, 5, 15), 1, "Randers");
        e14.getSubscription().setActivity();

        list.addEliteToMemberList(LocalDate.of(1955, 8, 11), "ELLEN@RR", "Ellen", Gender.FEMALE);
        EliteMember e15 = (EliteMember) list.findMemberViaID(16);
        e15.addCompSwimResultsToList(Discipline.BREASTSTROKE, new SwimTimer(1, 17, 8), LocalDate.of(2001, 10, 30), 3, "Esbjerg");

        System.out.println(list.totalIncome());

        System.out.println(e0.getBestTimeForDiscipline(Discipline.CRAWL));

        MenuSystem menu = new MenuSystem(list);

        menu.showMainMenu();

    }
}