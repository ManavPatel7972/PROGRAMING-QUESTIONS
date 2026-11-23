public class LongestUncommonSubsquence_I {
    public static void main(String[] args) {

    }

    public int findLUSlength(String a, String b) {
        return a.equals(b) ? -1 : (a.length() > b.length() ? a.length() : b.length());
    }
    
}