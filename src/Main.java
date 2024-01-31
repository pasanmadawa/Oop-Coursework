import javax.swing.*;


public class Main extends JFrame{
    public static void main(String[] args) {

        WestminsterShoppingManager manager = new WestminsterShoppingManager();
        manager.userLoad();
        manager.load();
        manager.console();


    }
}