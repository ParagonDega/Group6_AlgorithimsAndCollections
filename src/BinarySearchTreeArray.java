
import java.util.AbstractSet;
import java.util.Iterator;

/**
 *
 * @author greg
 */
public class BinarySearchTreeArray<E> extends AbstractSet<E> {

    Entry<E>[] tree;
    int root, size;

    protected static class Entry<E> {

        protected E element;
        protected Entry<E> left = null, right = null, parent;

        /**
         * Initializes this Entry object.
         */
        public Entry() {
        }

        /**
         * Initializes this Entry object from element and parent.
         */
        public Entry(E element, Entry<E> parent) {
            this.element = element;
            this.parent = parent;
        }
    }

    public BinarySearchTreeArray() {
        root = 0;
        size = 0;
    }//default constructor

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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
