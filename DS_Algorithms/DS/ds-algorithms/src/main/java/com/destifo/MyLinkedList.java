package com.destifo;

import com.destifo.Node;

public class MyLinkedList {
    private Node head;
    private Node tail;
    private int length;

    public int firstPrint(){
        return length;
    }

    public MyLinkedList(){};

    private boolean isEmpty(){
        if (head == null) return true;
        return false;
    }

    public int size(){
        return length;
    }

    public void print(){
        Node temp = head;
        while (temp != null){
            System.out.println(temp.getValue());
            temp = temp.getNext();
        }
    }

    public void addFirst(int value){
        Node node = new Node(value);
        if (isEmpty()){
            tail = node;
            head = node;
        }else{
            node.setNext(head);
            head = node;   
        }
        length++;
        
    }

    public void addLast(int value){
        Node node = new Node(value);
        if (isEmpty()){
            head = node;
            tail = node;
        }else{
            tail.setNext(node);
            tail = node;
        }
        length++;
        //if (head == tail){
        //    tail = node;
        //    head.setNext(node);
        //    return;
        //}
        
    }

    public void deleteLast(){
        if (isEmpty()) return;

        if (head == tail){
            head = null;
            tail = null;
        }else{
            Node temp = head.getNext();
            Node prev = head;
            while (true){
                if (temp.getNext() == null){
                    tail = prev;
                    prev.setNext(null);
                    break;
                }
                temp = temp.getNext();
                prev = prev.getNext();
            }
        }
        length--;
    }
    
    public void deleteFirst(){
        if (head == null){
            return;
        }

        if (head == tail){
            head = null;
            tail = null;
        }else{
            Node next = head.getNext();
            head.setNext(null);
            head = next;
        }
        length--;
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

    public boolean contains(int value){
        if (indexOf(value) == -1) 
            return false;
        return true;
    }

    public int[] toArray(){
        Node temp = head;
        int[] array = new int[length]; 
        int index = 0;
        while (temp != null){
            array[index] = temp.getValue();
            index++;
            temp = temp.getNext();
        }
        return array;
    }

    public void reverse(){
        if (isEmpty()) return;

        Node temp, prev, next;
        temp = head.getNext();
        prev = head;
        while (temp != null){
            next = temp.getNext();
            temp.setNext(prev);
            prev = temp;
            temp = next;
        }
        
        tail = head;
        tail.setNext(null);
        head = prev;
    }

    public int getKthFromTheEnd(int k){
        if (isEmpty()) throw new IllegalStateException();

        if (k < 0) throw new IllegalArgumentException();

        Node first, second;
        first = head;
        second = head;
        int distance = 0;

        while (true){
            if (distance == k - 1)
                break;
            if (second == null)
                throw new IllegalArgumentException();
            second = second.getNext();
            distance ++;

        }
        while (true){
            if (second.getNext() == null)
                return first.getValue();
            first = first.getNext();
            second = second.getNext();
        }

    }

}
