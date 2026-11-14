import java.util.HashMap;
import java.util.HashSet;

public class WordPatter {
    public static void main(String[] args) {

    }

    public boolean wordPatter(String patter, String s) {
        String[] words = s.split(" ");

        if (pattern.length() != words.length) {
            return false;
        }

        HashMap<Character, String> map = new HashMap<>();
        HashSet<String> set = new HashSet<>();

        for (int i = 0; i < pattern.length(); i++) {

            char ch = pattern.charAt(i);
            String word = words[i];

            if (map.containsKey(ch)) {

                if (!map.get(ch).equals(word)) {
                    return false;
                }

            } else {

                if (set.contains(word)) {
                    return false;
                }

                map.put(ch, word);
                set.add(word);
            }
        }

        return true;
    }
}