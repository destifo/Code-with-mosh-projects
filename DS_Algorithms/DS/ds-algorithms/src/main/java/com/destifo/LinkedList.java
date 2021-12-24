package com.destifo;

public class LinkedList {
    private Node head;
    private Node tail;

    public LinkedList(){};

    public void print(){
        Node temp = head;
        while (temp != null){
            System.out.println(temp.getValue());
            temp = temp.getNext();
        }
    }

    public void addFirst(int value){
        Node node = new Node(value);
        if (head == null & head == tail){
            tail = node;
            head = node;
            return;
        }
        node.setNext(head);
        head = node;   
    }

    public void addLast(int value){
        Node node = new Node(value);
        if (head == null & head == tail){
            head = node;
            tail = node;
            return;
        }
        //if (head == tail){
        //    tail = node;
        //    head.setNext(node);
        //    return;
        //}
        tail.setNext(node);
        tail = node;
    }

    public void deleteLast(){
        if (head == null){
            return;
        }

        if (head == tail){
            head = null;
            tail = null;
            return;
        }

        Node temp = head.getNext();
        Node prev = head;
        while (true){
            if (temp.getNext() == null){
                tail = prev;
                prev.setNext(null);
                return;
            }
            temp = temp.getNext();
            prev = prev.getNext();
        }
    }
    
    public void deleteFirst(){
        if (head == null){
            return;
        }

        if (head == tail){
            head = null;
            tail = null;
            return;
        }
        
        Node next = head.getNext();
        head.setNext(null);
        head = next;
    }

    public int indexOf(int value){
        int count = 0;
        Node temp = head;
        while (true){
            if (temp.getValue() == value) {
                return count;
            }
            if (temp.getNext() == null){
                return -1;
            }

            

            count++;
            temp = temp.getNext();
        }
    }
}
