package manager;

import controller.FruitController;

/**
 * The Main class serves as the entry point for the Fruit Shop application.
 */
public class Main {

    /**
     * The main entry method that initializes and starts the application controller.
     *
     * @param args Command line arguments (not used)
     */
    public static void main(String[] args) {
        FruitController fruitController;

        fruitController = new FruitController();

        fruitController.start();
    }
}
