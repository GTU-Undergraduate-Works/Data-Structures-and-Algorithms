import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.ListIterator;

/**
 * MyLİnkedList class that extends java LinkedList
 * @param <E> the type of elements in this collection
 */
public class MyLinkedList<E> extends LinkedList {


    ArrayList<Integer> disabledIndexes;

    /**
     * construct new linked list
     */
    public MyLinkedList() {
        super();
        disabledIndexes = new ArrayList<>();
    }

    /**
     * construct new linked list with specified collection
     * @param collection  the collection whose elements are to be placed into this list
     */
    public MyLinkedList(Collection collection) {
        super(collection);
        disabledIndexes = new ArrayList<>();
    }

    /**
     * insert the specified elemet at the specified position in the list.
     * increment 1 disabled element indexes after specified index
     * @param i  index at which the specified element is to be inserted
     * @param o the element to add
     */
    @Override
    public void add(int i, Object o) {
        for (int index = 0; i < disabledIndexes.size(); i++) {
            if (disabledIndexes.get(index) >= i)
                disabledIndexes.set(index, disabledIndexes.get(index) + 1);
        }
        super.add(i, o);
    }

    /**
     * insert the specified element at the begining of this list
     * increment 1 disabled element indexes
     * @param o the element to add
     */
    @Override
    public void addFirst(Object o) {
        for (int i = 0; i < disabledIndexes.size(); i++)
            disabledIndexes.set(i, disabledIndexes.get(i) + 1);
        super.addFirst(o);
    }

    /**
     * Returns the element at the specified position in this list.
     * @param i  index of the element to return
     * @return the element at the specified position in this list if element is not disabled, if not return null.
     */
    @Override
    public Object get(int i) {

        if (searchDisabledIndex(i))
            return null;
        return super.get(i);
    }

    /**
     * Returns the first element in this list.
     * @return if first element is disable return null, if not return the first element in this list
     */
    @Override
    public Object getFirst() {
        if (searchDisabledIndex(0))
            return null;
        return super.getFirst();
    }

    /**
     * Returns the last element in this list.
     * @return if last element is disable return null, if not return the last element in this list
     */
    @Override
    public Object getLast() {
        if (searchDisabledIndex(size() -1))
            return null;
        return super.getLast();
    }

    /**
     * Retrieves and removes the head (first element) of this list.
     * @return if first element is not disable return first element of this list, if not return null.
     */
    @Override
    public Object remove() {
        if (searchDisabledIndex(0))
            return null;
        for (int i = 0; i < disabledIndexes.size(); i++)
            disabledIndexes.set(i, disabledIndexes.get(i) - 1);

        return super.remove();
    }

    /**
     * Removes the element at the specified position in this list.
     * Shifts any subsequent elements to the left (subtracts one from their indices).
     * Returns the element that was removed from the list.
     * decrement 1, disabled index after specified index
     * @param i the index of the element to be removed
     * @return if element is disabled return null, if not return the element previously at the specified position
     */
    @Override
    public Object remove(int i) {

        if (searchDisabledIndex(i))
            return null;
        for (int index = 0; i < disabledIndexes.size(); i++) {
            if (disabledIndexes.get(index) >= i)
                disabledIndexes.set(index, disabledIndexes.get(index) - 1);
        }
        return super.remove(i);
    }

    /**
     * Removes and returns the last element from this list.
     * @return if first eleemnt is disabled return null, if not return the last element from this list
     */
    @Override
    public Object removeFirst() {
        if (searchDisabledIndex(0))
            return null;
        for (int i = 0; i < disabledIndexes.size(); i++)
            disabledIndexes.set(i, disabledIndexes.get(i) - 1);
        return super.removeFirst();
    }

    /**
     * Removes and returns the last element from this list.
     * @return if last element is disable return null, id not return the last element from this list
     */
    @Override
    public Object removeLast() {
        if (searchDisabledIndex(size() -1))
            return null;

        return super.removeLast();
    }

    /**
     * Returns the number of elements in this list except disabled element.
     * @return the number of elements in this list except disabled element
     */
    @Override
    public int size() {
        return (super.size() - disabledIndexes.size());
    }

    /**
     * Replaces the element at the specified position in this list with the specified element.
     * @param i index of the element to replace
     * @param o element to be stored at the specified position
     * @return if specified position is disabled return null, if not return the element previously at the specified position
     */
    @Override
    public Object set(int i, Object o) {
        if (searchDisabledIndex(i))
            return null;
        return super.set(i, o);
    }

    /**
     * Returns a list-iterator of the elements in this list (in proper sequence),
     * starting at the specified position in the list.
     * @param i index of the first element to be returned from the list-iterator (by a call to next)
     * @return a ListIterator of the elements in this list (in proper sequence),
     * starting at the specified position in the list if specified poisiton is not disabled,
     * if not return null
     */
    @Override
    public ListIterator listIterator(int i) {
        if (searchDisabledIndex(i))
            return null;
        return super.listIterator(i);
    }

    /**
     * Returns a list-iterator of the elements in this list (in proper sequence),
     * starting at head of list.
     * @return a ListIterator of the elements in this list (in proper sequence),
     * starting at the head of list
     */
    @Override
    public ListIterator listIterator() {
        if (searchDisabledIndex(0))
            return null;
        return super.listIterator();
    }

    /**
     * Disables the element in the specified position.
     * @param index index of element to be disabled
     * @return if disable operation is successfull return true, if return false
     * @throws ArrayIndexOutOfBoundsException if index is out of range
     */
    public boolean disable(int index) throws ArrayIndexOutOfBoundsException {
        if (index < 0 || index >= super.size())
            throw new ArrayIndexOutOfBoundsException(index);
        if (searchDisabledIndex(index))
            return false;
        disabledIndexes.add(index);
        return true;
    }

    /**
     * Enables the disabled element to old position
     * @param index index of element to be enabled.
     * @return enable operation is succesfull return true, if not return false
     */
    public boolean enable(int index) {

        if (index < 0 || index >= super.size())
            throw new ArrayIndexOutOfBoundsException(index);
        if (!searchDisabledIndex(index))
            return false;
        disabledIndexes.remove((Integer) index);
        return true;
    }

    /**
     * show disabled element on the screen
     */
    public void showDisabled() {

        if (disabledIndexes.size() == 0)
            System.out.println("There is no disabled object");
        for (int i = 0; i < disabledIndexes.size(); i++)
            System.out.println(super.get(disabledIndexes.get(i)));
    }

    /**
     * search specified indec in disabledIndexes list.
     * @param index index to be searched
     * @return if index in list return true, if not return false
     */
    private boolean searchDisabledIndex(int index) {

        for (Integer iter : disabledIndexes)
            if (iter.equals(index))
                return true;

        return false;
    }
}
