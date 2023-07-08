import java.util.ArrayList;

public class Scramblies {
    public static boolean scramble(String str1, String str2) {
        ArrayList<Character> arrayListStr2 = new ArrayList<>();
        for(char c : str2.toCharArray()) arrayListStr2.add(c);

        for(int i = 0; i < str1.length(); i++) {
            for(int j = 0; j < str2.length(); j++) {
                if(str1.charAt(i) == str2.charAt(j)) {
                    arrayListStr2.remove(Character.valueOf(str2.charAt(j)));
                    break;
                }
            }
        }

        return arrayListStr2.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(scramble("rkqodlw","world") == true);
        System.out.println(scramble("cedewaraaossoqqyt","codewars") == true);
        System.out.println(scramble("katas","steak") == false);
        System.out.println(scramble("scriptjavx","javascript") == false);
        System.out.println(scramble("scriptingjava","javascript") == true);
        System.out.println(scramble("scriptsjava","javascripts") == true);
        System.out.println(scramble("javscripts","javascript") == false);
        System.out.println(scramble("aabbcamaomsccdd","commas") == true);
        System.out.println(scramble("commas","commas") == true);
        System.out.println(scramble("sammoc","commas") == true);
    }
}
