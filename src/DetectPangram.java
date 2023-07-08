public class DetectPangram {
    public static boolean check(String request){
        String alphabetBig = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String alphabetLow = "abcdefghijklmnopqrstuvwxyz";
        for(int i = 0; i < alphabetBig.length(); i++) {
            if(request.contains(Character.toString(alphabetBig.charAt(i)))
                    || request.contains(Character.toString(alphabetLow.charAt(i)))) continue;
            else return false;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(check("The quick brown fox jumps over the lazy dog."));
        System.out.println(check("You shall not pass!"));
    }
}
