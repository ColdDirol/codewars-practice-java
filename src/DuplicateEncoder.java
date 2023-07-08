public class DuplicateEncoder {
    static String encode(String word){
        word = word.toLowerCase();
        char opB = '(';
        char clB = ')';
        char[] chars = new char[word.length()];
        for(int i = 0; i < word.length(); i++) chars[i] = word.toCharArray()[i];

        int[] nums = new int[word.length()];
        for (int i = 0; i < word.length(); i++) {
            int cnt = 0;
            for (int j = 0; j < word.length(); j++) {
                if(chars[i] == chars[j]) cnt++;
            }
            nums[i] = cnt;
        }

        String answer = "";
        for (int i : nums) {
            if(i == 1) answer += opB;
            else answer += clB;
        }

        return answer;
    }

    public static void main(String[] args) {
//        "din"      =>  "((("
//        "recede"   =>  "()()()"
//        "Success"  =>  ")())())"
//        "(( @"     =>  "))(("

        System.out.println(")()())()(()()(".equals(encode("Prespecialized")));
        System.out.println("))))())))".equals(encode("   ()(   ")));
    }
}
