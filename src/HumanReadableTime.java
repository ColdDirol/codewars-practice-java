public class HumanReadableTime {
    public static String makeReadable(int seconds) {
        int hh = seconds % 60;
        int mm = (seconds / 60) % 60;
        int ss = seconds / 3600;

        String answer = "";

        if(hh < 10) answer += "0" + hh + ":";
        else answer += answer + hh + ":";

        if(mm < 10) answer += "0" + mm + ":";
        else answer += mm + ":";

        if(ss < 10) answer += "0" + ss;
        else answer += ss;

//        System.out.println(answer);

        return answer;
    }

    public static void main(String[] args) {
        System.out.println("00:00:00".equals(makeReadable(0)) + " " + makeReadable(0));
        System.out.println("00:00:05".equals(makeReadable(5)) + " " + makeReadable(5));
        System.out.println("00:01:00".equals(makeReadable(60)) + " " + makeReadable(60));
        System.out.println("23:59:59".equals(makeReadable(86399)) + " " + makeReadable(86399));
        System.out.println("99:59:59".equals(makeReadable(359999)) + " " + makeReadable(359999));
    }
}
