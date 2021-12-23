public class LinkedList {
    private Node head;
    private Node tail;

    public void addFirst(int value){
        Node node = new Node(value);
        node.setNext(head);
        if (head == tail){
            tail = node;
        }
        head = node;
    }

    public void addLast(int value){
        Node node = new Node(value);
        tail.setNext(node);
        if (head == tail){
            head = node;
        }
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
            if (temp.getNext() == null){
                return -1;
            }

            if (temp.getValue() == value) {
                return count;
            }

            count++;
            temp = temp.getNext();
        }
    }
}
