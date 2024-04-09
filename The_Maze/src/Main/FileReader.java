package Main;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

/**
 * The File Reader Class reads from a formatted text file that contains a 2d array along
 * with its characteristics size, width, and height.
 *
 * @author Cameron "Dumpy" Basham
 * @version 1.0
 */
public class FileReader {
	public static void main(String[] args) {
		try {
			MazeReader.ReadFile("RawMaze.txt");
		} catch (IOException e) {
			System.out.println("Failed to read file: " + e.getMessage());
		}
	}
}