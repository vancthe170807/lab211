package calculator;

import java.util.Scanner;

public class Manager {
    private static final Scanner in = new Scanner(System.in);

    //display menu
    public static int menu() {
        System.out.println("===== [LAB211] J1.S.P0051 - DEVELOP A COMPUTER PROGRAM. =====");
        System.out.println("======== Calculator Program ========");
        System.out.println("1. Normal Calculator");
        System.out.println("2. BMI Calculator");
        System.out.println("3. Exit");
        System.out.print("Please choice one option: ");
        int choice = Validate.checkInputIntLimit(1, 3);
        return choice;
    }

}