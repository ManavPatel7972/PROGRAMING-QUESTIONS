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
}