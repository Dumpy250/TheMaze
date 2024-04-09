package Main;

/**
 * The Position class represents a single position on the maze represented by int x, and int y.
 * 
 * @author Cameron "Dumpy" Basham
 * @version 1.0
 *
 */
public class Position {
	
/**
 * int x, y represent a grid reference (0,1).
 */
private int x, y;

/**
 * Boolean for if the grid has been visited before.
 */
public boolean visited;
/**
 * Boolean to represent blocked pathways marked with int 1.
 */
public boolean isBlocked;
/**
 * Boolean to represent if a grid is outside of the playable maze area.
 */
public boolean isOutbounds;

/**
 * Position constructer with grid reference x, y.
 * This constructer determines if the position is blocked or out of bounds.
 * 
 * @param x Xaxis
 * @param y Yaxis
 */
public Position(int x, int y) {
	this.x = x;
	this.y = y;
	
	
	if (x < 0 || x > MazeReader.height - 1 || y < 0 || y > MazeReader.width - 1) {
		isOutbounds = true;
		isBlocked = true;
	}
	else {
		isOutbounds = false;
		isBlocked = MazeReader.Maze[x][y] == 1;
	}
}

/**
 * A Boolean method that receives a position "value" and determines if it equals grid[x][y].
 * 
 * @param value a position to be evaluated
 * @return returns evaluated boolean value.
 */
public boolean equals(Position value) {
	if (value.x == x && value.y == y) {
		return true;
	}
	return false;
}

/**
 * Boolean method to determine if grid has been visited before.
 * 
 * @param isvisited boolean to represent if grid has been visited before.
 * @return returns boolean value of evaluated grid.
 */
public boolean isVisited(boolean isvisited) {
	
	return visited;
}

/**
 * Method to set visted.
 * 
 * @param visited
 */
public void setVisited(boolean visited) {
	this.visited = visited;
}

/**
 * method to get x.
 * 
 * @return returning x
 */
public int getX() {
	return x;
}

/**
 * Method to set x.
 * 
 * @param x grid x
 */
public void setX(int x) {
	this.x = x;
}

/**
 * method to get Y.
 * 
 * @return grid y
 */
public int getY() {
	return y;
}

/**
 * method to set y.
 * 
 * @param y grid y
 */
public void setY(int y) {
	this.y = y;
}

/**
 * A String method to convert position x,y to a string.
 *@return position in string data type.
 */
@Override
public String toString() {
	return "(x, y) = (" + x + ", + " + y +")";
}



}
