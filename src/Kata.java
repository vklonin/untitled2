import java.util.*;
import java.util.stream.Collectors;

public class Kata {

    public static int[] arrayDiff(int[] a, int[] b) {
        // Your code here

        List<Integer> listB = Arrays.stream(b)        // IntStream
                .boxed()          // Stream<Integer>
                .collect(Collectors.toList());

        int[] ints = Arrays.stream(a).filter(i -> listB.contains(i)).toArray();

        return a;
    }

}