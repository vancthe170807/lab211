import java.util.Locale;

public class Menu {
    private final Validation validation;
    private final LoginService loginService;

    public Menu() {
        validation = new Validation();
        loginService = new LoginService(validation);
    }

    public void display() {
        Locale vietnamese = new Locale("vi");
        Locale english = Locale.ENGLISH;

        System.out.println("===== [LAB211] J1.S.P0070 - LOGIN PROGRAM FOR TIEN PHONG BANK'S EBANK =====");
        System.out.println("------- Login Program -------");
        System.out.println("1. Vietnamese");
        System.out.println("2. English");
        System.out.println("3. Exit");
        System.out.print("Please choice one option: ");

        int choice = validation.checkInputIntLimit(1, 3, english);
        switch (choice) {
            case 1 -> loginService.login(vietnamese);
            case 2 -> loginService.login(english);
            case 3 -> System.out.println("Goodbye!");
        }
    }}
