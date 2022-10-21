package com.destifo.AVLTrees;

public class AVLTree {
    
    private class AVLNode {
        
        public int val;
        public AVLNode left;
        public AVLNode right;
        public int height = 0;

        AVLNode(int val) {
            this.val = val;
        }

        @Override
        public String toString() {
            return "value = " + this.val;
        }

    }


    public AVLNode root;


    public void insert(int val) {
        root = insert(root, val);;
    }

    private AVLNode insert(AVLNode currNode, int val) {

        if (currNode == null) {
            return new AVLNode(val);
        }

        if (currNode.val > val) {
            currNode.left = insert(currNode.left, val);
        }
        else {
            currNode.right = insert(currNode.right, val);
        }

        setHeight(currNode);

        return balance(currNode);
        
        // return currNode;
    }

    private void setHeight(AVLNode node) {
        node.height = Integer.max(height(node.left), height(node.right)) + 1;
    }
    
    private AVLNode balance(AVLNode node) {
        if (isLeftHeavy(node))
            return detectRotationForLeftHeavy(node);
        else if (isRightHeavy(node))
            return detectRotationForRightHeavy(node);
        else
            return node;
        
    }

    private AVLNode rotateLeft(AVLNode node) {
        AVLNode rightChild = node.right;
        AVLNode rightChildLeftChild = rightChild.left;
        rightChild.left = node;
        node.right = rightChildLeftChild;
        
        setHeight(node);
        setHeight(rightChild);

        return rightChild;
    }

    private AVLNode rotateRight(AVLNode node) {
        AVLNode leftChild = node.left;
        AVLNode leftChildRightChild = leftChild;
        leftChild.right = node;
        node.left = leftChildRightChild;

        setHeight(node);
        setHeight(leftChild);

        return leftChild;
    }

    private boolean isLeftHeavy(AVLNode node) {
        return getBalanceFactor(node) > 1;
    }

    private AVLNode detectRotationForLeftHeavy(AVLNode node) {
        if (getBalanceFactor(node.left) < 0){
            System.out.println("Left rotate " + node.left.val);
            node.left = rotateLeft(node.left);
        }
        
        System.out.println("Right rotate " + node.val);
        return rotateRight(node);
        
    }

    private AVLNode detectRotationForRightHeavy(AVLNode node) {
        if (getBalanceFactor(node.right) > 0){
            System.out.println("Right rotate " + node.right.val);
            node.right = rotateRight(node.right);
        }
        
        System.out.println("Left rotate " + node.val);
        return rotateLeft(node);
    }

    private boolean isRightHeavy(AVLNode node) {
        return getBalanceFactor(node) < -1;
    }

    private int height(AVLNode node) {
        return (node == null) ? -1 : node.height;
    }

    private int getBalanceFactor(AVLNode node) {
        return height(node.left) - height(node.right);
    }


}
