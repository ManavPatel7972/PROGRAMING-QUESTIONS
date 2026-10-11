import java.util.*;

public class LetterCombinationsOfAPhoneNumber {
    public static void main(String[] args) {
        String digits = "26";
        System.out.println(letterCombinations(digits).toString());
    }

    public static List<String> letterCombinations(String digits) {

        List<String> res = new ArrayList<>();

        if (digits.length() == 0) {
            return res;
        }

        HashMap<Character, String> map = new HashMap<>();
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");

        res.add("");

        for (int i = 0; i < digits.length(); i++) {

            List<String> temp = new ArrayList<>();
            String letters = map.get(digits.charAt(i));

            for (String comb : res) {
                for (int j = 0; j < letters.length(); j++) {
                    temp.add(comb + letters.charAt(j));
                }
            }
            res = temp;
        }

        return res;
    }

    public static List<String> letterCombinationsBacktracking(String digits) {
        List<String> res = new ArrayList<>();
        HashMap<Character, String> map = new HashMap<>();
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");

        if (digits.length() == 0) {
            return res;
        }

        backtrack(digits, 0, "", map, res);

        return res;
    }

    public static void backtrack(String digits, int idx, String curr, HashMap<Character, String> map,
            List<String> res) {

        if (idx == digits.length()) {
            res.add(curr);
            return;
        }

        String letters = map.get(digits.charAt(idx));

        for (int i = 0; i < letters.length(); i++) {
            backtrack(digits, idx + 1, curr + letters.charAt(i), map, res);
        }
    }
}