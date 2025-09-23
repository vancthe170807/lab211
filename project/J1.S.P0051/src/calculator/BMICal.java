package calculator;

import java.util.Scanner;

public class BMICal {
    
    private static final Scanner in = new Scanner(System.in);

    /**
     * Determines the BMI status based on the given BMI value.
     *
     * @param bmi a double value representing the Body Mass Index
     * @return a String indicating the BMI status
     */
    public static String BMIStatus(double bmi) {
        // Check if BMI is less than 19
        if (bmi < 19) {
            return "Under-standard.";
        }
        // Check if BMI is less than 25
        else if (bmi < 25) {
            return "Standard.";
        }
        // Check if BMI is less than 30
        else if (bmi < 30) {
            return "Overweight.";
        }
        // Check if BMI is less than 40
        else if (bmi < 40) {
            return "Fat-should lose weight";
        }
        // BMI is 40 or greater
        else {
            return "Very fat - should lose weight immediately";
        }
    }

    /**
     * This method is used to calculate the BMI and output the status of BMI.
     */
    public static void BMICalculator() {
        System.out.println("----- BMI Calculator -----");
        System.out.print("Enter Weight(kg): ");
        double weight = Validate.possitiveNumber();
        System.out.print("Enter Height(cm): ");
        double height = Validate.possitiveNumber();
        double bmi = weight * 10000 / (height * height);
        System.out.printf("BMI number: %.2f%n", bmi);
        System.out.println("BMI Status: " + BMIStatus(bmi));
    }
}
