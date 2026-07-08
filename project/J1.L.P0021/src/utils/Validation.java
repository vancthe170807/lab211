package utils;

import java.util.Scanner;

/**
 * Validates user input for the console application.
 */
public class Validation {

    private final Scanner sc;
    private final Constants constants;

    /**
     * Initializes the scanner and constants helper.
     */
    public Validation () {
        this.sc = new Scanner(System.in);
        this.constants = new Constants();
    }

    /**
     * Reads a valid integer input from the console.
     *
     * @param msg The prompt shown to the user.
     * @param min The minimum allowed value.
     * @param max The maximum allowed value.
     * @return A validated integer within the given range.
     */
    public int getInteger (String msg, int min, int max) {
        int output;
        
        while (true) {
            String input;
            boolean isEmpty;
            
            System.out.print(msg);
            
            input = sc.nextLine();
            isEmpty = input.isEmpty();

            if (isEmpty) {
                System.out.println("Input cannot be empty, please try again");
                continue;
            }

            try {
                boolean isTooSmall;
                boolean isTooLarge;
                boolean isOutOfRange;

                output = Integer.parseInt(input);
                
                isTooSmall = output < min;
                isTooLarge = output > max;
                isOutOfRange = isTooSmall || 
                               isTooLarge;

                if (isOutOfRange) {
                    StringBuilder rangeBuilder;
                    
                    rangeBuilder = new StringBuilder();
                    
                    rangeBuilder.append("Input must be in range [");
                    rangeBuilder.append(min);
                    rangeBuilder.append(",");
                    rangeBuilder.append(max);
                    rangeBuilder.append("], please try again");
                    
                    System.out.println(rangeBuilder.toString());
                    continue;
                }

                break;
            } catch (NumberFormatException e) {
                System.out.println("Input must be integer");
            }
        }

        return output;
    }

    /**
     * Reads a string that matches the given regular expression.
     *
     * @param msg The prompt shown to the user.
     * @param regex The regular expression pattern.
     * @param exampleOfRegex An example of the expected format.
     * @return A validated string.
     */
    public String getString (String msg, String regex, String exampleOfRegex) {
        String output;
        
        while (true) {
            boolean isEmptyRegex;
            boolean isMatch;
            boolean isValid;
            
            System.out.print(msg);
            
            output = sc.nextLine();
            
            isEmptyRegex = regex.isEmpty();
            isMatch = output.matches(regex);
            isValid = isEmptyRegex || 
                      isMatch;

            if (isValid) {
                break;
            } else {
                StringBuilder errorBuilder;
                
                errorBuilder = new StringBuilder();
                
                errorBuilder.append("Incorrect format input. Correct like: ");
                errorBuilder.append(exampleOfRegex);
                
                System.out.println(errorBuilder.toString());
            }
        }

        return output;
    }

    /**
     * Reads a yes/no choice from the user.
     *
     * @param msg The prompt shown to the user.
     * @return True for Y, false for N.
     */
    public boolean checkYN (String msg) {
        boolean resultBool;
        
        while (true) {
            String resultStr;
            boolean isY;
            boolean isN;
            
            resultStr = getString(msg, constants.REGEX_YN, "Y or N");
            
            isY = resultStr.equalsIgnoreCase("Y");
            isN = resultStr.equalsIgnoreCase("N");

            if (isY) {
                resultBool = true;
                break;
            }

            if (isN) {
                resultBool = false;
                break;
            }
        }

        return resultBool;
    }

    /**
     * Reads an update/delete choice from the user.
     *
     * @param msg The prompt shown to the user.
     * @return A normalized value of U or D.
     */
    public String checkUD (String msg) {
        String resultStr;
        String upperStr;

        while (true) {
            resultStr = getString(msg, constants.REGEX_UD, "U or D");
            upperStr = resultStr.toUpperCase();
            
            return upperStr;
        }
    }
}