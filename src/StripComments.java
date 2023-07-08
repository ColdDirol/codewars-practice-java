import java.util.ArrayList;
import java.util.Arrays;

public class StripComments {

    // fckk random test
    public static String stripComments(String text, String[] commentSymbols) {
        ArrayList<String> stringArrayList = new ArrayList<>(Arrays.asList(text.split("\\n")));
        String newString = "";
        for(int i = 0; i < stringArrayList.size(); i++) {
            for(int j = 0; j < commentSymbols.length; j++) {
                if(stringArrayList.get(i).contains(commentSymbols[j])) {
                    int beginIndex = stringArrayList.get(i).indexOf(commentSymbols[j]);
                    int endIndex = stringArrayList.get(i).length() - 1;
                    newString = stringArrayList.get(i).substring(0, beginIndex).trim();
                    stringArrayList.set(i, newString);
                }
            }
        }
        String answer = "";
        for (String str : stringArrayList) {
            if(stringArrayList.get(stringArrayList.size() - 1).equals(str)) answer += str;
            else answer += str + "\n";
        }
        return answer;
    }

    public static void main(String[] args) {
        String should1 = "apples, pears\ngrapes\nbananas";
        String answer1 = stripComments("apples, pears # and bananas\ngrapes\nbananas !apples", new String[] { "#", "!"} );
        System.out.println(should1.equals(answer1));

        String should2 = "a\nc\nd";
        String answer2 = stripComments( "a #b\nc\nd $e f g", new String[] { "#", "$" } );
        System.out.println(should2.equals(answer2));
    }
}