import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class GroupAnagrams {
    public static void main(Stirng[] args) {

    }

    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();

        for (String str : strs) {

            char[] arr = str.toCharArray();
            Arrays.sort(arr);

            String key = new String(arr);

            map.putIfAbsent(key, new ArrayList<>());

            map.get(key).add(str);
        }

        return new ArrayList<>(map.values());
    }
}


import java.util.*;

public class GroupAnagrams {

    public static void main(String[] args) {

        String[] strs = {
            "eat", "tea", "tan",
            "ate", "nat", "bat"
        };

        GroupAnagrams obj = new GroupAnagrams();

        System.out.println(obj.groupAnagrams(strs));
    }

    public List<List<String>> groupAnagrams(String[] strs) {

        HashMap<String, List<String>> map = new HashMap<>();

        for (String str : strs) {

            int[] count = new int[26];

            for (char ch : str.toCharArray()) {
                count[ch - 'a']++;
            }

            StringBuilder key = new StringBuilder();

            for (int num : count) {
                key.append('#').append(num);
            }

            map.putIfAbsent(key.toString(), new ArrayList<>());

            map.get(key.toString()).add(str);
        }

        return new ArrayList<>(map.values());
    }
}
