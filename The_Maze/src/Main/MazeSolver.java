package Main;

import java.util.ArrayList;
import java.util.Stack;

/**
 * The MazeSolver Class takes the maze read from the FileReader Class and solves it from
 * Start to Finish. 
 * 
 * @author Cameron "Dumpy" Basham
 * @version 1.0
 *
 */
public class MazeSolver {
	/**
	 * A Position to represent the starting point.
	 */
	private static Position Start;
	/**
	 * A Position to represent the finish point.
	 */
	private static Position Finish;
	/**
	 * A Position to represent the current.
	 */
	private static Position Current;
	/**
	 * 2d array to represent the maze read from file.
	 */
	private static int[][] Maze;
	/**
	 * 2d boolean array to represent if grid has been visited.
	 */
	private static boolean[][] Visited;
	/**
	 * Stack of type Position to represent the Path app has taken.
	 */
	private static Stack<Position> Path;
	/**
	 * Boolean value to represent if the maze is solvable or not.
	 */
	private static boolean solvable;
	/**
	 * ArrayList to represent to four cardinal directions North, East, South, and West.
	 */
	static ArrayList <Position> CardinalPoints;
	

	/**
	 * Constructer to initiate the maze read from file.
	 * 
	 * @param Maze 2d maze array
	 * @param Start start position
	 * @param Finish finish position
	 */
	public MazeSolver(int[][] Maze, Position Start, Position Finish) {
		this.Maze = Maze;
		this.Start = Start;
		this.Finish = Finish;
		this.Current = Start;
		solvable = true;
		Path = new Stack<Position>();		
		Visited = new boolean[FileReader.height][FileReader.width];
	}
	
	/**
	 * Method to Solve the Maze Checking each position for validity and moving in a cardinal direction. 
	 */
	public static void Solver() {
		
		while (!Current.equals(Finish) && (solvable)) { 
			
			CardinalPoints = new ArrayList<Position>();
			
			//Add the current to the visited 2d boolean array.
			Visited[Current.getX()][Current.getY()] = true;
			System.out.println("Printing Current: " + Current.toString());
			
			//generate the four cardinal positions
			Position North = new Position(Current.getX() - 1, Current.getY());
			Position South = new Position(Current.getX() + 1, Current.getY());
			Position East = new Position(Current.getX(), Current.getY()+ 1);
			Position West = new Position(Current.getX(), Current.getY() - 1);
			
			//check for validity.
			if ( !((North.isOutbounds) || (Visited[North.getX()][North.getY()]) || North.isBlocked) ) {
				CardinalPoints.add(North);
			}
			if ( !((South.isOutbounds) || (Visited[South.getX()][South.getY()]) || South.isBlocked) ) {
				CardinalPoints.add(South);
			}
			
			if ( !((East.isOutbounds) || (Visited[East.getX()][East.getY()]) || East.isBlocked) ) {
				CardinalPoints.add(East);
			}
			if ( !((West.isOutbounds) || (Visited[West.getX()][West.getY()]) || West.isBlocked) ) {
				CardinalPoints.add(West);
			}
			
			
				// check all cases of validity.
				switch (CardinalPoints.size()) {
				
				case 0: 
						if (Path.isEmpty()) {
							solvable = false;
							}
						else {
							Current = Path.pop();
							}
					
				break;
				
				case 1:
						Current = CardinalPoints.get(0);
				break;
				
				case 2: 
							Current = CardinalPoints.get(0);
							Path.push(CardinalPoints.get(1));
				break;	
				
				case 3: 
					Current = CardinalPoints.get(0);
					Path.push(CardinalPoints.get(1));
					Path.push(CardinalPoints.get(2));
				break;	
				
				default:
					System.out.println("Error");
				break;	
				}
			if (solvable == false) {
				System.out.print("maze is broken");
			}
			if (Current.equals(Finish)) {
				System.out.println("Finished the maze");
			}
		}
	}	
	
	/**
	 * main method to call methods and create the maze.
	 * 
	 * @param args ......
	 */
	public static void main(String[] args) {
		FileReader.ReadFile();
		MazeSolver N1 = new MazeSolver(FileReader.Maze, FileReader.Start,FileReader.Finish);
		N1.Solver();		
	}
}
