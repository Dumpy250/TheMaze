package Main;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;
class MazeReader {
    /**
     * Reads input from file.
     */
    private static FileInputStream fileByteStream = null;
    /**
     * String reader.
     */
    private static Scanner inFS = null;
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
    static Position Start;
    /**
     * The Finish Position read from file.
     */
    static Position Finish;
    /**
     * 2D int array representing the maze.
     */
    static int[][] Maze;

    /**
     * Reads the maze file and initializes maze properties.
     *
     * @param fileName The name of the maze file.
     * @throws IOException If an I/O error occurs.
     */
    public static void ReadFile(String fileName) throws IOException {
        try {
            fileByteStream = new FileInputStream(fileName);
            inFS = new Scanner(fileByteStream);
        } catch (IOException e) {
            System.out.println("Failed to open file: " + e.getMessage());
            throw e;
        }

        width = inFS.nextInt();
        height = inFS.nextInt();
        Maze = new int[width][height];
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                Maze[i][j] = inFS.nextInt();
            }
        }
        Start = new Position(inFS.nextInt(), inFS.nextInt());
        Finish = new Position(inFS.nextInt(), inFS.nextInt());
        inFS.close();
    }
}
