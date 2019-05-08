import java.util.Arrays;

public class Main {
    public static int generationCap = 100;

    public static void main(String[] args) {
        // 0 - empty || 1 - wall || 2 - starting cell || 3 - finish/end cell
        Maze maze = new Maze(new int[][] {
                { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
                { 1, 3, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1 },
                { 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1 },
                { 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1 },

                { 1, 0, 0, 1, 0, 0, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 1 },
                { 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1 },
                { 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1, 1, 1, 1 },
                { 1, 0, 0, 1, 1, 1, 1, 1, 1, 0, 0, 0, 1, 0, 0, 0, 0, 1 },

                { 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1 },
                { 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1 },
                { 1, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 1 },
                { 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1 },

                { 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1 },
                { 1, 0, 0, 0, 0, 1, 0, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 1 },
                { 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1 },
                { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
        });

        DNASequence dna = new DNASequence(new int[]{1, 1, 0 ,0});
        int[] chromosomes = dna.getChromosome();
        System.out.println(Arrays.toString(dna.getChromosome()));
        CrawlerBot bot = new CrawlerBot(maze, 150, chromosomes);
        System.out.println(Arrays.toString(bot.getChromosomes()));
        bot.run();
//        System.out.println(Arrays.toString(bot.getPosition()));
// Methods to check maze functionality
//        System.out.println(maze.getMazeMaxX());
//        System.out.println(maze.getMazeMaxY());
//        maze.getPositionValue(0, 17);
//        maze.getPositionValue(0, 0);
//        maze.getPositionValue(0, 1);
//        maze.getPositionValue(1, 1);
//        maze.getPositionValue(9, 13);
//        maze.getPositionValue(3, 1);
//        maze.getPositionValue(-3, 4);
//        maze.getPositionValue(4, -4);
//        maze.getPositionValue(15, 1);
//        maze.getPositionValue(16, 1);
////        maze.checkForWall(1, 1);
//        maze.getStartingPosition();

    }
}
