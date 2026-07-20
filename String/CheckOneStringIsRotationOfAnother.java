package String;

public class CheckOneStringIsRotationOfAnother {

    public static void main(String[] args) {
        String s1 = "rotation";
        String goal1 = "tionrota";
        System.out.println("Result = " + rotateStringOptimal(s1, goal1));
    }

    public static boolean rotateString(String str, String goal) {
        if (str.length() != goal.length())
            return false;

        for (int i = 0; i < str.length(); i++) {
            String rotated = str.substring(i) + str.substring(0, i);

            if (rotated.equals(goal))
                return true;
        }

        return false;

    }

    public static boolean rotateStringOptimal(String str, String goal) {

        if (str.length() != goal.length())
            return false;

        String doubleStr = str + str;

        return doubleStr.contains(goal);

    }

}