
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

        testTree.add("dog");
        testTree.add("turtle");
        testTree.add("cat");
        testTree.add("ferret");

        System.out.println(testTree.toString());

        BinarySearchTreeArray<String> testTreeArray = new BinarySearchTreeArray<>();
        
        testTreeArray.add("dog");
        testTreeArray.add("turtle");
        testTreeArray.add("cat");
        testTreeArray.add("bird");
        testTreeArray.add("ferret");
        System.out.println(testTreeArray.size());
        System.out.println(testTreeArray.contains("ferret"));

        System.out.println(testTreeArray.toString());

        for (String i : testTreeArray) {
            System.out.println("Animal: " + i);
           
        }
        
        System.out.println();
        testTreeArray.add("norwol");
        testTreeArray.remove("turtle");
        
         for (String i : testTreeArray) {
            System.out.println("Animal: " + i);
            
        }
         
//         testTreeArray.add("bork");
//         System.out.println();
//         
//          for (String i : testTreeArray) {
//            System.out.println("Animal: " + i);
//            
//        }                                                                     // Gets stuck in loop if you add then display for some reason.

    }
                                                                                // Are we even using the Iterator? It's never intialised in this class.
}
