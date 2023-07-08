import java.util.*;

public class PickPeaks {
    public static Map<String,List<Integer>> getPeaks(int[] arr) {
        Map<String, List<Integer>> answerMap = new HashMap<>();

        List<Integer> posList = new ArrayList<>();
        List<Integer> peaksList = new ArrayList<>();

        boolean check1 = false;
        boolean check2 = false;
        boolean check3 = false;
        boolean check4 = false;
        boolean check5 = false;   // crutch

        if(arr.length > 2) {
            boolean isPeak = false;
            boolean isLastPlateaus = true;
            int previousPeak = 0;
            for (int i = 0; i < arr.length - 1; i++) {
                if (arr[i + 1] >= arr[i]) isPeak = true;

                check1 = arr[i] >= arr[i + 1];
                check2 = arr[i] != previousPeak;
                check3 = i != 0 && (i + 1) != arr.length;
                if(i != 0) check4 = arr[i-1] <= arr[i];
                if(i != 0 && i < arr.length - 2) check5 = arr[i - 1] < arr[i] && arr[i + 1] == arr[i] && arr[i+2] > arr[i];

                if (check1 && check2 && check3 && check4 && !check5 && isPeak) {
                    for(int j = i; j < arr.length - 1; j++) if(arr[j] != arr[j+1]) isLastPlateaus = false;
                    if(isLastPlateaus) continue;
                    posList.add(i);
                    peaksList.add(arr[i]);
                    isPeak = false;
                    isLastPlateaus = true;
                }
                previousPeak = arr[i];
            }
        }

        answerMap.put("pos", posList);
        answerMap.put("peaks", peaksList);
        return answerMap;
    }

    public static void main(String[] args) {
        System.out.println(getPeaks(new int[]{ 1, 2, 3, 6, 4, 1, 2, 3, 2, 1 }));
        System.out.println(getPeaks(new int[]{ 3, 2, 3, 6, 4, 1, 2, 3, 2, 1, 2, 3 }));
        System.out.println(getPeaks(new int[]{ 3, 2, 3, 6, 4, 1, 2, 3, 2, 1, 2, 2, 2, 1 }));
        System.out.println(getPeaks(new int[]{ 2, 1, 3, 1, 2, 2, 2, 2, 1 }));
        System.out.println(getPeaks(new int[]{ 2, 1, 3, 1, 2, 2, 2, 2 }));
    }
}
