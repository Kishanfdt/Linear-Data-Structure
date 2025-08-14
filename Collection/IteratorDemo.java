import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class IteratorDemo { 
    public static void main(String[] args) {
        List<Integer> l1 = new ArrayList<>();
        l1.add(2);
        l1.add(1);
        l1.add(5);
        l1.add(6);
        l1.add(7);
        int g = l1.size();
        int h = g / 2;
        Collections.sort(l1.subList(0, h));
        Collections.reverse(l1.subList(h, g+1)); 
        System.out.println("List after modification: " + l1);
    }
}