class Node{
    int data;
    Node next;
    Node prev;

    public Node(int data){
        this.data = data;
        next = null;
        prev = null;
    }
}

class Methods{
   static Node head , tail = null;

    public static void insertAtBeg(int data){
        Node newNode = new Node(data);
        if(head == null){
            head = newNode;
            tail = newNode;
            head.prev = tail;
            head.next = head;
            tail.prev = head;
            tail.next = head;
            return;
        }
        newNode.prev = tail;
        newNode.next = head;
        head = newNode;
        tail.prev = head;
        tail.next = head;
    }

    public static void insertAtEnd(int data){
        if(head == null){
            insertAtBeg(data);
            return;
        }
        Node newNode = new Node(data);

        newNode.prev = tail;
        newNode.next = head;
        tail.next = newNode;
        tail = newNode;
    }

    public static void insertAtPos(int pos,int data){
        Node newNode = new Node(data);
        if(pos == 0){
            insertAtBeg(data);
            return;
        }

        Node temp_head = head;
        Node temp_tail = tail;

        while(temp_head != temp_tail && pos-1 >0){
            temp_head = temp_head.next;
            pos--;
        }
        if(temp_head.next == head){
            insertAtEnd(data);
            return;
        }
        
        newNode.next = temp_head.next;
        newNode.prev = temp_head;
        temp_head.next.prev = newNode;
        temp_head.next = newNode;

        
    }

    public static void delAtBeg(){
        if(head == null) return;
        head = head.next;
        
        if(head == tail){
            head = null;
            tail = null;
            return;
        }

        head.prev = tail;
        tail.next = head;


    }

    public static void delAtEnd(){
        if(head == null) return;

        Node temp_head = head;
        Node temp_tail = tail;

        do { 
            temp_head = temp_head.next;
        } while (temp_head.next != temp_tail);

       
        if(temp_head == tail){
            head = null;
            tail = null;
            return;
        }
        
        temp_head.next = head;
        tail = temp_head;
        head.prev = tail;
    }

    public static void delAtPos(int pos){
        if(head == null) return;

        Node temp_head = head;
        Node temp_tail = tail;

        if(pos == 0){
            delAtBeg();
            return;
        }

        if(temp_head.next == tail){
            head = null;
            tail = null;
            return;
        }

        while(temp_head.next != temp_tail && pos-1 >0){
            temp_head = temp_head.next;
            pos--;
        }

        if(temp_head.next.next == head){
            delAtEnd();
            return;
        }
        temp_head.next.prev = temp_head;
        temp_head.next = temp_head.next.next;

    }

    public static void display(){
        if(head == null) return;

        Node temp_head = head;
        Node temp_tail = tail;
        do { 
            System.out.print(temp_head.data + " ");
            temp_head = temp_head.next;
        } while (temp_head!=temp_tail.next);
        System.out.println();
    }
}

public class Circular extends Methods{
    public static void main(String[] args) {
        insertAtBeg(0);
        insertAtBeg(1);
        insertAtBeg(2);

        insertAtEnd(56);
       
        insertAtPos(2, 90);
        // delAtBeg();
        // delAtEnd();
       
        display();
        delAtPos(3);
        
        display();
    }
}

