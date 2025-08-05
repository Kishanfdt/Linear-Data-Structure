


class Node {
    int data;
    Node left, right;

    public Node(int data) {
        this.data = data;
        left = right = null;
    }
}

    class Methods {
        static Node root = null;

        public static void insert(Node root, int data) {
            if (root == null) {
                Node newNode = new Node(data);
                root = newNode;
                return ;
            }
            if (data < root.data) {
                insert(root.left, data);
            } else if (data > root.data) {
                insert(root.right, data);
            }
        }
        public static void inorder(Node root) {
            if (root != null) {
                inorder(root.left);
                System.out.print(root.data + " ");
                inorder(root.right);
            }
        }
    }

public class Binary_Search_Tree extends Methods {
    public static void main(String[] args) {
        Node root = null;
        insert(root, 50);
        insert(root, 30);
        insert(root, 25);
        inorder(root);
    }
    
}