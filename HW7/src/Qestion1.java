import java.util.Random;

/**
 * Class for HW7 Question1
 * @author Efkan Durakli
 */
public class Qestion1 {


    /**
     * main method
     * @param args argument list
     */
    public static void main(String[] args) {

        ListGraph graph = new ListGraph(10, true);
        Random random = new Random();
        double[] randomWeights = new double[20];
        for (int i = 0; i < 20; i++)
            randomWeights[i] = (Math.random() * ((100-1) + 1)) + 1;
        System.out.println("QUESTION1 TEST");
        graph.insert(new Edge(0,1,randomWeights[0]));
        graph.insert(new Edge(1,2,randomWeights[1]));
        graph.insert(new Edge(2,3,randomWeights[2]));
        graph.insert(new Edge(3,4,randomWeights[3]));
        graph.insert(new Edge(4,5,randomWeights[4]));
        graph.insert(new Edge(5,6,randomWeights[5]));
        graph.insert(new Edge(6,7,randomWeights[6]));
        graph.insert(new Edge(7,8,randomWeights[7]));
        graph.insert(new Edge(8,9,randomWeights[8]));
        graph.insert(new Edge(0,9,randomWeights[9]));
        graph.insert(new Edge(1,6,randomWeights[10]));
        graph.insert(new Edge(1,7,randomWeights[11]));
        graph.insert(new Edge(1,8,randomWeights[12]));
        graph.insert(new Edge(2,4,randomWeights[13]));
        graph.insert(new Edge(2,5,randomWeights[14]));
        graph.insert(new Edge(2,7,randomWeights[15]));
        graph.insert(new Edge(3,6,randomWeights[16]));
        graph.insert(new Edge(3,7,randomWeights[17]));
        graph.insert(new Edge(4,6,randomWeights[18]));
        graph.insert(new Edge(4,9,randomWeights[19]));

        System.out.println("Created Directed Acyclic Graph have random weights");
        System.out.println("Number of vertices : 10");
        System.out.println("Number of edges : 20");
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


        Path path1 = UsefulMethodsForGraphs.shortestPath(graph, 2, 6);
        Path path2 = UsefulMethodsForGraphs.shortestPath(graph, 3, 9);
        Path path3 = UsefulMethodsForGraphs.shortestPath(graph, 0, 4);
        Path path4 = UsefulMethodsForGraphs.shortestPath(graph, 8, 0);
        System.out.println("------------------------------------------------------------------------------------");

        if (!path1.getPathOrder().isEmpty()) {
            System.out.println("The shortest path between vertex 2 and vertex 6 = " + path1.getPathOrder());
            System.out.println("Distance of shortest path = " + path1.getDistance());
        }
        else
            System.out.println("There is no path between vertex 2 and vertex 6");

        System.out.println("------------------------------------------------------------------------------------");

        if (!path2.getPathOrder().isEmpty()) {
            System.out.println("The shortest path between vertex 3 and vertex 9 = " + path2.getPathOrder());
            System.out.println("Distance of shortest path = " + path2.getDistance());
        }
        else
            System.out.println("There is no path between vertex 3 and vertex 9");

        System.out.println("------------------------------------------------------------------------------------");


        if (!path3.getPathOrder().isEmpty()) {
            System.out.println("The shortest path between vertex 0 and vertex 4 = " + path3.getPathOrder());
            System.out.println("Distance of shortest path = " + path3.getDistance());
        }
        else
            System.out.println("There is no path between vertex 0 and vertex 4");


        System.out.println("------------------------------------------------------------------------------------");


        if (!path4.getPathOrder().isEmpty()) {
            System.out.println("The shortest path between vertex 8 and vertex 0 = " + path4.getPathOrder());
            System.out.println("Distance of shortest path = " + path4.getDistance());
        }
        else
            System.out.println("There is no path between vertex 8 and vertex 0");
    }
}
