public class WhoLikesIt {
    public static String whoLikesIt(String... names) {
        int namesLength = names.length;

        if(namesLength == 1) return names[0] + " likes this";
        if(namesLength == 2) return names[0] + " and " + names[1] + " like this";
        if(namesLength == 3) return names[0] + ", " + names[1] + " and " + names[2] + " like this";
        if(namesLength > 3) return names[0] + ", " + names[1] + " and " + (namesLength-2) + " others like this";

        return "no one likes this";
    }

    public static void main(String[] args) {
        System.out.println(whoLikesIt());
        System.out.println(whoLikesIt("Peter"));
        System.out.println(whoLikesIt("Jacob", "Alex"));
        System.out.println(whoLikesIt("Max", "John", "Mark"));
        System.out.println(whoLikesIt("Alex", "Jacob", "Mark", "Max"));
    }
}