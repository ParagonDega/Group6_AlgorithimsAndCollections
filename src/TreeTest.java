/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author greg
 */
public class TreeTest {
    
    public static void main (String[] args){
        
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
        testTreeArray.add("ferret");
        
        System.out.println(testTreeArray.toString());
        
    }
    
}
