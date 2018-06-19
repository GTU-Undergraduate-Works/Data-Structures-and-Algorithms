import java.io.File;
import java.util.Scanner;

/**
 * Class for HW7 Question2
 * @author Efkan Durakli
 */
public class Qestion2 {

    /**
     * main method
     * @param args argument list
     */
    public static void main(String[] args) {

        try {
            Scanner scanner = new Scanner(new File("Resources/q2graph.txt"));
            ListGraph graph = new ListGraph(15, false);
            graph.loadEdgesFromFile(scanner);
            System.out.println("QUESTION2 TEST");
            System.out.println("Created Undirected Acyclic Graph have no weights");
            System.out.println("Number of vertices : 15");
            System.out.println("Number of edges : 13");
            System.out.println("Visual representation of graph");
            UsefulMethodsForGraphs.plotGraph(graph);
            if (UsefulMethodsForGraphs.isUndirected(graph))
                System.out.println("Graph is undirected");
            else
                System.out.println("Graph is directed");
            if (UsefulMethodsForGraphs.isAcyclicGraph(graph))
                System.out.println("Graph is acyclic");
            else
                System.out.println("Graph is cyclic");

            System.out.println("------------------------------------------------------");
            if (UsefulMethodsForGraphs.isConnected(graph, 0, 8))
                System.out.println("Vertex 0 and vertex 8 is connected");
            else
                System.out.println("Vertex 0 and vertex 8 is not connected");

            if (UsefulMethodsForGraphs.isConnected(graph, 14, 5))
                System.out.println("Vertex 14 and vertex 5 is connected");
            else
                System.out.println("Vertex 14 and vertex 5 is not connected");

            if (UsefulMethodsForGraphs.isConnected(graph, 7, 10))
                System.out.println("Vertex 7 and vertex 10 is connected");
            else
                System.out.println("Vertex 7 and vertex 10 is not connected");
            if (UsefulMethodsForGraphs.isConnected(graph, 6, 13))
                System.out.println("Vertex 6 and vertex 13 is connected");
            else
                System.out.println("Vertex 6 and vertex 13 is not connected");

        } catch (Exception e) {
            e.printStackTrace();
        }




    }




}
