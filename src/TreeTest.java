
import java.util.Iterator;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author s B00308929 && B00308927
 */
import java.util.ConcurrentModificationException;
import java.util.Iterator;

public class TreeTest {

    public static void main(String[] args) {

        BinarySearchTree<String> testTree = new BinarySearchTree<>();
        BinarySearchTreeArray<String> testTreeArray = new BinarySearchTreeArray<>();

        System.out.println("BST Test\n");
        testTree.add("dog");
        testTree.add("turtle");
        testTree.add("cat");
        testTree.add("bird");
        testTree.add("ferret");
        testTree.add("deer");
        testTree.add("zebra");
        testTree.add("frog");
        System.out.println(testTree.size());
        System.out.println(testTree.contains("ferret"));

        for (String i : testTree) {
            System.out.println("Animal: " + i);
        }

        System.out.println(testTree.remove("cat"));
        System.out.println(testTree.remove("dog"));
        System.out.println(testTree.remove("turtle"));

        for (String i : testTree) {
            System.out.println("Animal: " + i);
        }

        System.out.println("\nBSTA Test\n");

        testTreeArray.add("dog");
        testTreeArray.add("turtle");
        testTreeArray.add("cat");
        testTreeArray.add("bird");
        testTreeArray.add("ferret");
        testTreeArray.add("deer");
        testTreeArray.add("zebra");
        testTreeArray.add("frog");
        System.out.println(testTreeArray.size());
        System.out.println(testTreeArray.contains("ferret"));

        for (String j : testTreeArray) {
            System.out.println("Animal: " + j);
        }

        System.out.println(testTreeArray.remove("cat"));
        System.out.println(testTreeArray.remove("dog"));
        System.out.println(testTreeArray.remove("turtle"));

        for (String j : testTreeArray) {
            System.out.println("Animal: " + j);
        }

        // Gets stuck in loop if you add then display for some reason.
//        count = 0;
//        testSize = testTreeArray.size();
//        itr = testTreeArray.iterator();
//        while(itr.hasNext()){
//            Object current = itr.next();
//            System.out.println("Animal: " + current);
//            count++;
//            if(count> testSize * 2){
//                System.out.println("Apparent infinite loop when appending"
//                            + " while iterating");
//            break;
//            }
//        }
    }
    // Are we even using the Iterator? It's never intialised in this class.
}
