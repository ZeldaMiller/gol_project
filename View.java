//View class that displays the game board and the cell generation.
public class View {
    // Method to print the current state of the grid.
    // This also prints out a dotted line border around the grid.
    public void printGrid(boolean[][] grid, int generationNum) {
        System.out.println("-------------"); // Top border
        for (boolean[] row : grid) {
            for (boolean cell : row) {
                System.out.print(cell ? "*" : " ");
            }
            System.out.println();
        }
        System.out.println("-------------"); // Bottom border
        System.out.println("Generation #: " + generationNum); //Displays the generation count
    }

    // Method to display the delimiter using the delimiter char "="
    public void displayDelimiter() {
        System.out.println("=========================================");
    }

    // Method to clear the screen to reset for a new cell generation
    public void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}
