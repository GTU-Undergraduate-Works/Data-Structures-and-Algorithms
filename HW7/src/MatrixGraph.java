import java.util.*;

public class MatrixGraph extends AbstractGraph {

    Map<Integer, Edge> []  outgoingEdges;

    /**
     * Construct a graph with the specified number of vertices
     * and the directed flag. If the directed flag is true,
     * this is a directed graph.
     *
     * @param numV     The number of vertices
     * @param directed The directed flag
     */
    public MatrixGraph(int numV, boolean directed) {
        super(numV, directed);
        outgoingEdges = new Map[numV];
        for (int i = 0; i < numV; i++) {
            outgoingEdges[i] = new LinkedHashMap<>();
        }
    }

    /** {@inheritDoc}
     */
    @Override
    public void insert(Edge edge) {
        int source = edge.getSource();
        int dest = edge.getDest();
        double weight = edge.getWeight();
        outgoingEdges[source].put(dest, edge);
        if (!isDirected()) {
            Edge reverseEdge = new Edge(dest, source, weight);
            outgoingEdges[dest].put(source, reverseEdge);
        }
    }

    /** {@inheritDoc}
     */
    @Override
    public boolean isEdge(int source, int dest) {
        return outgoingEdges[source].containsKey(dest);
    }

    /** {@inheritDoc}
     */
    @Override
    public Edge getEdge(int source, int dest) {
        return outgoingEdges[source].get(dest);
    }

    /** {@inheritDoc}
     */
    @Override
    public Iterator<Edge> edgeIterator(int source) {
        return outgoingEdges[source].values().iterator();
    }
}
