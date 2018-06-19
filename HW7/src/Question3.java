import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class Question3 {

    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(new File("Resources/q3graph.txt"));
            ListGraph graph = new ListGraph(10, false);
            graph.loadEdgesFromFile(scanner);
            System.out.println("QUESTION3 TEST");
            System.out.println("Created Undirected Cyclic Graph have no weights");
            System.out.println("Number of vertices : 10");
            System.out.println("Number of edges : 16");
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
            System.out.println("-------------------------------------------------");
            System.out.println("BREADTH-FIRST SEARCH TEST");
            System.out.println("Parent Array for Starting point 0 ");
            int[] parent = BreadthFirstSearch.breadthFirstSearch(graph, 0);
            System.out.print("[ ");
            for (int n : parent)
                System.out.print(n + " ");
            System.out.println("]");
            System.out.println("----------------------------------------------------");
            System.out.println("DEPTH-FIRST SEARCH TEST");
            DepthFirstSearch search = new DepthFirstSearch(graph);
            parent = search.getParent();
            int[] finishOrder = search.getFinishOrder();
            int[] discoveryOrder = search.getDiscoveryOrder();
            System.out.println("Parent Array for Graph ");
            System.out.print("[ ");
            for (int n : parent)
                System.out.print(n + " ");
            System.out.println("]");
            System.out.println("Finish Order for for Graph ");
            System.out.print("[ ");
            for (int n : finishOrder)
                System.out.print(n + " ");
            System.out.println("]");
            System.out.println("Discovery Order for for Graph ");
            System.out.print("[ ");
            for (int n : discoveryOrder)
                System.out.print(n + " ");
            System.out.println("]");
            System.out.println("----------------------------------------------------------");
            System.out.println("Minimum Spanning Tree of Graph for Starting point 0");
            ArrayList<Edge> spanningTree = PrimsAlgorithm.primsAlgorithm(graph, 0);
            for (Edge e : spanningTree)
                System.out.println(e);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
