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
//            System.out.println("Move #" + this.currentMoveCount);
            if (this.getNextAction() == 0) {
                System.out.println("@run: getNextAction = 0");
                return;
            }
            if (this.maze.getPositionValue(currentXPosition, currentYPosition) == 2) {
                System.out.println("End found on cell " + currentXPosition + ", " + currentYPosition);
                return;
            }
            if (this.currentMoveCount > this.movesLimit) {
                System.out.println("@run: the bot has used " + (this.currentMoveCount - 1) + "/" + this.movesLimit + " moves.");
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
        boolean upWallSensor = false;
        boolean rightWallSensor = false;
        boolean downWallSensor = false;
        boolean leftWallSensor = false;

        if (this.getAction() == Action.UP) {
            upWallSensor = this.maze.checkForWall(this.currentXPosition, this.currentYPosition -1);
//            rightWallSensor = this.maze.checkForWall(this.currentXPosition +1, this.currentYPosition);
//            downWallSensor = this.maze.checkForWall(this.currentXPosition, this.currentYPosition +1);
//            leftWallSensor = this.maze.checkForWall(this.currentXPosition -1, this.currentYPosition);
        } else if (this.directionAction == Action.RIGHT) {
//            upWallSensor = this.maze.checkForWall(this.currentXPosition +1, this.currentYPosition);
            rightWallSensor = this.maze.checkForWall(this.currentXPosition +1, this.currentYPosition);
//            downWallSensor = this.maze.checkForWall(this.currentXPosition, this.currentYPosition +1);
//            leftWallSensor = this.maze.checkForWall(this.currentXPosition -1, this.currentYPosition);
        } else if (this.getAction() == Action.DOWN) {
            downWallSensor = this.maze.checkForWall(this.currentXPosition, this.currentYPosition +1);
        } else {
            leftWallSensor = this.maze.checkForWall(this.currentXPosition -1, this.currentYPosition);
        }

        if (upWallSensor) {
            this.directionAction = Action.RIGHT;
        } else if (rightWallSensor) {
           this.directionAction = Action.DOWN;
        } else if (downWallSensor) {
            this.directionAction = Action.LEFT;
        } else if(leftWallSensor) {
            this.directionAction = Action.UP;
        }

    }

    public Action getAction() {
        return this.directionAction;
    }

    public void executeAction() {
        if (this.getNextAction() == 1) {
//            System.out.println("@executeAction: getNextAction = 1");
            int currentX = this.currentXPosition;
            int currentY = this.currentYPosition;

            this.senseEnvironment();
            if (this.directionAction == Action.UP) {
                System.out.println("@CrawlerBot - executeAction: direction UP");
                this.currentYPosition -= 1;
                if (this.currentYPosition < 0) {
                    this.currentYPosition = 1;
                }
            } else if (this.directionAction == Action.RIGHT) {
                System.out.println("@CrawlerBot - executeAction: direction RIGHT");
                this.currentXPosition += 1;
                if (this.currentXPosition > 15) {
                    this.currentXPosition = 15;
                }
            } else if (this.directionAction == Action.DOWN) {
                System.out.println("@CrawlerBot - executeAction: direction DOWN");
                this.currentYPosition += 1;
                if (this.currentYPosition > 15) {
                    this.currentYPosition = 15;
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
