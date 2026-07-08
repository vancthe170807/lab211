import controller.StudentController;

/**
 * Entry point of the student management application.
 */
public class Main {
    
    /**
     * Starts the application by creating the controller and running the program.
     *
     * @param args Command-line arguments passed to the program.
     */
    public static void main (String[] args) {
        StudentController controller;
        
        controller = new StudentController();
        
        controller.run();
    }
}