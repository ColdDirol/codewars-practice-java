public class DescendingOrder {
    public static int sortDesc(final int num) {
        char numCharArray[] = String.valueOf(num).toCharArray();

        String answer = "";
        for(int i = 0; i <= 9; i++) {
            if(answer.length() == numCharArray.length) break;
            for(char n : numCharArray) {
                if(Integer.valueOf(String.valueOf(n)) == i) answer += n;
            }
        }

        return Integer.parseInt((new StringBuilder(answer).reverse()).toString());
    }

    public static void main(String[] args) {
        System.out.println(sortDesc(0));
        System.out.println(sortDesc(15));
        System.out.println(sortDesc(123456789));
    }
}
