public class BreakCamelCase {
    public static String camelCase(String input) {
        String alphabetBig = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String answer = "";
        for(char c : input.toCharArray()) {
            if(alphabetBig.contains(String.valueOf(c))) {
                answer += " " + c;
            }
            else answer += c;
        }
        return answer;
    }

    public static void main(String[] args) {
//        "camelCasing"  =>  "camel Casing"
//        "identifier"   =>  "identifier"
//        ""             =>  ""

        System.out.println(camelCase("camelCasing"));
        System.out.println("camelCasingTest");
        System.out.println("camelcasingtest");
    }
}
