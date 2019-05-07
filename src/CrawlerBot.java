// This class is the MazeCrawler that will

public class CrawlerBot {
    // Will be based off the starting position, will mutate according to the moves made
    private int currentXPosition;
    private int currentYPostion;
    // Actions for the bot to choose from
    private enum Action {UP, RIGHT, DOWN, LEFT};
    // The maze the bot will receive to perform operations on
    private Maze maze;

    // Count current moves as part of the fitness factor
    int currentMoveCount = 0;

    public CrawlerBot(Maze maze ){
        this.maze = maze;
    }
}
