

class Node { //node class
    int data;
    Node next;

    public Node(int data){
        this.data = data;
        next = null;
    }
}

class Methods { //method class
    static Node head = null;

    public static void insertAtBeg(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            return;
        }
        newNode.next = head;
        head = newNode;

    }

    public static void insertAtEnd(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            return;
        }
        Node current = head;
        head = current;
        while (current.next != null) {
            current = current.next;
        }
        current.next = newNode;

    }
    
    public static void insertAtpos(int pos,int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            return;
        }
        Node current =head;
        while (current != null && pos- 1 > 0) {
            current = current.next;
            pos--;
        }
        if (current == null) {
            insertAtEnd(data);
            return;
        }
        newNode.next = current.next;
        current.next = newNode;
    }
}

public class Singly_Linked_List extends Methods{ //main class
    
    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            insertAtBeg(i);
        }
        Node current = head;

        insertAtEnd(11);
        // while (current != null) {
        //     System.out.println(current.data);
        //     current = current.next;
        // }
        insertAtpos(3, 24);
        current = head;
        while (current != null) {
            System.out.println(current.data);
            current = current.next;
        }
    }
}