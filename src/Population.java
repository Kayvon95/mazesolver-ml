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

    public void setAllSequences(DNASequence[] dna) {
        this.population = dna;
    }

    public DNASequence getSequence(int index) {
        return this.population[index];
    }

    public DNASequence setSequence(int index, DNASequence sequence) {
        return this.population[index] = sequence;

    }
}