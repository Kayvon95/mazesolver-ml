// This class is the MazeCrawler that will

import java.util.ArrayList;
import java.util.Arrays;

public class CrawlerBot {
    // Will be based off the starting position, will mutate according to the moves made
    private int currentXPosition;
    private int currentYPosition;
    // Actions for the bot to choose from
    private enum Action {UP, RIGHT, DOWN, LEFT};
    private Action directionAction;
    private int movesLimit;
    // The maze the bot will receive to perform operations on
    private Maze maze;
    private final int chromosomes[];
    private ArrayList<int[]> route;

    // Count current moves as part of the fitness factor
    private int currentActionsCount;
    int currentMoveCount = 0;

    public CrawlerBot(Maze maze, int movesLimit, int[] chromosomes){
        this.chromosomes = chromosomes;
        this.maze = maze;
        this.movesLimit = movesLimit;
        this.currentMoveCount = 0;

        int startingPosition[] = this.maze.getStartingPosition();
        this.currentXPosition = startingPosition[0];
        this.currentYPosition = startingPosition[1];

        this.route = new ArrayList<int[]>();
        this.route.add(startingPosition);
        this.directionAction = Action.DOWN;
    }

    public void run() {
        while (true) {
            this.currentMoveCount++;
            if (this.getNextAction() == 0) {
                System.out.println("@run: getNextAction = 0");
                return;
            }
            if (this.maze.getPositionValue(currentXPosition, currentYPosition) == 2) {
                System.out.println("End found on cell " + currentXPosition + ", " + currentYPosition);
                return;
            }
            if (this.currentMoveCount > this.movesLimit) {
                System.out.println("@run: movesLimit reached");
                return;
            }
            if (this.currentMoveCount > this.chromosomes.length) {
                System.out.println("@run: end not found, out of chromosomes");
            }
//            System.out.println("currentMoveCount = " + this.currentMoveCount);
            this.executeAction();
        }
    }

    public void senseEnvironment() {
        //Use booleans to log if environments are walls
        boolean upSensor = false;
        boolean rightSensor = false;
        boolean downSensor = false;
        boolean leftSensor = false;

        if (this.directionAction == Action.UP) {
            upSensor = this.maze.checkForWall(this.currentXPosition, this.currentYPosition -1);
            rightSensor = this.maze.checkForWall(this.currentXPosition +1, this.currentYPosition);
            downSensor = this.maze.checkForWall(this.currentXPosition, this.currentYPosition +1);
            leftSensor = this.maze.checkForWall(this.currentXPosition -1, this.currentYPosition);
        } else if (this.directionAction == Action.RIGHT) {

        }
    }

    public Action getAction() {
        return this.directionAction;
    }

    public void executeAction() {
        if (this.getNextAction() == 1) {
            System.out.println("@executeAction: getNextAction = 1");
            int currentX = this.currentXPosition;
            int currentY = this.currentYPosition;


            if (this.directionAction == Action.UP) {
                System.out.println("@CrawlerBot - executeAction: direction UP");
                this.currentYPosition -= 1;
                if (this.currentYPosition < 0) {
                    this.currentYPosition = 0;
                }
            } else if (this.directionAction == Action.RIGHT) {
                System.out.println("@CrawlerBot - executeAction: direction RIGHT");
                this.currentXPosition += 1;
                if (this.currentXPosition < 0) {
                    this.currentXPosition = 0;
                }
            } else if (this.directionAction == Action.DOWN) {
                System.out.println("@CrawlerBot - executeAction: direction DOWN");
                this.currentYPosition += 1;
                if (this.currentYPosition < 0) {
                    this.currentYPosition = 0;
                }
            } else if (this.directionAction == Action.LEFT) {
                System.out.println("@CrawlerBot - executeAction: direction LEFT");
                this.currentXPosition -= 1;
                if (this.currentXPosition < 0) {
                    this.currentXPosition = 0;
                }
            } else {
                System.out.println("@Crawlerbot - executeAction: No valid direction");
            }
            System.out.println(Arrays.toString(this.getPosition()));
        }
    }

    public int getNextAction() {
        return this.chromosomes[this.currentMoveCount - 1];
    }

    public int[] getPosition(){
        return new int[]{this.currentXPosition, this.currentYPosition};
    }

    public int[] getChromosomes() {
        return this.chromosomes;
    }
}
