import java.util.HashMap;

public class RansomNote {
    public static void main(String[] args) {

    }

    public boolean canConstruct(String ransomNote, String magazine) {
        HashMap<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < magazine.length(); i++) {
            char ch = magazine.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        for (int i = 0; i < ransomNote.length(); i++) {
            char ch = ransomNote.charAt(i);
            if (!map.get(ch) || map.get(ch) == 0) {
                return false;
            }
            map.put(ch, map.get(ch) - 1);
        }
        return true;
    }

    public boolean canConstructMethod2(String ransomNote, String magazine) {
        int[] arr = new int[26];

        for (int i = 0; i < magazine.length(); i++) {
            char ch = magazine.charAt(i);
            arr[ch - 'a']++;
        }

        for (int i = 0; i < ransomNote.length(); i++) {
            char ch = ransomNote.charAt(i);
            if (arr[ch - 'a'] == 0) {
                return false;
            }
            arr[ch - 'a']--;
        }

        return true;
    }
}