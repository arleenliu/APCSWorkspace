import java.awt.Point;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import processing.core.PApplet;

/*

	Represents a Game Of Life grid.

	Coded by:
	Modified on:

*/

public class MazeObject {

	char[][] grid;
	int[][] neighbors;
	ArrayList<Point> points;

	// Constructs an empty grid
	public MazeObject() {
		grid = new char[20][20];
		neighbors = new int[20][20];
		points = new ArrayList<>();
	}

	// Constructs the grid defined in the file specified
	public MazeObject(String filename) {
		grid = new char[20][20];
		neighbors = new int[20][20];
		points = new ArrayList<>();
		readData(filename, grid);
	}

	// public int countNeighbors(int j, int i) {
	//
	// int nb = 0;
	// for (int x = -1; x < 2; x++) {
	// for (int y = -1; y < 2; y++) {
	// if (j + x < grid.length && j + x > -1 && i + y < grid[0].length && i + y > -1
	// && grid[j + x][i + y]) {
	// nb++;
	// }
	// }
	// }
	//
	// if (grid[j][i]) {
	// nb--;
	// }
	//
	// System.out.println(nb);
	// return nb;
	//
	// }

	// Runs a single turn of the Game Of Life
	public void step() {
		for (int i = 0; i < grid[0].length; i++) {
			for (int j = 0; j < grid.length; j++) {
				// System.out.println(countNeighbors(j, i));
				// neighbors[j][i] = countNeighbors(j, i);
			}
		}

		for (int i = 0; i < grid[0].length; i++) {
			for (int j = 0; j < grid.length; j++) {
				if (neighbors[j][i] == 3) {
					// grid[j][i] = true;
				}
				if (neighbors[j][i] <= 1 || neighbors[j][i] >= 4) {
					// grid[j][i] = false;
				}
			}
		}
	}

	// Runs n turns of the Game Of Life
	public void step(int n) {
		for (int i = 0; i < n; i++) {
			step();
		}
	}

	// Formats this Life grid as a String to be printed (one call to this method
	// returns the whole multi-line grid)
	public void findPath(double x, double y) {

		findConnectedPoints(new Point((int) x, (int) y));

		for (int i = 0; i < points.size(); i++) {
			grid[(int) points.get(i).getX()][(int) points.get(i).getY()] = '!';
		}

		points.clear();
	}

	public String toString() {
		String response = "";
		// dead = "-"
		// alive = "*"
		for (int i = 0; i < grid[0].length; i++) {
			for (int j = 0; j < grid.length; j++) {
				response += grid[j][i];
			}
			response += "\n";
		}

		return response;
	}

	private void findConnectedPoints(Point p) {
		if (p.getX() - 1 >= 0 && (grid[(int) (p.getX() - 1)][(int) p.getY()] == '.'
				|| grid[(int) (p.getX() - 1)][(int) p.getY()] == 'X')) {
			Point newP = new Point((int) p.getX() - 1, (int) p.getY());

			if (grid[(int) (p.getX() - 1)][(int) p.getY()] == 'X')
				return;
			
			if (points.indexOf(newP) == -1) {
				points.add(newP);
				findConnectedPoints(newP);
			}
		}

		if (p.getY() - 1 >= 0 && (grid[(int) (p.getX())][(int) p.getY() - 1] == '.' 
				|| grid[(int) (p.getX())][(int) p.getY() - 1] == 'X')) {
			Point newP = new Point((int) p.getX(), (int) p.getY() - 1);
			
			if (grid[(int) (p.getX())][(int) p.getY() - 1] == 'X')
				return;

			if (points.indexOf(newP) == -1) {
				points.add(newP);
				findConnectedPoints(newP);
			}
		}

		if (p.getX() + 1 < grid.length && (grid[(int) (p.getX() + 1)][(int) p.getY()] == '.' 
				|| grid[(int) (p.getX() + 1)][(int) p.getY()] == 'X')) {
			Point newP = new Point((int) p.getX() + 1, (int) p.getY());
			
			if (grid[(int) (p.getX() + 1)][(int) p.getY()] == 'X')
				return;

			if (points.indexOf(newP) == -1) {
				points.add(newP);
				findConnectedPoints(newP);
			}
		}

		if (p.getY() + 1 < grid.length && (grid[(int) (p.getX())][(int) p.getY() + 1] == '.'
				|| grid[(int) (p.getX())][(int) p.getY() + 1] == 'X')) {
			Point newP = new Point((int) p.getX(), (int) p.getY() + 1);
			
			if (grid[(int) (p.getX())][(int) p.getY() + 1] == 'X') 
				return;

			if (points.indexOf(newP) == -1) {
				points.add(newP);
				findConnectedPoints(newP);
			}
		}
	}

