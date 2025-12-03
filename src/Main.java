import java.io.FileReader;
import java.time.LocalDate;

public class Main {

    public static void main(String[] args) {

        MemberList list = new MemberList();






        MenuSystem menu = new MenuSystem(list);

        menu.showMainMenu();

    }
}