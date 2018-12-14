import java.util.ArrayList;

public class test {
    public static void main(String[] args) {
        ArrayList<Integer> test= new ArrayList<>();
        ArrayList<Integer> clone= new ArrayList<>();

        test.add(1);
        test.add(2);

        clone = (ArrayList<Integer>) test.clone();
        System.out.println(clone);

    }
}
