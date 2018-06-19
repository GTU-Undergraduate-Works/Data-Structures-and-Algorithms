package duraklefkan.cse222hw4.part2;

import java.security.InvalidParameterException;

/**
 * Class to represent MultiDimensionalTree.
 * @param <E> data of MultiDimensionalTree
 */
public class MultiDimensionalTree<E extends Point>
        extends BinaryTree<E>
        implements SearchTree<E> {

    private boolean addReturn;
    private E deleteReturn;
    private int dimension;

    /**
     * Creates empty MultiDimensionalTree with given dimension
     * @param dimension dimesion of MultiDimensionalTree
     */
    public MultiDimensionalTree(int dimension) {
        if (dimension <= 0)
            throw new InvalidParameterException("Invalid dimension : " + dimension);
        this.dimension = dimension;
        root = null;
    }

    /** Inserts item where it belongs in the tree.
     @param item The item to be inserted
     @return true If the item is inserted, false if the
     item was already in the tree.
     */
    @Override
    public boolean add(E item) {
        if (item.getDimension() != dimension)
            throw new InvalidParameterException("ınvalid dimension : " + item.getDimension());
        root = add(root, item, 0);
        return addReturn;
    }

    /** Determine if an item is in the tree
     @param target Item being sought in tree
     @return true If the item is in the tree, false otherwise
     */
    @Override
    public boolean contains(E target) {
        return  (find(root,target, 0) != null);
    }

    /** Find an object in the tree
     @param target The item being sought
     @return A reference to the object in the tree that compares
     equal as determined by compareTo to the target. If not found
     null is returned.
     */
    @Override
    public E find(E target) {
        return find(root, target, 0);
    }

    /**
     * Recursive find method.
     * @param localRoot the locl subtree of root.
     * @param target The object being saught.
     * @param depth level of tree.
     * @return The object, if found true, otherwise null.
     */
    private E find(Node<E> localRoot, E target, int depth) {
        if (localRoot == null)
            return null;
        int coordinate = depth % target.getDimension();
        int compResult = target.get(coordinate).compareTo(localRoot.data.get(coordinate));
        if (compResult == 0) {
            if (target.equals(localRoot.data))
                return localRoot.data;
            else
                return null;
        }
        else if (compResult < 0)
            return find(localRoot.left, target, depth+1);
        else
            return find(localRoot.right, target, depth+1);
    }

    /** Removes target from tree.
     @param target Item to be removed
     @return A reference to the object in the tree that compares
     equal as determined by compareTo to the target. If not found
     null is returned.
     @post target is not in the tree
     */
    @Override
    public E delete(E target) {
        root = delete(root, target, 0);
        return deleteReturn;
    }

    /** Removes target from tree.
     @param target Item to be removed
     @return true if the object was in the tree, false otherwise
     @post target is not in the tree
     */
    @Override
    public boolean remove(E target) {
        root = delete(root, target, 0);
        return (deleteReturn != null);
    }

    /**
     * Recursive add method.
     * @post The data field addReturn is set true if the item is added to
     *        the tree, false if the item is already in the tree.
     * @param localRoot localRoot The local root of the subtree
     * @param target item The object to be inserted
     * @param depth level of tree.
     * @return The new local root that now contains the inserted item
     */
    private Node<E> add(Node<E> localRoot, E target, int depth) {
        int coordinate = depth % target.getDimension();
        if (localRoot == null) {
            addReturn = true;
            return new Node<>(target);
        } else if (target.get(coordinate).compareTo(localRoot.data.get(coordinate)) <=  0) {
            if (!target.equals(localRoot.data)) {
                localRoot.left = add(localRoot.left, target, depth + 1);
                return localRoot;
            }
            else {
                addReturn = false;
                return null;
            }
        } else {
            localRoot.right = add(localRoot.right, target, depth+1);
            return localRoot;
        }
    }

    /**
     * Recursive delete method.
     * @post The item is not in the tree;
     *       deleteReturn is equal to the deleted item
     *       as it was stored in the tree or null
     *       if the item was not found.
     * @param localRoot The root of the current subtree
     * @param target The item to be deleted
     * @param depth level of tree
     * @return The modified local root that does not contain
     *         the item
     */
    private Node<E> delete(Node<E> localRoot, E target, int depth) {

        if (localRoot == null) {
            deleteReturn = null;
            return localRoot;
        }
        int coordinate = depth % target.getDimension();
        int compResult = target.get(coordinate).compareTo(localRoot.data.get(coordinate));
        if (compResult < 0) {
            localRoot.left = delete(localRoot.left, target, depth+1);
            return localRoot;
        } else if (compResult > 0) {
            localRoot.right = delete(localRoot.right, target, depth+1);
            return localRoot;
        } else {

            if (localRoot.data.equals(target)) {
                deleteReturn = localRoot.data;
                if (localRoot.left == null)
                    return localRoot.right;
                else if (localRoot.right == null)
                    return localRoot.left;
                else {

                    if (localRoot.left.right == null) {
                        localRoot.data = localRoot.left.data;
                        localRoot.left = localRoot.left.left;
                        return localRoot;
                    } else {
                        localRoot.data = findLargestChild(localRoot.left);
                        return localRoot;
                    }
                }
            }
            else {
                localRoot.left = delete(localRoot.left, target, depth+1);
                return localRoot;
            }
        }
    }

    /**
     * Find the node that is the
     * inorder predecessor and replace it
     * with its left child (if any).
     * @post The inorder predecessor is removed from the tree.
     * @param root The parent of possible inorder
     *        predecessor (ip)
     * @return The data in the ip
     */
    private E findLargestChild(Node<E> root) {
        if (root.right.right == null) {
            E returnValue = root.right.data;
            root.right = root.right.left;
            return returnValue;
        } else {
            return findLargestChild(root.right);
        }
    }
}
