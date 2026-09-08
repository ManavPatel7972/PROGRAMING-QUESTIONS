public class LengthOfLastWord {
    public static void main(String[] args) {
        String s = "   fly me   to   the moon  ";
        System.out.println("Length = " + lengthOfWord(s));
    }

    public static int lengthOfWord(String s) {
        int i = s.length() - 1;
        int len = 0;

        while (i >= 0 && s.charAt(i) == ' ') {
            i--;
        }

        while (i >= 0 && s.charAt(i) != ' ') {
            i--;
            len++;
        }

        return len;
    }
}