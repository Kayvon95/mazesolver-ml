import java.util.Arrays;

public class Maze {
    // 2d array to map maze
    private final int maze[][];
    // Represent maze as
    // 0 - empty
    // 1 - wall
    // 2 - starting cell
    // 3 - finish/end cell
    private int startingPostion[] = { 0, 0};

    public Maze(int maze[][]) {
        this.maze = maze;
    }

    int[] getStartingPosition() {
//        System.out.println("@Maze - getStartingPosition(): Looping through maze");
        for (int i = 0; i < this.maze.length; i++) {
//            System.out.println("@Maze - getStartingPosition(): Looping through maze row #" + i);
            for (int j = 0; j < this.maze[i].length; j++) {
//                System.out.println("@Maze - getStartingPosition(): Looping through maze cell (" + i + ", " + j + ")");
                if (this.getPositionValue(j, i) == 3) {
                 this.startingPostion = new int[] {i, j};
                 System.out.println("Starting position = " + Arrays.toString(this.startingPostion));
                 return new int[] {j, i};
                }
            }
        }
        System.out.println("No starting position in the maze");
        return startingPostion;
    }

    int getPositionValue(int x, int y) {
        if (x < 0 || y < 0 || x >= this.maze.length || y >= this.maze[0].length || y > 16) {
            System.out.println("Parameters out of bounds");
            return 1;
        } else {
            // We ask for x-y but return y-x because of 2d array structure.
            System.out.println("Cell [" + x + ", " + y + "] has value " + this.maze[y][x]);
            return this.maze[y][x];
        }
    }

    int getMazeMaxX() {
        return this.maze[0].length - 1;
    }

    int getMazeMaxY() {
        return this.maze.length -1;
    }


    boolean checkForWall(int x, int y) {
        System.out.println("@Maze - isWall(" + x + ", " + y +") is " + this.getPositionValue(x,y));
        return (this.getPositionValue(x, y) == 1);
    }
}
