import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

class Persist {
    public static int persistence(long n) {
        // your code

        String stringN = String.valueOf(n);;
        long reduce = n;

        int i = 0;

        while (String.valueOf(reduce).length()!=1) {

            IntStream intStream = Arrays.stream(stringN.split("(?<=.)")).mapToInt(Integer::new);
            reduce = intStream.reduce(1, (a, b) ->
            { return a * b;});

            stringN = ""+reduce;
            i++;
        }

        return i;

    }

    public static long findNextSquare(long sq) {

        long round = Math.round(Math.sqrt(sq));
        long l = -1;
        if(round*round==sq) {
           l = (round + 1) * (round + 1);
        }

        return l;
    }


    public static String getMiddle(String word) {
        int i = word.length() / 2;

        return i+i != word.length() ? String.valueOf(word.charAt(i)) : word.substring(i-1,i+1) ;

    }


    public static String solution(int n) {

        Map<Integer,String> map = new LinkedHashMap<>();
        map.put( 1000, "M");
        map.put( 500, "D" );
        map.put( 100, "C");
        map.put( 50, "L");
        map.put( 10, "X");
        map.put( 5, "V" );
        map.put( 1, "I");

        String romanNumber ="";
        String previouceNumber ="";
        String before ="";

        for (Map.Entry<Integer,String> e: map.entrySet()) {
            int i = n / e.getKey();

            if(i==0) {
                romanNumber = romanNumber + "";
            }else if(i<4) {
                romanNumber = romanNumber + returnStringNumber(e.getValue(),i);
            }else{
                romanNumber= romanNumber + before + previouceNumber;
            }

            n = n%e.getKey();
            before = previouceNumber;
            previouceNumber = e.getValue();


        }

        return romanNumber;
    }

    public static String returnStringNumber(String toRepeat, int repeat) {

        String result = toRepeat;

        for(int i =1; i<repeat;i++) {
            result = result + toRepeat;
        }
        return result;
    }

    public static String getString(int[] numbers, int n, int ii){

        String result ="";
        for (int i = n; i < ii; i++) {

            result = result + numbers[i];

        }

        return result;
    }

    public static String createPhoneNumber(int[] numbers) {
        // Your code here!

        return String.format("(%s) %s-%s", ""+getString(numbers,0,3),getString(numbers,3 ,6), getString( numbers, 6,10));

    }

    public static int[] sortArray(int[] array) {

        List<Integer> collectOdd = Arrays.stream(array).boxed().filter(e -> e%2 != 0).collect(Collectors.toList()).stream().sorted().collect(Collectors.toList());
        int j = 0;
        for (int i = 0; i < array.length; i++) {
            if(array[i]%2!=0){
                array[i] = collectOdd.get(j);
                j++;
            }
        }

        return array;
    }

    public static String high(String s) {

        TreeMap<Integer, String> sorted = new TreeMap<>();
        String[] wordList = s.split(" ");

        for (int i = wordList.length-1; i >= 0 ; i--) {
            sorted.put(getScore(wordList[i]),wordList[i]);
        }

        return sorted.lastEntry().getValue();
    }

    public static int getScore(String word) {
//        String abc = "abcdefghijklmnopqrstuvwxyz";
//        Integer reduce = Arrays.stream(word.split("(?<=.)")).map(l -> abc.indexOf(l.toLowerCase(Locale.ROOT)) + 1).reduce(0, (subtotal, element) -> subtotal + element);
        int sum = word.chars().map(i ->
        {
            return i - 96;
        })
                .sum();

        return sum;
    }

    public static String high2(String s) {
        return Arrays.stream(s.split(" "))
                .max(Comparator.comparingInt(
                        a -> a.chars().map(i -> i - 96).sum()
                )).get();
    }

    public static String camelCase(String input) {

        StringBuilder splitString = new StringBuilder();

        Arrays.stream(input.split("(?<=.)")).forEach(l -> {
            if(l.equals(l.toUpperCase(Locale.ROOT))){
                l = " " + l;
            }
            splitString.append(l);
        });

        return input.equals("") ? "" : splitString.toString();
    }


    public static boolean isValid(String braces) {

        String oldBraces = "";
        while (true)
        {
            braces = braces.replace("()","").replace("{}","").replace("[]","");
        if(braces.equals("")){return true;}
        if(braces.equals(oldBraces)) {return false;}
        oldBraces = braces;
        }

    }


    public static int findEvenIndex(int[] arr) {

        int index = -1;

        for (int i = 0; i < arr.length; i++) {

            int[] first = Arrays.copyOfRange(arr, 0, i);
            int[] last = Arrays.copyOfRange(arr, Math.min(i + 1, arr.length-1), arr.length);
            int firstSum = Arrays.stream(first).reduce(0, Integer::sum);
            int lastSum = Arrays.stream(last).reduce(0, Integer::sum);

            if(firstSum == lastSum) {return i;}

        }

        return index;
    }

    public static void main(String[] args) {

        System.out.println(findEvenIndex(new int[] {0,0,0,0}));

        //high("man i need a taxi up to ubud");
        //System.out.println("-"+camelCase("")+"-");
        //System.out.println(Arrays.toString(sortArray(new int[]{ 5, 3, 2, 8, 1, 4 })));
    }

}