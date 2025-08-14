import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;
import java.util.Vector;

class Lists {
    public static void main(String[] args) {
        List<Integer> li = new LinkedList<>();
        List<Integer> al = new ArrayList<>();
        List<Integer> sk = new Stack<>();
        List<Integer> vtr = new Vector<>();

        li.add(1);
        al.add(2);
        sk.add(3);
        vtr.add(4);
        li.add(5);
        al.add(6);
        sk.add(7);
        vtr.add(8);
        System.out.println("LinkedList: " + li);
        System.out.println("ArrayList: " + al);
        System.out.println("Stack: " + sk);
        System.out.println("Vector: " + vtr);

    }
}
