import java.util.ArrayList;

/**
 * Class to represent a path in graph.
 * @author Efkan Durakli
 */
public class Path {

    /** oeder of path */
    private ArrayList<Integer> pathOrder;

    /** distance of the path */
    private double distance;

    /**
     * Creates Path object with specified pathOrder and distance.
     * @param pathOrder The path order
     * @param distance The distance
     */
    public Path(ArrayList<Integer> pathOrder, double distance) {
        this.pathOrder = pathOrder;
        this.distance = distance;
    }

    /**
     * This the getter which gets path order.
     * @return pathorder of this path
     */
    public ArrayList<Integer> getPathOrder() {
        return pathOrder;
    }

    /**
     * This is the getter which gets distance of the path.
     * @return distance of this path
     */
    public double getDistance() {
        return distance;
    }



}
