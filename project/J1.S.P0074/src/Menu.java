import java.sql.SQLOutput;

public class Menu {
    public int menu() {
        Validation validation = new Validation();
        System.out.println("======== Calculator Program ========");
        System.out.println("1. Addition Matrix");
        System.out.println("2. Subtraction Matrix");
        System.out.println("3. Multiplication Matrix");
        System.out.println("4. Quit");
        System.out.print("Your choice: ");
        int choice = validation.checkIntLimit(1, 4);
        return choice;
    }
}
