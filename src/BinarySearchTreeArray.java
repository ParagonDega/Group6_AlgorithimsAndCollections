
import java.util.AbstractSet;
import java.util.Iterator;

/**
 *
 * @author greg
 */
public class BinarySearchTreeArray<E> extends AbstractSet<E> {

    private static final int DEFAULT_SIZE = 16;
    Entry<E>[] tree;
    int root, size;

    protected class Entry<E> {

        protected E element;
        protected int left, right, parent;

        /**
         * Initializes this Entry object.
         */
        public Entry() {
        }

        /**
         * Initializes this Entry object from element and parent.
         */
        public Entry(E element, int parent) {
            this.element = element;
            this.parent = parent;
            this.left = parent = -1;
            this.right = parent = -1;
        }
    }

    public BinarySearchTreeArray() {
        tree = new Entry[DEFAULT_SIZE];
        size = 0;
        //this(size);
    }//default constructor

    /**
     * Initialises this ArraySequence object to be empty, with a specified
     * initial capacity.
     *
     * @param capacity - the initial capacity of this ArraySequence object.
     *
     * @throws IllegalArgumentException - if capacity is non-positive
     */
    public BinarySearchTreeArray(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("Non-positive capacity: "
                    + capacity);
        }
        tree = new Entry[capacity];
        size = 0;
        //modCount = 0;
    }

    @Override
    public int size() {
        return size;
    }

    public BinarySearchTreeArray(BinarySearchTreeArray<? extends E> otherTree) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean contains(Object obj) {
        if (tree[root] == null) {
            return false;
        }
        return (containsElement(tree[root], obj)); //To change body of generated methods, choose Tools | Templates.
    }

    protected boolean containsElement(Entry<E> e, Object obj) {
        int comp;

        if (e == null) {
            return false;
        }

        Entry temp = e;
        comp = ((Comparable) obj).compareTo(e.element);

        if (comp == 0) {
            return true;
        }
        if (temp.left == -1) {
            return false;
        } else if (comp < 0) {
            return containsElement(tree[temp.left], obj);
        } else if (temp.right == -1) {
            return false;
        } else {
            return containsElement(tree[temp.right], obj);
        }
        // method requires a return method
    }

    @Override
    public boolean add(E element) {
        int parent = 0;
        if (element == null) {
            throw new NullPointerException();
        }
        if (tree[root] == null) {
            tree[root] = new Entry(element, -1);
            size++;
            return true;
        } else {
            int i = 0, comp;
            Entry temp = tree[root];
            while (true) {
                comp = ((Comparable) element).compareTo(temp.element);
                if (comp == 0) {
                    return false;
                }
                if (comp < 0) {
                    if (temp.left != -1) {
                        parent = temp.left;
                        temp = tree[temp.left];
                    } else {
                        tree[size] = new Entry(element, parent);
                        tree[parent].left = size;
                        size++;
                        return true;
                    }
                } else if (temp.right != -1) {
                    parent = temp.right;
                    temp = tree[temp.right];
                } else {
                    tree[size] = new Entry(element, parent);
                    tree[parent].right = size;
                    size++;
                    return true;
                }
            }
        }
    }

    public boolean remove(Object obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

//    protected Entry<E> getEntry(Object obj) {
//        int temp = root, comp;
//        while (temp != -1) {
//            comp = ((Comparable) obj).compareTo(tree[temp].element);
//            if (comp == 0) {
//                return tree[temp];
//            } else if (comp < 0) {
//                emp = tree[temp].left;
//            } else {
//                temp = tree[temp].right;
//            }
//        } // while    return null; 
//    } From coursework description
    protected Entry<E> deleteEntry(Entry<E> p) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    protected Entry<E> successor(Entry<E> e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Iterator<E> iterator() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.

    }

    protected class ArrayIterator implements Iterator<E> {

        protected ArrayIterator() {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        public boolean hasNext() {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        public E next() {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        public void remove() {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

    }

}
