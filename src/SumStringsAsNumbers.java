import java.util.ArrayList;

public class SumStringsAsNumbers {
    public static String sumStrings(String a, String b) {
        ArrayList<Character> littleCharsArrayList = new ArrayList<>();
        ArrayList<Character> bigCharsArrayList = new ArrayList<>();
        if(a.length() > b.length()) {
            for(char c : a.toCharArray()) bigCharsArrayList.add(c);
            for(char c : b.toCharArray()) littleCharsArrayList.add(c);
        } else {
            for(char c : a.toCharArray()) littleCharsArrayList.add(c);
            for(char c : b.toCharArray()) bigCharsArrayList.add(c);
        }

//        System.out.println(bigCharsArrayList);
//        System.out.println(littleCharsArrayList);

        String[] answerStrings = new String[bigCharsArrayList.size()];
        int littleBackIndex = littleCharsArrayList.size() - 1;
//        System.out.println(littleBackIndex);
        for(int i = bigCharsArrayList.size() - 1; i >= 0; i--) {
            if(littleBackIndex >= 0) {
                answerStrings[i] = String.valueOf(Character.getNumericValue(bigCharsArrayList.get(i)) + Character.getNumericValue(littleCharsArrayList.get(littleBackIndex)));
                littleBackIndex--;
            } else {
                answerStrings[i] = String.valueOf(bigCharsArrayList.get(i));
            }
//            System.out.println(littleBackIndex + " - " + answerStrings[i]);
        }

        String answer = "";
        boolean carryFlag = false;
        int num;
        for(int i = answerStrings.length - 1; i >= 0; i--) {
            num = Integer.valueOf(answerStrings[i]);
            if(carryFlag) num++;
            carryFlag = false;
            if(num < 10) {
                answer += num;
            } else {
                answer += num - 10;
                carryFlag = true;
            }
        }
        if(carryFlag) answer += "1";
        if(answer.charAt(answer.length() - 1) == '0') answer = answer.substring(0, answer.length() - 1);

        return new StringBuilder(answer).reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(sumStrings("123", "456"));
        System.out.println(sumStrings("19", "10009"));
        System.out.println(sumStrings("9005", "9009"));
    }
}
