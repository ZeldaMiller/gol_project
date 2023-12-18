// Marilyn Nguyen and Zelda Miller
// IS 247 - Paul Comitz
// Game Of Life Final Project


import java.util.Scanner;

//This main class will take in user input to set up the game and creates the game.
public class Main {
    public static void main(String[] args){
     Scanner scanner = new Scanner(System.in);

     //A series of questions to set up the game of life game board.
        //Asks the user for the number of rows for the game board grid:
     System.out.print("Enter the number of rows: ");
     int rows = scanner.nextInt();

        //Asks the user for the number of columns for the game board grid:
     System.out.print("Enter the number of columns: ");
     int columns = scanner.nextInt();

        //Asks the user for the number of cell generations:
     System.out.print("Enter the number of generations: ");
     int generations = scanner.nextInt();

        //Asks the user for the delay time between each cell generations:
     System.out.print("Enter the delay time between generations (in milliseconds): ");
     long sleepTime = scanner.nextLong();

        //Asks the user for the cell pattern:
     System.out.println("Choose between these 6 patterns.");
     System.out.println("1) Glider.pat  | 2) GliderGun.pat | 3) Spaceship.pat");
     System.out.println("4) Tumbler.pat | 5) 10CellRow.pat | 6) Exploder.pat");
     System.out.print("Enter the file name for the pattern you want: ");
     String patternFileName = scanner.next();

    //Creates a new game of life game using model view con5
        // Controller:
        Controller game = new Controller(rows, columns, patternFileName);
        try {
            game.runGame(generations, sleepTime);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        scanner.close();
    }
}
