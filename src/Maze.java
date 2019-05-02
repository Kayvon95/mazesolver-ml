public class Maze {
    // 2d array to map maze
    private final int maze[][];
    // Represent maze as
    // 0 - empty
    // 1 - wall
    // 2 - starting cell
    // 3 - finish/end cell


    public Maze(int maze[][]) {
        this.maze = maze;
    }

    public int getPositionValue(int x, int y) {
        if (x < 0 || y < 0 || x >= this.maze.length || y >= this.maze[0].length) {
            System.out.println("Parameters out of bounds");
            return 1;
        } else {
            // We ask for x-y but return y-x because of 2d array structure.
            System.out.println("Cell [" + x + ", " + y + "] has value " + this.maze[y][x]);
            return this.maze[y][x];
        }
    }

    public boolean isWall(int x, int y) {
        return (this.getPositionValue(x, y) == 1);
    }
}
