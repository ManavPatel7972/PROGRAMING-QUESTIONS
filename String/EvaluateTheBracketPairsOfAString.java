package String;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class EvaluateTheBracketPairsOfAString {
    public static void main(String[] args) {
        String s = "(name)is(age)yearsold";

        List<List<String>> knowledge = new ArrayList<>();
        List<String> pair1 = new ArrayList<>();
        pair1.add("name");
        pair1.add("bob");
        knowledge.add(pair1);
        List<String> pair2 = new ArrayList<>();
        pair2.add("age");
        pair2.add("two");
        knowledge.add(pair2);

        System.out.println("Result = " + evaluate(s, knowledge));
    }

    public static String evaluate(String s, List<List<String>> adj) {

        HashMap<String, String> map = new HashMap<>();

        for (List<String> pair : adj) {
            map.put(pair.get(0), pair.get(1));
        }

        StringBuilder res = new StringBuilder();
        int i = 0;

        while (i < s.length()) {

            // if open bracket
            if (s.charAt(i) == '(') {
                int j = i + 1;

                // find close bracket
                while (s.charAt(j) != ')') {
                    j++;
                }

                String key = s.substring(i + 1, j);

                // if key present so replace with value or "?"
                if (map.containsKey(key)) {
                    res.append(map.get(key));
                } else {
                    res.append("?");
                }

                i = j + 1;
            } else {
                res.append(s.charAt(i));
                i++;
            }
        }
        return res.toString();
    }
}
