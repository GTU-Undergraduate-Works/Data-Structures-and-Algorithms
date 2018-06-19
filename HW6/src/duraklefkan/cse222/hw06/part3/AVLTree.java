package duraklefkan.cse222.hw06.part3;



/*<listing chapter="9" section="2">*/

import duraklefkan.cse222.hw06.part1.*;

/*<listing chapter="9" section="2">*/
/**
 * Self-balancing binary search tree using the algorithm defined
 * by Adelson-Velskii and Landis.
 * @author Koffman and Wolfgang
 */
public class AVLTree<E extends Comparable<E>>
        extends BinarySearchTreeWithRotate<E> {

    // Insert nested class AVLNode<E> here.
    /*<listing chapter="9" number="2">*/
    /** Class to represent an AVL Node. It extends the
     * BinaryTree.Node by adding the balance field.
     */
    private static class AVLNode<E> extends Node<E> {

        /** Constant to indicate left-heavy */
        public static final int LEFT_HEAVY = -1;
        /** Constant to indicate balanced */
        public static final int BALANCED = 0;
        /** Constant to indicate right-heavy */
        public static final int RIGHT_HEAVY = 1;
        /** balance is right subtree height - left subtree height */
        private int balance;

        // Methods
        /**
         * Construct a node with the given item as the data field.
         * @param item The data field
         */
        public AVLNode(E item) {
            super(item);
            balance = BALANCED;
        }

        /**
         * Return a string representation of this object.
         * The balance value is appended to the contents.
         * @return String representation of this object
         */
        @Override
        public String toString() {
            return balance + ": " + super.toString();
        }
    }
    /*</listing>*/
    // Data Fields
    /** Flag to indicate that height of tree has increased. */
    private boolean increase;

    /** Flag to indicate that height of tree has increased. */
    private boolean decrease;

    /**
     * Creates empty AVL tree.
     */
    public AVLTree() {
        super();
        increase = false;
        decrease = false;
    }

    /**
     * Creates AVLTree with specified BinaryTree
     * @param binaryTree The BinaryTree
     * @throws IllegalArgumentException if given BİnaryTree is not AVLTree.
     */
    public AVLTree(BinarySearchTree<E> binaryTree) throws IllegalArgumentException {

        if (isAVLTree(binaryTree)) {
            if (binaryTree.getData() != null)
                copy(binaryTree);
        }
        else
            throw new IllegalArgumentException("Given Binary Tree is not AVL Tree.");
    }

    /**
     * Copies elements of gicen binaryTree to this tree.
     * @param binaryTree The binaryTree
     */
    private void copy(BinaryTree<E> binaryTree) {

        if (binaryTree != null && binaryTree.getData() != null) {
            add(binaryTree.getData());
            copy(binaryTree.getLeftSubtree());
            copy(binaryTree.getRightSubtree());
        }
    }

    /**
     * checks the given binaryTree is AVL Tree or not.
     * @param binaryTree - The binaryTree
     * @return if AVL Tree return true, if not return false
     */
    private boolean isAVLTree(BinaryTree<E> binaryTree) {

        if (binaryTree == null)
            return true;
        BinaryTree<E> rightSubTree = binaryTree.getRightSubtree();
        BinaryTree<E> leftSubTree = binaryTree.getLeftSubtree();
        int leftHeight = 0, rightHeight = 0;
        if (rightSubTree != null)
            rightHeight = rightSubTree.height();
        if (leftSubTree != null)
            leftHeight = leftSubTree.height();
        int balance = rightHeight - leftHeight;
        if (balance < AVLNode.LEFT_HEAVY || balance > AVLNode.RIGHT_HEAVY)
            return false;
        return isAVLTree( binaryTree.getLeftSubtree()) &&
                isAVLTree(binaryTree.getRightSubtree());
    }


    /**
     * Returns maximum number of two numbers.
     * @param first  The first number
     * @param second The second number
     * @return maximum number of two numbers
     */
    private int max(int first, int second) {
        return (first >= second) ? first : second;
    }

    /**
     * Calculates height of given tree.
     * @param root The root of tree
     * @return height of tree
     */
    private int height(Node<E> root) {
        if (root == null)
            return 0;
        return 1 + max(height(root.left), height(root.right));
    }


// Insert solution to programming project 5, chapter -1 here

    // Methods
    /**
     * add starter method.
     * pre: the item to insert implements the Comparable interface.
     * @param item The item being inserted.
     * @return true if the object is inserted; false
     *         if the object already exists in the tree
     * @throws ClassCastException if item is not Comparable
     */
    @Override
    public boolean add(E item) {
        increase = false;
        root = add((AVLNode<E>) root, item);
        return addReturn;
    }

    /**
     * Recursive add method. Inserts the given object into the tree.
     * @post addReturn is set true if the item is inserted,
     *       false if the item is already in the tree.
     * @param localRoot The local root of the subtree
     * @param item The object to be inserted
     * @return The new local root of the subtree with the item
     *         inserted
     */
    private AVLNode<E> add(AVLNode<E> localRoot, E item) {
        if (localRoot == null) {
            addReturn = true;
            increase = true;
            return new AVLNode<E>(item);
        }

        if (item.compareTo(localRoot.data) == 0) {
            // Item is already in the tree.
            increase = false;
            addReturn = false;
            return localRoot;
        } else if (item.compareTo(localRoot.data) < 0) {
            // item < data
            localRoot.left = add((AVLNode<E>) localRoot.left, item);

            if (increase) {
                decrementBalance(localRoot);
                if (localRoot.balance < AVLNode.LEFT_HEAVY) {
                    increase = false;
                    return rebalanceLeft(localRoot, false);
                }
            }
            return localRoot; // Rebalance not needed.
        } else {
            localRoot.right = add((AVLNode<E>) localRoot.right, item);
            if (increase) {
                incrementBalance(localRoot);
                if (localRoot.balance > AVLNode.RIGHT_HEAVY) {
                    increase = false;
                    return rebalanceRight(localRoot, false);
                }
            }
            return localRoot;
        }
    }


    /** Delete starter method. Removes the given object
     from the AVL tree.
     post: The object is not in the tree
     @param target - The object to be removed.
     @return The object from the tree that was removed
     or null if the object was not in the tree.
     */
    @Override
    public E delete(E target) {
        root = delete((AVLNode<E>) root, target);
        return deleteReturn;
    }

    /** Recursive delete method. Removes the given object
     from the AVL tree.
     post: The object is not in the tree and removeReturn
     is set to the object that was removed, otherwise
     it is set false.
     @param localRoot The root of the local subtree
     @param item The item to be removed
     @return The new root of the local subtree with the item
     removed.
     */
    private AVLNode<E> delete(AVLNode<E> localRoot, E item) {
        if (localRoot == null) {
            // item is not in the tree.
            deleteReturn = null;
            decrease = false;
            return localRoot;
        }

        // Search for item to delete.
        int compResult = item.compareTo(localRoot.data);
        if (compResult < 0) {
            // item is smaller than localRoot.data.
            localRoot.left = delete((AVLNode<E>) localRoot.left, item);
            localRoot = getEavlNode((AVLNode<E>) localRoot);
            return localRoot;
        } else if (compResult > 0) {
            // item is larger than localRoot.data.
            localRoot.right = delete((AVLNode<E>)localRoot.right, item);
            if(decrease){
                decrementBalance(localRoot);
                if(localRoot.balance < AVLNode.LEFT_HEAVY){
                    decrease = false;
                    localRoot = rebalanceLeft(localRoot,true);
                    if(localRoot.balance == AVLNode.BALANCED)
                        decrease = true;
                }
            }
            return localRoot;
        } else {
            // item is at local root.
            deleteReturn = localRoot.data;
            if (localRoot.left == null) {
                // If there is no left child, return right child
                // which can also be null.
                return (AVLNode<E>)localRoot.right;
            } else if (localRoot.right == null) {
                // If there is no right child, return left child.
                return (AVLNode<E>)localRoot.left;
            } else {
                // Node being deleted has 2 children, replace the data
                // with inorder predecessor.
                if (localRoot.left.right == null) {
                    // The left child has no right child.
                    // Replace the data with the data in the
                    // left child.
                    localRoot.data = localRoot.left.data;
                    // Replace the left child with its left child.
                    localRoot.left = localRoot.left.left;
                } else {
                    // Search for the inorder predecessor (ip) and
                    // replace deleted nodes data with ip.
                    localRoot.data = findReplacement(localRoot);
                }

                localRoot = getEavlNode((AVLNode<E>) localRoot);

                return localRoot;
            }
        }
    }




    /*<listing chapter="9" number="3">*/
    /**
     * Method to rebalance left.
     * pre: localRoot is the root of an AVL subtree that is
     *      critically left-heavy.
     * post: Balance is restored.
     * @param localRoot Root of the AVL subtree
     *        that needs rebalancing
     * @param isDelete - delete flag
     * @return a new localRoot
     */
    private AVLNode<E> rebalanceLeft(AVLNode<E> localRoot, boolean isDelete) {
        // Obtain reference to left child.
        AVLNode<E> leftChild = (AVLNode<E>) localRoot.left;
        // See whether left-right heavy.
        if (leftChild.balance > AVLNode.BALANCED) {
            // Obtain reference to left-right child.
            AVLNode<E> leftRightChild = (AVLNode<E>) leftChild.right;
            /** Adjust the balances to be their new values after
             the rotations are performed.
             */
            if (leftRightChild.balance < AVLNode.BALANCED) {
                leftChild.balance = AVLNode.BALANCED;
                leftRightChild.balance = AVLNode.BALANCED;
                localRoot.balance = AVLNode.RIGHT_HEAVY;
            } else if(leftRightChild.balance > AVLNode.BALANCED){
                leftChild.balance = AVLNode.LEFT_HEAVY;
                leftRightChild.balance = AVLNode.BALANCED;
                localRoot.balance = AVLNode.BALANCED;
            } else {
                leftChild.balance = AVLNode.BALANCED;
                leftRightChild.balance = AVLNode.BALANCED;
                localRoot.balance = AVLNode.BALANCED;
            }
            // Perform left rotation.
            localRoot.left = rotateLeft(leftChild);
        } else { //Left-Left case
            /** In this case the leftChild (the new root)
             and the root (new right child) will both be balanced
             after the rotation.
             */
            if (isDelete && leftChild.balance == AVLNode.BALANCED){
                leftChild.balance = AVLNode.RIGHT_HEAVY;
                localRoot.balance = AVLNode.LEFT_HEAVY;
            } else {
                leftChild.balance = AVLNode.BALANCED;
                localRoot.balance = AVLNode.BALANCED;
            }


        }
        // Now rotate the local root right.
        return (AVLNode<E>) rotateRight(localRoot);
    }

    /**
     * Method to rebalance right.
     * @pre localRoot is the root of an AVL subtree that is
     *      critically right-heavy.
     * @post Balance is restored.
     * @param localRoot Root of the AVL subtree
     *        that needs rebalancing
     * @param isDelete - delete flag
     * @return a new localRoot
     */
    private AVLNode<E> rebalanceRight(AVLNode<E> localRoot, boolean isDelete) {

        AVLNode<E> rightChild = (AVLNode<E>) localRoot.right;
        if (rightChild.balance < AVLNode.BALANCED) {

            AVLNode<E> rightLeftChild = (AVLNode<E>) rightChild.left;

            if (rightLeftChild.balance > AVLNode.BALANCED) {
                rightChild.balance = AVLNode.BALANCED;
                rightLeftChild.balance = AVLNode.BALANCED;
                localRoot.balance = AVLNode.LEFT_HEAVY;
            } else if(rightLeftChild.balance < AVLNode.BALANCED){
                rightChild.balance = AVLNode.RIGHT_HEAVY;
                rightLeftChild.balance = AVLNode.BALANCED;
                localRoot.balance = AVLNode.BALANCED;
            } else {
                rightChild.balance = AVLNode.BALANCED;
                rightLeftChild.balance = AVLNode.BALANCED;
                localRoot.balance = AVLNode.BALANCED;
            }

            localRoot.right = rotateRight(rightChild);
        } else {
            if (isDelete && rightChild.balance == AVLNode.BALANCED) {
                rightChild.balance = AVLNode.LEFT_HEAVY;
                localRoot.balance = AVLNode.RIGHT_HEAVY;
            } else {
                rightChild.balance = AVLNode.BALANCED;
                localRoot.balance = AVLNode.BALANCED;
            }
        }

        return (AVLNode<E>) rotateLeft(localRoot);

    }

    /**
     * Method to decrement the balance field and to reset the value of
     * increase.
     * pre: The balance field was correct prior to an insertion [or
     *      removal,] and an item is either been added to the left[
     *      or removed from the right].
     * post: The balance is decremented and the increase flags is set
     *       to false if the overall height of this subtree has not
     *       changed.
     * @param node The AVL node whose balance is to be incremented
     */
    private void decrementBalance(AVLNode<E> node) {
        // Decrement the balance.
        node.balance--;
        if (node.balance < AVLNode.BALANCED)
            decrease = false;
        else
            increase = false;
    }
    /**
     * Method to increment the balance field and to reset the value of
     * increase.
     * pre: The balance field was correct prior to an insertion [or
     *      removal,] and an item is either been added to the rigt[
     *      or removed from the left].
     * post: The balance is decremented and the increase flags is set
     *       to false if the overall height of this subtree has not
     *       changed.
     * @param node The AVL node whose balance is to be incremented
     */
    private void incrementBalance(AVLNode<E> node) {

        node.balance++;
        if (node.balance > AVLNode.BALANCED)
            decrease = false;
        else
            increase = false;
    }

    // helper method
    private AVLNode<E> getEavlNode(AVLNode<E> localRoot) {
        if(decrease) {
            incrementBalance(localRoot);
            if(localRoot.balance > AVLNode.RIGHT_HEAVY){
                decrease = false;
                localRoot = rebalanceRight(localRoot,true);
                if(localRoot.balance == AVLNode.BALANCED)
                    decrease = true;
            }
        }
        return localRoot;
    }

    /** Function to find a replacement for a node that is being
     deleted from a binary search tree.  If the node has a null
     child, then the replacement is the other child.  If neither
     are null, then the replacement is the largest value less
     than the item being removed.
     pre:  node is not null
     post :a node is deleted from the tree
     @param parent The node to be deleted or replaced
     @return null if both of node's children are null
     node.left if node.right is null
     node.right if node.left is null
     modified copy of node with its data field changed
     */
    private E findReplacement(AVLNode<E> parent){
        AVLNode<E> parentLeft = (AVLNode<E>) parent.left;
        E result = findLargestChild(parentLeft);
        if(decrease){
            decrementBalance(parentLeft);
            if(parentLeft.balance < AVLNode.LEFT_HEAVY){
                decrease = false;
                parentLeft = rebalanceLeft(parentLeft,true);
                if(parentLeft.balance == AVLNode.BALANCED)
                    decrease = true;
                parent.left = parentLeft;
            }
        }
        return result;
    }

    /** Find the node such that parent.right.right == null
     post: The found node is removed from the tree and replaced
     by its left child (if any)
     @param parent - The possible parent
     @return the value of the found node
     */
    private E findLargestChild(AVLNode<E> parent) {
        // If the right child has no right child, it is
        // the inorder predecessor.
        if (parent.right.right == null) {
            E returnValue = parent.right.data;
            parent.right = parent.right.left;
//            decrease = true;
            return returnValue;
        } else {
            AVLNode<E> parentRight = (AVLNode<E>) parent.right;
            E result = findLargestChild(parentRight);
            if(decrease){
                decrementBalance(parentRight);
                if(parentRight.balance < AVLNode.LEFT_HEAVY){
                    decrease = false;
                    parentRight = rebalanceLeft(parentRight,true);
                    if(parentRight.balance == AVLNode.BALANCED)
                        decrease = true;
                    parent.right = parentRight;
                }
            }
            return result;
        }
    }

// Insert solution to programming exercise 3, section 2, chapter 9 here

// Insert solution to programming project 5, chapter -1 here
}
