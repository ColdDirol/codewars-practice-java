public class NumberOfTrailingZerosOfN {
    public static int zeros(int n) {
        int cnt = 0;

        while (n >= 5) {
            n /= 5;
            cnt += n;
        }

        return cnt;
    }

    public static void main(String[] args) {
        System.out.println(zeros(0) == 0);
        System.out.println(zeros(6) == 1);
        System.out.println(zeros(14) == 2);
    }
}
