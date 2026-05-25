package utils;

import java.util.Scanner;

/**
 * Validation class to verify user inputs.
 */
public class Validation {

    private final Scanner sc;

    /**
     * Constructor initializes scanner.
     */
    public Validation () {
        this.sc = new Scanner(System.in);
    }

    /**
     * Gets a valid integer input from console.
     * 
     * @param msg Input prompt
     * @param min Minimum bound
     * @param max Maximum bound
     * @return Validated integer
     */
    public int getInteger (String msg, int min, int max) {
        int output;
        
        // Loop continuously to fetch number
        while (true) {
            String input;
            boolean isEmpty;
            
            System.out.print(msg);
            
            input = sc.nextLine();
            isEmpty = input.isEmpty();

            // Handle empty input
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

                // Validate boundaries
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
     * Gets a string matching designated regex pattern.
     * 
     * @param msg Input prompt
     * @param regex Regex pattern
     * @param exampleOfRegex Expected example
     * @return Validated string
     */
    public String getString (String msg, String regex, String exampleOfRegex) {
        String output;
        
        // Loop formatting loop
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

            // Check if string adheres to rules
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
     * Gets binary choice Y or N.
     * 
     * @param msg Input prompt
     * @return boolean evaluation of choice
     */
    public boolean checkYN (String msg) {
        boolean resultBool;
        
        // Loop binary input check
        while (true) {
            String resultStr;
            boolean isY;
            boolean isN;
            
            resultStr = getString(msg, Constants.REGEX_YN, "Y or N");
            
            isY = resultStr.equalsIgnoreCase("Y");
            isN = resultStr.equalsIgnoreCase("N");

            // Evaluate branches to boolean
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
     * Gets Update or Delete string character.
     * 
     * @param msg Input prompt
     * @return Upper cased U or D
     */
    public String checkUD (String msg) {
        String resultStr;
        String upperStr;

        // Uses loop for regex guard
        while (true) {
            resultStr = getString(msg, Constants.REGEX_UD, "U or D");
            upperStr = resultStr.toUpperCase();
            
            return upperStr;
        }
    }
}