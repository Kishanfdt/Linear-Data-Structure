class Node{
    int data;
    Node next;
    public Node(int data){
        this.data=data;
        next =null;
    }
    class Methods { //method class
    static Node head = null;

    public static void insertAtBeg(int data) {
        Node newNode = new Node (data);
        if (head == null) {
            head = newNode;
            return;
        }
        newNode.next = head;
        head = newNode;

    }
    public static void deleteAtbeg(){
        Node temp=head;
        head=head.next;
        temp.next=null;
    }
    public class Singly_Delete extends Methods{ //main class
    
    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            insertAtBeg(i);
        }
        deleteAtbeg();
}
}
    }
}