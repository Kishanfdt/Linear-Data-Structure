class DubNode {
    DubNode prev;
    int data;
    DubNode next;

    public DubNode(int data) {
        prev = null;
        this.data = data;
        next = null;
    }
}

class DubMethods {
     static DubNode head,tail;
     public static void insertAtBeg (int data) {
        DubNode newNode = new DubNode(data);
        if (head == null && tail == null) {
            head = newNode;
            tail = newNode;
        }
        newNode.prev = tail;
        tail.next = newNode;
        tail = newNode;
    }
}

public class Doubly_Linked_List extends DubMethods {
    public static void main(String[] args) {
        insertAtBeg(0);
        insertAtBeg(2);
        insertAtBeg(3);
        DubNode temp = head;
        while(temp!=null){
            System.out.println(temp.data);
            temp = temp.next;
        }
    }
    
}
