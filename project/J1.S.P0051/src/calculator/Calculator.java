package calculator;

import java.util.Scanner;

public class Calculator {
    
    private static final Scanner in = new Scanner(System.in);
    
    public static String checkInputOperator() {
        //loop until user input correct
        while (true) {
            String result = in.nextLine().trim();
            if (result.isEmpty()) {
                System.err.println("Not empty");
            } else if (result.equalsIgnoreCase("+")
                    || result.equalsIgnoreCase("-")
                    || result.equalsIgnoreCase("*")
                    || result.equalsIgnoreCase("/")
                    || result.equalsIgnoreCase("^")
                    || result.equalsIgnoreCase("=")) {
                return result;
            } else {
                System.err.println("Please input (+, -, *, /, ^)");
            }
            System.out.print("Enter again: ");
        }
    }

    //allow user input number
    public static double inputNumber() {
        System.out.print("Enter number: ");
        double number = Validate.checkInputDouble();
        return number;
    }
    
    //Noi divide 0
    public static double divideNumber() {
        //loop until user input correct
        System.out.print("Enter number: ");
        while (true) {
            try {
                double result = Double.parseDouble(in.nextLine());
                if(result == 0) {
                    throw new ArithmeticException();
                }
                return result;
            } catch (ArithmeticException e) {
                System.err.println("The calculator not divide 0!");
                System.out.print("Enter again: ");
            }
        }
    }

    //allow user calculator normal
    public static void normalCalculator() {
        double memory;
        System.out.println("----- Normal Calculator -----");
        System.out.print("Enter number: ");
        memory = Validate.checkInputDouble();
        while (true) {
            System.out.print("Enter operator: ");
            String operator = checkInputOperator();
            if (operator.equalsIgnoreCase("+")) {
                memory += inputNumber();
                System.out.println("Memory: " + memory);
            }
            if (operator.equalsIgnoreCase("-")) {
                memory -= inputNumber();
                System.out.println("Memory: " + memory);
            }
            if (operator.equalsIgnoreCase("*")) {
                memory *= inputNumber();
                System.out.println("Memory: " + memory);
            }
            if (operator.equalsIgnoreCase("/")) {
                memory /= divideNumber();
                System.out.println("Memory: " + memory);
            }
            if (operator.equalsIgnoreCase("^")) {
                memory = Math.pow(memory, inputNumber());
                System.out.println("Memory: " + memory);
            }
            if (operator.equalsIgnoreCase("=")) {
                System.out.println("Result: " + memory);
                return;
            }
        }

    }
}
