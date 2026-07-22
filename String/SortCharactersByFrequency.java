package String;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SortCharactersByFrequency {
    public static void main(String[] args) {
        String s = "raaaajj";

        String res = frequencySort(s);
        System.out.println("Result = " + res);
    }

    public static String fre(String s) {
        HashMap<Character, Integer> map = new HashMap<>();

        char[] charArr = s.toCharArray();

        for (char c : charArr) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        List<Character> li = new ArrayList<>(map.keySet());

        // sort
        Collections.sort(li, (a, b) -> {
            // higher fre first
            if (!map.get(a).equals(map.get(b))) {
                return map.get(b) - map.get(a);
            }

            return a - b;
        });

        return li.toString();
    }

    public static String frequencySort(String s) {

        Map<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        List<Character> li = new ArrayList<>(map.keySet());
        Collections.sort(li, (a, b) -> {

            if (!map.get(a).equals(map.get(b))) {
                return map.get(b) - map.get(a);
            }

            return a - b;
        });

        StringBuilder result = new StringBuilder();
        
        for (char c : li) {
            result.append(String.valueOf(c).repeat(map.get(c)));
        }
        return result.toString();
    }

}
