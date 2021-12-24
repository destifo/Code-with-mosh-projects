package com.destifo;

public class Node {
    private int value;
    private Node next = null;

    public Node(int value){
        this.value = value;
    }
    
    public void setNext(Node node){
        this.next = node;
    }

    public Node getNext(){
        return next;
    }

    public int getValue(){
        return value;
    }
    
}