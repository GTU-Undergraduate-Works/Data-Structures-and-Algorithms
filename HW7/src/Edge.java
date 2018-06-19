/**
 * Edge class to repsresent relationship
 * two vertices.
 * @author Efkan Durakli
 */
public class Edge {

    // Data Fields
    /** The source vertix */
    private int source;

    /** The destination vertix */
    private int dest;

    /** The weight */
    private double weight;

    // Constructors
    /**
     * Construct and Edge object with a source of from
     * and a destination to. Set weight to 1.0.
     * @param source - The source vertix
     * @param dest - The destination vertix
     */
    public Edge(int source, int dest) {
        this.source = source;
        this.dest = dest;
        this.weight = 1.0;
    }

    /**
     * Construct weighted Edge object with a source of from
     * and a destination to. Set weight to weight.
     * @param source - The source vertix
     * @param dest - The destination vertix
     * @param weight - The wight
     */
    public Edge(int source, int dest, double weight) {
        this.source = source;
        this.dest = dest;
        this.weight = weight;
    }

    // Methods

    /**
     * Get the destination
     * @return The value of destination
     */
    public int getDest() {
        return dest;
    }

    /**
     * Get the source
     * @return The value of source
     */
    public int getSource() {
        return  source;
    }

    /**
     * Get the weight
     * @return The value of weight
     */
    public double getWeight() {
        return weight;
    }

    /**
     * return true if two edges are equal. Edges are equal
     * if the source and destination are equal.Weight is
     * not considered.
     * @param o The object to compare to
     * @return true if the edges same source and destination
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Edge edge = (Edge) o;
        return (source == edge.source &&
                dest == edge.dest);

    }

    /**
     * Return a hash code for an edge. The hascode is
     * hash code concetanation of string representations
     * of source and destination.
     * @return a hash code for an edge
     */
    @Override
    public int hashCode() {
        return (new Integer(source).toString() +
                new Integer(dest)).hashCode();
    }

    /**
     * Return a String representaion of the edge
     * @return A String representation of the edge
     */
    @Override
    public String toString() {
        return new Integer(source).toString() + " -> " + new Integer(dest).toString();
    }
}
