import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Xbonacci {

    static public double[] tribonacci(double[] s, int n) {
        // hackonacci me

        Double[] res = Arrays.stream(s).boxed().toArray(Double[]::new);
        List<Double> resList = Arrays.stream(s).boxed().collect(Collectors.toList());

        for (int i = 2; i < n-1; i++) {
            int length = res.length;
            double v = res[length - 3] + res[length - 2] + res[length - 1];
            resList.add(v);
            res = resList.toArray(new Double[0]);
        }


        return n>s.length ? resList.stream().mapToDouble(Double::doubleValue).toArray() : Arrays.copyOfRange(s, 0, n);


    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(tribonacci(new double []{0,1,1},1)));
    }

}

