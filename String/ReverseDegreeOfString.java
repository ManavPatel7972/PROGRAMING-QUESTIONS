import java.util.HashMap;
import java.util.Map;

public class ReverseDegreeOfString {
    public static void main(String[] args) {

    }

    public int reverseDegree(String s) {

        Map<Character, Integer> map = new HashMap<>();
        int v = 26;

        for (char ch = 'a'; ch <= 'z'; ch++) {
            map.put(ch, v--);
        }

        int ans = 0;

        for (int i = 0; i < s.length(); i++) {
            ans += map.get(s.charAt(i)) * (i + 1);
        }

        return ans;
    }

    public int reverseDegree2(String s) {

        int ans = 0;

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            int position = ch - 'a' + 1;
            int reverseDegree = 27 - position;
            ans += reverseDegree * (i + 1);
        }

        return ans;
    }
}