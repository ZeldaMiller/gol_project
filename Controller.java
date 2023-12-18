//Controller Class that integrates the model class and view class
public class Controller {
    private Model model;
    private View view;

    // Constructor to initialize the model and view class.
    public Controller(int rows, int columns, String patternFileName) {
        model = new Model(rows, columns, patternFileName);
        view = new View();
    }

    // Method to run the game using the model and view class.
    public void runGame(int generations, long sleepTime) throws InterruptedException {
        for (int gen = 0; gen < generations; gen++) {
            view.clearScreen();
            view.printGrid(model.getGrid(), gen);

            // Display delimiter between generations
            view.displayDelimiter();

            //Updates the grid to display a new generation
            model.updateGrid();
            Thread.sleep(sleepTime); //the sleep/delay time in between each generation
        }
    }
}
