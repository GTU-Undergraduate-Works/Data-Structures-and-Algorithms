import java.lang.reflect.Array;
import java.util.*;

/**
 * Class to implement useful methods for Graph class.
 * @author Efkan Durakli
 */
public class UsefulMethodsForGraphs {


    /**
     * Determine the if there is any path between vertex1
     * and verex2 in the graph.
     * @param graph A Graph Object
     * @param vertex1 vertex label in graph
     * @param vertex2 vertex label int graph
     * @return true if there is a part from vertex 1 vertex2, false if not
     * @throws IllegalArgumentException vertex1 and vertex2 are not int the graph
     */
    public static boolean isConnected(Graph graph, int vertex1, int vertex2) throws IllegalArgumentException {

        if (vertex1 < 0 ||vertex1 >= graph.getNumV() ||
                vertex2 < 0 || vertex2 >= graph.getNumV())
            throw new IllegalArgumentException("Given vertices are not in the graph");
        Queue<Integer> theQueue = new LinkedList<>();
        boolean[] idendified = new boolean[graph.getNumV()];
        idendified[vertex1] = true;
        theQueue.offer(vertex1);
        while (!theQueue.isEmpty()) {
            int current = theQueue.remove();
            Iterator<Edge> itr = graph.edgeIterator(current);
            while (itr.hasNext()) {
                Edge edge = itr.next();
                int neighbour = edge.getDest();
                if (neighbour == vertex2)
                    return true;
                if (!idendified[neighbour]) {
                    idendified[neighbour] = true;
                    theQueue.offer(neighbour);
                }
            }
        }
        return false;
    }

    /**
     * Checks if the graph is undirected, this is true if all
     * directed edges have a complementary directed edge with
     * the same weight in opposite direction.
     * @param graph A graph object
     * @return true if g is undirected, false if not
     */
    public static boolean isUndirected(Graph graph) {

        for (int i = 0; i < graph.getNumV(); i++) {
            Iterator<Edge> itr = graph.edgeIterator(i);
            while (itr.hasNext()) {
                Edge edge = itr.next();
                if (!graph.isEdge(edge.getDest(), edge.getSource()))
                    return false;
                else {
                    if (graph.getEdge(edge.getDest(), edge.getSource()).getWeight() != edge.getWeight())
                        return true;
                }
            }

        }
        return true;
    }

    /**
     * Checks if graph contains any cycle.
     * @param graph A graph object
     * @return true if graph is acyclic, false if not
     */
    public static boolean isAcyclicGraph(Graph graph) {

        boolean visited[] = new boolean[graph.getNumV()];
        for (int i = 0; i < graph.getNumV(); i++)
            visited[i] = false;

        if (!graph.isDirected()) {
            for (int i = 0; i < graph.getNumV(); i++)
                if (!visited[i]) // Don't recur for u if already visited
                    if (isCyclicHelperForUndirected(graph, i, visited, -1))
                        return false;
            return true;
        }
        else {
            boolean[] visited2 = new boolean[graph.getNumV()];
            boolean[] recStack = new boolean[graph.getNumV()];
            for (int i = 0; i < i; i++)
                if (isCyclicHelperForDirected(graph, i, visited, recStack))
                    return false;
            return true;
        }

    }

    /** helper method for undirected graph is cyclic or nnot */
    private static boolean isCyclicHelperForUndirected(Graph graph, int vertex, boolean[] visited, int parent) {

        visited[vertex] = true;
        Iterator<Edge> itr = graph.edgeIterator(vertex);
        while (itr.hasNext())
        {
            int i = itr.next().getDest();
            if (!visited[i])
            {
                if (isCyclicHelperForUndirected(graph, i, visited, vertex))
                    return true;
            }
            else if (i != parent)
                return true;
        }
        return false;
    }

    /** helper method for directed graph is cylic or not */
    private static boolean isCyclicHelperForDirected(Graph graph, int vertex, boolean[] visited, boolean[] recStack) {

        if (recStack[vertex])
            return true;

        if (visited[vertex])
            return false;

        visited[vertex] = true;
        recStack[vertex] = true;
        Iterator<Edge> itr = graph.edgeIterator(vertex);
        while (itr.hasNext()) {
            if (isCyclicHelperForDirected(graph, itr.next().getDest(), visited, recStack))
                return true;
        }
        recStack[vertex] = false;
        return false;
    }

    /**
     * Plot showing all vertices(labeled) and edges.
     * @param graph A graph Object
     */
    public static void plotGraph(Graph graph) {

        for (int i = 0; i < graph.getNumV(); i++) {
            System.out.print(i + " : ");
            Iterator < Edge > itr = graph.edgeIterator(i);
            StringBuilder sb = new StringBuilder();
            while (itr.hasNext()) {
                Edge edge = itr.next();
                sb.append(String.format("( %.2f )", edge.getWeight()) + edge.getDest() + " -> ");
            }
            int index = sb.lastIndexOf(" -> ");
            if (index >= 0)
                sb.delete(index, index+4);
            System.out.println(sb);
            sb.setLength(0);
        }
    }

    /**
     * Find the shortest path from vertex 1 to vertex2
     * using Dijkstra’s algorithm.
     * @param graph A Graph object
     * @param vertex1 vertex label in Graph
     * @param vertex2 vertex label 2 in Graph
     * @return A path between vertex1 and vertex2
     * @throws IllegalArgumentException if vertex 1 or vertex2 is not in the graph
     */
    public static Path shortestPath(Graph graph, int vertex1, int vertex2) throws IllegalArgumentException {

        if (vertex1 < 0 ||vertex1 >= graph.getNumV() ||
                vertex2 < 0 || vertex2 >= graph.getNumV())
            throw new IllegalArgumentException("Given vertices are not in the graph");
        ArrayList<Integer> pathList = new ArrayList<>();
        int[] pred = new int[graph.getNumV()];
        double[] dist = new double[graph.getNumV()];
        DijkstrasAlgorithm.dijkstrasAlgorithm(graph, vertex1, pred, dist);
        int currentIndex = vertex2;
        while (currentIndex != vertex1) {

            if (dist[currentIndex] != Double.POSITIVE_INFINITY)
                pathList.add(pred[currentIndex]);

            else
                return new Path(new ArrayList<Integer>(), Double.POSITIVE_INFINITY);
            currentIndex = pred[currentIndex];

        }
        Collections.reverse(pathList);
        pathList.add(vertex2);
        return new Path(pathList, dist[vertex2]);
    }













}
