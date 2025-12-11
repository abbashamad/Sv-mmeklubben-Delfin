import delfin.files.FileHandler;
import delfin.mainsystem.MemberList;
import delfin.mainsystem.MenuSystem;

public class Main {

    public static void main(String[] args) {

        MemberList list = new MemberList();
        MenuSystem menu = new MenuSystem(list);

        FileHandler.decodeFile("MemberData.csv", list);
        FileHandler.decodeFile("SwimResultData.csv", list);

        menu.showMainMenu();
    }

}