class Node {
    int data;
    Node ledt, right;

    Node(int data) {
        this.data = data;
        this.ledt = null;
        this.right = null;
    }
}

class Methods {
    Node root;

    public Methods() {
        this.root = null;
    }

    public void insert(int data) {
        root = insertRec(root, data);
    }

    private Node insertRec(Node root, int data) {
        if (root == null) {
            root = new Node(data);
            return root;
        }
        if (data < root.data) {
            root.ledt = insertRec(root.ledt, data);
        } else if (data > root.data) {
            root.right = insertRec(root.right, data);
        }
        return root;
    }

    public void inorder() {
        inorderRec(root);
    }

    private void inorderRec(Node root) {
        if (root != null) {
            inorderRec(root.ledt);
            System.out.print(root.data + " ");
            inorderRec(root.right);
        }
    }

    public void preorder() {
        preorderRec(root);
    }

    private void preorderRec(Node root) {
        if (root != null) {
            System.out.print(root.data + " ");
            preorderRec(root.ledt);
            preorderRec(root.right);
        }
    }

    public void postorder() {
        postorderRec(root);
    }

    private void postorderRec(Node root) {
        if (root != null) {
            postorderRec(root.ledt);
            postorderRec(root.right);
            System.out.print(root.data + " ");
        }
    }

    public boolean search(int data) {
        return searchRec(root, data);
    }
    private boolean searchRec(Node root, int data) {
        if (root == null) {
            return false;
        }
        if (data < root.data) {
            return searchRec(root.ledt, data);
        } else if (data > root.data) {
            return searchRec(root.right, data);
        } else {
            return true; 
        }
    }
}
public class Binary_Search_Tree {
    public static void main(String[] args) {
        Methods bst = new Methods();
        bst.insert(26);
        bst.insert(22);
        bst.insert(120);
        bst.insert(70);
        bst.insert(7);
        bst.insert(6);
        bst.insert(11);

        System.out.println("Inorder traversal:");
        bst.inorder();
        
        System.out.println("\nPreorder traversal:");
        bst.preorder();
        
        System.out.println("\nPostorder traversal:");
        bst.postorder();

        int searchValue = 40;
        System.out.println("\nSearching for " + searchValue + ": " + bst.search(searchValue));
    }
}