	// Reads in array data from a simple text file containing asterisks (*)
	public void readData(String filename, char[][] gameData) {
		File dataFile = new File(filename);

		if (dataFile.exists()) {
			int count = 0;

			FileReader reader = null;
			Scanner in = null;
			try {
				reader = new FileReader(dataFile);
				in = new Scanner(reader);

				while (in.hasNext()) {
					String line = in.nextLine();
					for (int i = 0; i < line.length(); i++)
						if (i < gameData.length && count < gameData[i].length)
							gameData[i][count] = line.charAt(i);

					count++;
				}
			} catch (IOException ex) {
				throw new IllegalArgumentException("Data file " + filename + " cannot be read.");
			} finally {
				if (in != null)
					in.close();
			}

		} else {
			throw new IllegalArgumentException("Data file " + filename + " does not exist.");
		}
	}

	/**
	 * Optionally, complete this method to draw the grid on a PApplet.
	 * 
	 * @param marker
	 *            The PApplet used for drawing.
	 * @param x
	 *            The x pixel coordinate of the upper left corner of the grid
	 *            drawing.
	 * @param y
	 *            The y pixel coordinate of the upper left corner of the grid
	 *            drawing.
	 * @param width
	 *            The pixel width of the grid drawing.
	 * @param height
	 *            The pixel height of the grid drawing.
	 */
	public void draw(PApplet marker, float x, float y, float width, float height) {

		marker.pushStyle();
		float cellWidth = width / grid.length;
		float cellHeight = height / grid[0].length;
		marker.stroke(0);
		// dead = "-"
		// alive = "*"
		for (int i = 0; i < grid[0].length; i++) {
			for (int j = 0; j < grid.length; j++) {
				if (grid[j][i] == '*') {
					marker.fill(0);
				} else {
					marker.fill(255);
				}
				marker.rect(j * cellWidth + x, i * cellHeight + y, cellWidth, cellHeight);
			}
		}
		marker.popStyle();
	}

	/**
	 * Optionally, complete this method to determine which element of the grid
	 * matches with a particular pixel coordinate.
	 * 
	 * @param p
	 *            A Point object representing a graphical pixel coordinate.
	 * @param x
	 *            The x pixel coordinate of the upper left corner of the grid
	 *            drawing.
	 * @param y
	 *            The y pixel coordinate of the upper left corner of the grid
	 *            drawing.
	 * @param width
	 *            The pixel width of the grid drawing.
	 * @param height
	 *            The pixel height of the grid drawing.
	 * @return A Point object representing a coordinate within the game of life
	 *         grid.
	 */
	public Point clickToIndex(Point p, float x, float y, float width, float height) {
		float cellWidth = width / grid.length;
		float cellHeight = height / grid[0].length;

		int j = (int) ((p.getX() - x) / cellWidth);
		int i = (int) ((p.getY() - y) / cellHeight);

		if (j < 0 || j >= grid.length) {
			return null;
		}
		if (i < 0 || i >= grid[0].length) {
			return null;
		}

		points.add(new Point(j, i));

		return new Point(j, i);
	}

	/**
	 * Optionally, complete this method to toggle a cell in the game of life grid
	 * between alive and dead.
	 * 
	 * @param i
	 *            The x coordinate of the cell in the grid.
	 * @param j
	 *            The y coordinate of the cell in the grid.
	 */
	// public void toggleCell(int i, int j) {
	// grid[i][j] = !grid[i][j];
	// }

}