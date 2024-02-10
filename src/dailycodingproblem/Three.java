package dailycodingproblem;

import java.util.HashSet;
import java.util.Set;

/*
Given the root to a binary tree, implement serialize(root), which serializes
the tree into a string, and deserialize(s), which deserializes the string back into the tree.

Exercise was prepared for different language, but I thought I'll make it similar anyway.
 */

public class Three{

    public static void main(String[] args) throws Exception {
        binaryTree tree = new binaryTree();
        tree.add(6);
        tree.add(4);
        tree.add(8);
        tree.add(3);
        tree.add(5);
        tree.add(7);
        tree.add(9);

        System.out.println(tree.findMin());
        System.out.println(tree.findMax());
        System.out.println(tree.treeSizeCheck(tree.root));
        System.out.println(tree.treeSizeCheck(tree.root));


        Integer[] serializedTree = tree.serialize();
        for (Integer integer : serializedTree)
            System.out.print(integer + ", ");

        System.out.println();

        Integer[] array = {6,4,8,3,5,7,9};
        binaryTree tree2 = tree.deserialize(array);
        System.out.println(tree2.findMin());
        System.out.println(tree2.findMax());

    }

}

class Node {
    int value;
    Node rightChild;
    Node leftChild;

    Node(int value){
        this.value=value;
        rightChild = null;
        leftChild = null;
    }
}
class binaryTree {
    Node root;
    int counter = 0;
    int countToReset = 0;

    public binaryTree(){}

    private Node recursiveAdd(Node current, int value){
        if(current==null)
            return new Node(value);

        if(value < current.value)
            current.leftChild = recursiveAdd(current.leftChild, value);
        else if(value > current.value)
            current.rightChild = recursiveAdd(current.rightChild, value);
        else
            return current;
        return current;
    }

    public void add(int value) {
        root = recursiveAdd(root,value);
    }

    public int findMin() throws Exception {
        Node current = root;
        if(current == null)
            throw new Exception("This tree hasn't been rooted yet.");

        while(current.leftChild != null)
            current = current.leftChild;

        return current.value;
    }

    public int treeSizeCheck(Node current){

        if(current.leftChild != null){
            counter++;
            treeSizeCheck(current.leftChild);
        }
        if(current.rightChild != null){
            treeSizeCheck(current.rightChild);
            counter++;
        }
        int sum = counter;
        sum++; //doliczenie root'a

        if(current.leftChild == null && current.rightChild == null)
            if(countToReset==0)
                countToReset++;
            if(countToReset--==2)
                counter=0;
        return sum;
    }

    public int findMax() throws Exception {
        Node current = root;
        if(current == null)
            throw new Exception("This tree hasn't been rooted yet.");

        while (current.rightChild != null)
            current = current.rightChild;

        return current.value;
    }

    public Integer[] serialize(){
        Set<Integer> set = new HashSet<>();
        getValues(root, set);

        return set.toArray(new Integer[0]);
    }

    private void getValues(Node current, Set<Integer> set){
        set.add(current.value);
        if(current.leftChild != null)
            getValues(current.leftChild,set);
        if(current.rightChild != null)
            getValues(current.rightChild,set);
    }

    public binaryTree deserialize(Integer[] array){
        binaryTree bt = new binaryTree();
        for (Integer integer : array)
            bt.add(integer);
        return bt;
    }

}
