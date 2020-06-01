import java.awt.Point;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;


/*

	Represents a 2D maze.

	Coded by:
	Modified on:

*/

public class Maze {

	private static final int rows = 20;
	private static final int cols = 20;

	private char[][] grid;

	// Constructs an empty grid
	public Maze() {
		grid = new char[cols][rows];
	}

	// Constructs the grid defined in the file specified
	public Maze(String filename) {
		grid = readData(filename);
	}

	// Attempts to find a path through the maze and returns whether a path was found or not
	public boolean solve() {
		// Loop through all elements of the grid:
			// Is the character at this spot?
				// Call solve with this location & return the value
		
		// Character not found - return false
	}
	
	
	
	// Private recursive version of solve()
	private boolean solve(int i, int j) {
		// Am I at a wall? (Base case)
			// return false
		// Am I at a place I've been before? (Base case)
			// return false
		// Am I at the exit? (Base case)
			// return true

		// Otherwise: (Recursive case)
			// Drop a !
		
			// Try up
			// Did you find an exit that way?
				// return true		
		
			// Try down
			// Did you find an exit that way?
				// return true
		
			// Try left
			// Did you find an exit that way?
				// return true
		
			// Try right
			// Did you find an exit that way?
				// return true
		
			// There are no directions that lead to an exit. Pick up the !
			// return false
	}
	

	// Formats this grid as a String to be printed (one call to this method returns the whole multi-line grid)
	public String toString() {
		String output = "";
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[i].length; j++) {
				output += grid[i][j];
			}
			output += "\n";
		}
		return output;
	}
	

	public char[][] readData (String filename) {
		File dataFile = new File(filename);

		if (dataFile.exists()) {
			char[][] gameData = new char[cols][rows];

			int count = 0;

			FileReader reader = null;
			try {
					reader = new FileReader(dataFile);
					Scanner in = new Scanner(reader);


					while (in.hasNext() && count < rows) {
						String line = in.nextLine();
						for(int i = 0; i < line.length(); i++)
							gameData[count][i] = line.charAt(i);

						count++;
					}

			} catch (IOException ex) {
				System.out.println("File cannot be read.");
				return null;
			} catch (NumberFormatException ex) {
				System.out.println("File is in the wrong format.");
				return null;
			} finally {
				try {
					reader.close();
				} catch (IOException ex) {
					System.out.println("File cannot be closed.");
					return null;
				}
			}
			return gameData;
		} else {
			throw new IllegalArgumentException("Data file " + filename + " does not exist.");
		}
    }

}