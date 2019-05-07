//This class will be used to collectively store unique DNA Sequences in order to be able to compare
public class Population {

    private DNASequence[] population;

    public Population(int size) {
        // Initial population
        this.population = new DNASequence[size];
    }

    public DNASequence[] getAllSequences() {
        return this.population;
    }
}
