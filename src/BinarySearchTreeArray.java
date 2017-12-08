
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

    public boolean contains(Object obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public boolean add(E element) {
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
                    if (tree[i].left != 0) {
                        temp = tree[temp.left];
                        i++;
                    } else {
                        tree[size] = new Entry(element, i);
                        tree[i].left = size;
                        size++;
                        return true;
                    }
                } else if (tree[i].right != 0) {
                    temp = tree[temp.right];
                    i++;
                } else {
                    tree[size] = new Entry(element, i);
                    tree[i].right = size;
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
