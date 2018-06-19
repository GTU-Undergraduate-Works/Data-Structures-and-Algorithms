import java.util.*;


/** A ListGraph is an extension of the AbstractGraph abstract class
 that uses an array of lists to represent the edges.
 */
public class ListGraph extends AbstractGraph {

    // Data Field
    /** An array of Lists to contain the edges that
     originate with each vertex.
     */
    private List<Edge>[] edges;

    /**
     * Construct a graph with the specified number of vertices
     * and the directed flag. If the directed flag is true,
     * this is a directed graph.
     *
     * @param numV     The number of vertices
     * @param directed The directed flag
     */
    public ListGraph(int numV, boolean directed) {
        super(numV, directed);
        edges = new List[numV];
        for (int i = 0; i < numV; i++)
            edges[i] = new LinkedList<Edge>();
    }

    /** {@inheritDoc}
     */
    @Override
    public void insert(Edge edge) {

        if (!isEdge(edge.getSource(), edge.getDest()))
            edges[edge.getSource()].add(edge);
            if (!isDirected()) {
                if (!isEdge(edge.getDest(), edge.getSource()))
                    edges[edge.getDest()].add(new Edge(edge.getDest(), edge.getSource(),
                            edge.getWeight()));
            }

    }

    /** {@inheritDoc}
     */
    @Override
    public boolean isEdge(int source, int dest) {

        if (source < 0 || source >= getNumV())
            return false;
        return edges[source].contains(new Edge(source, dest));
    }

    /** {@inheritDoc}
     */
    @Override
    public Edge getEdge(int source, int dest) {
        Edge target = new Edge(source, dest, Double.POSITIVE_INFINITY);
        for (Edge edge: edges[source]) {
            if (edge.equals(target))
                return edge; // Desired edge found, return it.
        }
        // Assert: All edges for source checked.
        return target; // Desired edge not found.
    }

    /** { @inheritDoc}
     */
    @Override
    public Iterator<Edge> edgeIterator(int source) {
        return edges[source].iterator();
    }
}
