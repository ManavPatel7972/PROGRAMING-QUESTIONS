import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class WordLadder_II {
    public static void main(String[] args) {
        List<String> wordList = Arrays.asList("des", "der", "dfr", "dgt", "dfs");

        String beginWord = "der", endWord = "dfs";

        WordLadder_II obj = new WordLadder_II();

        List<List<String>> ans = obj.findSequences(beginWord, endWord, new ArrayList<>(wordList));

        if (ans.isEmpty()) {
            System.out.println(-1);
        } else {
            for (List<String> sequence : ans) {
                System.out.println(String.join(" ", sequence));
            }
        }

    }

    public List<List<String>> findSequences(String beginWord, String endWord, List<String> wordList) {

        Set<String> s = new HashSet<>(wordList);

        Queue<List<String>> q = new LinkedList<>();
        q.add(new ArrayList<>(Arrays.asList(beginWord)));

        List<String> level = new ArrayList<>();
        level.add(beginWord);

        int l = 0;

        List<List<String>> ans = new ArrayList<>();

        while (!q.isEmpty()) {

            List<String> li = q.poll();

            if (li.size() > l) {
                l++;
                for (String used : level) {
                    s.remove(used);
                }
            }

            String word = li.get(li.size() - 1);

            if (word.equals(endWord)) {

                if (ans.isEmpty()) {
                    ans.add(new ArrayList<>(li));

                } else if (ans.get(0).size() == li.size()) {
                    ans.add(new ArrayList<>(li));
                }
            }

            char[] wordArr = word.toCharArray();

            for (int i = 0; i < wordArr.length; i++) {

                char ori = wordArr[i];

                for (char ch = 'a'; ch <= 'z'; ch++) {
                    wordArr[i] = ch;

                    String newWord = new String(wordArr);

                    if (s.contains(newWord)) {
                        li.add(newWord);
                        q.add(new ArrayList<>(li));
                        level.add(newWord);
                        li.remove(li.size() - 1);
                    }
                }

                wordArr[i] = ori;
            }

        }

        return ans;

    }

}
