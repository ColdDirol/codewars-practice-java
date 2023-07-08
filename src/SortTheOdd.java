import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class SortTheOdd {
    public static int[] sortArray(int[] array) {
        ArrayList<Integer> numbers = new ArrayList<>();
        for(int i : array) numbers.add(i);

        ArrayList<Integer> positions = new ArrayList<>();
        ArrayList<Integer> odds = new ArrayList<>();
        for(int i = 0; i < numbers.size(); i++) {
            if(numbers.get(i) % 2 == 1) {
                odds.add(numbers.get(i));
                positions.add(i);
            }
        }
        Collections.sort(odds);
        int cnt = 0;
        for(int i = 0; i < numbers.size(); i++) {
            if(positions.contains(i)) {
                numbers.set(i, odds.get(cnt));
                cnt++;
            }
        }
        int[] answer = new int[numbers.size()];
        for(int i = 0; i < numbers.size(); i++) {
            answer[i] = numbers.get(i);
        }
        return answer;
    }

    public static void main(String[] args) {
//        [7, 1]  =>  [1, 7]
//        [5, 8, 6, 3, 4]  =>  [3, 8, 6, 5, 4]
//        [9, 8, 7, 6, 5, 4, 3, 2, 1, 0]  =>  [1, 8, 3, 6, 5, 4, 7, 2, 9, 0]

        System.out.println(Arrays.equals(new int[]{ 1, 3, 2, 8, 5, 4 }, sortArray(new int[]{ 5, 3, 2, 8, 1, 4 })));
        System.out.println(Arrays.equals(new int[]{ 1, 3, 5, 8, 0 }, sortArray(new int[]{ 5, 3, 1, 8, 0 })));
        System.out.println(Arrays.equals(new int[]{}, sortArray(new int[]{})));
    }
}
