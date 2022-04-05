import java.sql.Array;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.stream.Collectors;

public class Test {

    public static Map<String, Integer> removeLessThanZero(Map<String, Integer> map){

        Map<String, Integer> collect = map.entrySet().stream().filter(e -> e.getValue() > 0).collect(Collectors.toMap(e -> e.getKey(), e -> e.getValue()));

        return collect;

    }

    public static String getFlatMap(String input) {

        char[] chars = input.toCharArray();

        int index = 1;
        String result ="";
        String p = String.valueOf(chars[0]);;

        for (int i = 1; i < chars.length; i++) {

            String s = String.valueOf(chars[i]);
            if (s.equals(p)) {
                index++;

            }else {
                result = result + p + "" + index;
                index = 1;
            }

            p=s;

        }

        result = result + p + "" + index;

        return input.length() < result.length() ? input : result;

    }

    public static void main(String[] args) {

        System.out.println(getFlatMap("aaaaabbbbaCCCC"));;

    }

}
