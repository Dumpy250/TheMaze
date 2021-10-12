package Main;

import java.util.Scanner;
import java.io.FileInputStream;
import java.io.IOException;


/**
 * The File Reader Class reads from a formated text file that contains a 2d array along
 *  with its characteristics size, width, and height.
 * 
 * 	@author Cameron "Dumpy" Basham
 *	@version 1.0
 *
 */
public class FileReader {

/**
 * Reads input from file.
 */
public static FileInputStream fileByteStream = null;
/**
 * String reader.
 */
public static Scanner inFS = null;
/**
 * int Width of the maze.
 */
public static int width = 0;
/**
 * int Height of the Maze
 */
public static int height = 0;
/**
 * The Start Position read from file.
 */
public static Position Start;
/**
 * The Finish Position read from file.
 */
public static Position Finish;
/**
 * 2D int array representing the maze.
 */
public static int[][] Maze;
		
	/**
	 * This method reads from RawMaze.txt storing its contents into the 2d Maze array.
	 * The method then creates a Start and Finish Position according to the text file.
	 */
	public static void ReadFile() {
		
		try {			
			fileByteStream = new FileInputStream("RawMaze.txt");
			inFS = new Scanner(fileByteStream);			
		}
		
		catch (IOException Fail){			
			System.out.println(Fail.getMessage());
					}	
		
		width = inFS.nextInt();
		height = inFS.nextInt();
		Maze = new int[width][height];
		for(int i = 0; i < width; i++) {
			for(int j = 0; j < height; j++) {
				Maze[i][j] = inFS.nextInt();
			}
		}
		Start = new Position(inFS.nextInt(), inFS.nextInt());
		Finish = new Position(inFS.nextInt(), inFS.nextInt());
		inFS.close();		
	}
}

