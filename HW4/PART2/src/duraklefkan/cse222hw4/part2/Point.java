package duraklefkan.cse222hw4.part2;

import java.util.ArrayList;

/**
 * class to represent Point
 * @param <E> coordinates of Point
 */
public class Point<E extends Comparable> {

    int dimension;
    ArrayList<E> coordinates;

    /**
     * Creates Point with given  arguments
     * @param coordinates coordinates of point
     */
    public Point(E... coordinates) {
        this.coordinates = new ArrayList<>();
        for (int i = 0; i < coordinates.length; i++)
            this.coordinates.add(coordinates[i]);
        dimension = this.coordinates.size();
    }

    /**
     * This is the getter which gets specified coordinates of Point
     * @param index index of coordinate to get
     * @return specified coordinate
     */
    public E get(int index) {
        return coordinates.get(index);
    }

    /**
     * This is the getter which gets dimension of Point
     * @return dimension of Point
     */
    public int getDimension() {
        return dimension;
    }

    /**
     * Compares this object to the specified object.
     * @param o  the object to compare with.
     * @return true if the objects are the same; false otherwise.
     */
    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Point))
            return false;
        Point p = (Point) o;
        if (dimension != p.getDimension())
            return false;
        for (int i = 0; i < dimension; i++) {
            if (!get(i).equals(p.get(i)))
                return false;
        }
        return true;
    }

    /**
     * Returns string representation of Point
     * @return string representaion of Point
     */
    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder();
        sb.append("( ");
        for (int i = 0; i < dimension; i++)
            sb.append(get(i) + " ");
        sb.append(")");
        return sb.toString();
    }
}
