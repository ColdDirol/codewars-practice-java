import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class HighestAndLowest {
    public static String highAndLow(String numbers) {
        ArrayList<String> arrayList = new ArrayList<>(Arrays.asList(numbers.split(" ")));
        ArrayList<Integer> integerArrayList = new ArrayList<>();
        for(String n : arrayList) {
            integerArrayList.add(Integer.parseInt(n));
        }
        Collections.sort(integerArrayList);
        return integerArrayList.get(integerArrayList.size() - 1) + " " + integerArrayList.get(0);
    }

    public static void main(String[] args) {
        System.out.println(highAndLow("8 3 -5 42 -1 0 0 -9 4 7 4 -4"));
        System.out.println(highAndLow("1 2 3"));
    }
}
