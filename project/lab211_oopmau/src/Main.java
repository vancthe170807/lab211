import controller.StudentController;
import model.StudentModel;
import view.StudentView;
import utils.Validation;

/**
 * Bootstrap entry point for the Student Management application.
 */
public class Main {
    public static void main(String[] args) {
        StudentModel model = new StudentModel();
        StudentView view = new StudentView();
        Validation validation = new Validation();
        
        StudentController controller = new StudentController(model, view, validation);
        controller.run();
    }
}
