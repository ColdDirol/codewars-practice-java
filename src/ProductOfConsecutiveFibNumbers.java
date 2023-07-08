import java.util.Arrays;

public class ProductOfConsecutiveFibNumbers {
    public static long[] productFib(long prod) {
        long first = 0;
        long second = 1;
        long next;

        long[] answer = new long[3];
        if(prod == 0) {
            answer[0] = first;
            answer[1] = second;
            answer[2] = 1;
            return answer;
        }
        for(long i = 0; i <= prod; i++) {
            next = first + second;

            if(first * next == prod) {
                answer[0] = first;
                answer[1] = next;
                answer[2] = 1;
                return answer;
            }
            if(first * next > prod) {
                answer[0] = first;
                answer[1] = next;
                answer[2] = 0;
                return answer;
            }

            second = first;
            first = next;
        }
        return null;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.equals(new long[]{ 55, 89, 1 }, productFib(4895)));
        System.out.println(Arrays.equals(new long[]{ 89, 144, 0 }, productFib(5895)));
    }
}
