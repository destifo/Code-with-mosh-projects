package com.destifo.Tree;

import java.util.ArrayList;
import java.util.List;

public class MyTree {

    private Node root;


    public void insert(int value){
        Node node = new Node(value);

        if (root == null){
            root = node;
            return;
        }
        Node current = root;
        Node prev;
        while (true){
            if (value < current.value){
                prev = current;
                current = current.getLeftChild();
                if (current == null){
                    prev.setLeftChild(node);
                    break;
                }
            }
            else{
                prev = current;
                current = current.getRightChild();
                if (current == null){
                    prev.setRightChild(node);
                    break;
                }
            }
        }
    }


    public boolean find(int value){
        Node current = root;
        while (current != null && current.value != value){
            if (value > current.value){
                current = current.getRightChild();
            }
            else{
                current = current.getLeftChild();
            }
        }
        return (current != null)?true:false;
    }

    public void traversePreOrder(){
        _traversePreOrder(this.root);
    }

    private void _traversePreOrder(Node root) {
        if (root == null)
            return;
        System.out.println(root.value);
        _traversePreOrder(root.getLeftChild());
        _traversePreOrder(root.getRightChild());
    }

    public void traverseInOrder() {
        traverseInOrder(this.root);
    }

    private void traverseInOrder(Node root) {
        if (root == null)
            return;
        traverseInOrder(root.getLeftChild());
        System.out.println(root.value);
        traverseInOrder(root.getRightChild());
    }
   

    public void traversePostOrder() {
        traversePostOrder(this.root);
    }

    private void traversePostOrder(Node root) {
        if (root == null)
            return;
        traversePostOrder(root.getLeftChild());
        traversePostOrder(root.getRightChild());
        System.out.println(root.value);   
    }

    public int height() {
        return height(root);
    }

    private int height(Node root) {
        if (root == null)
            return -1;

        // base condn: if we reach a leaf
        if (isLeaf(root))
            return 0;
        
        return 1 + Math.max(height(root.getLeftChild()), height(root.getRightChild()));
    }

    // for binary search tree, O(logn)
    public int minValue() {
        if (root == null)
            throw new IllegalStateException();

        Node root = this.root;
        while (root.getLeftChild() != null) {
            root = root.getLeftChild();
        }
        return root.value;
    }

    public int min() {
        return minValueRec(this.root);
    }

    // O(n)
    private int minValueRec(Node root) {// for binary tree
        if (root == null)
            return Integer.MAX_VALUE;

        if (isLeaf(root))
            return root.value;

        int left = minValueRec(root.getLeftChild());
        int right = minValueRec(root.getRightChild());

        return Math.min(Math.min(right, left), root.value);
    }

    private boolean isLeaf(Node node) {
        return node.getLeftChild() == null && node.getRightChild() == null;
    }

    public boolean equals(MyTree tree) {
        if (tree == null)
            return false
            ;
        return equals(this.root, tree.root);
    }

    private boolean equals(Node node, Node other) {
        if (node == null && other == null)
            return true;
        if (node == null)
            return false;
        if (other == null)
            return false;
        return node.value == other.value && equals(node.getRightChild(), other.getRightChild()) && equals(node.getLeftChild(), other.getLeftChild());
    }

    public boolean isBinaryTree() {
        return isBinaryTree(this.root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private boolean isBinaryTree(Node root, int min, int max) {
        if (root == null)
            return true;

        int val = root.value;

        if (val > min && val < max)
            return isBinaryTree(root.getLeftChild(), min,val - 1) && isBinaryTree(root.getRightChild(), val - 1, max);
        else
            return false;
    }

    public void swap() {
        Node temp = root.getLeftChild();
        root.setLeftChild(root.getRightChild());
        root.setRightChild(temp);
    }

    public List<Integer> nodesAtKdistance(int k) {
        List<Integer> ans = new ArrayList<>();
        nodesAtKdistance(root, k, ans);
        return ans;
    }

    private void nodesAtKdistance(Node root, int distance, List<Integer> ans) {
        if (root == null)
            return;        
        if (distance == 0){
            ans.add(root.value);
            return;
        }
        
        nodesAtKdistance(root.getLeftChild(), distance - 1, ans);
        nodesAtKdistance(root.getRightChild(), distance - 1, ans);
        
    }

    public void traverseLevelOrder() {
        for (int i = 0; i <= height(); i++){
            System.out.print("Nodes at level " + i + ": ");
            System.out.println(nodesAtKdistance(i));
        }
    }

}

