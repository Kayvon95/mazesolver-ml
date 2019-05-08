// This class will represent a single solution to the maze found by the bot
// Will get a score to track it's relative performance.

public class DNASequence {
    private int[] chromosomes;
    private double fitnessScore;

    public DNASequence( int[] chromosomes) {
        this.chromosomes = chromosomes;
    }

    public int[] getChromosome() {
        for (int i = 0; i < chromosomes.length; i++) {
            System.out.println(this.chromosomes[i]);
        }
        return this.chromosomes;
    }
}
