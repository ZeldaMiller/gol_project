import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

// Model Class that performs most of the calculation of the game and checks the cell's neighbors
public class Model {
    private boolean[][] grid;

    // Constructor to initialize the grid with a glider population
    public Model(int rows, int cols, String patternFileName) {
        grid = new boolean[rows][cols];
        initializePattern(patternFileName);
    }

    // Method to initialize the grid with a specific pattern from the files.
    private void initializePattern(String patternFileName) {
        try (BufferedReader reader = new BufferedReader(new FileReader(patternFileName))) {
            String line;
            int row = 0;

            while ((line = reader.readLine()) != null && row < grid.length) {
                for (int col = 0; col < line.length() && col < grid[0].length; col++) {
                    grid[row][col] = (line.charAt(col) == '*');
                }
                row++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Method that gets the current state of the grid
    public boolean[][] getGrid() {
        return grid;
    }

    // Method to update the grid based on Conway's 3 Rules
    public void updateGrid() {
        boolean[][] newGrid = new boolean[grid.length][grid[0].length];

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                int neighbors = countNeighbors(i, j);
                // Checks the Generation Using Conway's Game Of Life Rules
                // Survival Rule
                if (grid[i][j]) {
                    newGrid[i][j] = (neighbors == 2 || neighbors == 3);
                } else {
                    // Birth Rule
                    newGrid[i][j] = (neighbors == 3);
                }
                // Overcrowding Rule
                if (grid[i][j] && neighbors > 3) {
                    newGrid[i][j] = false;
                }
                // Loneliness Rule
                if (grid[i][j] && neighbors < 2) {
                    newGrid[i][j] = false;
                }
            }
        }
        grid = newGrid;
    }

    // Method that counts the number of live neighbors of a cell.
    private int countNeighbors(int row, int col) {
        int count = 0;

        for (int i = row - 1; i <= row + 1; i++) {
            for (int j = col - 1; j <= col + 1; j++) {
                if (i >= 0 && i < grid.length && j >= 0 && j < grid[0].length && !(i == row && j == col)) {
                    if (grid[i][j]) {
                        count++;
                    }
                }
            }
        }
        return count;
    }
}
