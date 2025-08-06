/*
class AVLNode {
    int key;
    int height;
    AVLNode left, right;

    public AVLNode(int d) {
        key = d;
        height = 1;
        left = right = null;
    }
}

public class AVL_tree {
    static AVLNode root;

    public static int height(AVLNode N) {
        if (N == null)
            return 0;
        return N.height;
    }

    public static int getBalance(AVLNode N) {
        if (N == null)
            return 0;
        return height(N.left) - height(N.right);
    }

    public static AVLNode rightRotate(AVLNode y) {
        AVLNode x = y.left;
        AVLNode T2 = x.right;

        // Perform rotation
        x.right = y;
        y.left = T2;

        // Update heights
        y.height = Math.max(height(y.left), height(y.right)) + 1;
        x.height = Math.max(height(x.left), height(x.right)) + 1;

        // Return new root
        return x;
    }

    public static AVLNode leftRotate(AVLNode x) {
        AVLNode y = x.right;
        AVLNode T2 = y.left;

        // Perform rotation
        y.left = x;
        x.right = T2;

        // Update heights
        x.height = Math.max(height(x.left), height(x.right)) + 1;
        y.height = Math.max(height(y.left), height(y.right)) + 1;

        // Return new root
        return y;
    }

    public static void insert(int key) {
        root = insertNode(root, new AVLNode(key));
    }

    public static AVLNode insertNode(AVLNode node, AVLNode newNode) {
        if (node == null)
            return newNode;

        if (newNode.key < node.key)
            node.left = insertNode(node.left, newNode);
        else if (newNode.key > node.key)
            node.right = insertNode(node.right, newNode);
        else // Duplicate keys not allowed
            return node;

        // Update height
        node.height = 1 + Math.max(height(node.left), height(node.right));

        // Get balance factor
        int balance = getBalance(node);

        // Left Left Case
        if (balance > 1 && newNode.key < node.left.key)
            return rightRotate(node);

        // Right Right Case
        if (balance < -1 && newNode.key > node.right.key)
            return leftRotate(node);

        // Left Right Case
        if (balance > 1 && newNode.key > node.left.key) {
            node.left = leftRotate(node.left);
            return rightRotate(node);
        }

        // Right Left Case
        if (balance < -1 && newNode.key < node.right.key) {
            node.right = rightRotate(node.right);
            return leftRotate(node);
        }

        return node;
    }

    public static void inOrder(AVLNode node) {
        if (node != null) {
            inOrder(node.left);
            System.out.print(node.key + " ");
            inOrder(node.right);
        }
    }

    public static void main(String[] args) {
        insert(50);
        insert(30);
        insert(70);
        insert(20);
        insert(40);
        insert(60);
        insert(80);

        System.out.print("Inorder traversal: ");
        inOrder(root);
        System.out.println();
    }
}
*/
// Java Program to Implement AVL Tree

class Node {
    int data, height,bal;
    Node left, right;

    Node(int data) {
        this.data = data;
        left = null;
        right = null;
        height = 1;
    }
}

class Methods{
    static Node root = null;

    public static int setHeight(Node root){
        if(root.left == null && root.right == null) return 0;
        if(root.left != null && root.right == null) return root.left.height;
        if(root.left == null && root.right != null) return root.right.height;
        return root.left.height >root.right.height ? root.left.height : root.right.height;
    }

    public static int getBalance(Node root){
        if(root.left != null && root.right == null) return root.left.height;
        if(root.left == null && root.right != null) return 0 - root.right.height;
        return root.left.height - root.right.height;
    }

    public static Node leftRotate(Node root){
        Node rightchild = root.right;
        Node leftChildOfRight = rightchild.left;

        rightchild.left = root;
        root.right = leftChildOfRight;

        root.height = setHeight(root)+1;
        root.bal = getBalance(root);
        
        rightchild.height = setHeight(rightchild)+1;
        rightchild.bal = getBalance(rightchild);

        return rightchild;
    }



    public static Node rightRotate(Node root){
        Node leftchild = root.left;
        Node rightChildofLeft = leftchild.right;

        leftchild.right = root;
        root.left = rightChildofLeft;

        root.height = setHeight(root)+1;
        root.bal = getBalance(root);
        
        leftchild.height = setHeight(leftchild)+1;
        leftchild.bal = getBalance(leftchild);

        return leftchild;
    }
    

    public static Node insert(Node root,int data){
        if(root == null){
            root = new Node(data);
            return root;
        }

        if(data <root.data){
            root.left = insert(root.left,data);
        }
        else if(data >root.data){
            root.right = insert(root.right,data);
        }
        else{
            return root;
        }

        root.height = setHeight(root) + 1;
        
        int bal =  getBalance(root);
        root.bal = bal;

        if(bal > 1 && data < root.left.data){
            root = rightRotate(root);
        }
        if(bal <-1 && data > root.right.data){
            root = leftRotate(root);
        }
        if(bal < -1 && data < root.right.data ){
            root.right = rightRotate(root.right);
            root = leftRotate(root);
        }
        if(bal > 1 && data > root.left.data){
            root.left = leftRotate(root.left);
            root = rightRotate(root);
        }
        return root;
    }

    public static void inorder(Node root){
        if(root == null) return;
        System.out.print("    Node:" + root.data +"\n"+"Height: "+ root.height+" "+"Bal: "+root.bal +"\n");
        System.out.println();
        inorder(root.left);
        inorder(root.right);

    }

}

class AVL_tree extends Methods{
    public static void main(String[] args) {
        int[] values = {50, 30, 70, 20, 40, 60, 80, 10, 25, 35, 45, 55, 65, 75, 85, 5, 15, 27, 37, 47, 52, 57, 67, 77, 87};
        for (int v : values) {
            root = insert(root, v);
}
        
        inorder(root);
    }
}