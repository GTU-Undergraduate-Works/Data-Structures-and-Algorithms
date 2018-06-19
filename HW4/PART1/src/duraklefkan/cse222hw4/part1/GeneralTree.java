package duraklefkan.cse222hw4.part1;

import java.util.LinkedList;
import java.util.Queue;

/**
 * class to keep data of General Tree structure(Example: family tree)
 *
 * @author Efkan Duarkli
 */
public class GeneralTree<E> extends BinaryTree {

    /**
     * creates new empty General Tree.
     */
    public GeneralTree() {
        super();
    }

    /**
     * creates General Tree with given root data.
     * @param root root data of General Tree.
     */
    public GeneralTree(E root) {
        super(new Node<>(root));
    }

    /**
     * creates new General Tree with given left and right tree and root dat
     * @param data data of root node
     * @param leftTree left tree of General Tree.
     * @param rightTree right tree og General Tree.
     */
    public GeneralTree(E data, BinaryTree<E> leftTree,
                       BinaryTree<E> rightTree) {
        super(data, leftTree, rightTree);
    }

    /**
     * if tree is empty, adds given parenItem and childItem to tree.
     * if tree is not empty  and parentItem is exist in tree, adds childItem
     * to tree as child of given parentItem.
     * @param parentItem parent of child to add.
     * @param childItem child to add.
     * @return if add is successful return true, if not return false.
     */
    public boolean add(E parentItem, E childItem) {

        if (root == null) {
            root = new Node(parentItem);
            root.left = new Node(childItem);
            return true;
        }
        Node<E> parentNode = postOrderSearch(parentItem, false);
        if (parentNode != null) {
            Node<E> childNode = new Node<>(childItem);
            if (parentNode.left == null) {
                parentNode.left = childNode;
                return true;
            }
            Node<E> currentNode = parentNode.left;
            while (currentNode.right != null)
                currentNode = currentNode.right;
            currentNode.right = childNode;
            return true;
        }
        return false;
    }

    /**
     * wrapper public function for levelOrderSearch method.
     * @param data data to search
     * @param flag flag to print traversed node
     * @return if given data is exist in the tree return true, if not return false.
     */
    public Node<E> levelOrderSearch(E data, boolean flag) {
        return levelOrderSearch(root, data, flag);
    }

    /**
     * level order search given data in the tree with root given root.
     * @param data data to search
     * @param flag flag to print traversed node
     * @return if given data is exist in the tree return true, if not return false.
     */
    private Node<E> levelOrderSearch(Node<E> root, E data, boolean flag) {
        if (root != null) {
            Node<E> currentNode;
            Queue<Node<E>> queue = new LinkedList<>();
            queue.offer(root);
            while ((currentNode = queue.poll()) != null ) {
                if (flag)
                    System.out.println(currentNode);
                if (currentNode.data.equals(data))
                    return currentNode;
                Node<E> currentChild = currentNode.left;
                while (currentChild != null) {
                    queue.offer(currentChild);
                    currentChild = currentChild.right;
                }
            }
        }
        return null;
    }

    /**
     * wrapper public function for postOrderSearch search method.
     * @param data data to search
     * @param flag flag to print traversed node
     * @return if given data is exist in the tree return true, if not return false.
     */
    public Node<E> postOrderSearch(E data, boolean flag) {
        return postOrderSearch(root,data, flag);
    }

    /**
     * level order search given data in the tree with root given root recursively.
     * @param data data to search
     * @param flag flag to print traversed node
     * @return if given data is exist in the tree return true, if not return false.
     */
    private Node<E> postOrderSearch(Node<E> root, E data, boolean flag) {

        if (root == null)
            return null;
        if (root.data.equals(data))
            return root;
        Node<E> currentNode = root.left;
        Node<E> retVal = null;
        while (currentNode != null && retVal == null) {
            retVal = postOrderSearch(currentNode, data, flag);

            if (currentNode.data.equals(data)) {
                retVal = currentNode;
            }
            currentNode = currentNode.right;
        }
        if (flag)
            System.out.println(root);
        return retVal;
    }

    /**
     * {@inheritDoc}
     * @param node The local root
     * @param depth The depth
     * @param sb The string buffer to save the output
     */
    @Override
    protected void preOrderTraverse(Node node, int depth, StringBuilder sb) {
        for (int i = 1; i < depth; i++) {
            sb.append("  ");
        }
        if (node == null) {
            sb.append("null\n");
        } else {
            sb.append(node.toString());
            sb.append("\n");
            preOrderTraverse(node.right, depth + 1, sb);
            preOrderTraverse(node.left, depth + 1, sb);
        }
    }
}

