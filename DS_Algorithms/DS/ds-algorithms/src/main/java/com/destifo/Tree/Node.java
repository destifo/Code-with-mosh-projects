package com.destifo.Tree;

public class Node {
    private Node rightChild;
    private Node leftChild;
    int value;//avoided private for writeability

    public Node(){};

    public Node(int value){
        this.value = value;
    }

    public void setRightChild(Node node){
        rightChild = node;
    }

    public void setLeftChild(Node node){
        leftChild = node;
    }

    public Node getRightChild(){
        return rightChild;
    }

    public Node getLeftChild(){
        return leftChild;
    }

    @Override
    public String toString(){
        return "Node = " + this.value;
    } 
    
}
