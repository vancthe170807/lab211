package calculator;

public class Main {

    public static void main(String[] args) {
        // Continuously display the menu until the user chooses to exit
        while (true) {
            // Display the menu and get the user's choice
            int choice = Manager.menu();
            switch (choice) {
                case 1:
                    // Invoke the normal calculator
                    Calculator.normalCalculator();
                    break;
                case 2:
                    // Invoke the BMI calculator
                    BMICal.BMICalculator();
                    break;
                case 3:
                    // Exit the program
                    return;
            }
        }
    }
    
}
