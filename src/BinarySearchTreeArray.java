
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
    protected int modCount = 0;

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
            //modCount++;
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
                        //modCount++;
                        return true;
                    }
                } else if (temp.right != -1) {
                    parent = temp.right;
                    temp = tree[temp.right];
                } else {
                    tree[size] = new Entry(element, parent);
                    tree[parent].right = size;
                    size++;
                    //modCount++;
                    return true;
                }
            }
        }
    }

    public boolean remove(Object obj) {
        Entry<E> e = getEntry(obj);
        if (e == null) {
            return false;
        }
        deleteEntry(e);
        //modCount++;                                                             //Increments as an object has been removed from the tree
        return true;
    } // method remove

    /**
     * Finds the Entry object that houses a specified element, if there is such
     * an Entry. The worstTime(n) is O(n), and averageTime(n) is O(log n).
     *
     * @param obj - the element whose Entry is sought.
     *
     * @return the Entry object that houses obj - if there is such an Entry;
     * otherwise, return null.
     *
     * @throws ClassCastException - if obj is not comparable to the elements
     * already in this BinarySearchTree object.
     * @throws NullPointerException - if obj is null.
     *
     */
    protected Entry<E> getEntry(Object obj) {
        int comp;

        if (obj == null) {
            throw new NullPointerException();
        }
        Entry e = tree[root];
        while (e != null) {
            comp = ((Comparable) obj).compareTo(e.element);
            if (comp == 0) {
                return e;
            } else if (comp < 0) {
                e = tree[e.left];
            } else {
                e = tree[e.right];
            }
        } // while
        return null;
    } // method getEntry

    protected Entry<E> deleteEntry(Entry<E> p) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    protected int successor(int e) {
        if (e == -1) {
            return -1;
        } else if (tree[e].right != -1) {
            // successor is leftmost Entry in right subtree of e
            int p = tree[e].right;
            while (tree[p].left != -1) {
                p = tree[p].left;
            }
            return p;

        } // e has a right child
        else {

            // go up the tree to the left as far as possible, then go up
            // to the right.
            int p = tree[e].parent;
            int ch = e;
            while (p != -1 && ch == tree[p].right) {
                ch = p;
                p = tree[p].parent;
            } // while
            return p;

        } // e has no right child
    } // method successor    }

    @Override
    public Iterator<E> iterator() {
        return new ArrayIterator();
    }

    protected class ArrayIterator implements Iterator<E> {

        protected Entry<E> lastReturned = null;
        protected int next;

        protected ArrayIterator() {
            next = root;
            if (next != -1) {
                while (tree[next].left != -1) {
                    next = tree[next].left;
                }
            }
        }
        public boolean hasNext() {
            return next != -1;
        }
        public E next() {
            if (next == -1) {
                throw new IllegalStateException();
            }
            lastReturned = tree[next];
            next = successor(next);
            return lastReturned.element;
        }

        public void remove() {
            if (lastReturned == null) {
                throw new IllegalStateException();
            }
            if (lastReturned.left != -1 && lastReturned.right != -1) {

            }
            deleteEntry(lastReturned);
            lastReturned = null;
            //modCount++;
            //expectedModCount++;
        }
    }
}
