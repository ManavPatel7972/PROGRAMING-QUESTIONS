import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

class Pair_Word {
    String first;
    int second;

    Pair_Word(String first, int second) {
        this.first = first;
        this.second = second;
    }
}

public class WordLadder_I {
    public static void main(String[] args) {
        String beginWord = "hit";
        String endWord = "cog";

        List<String> wordList = new ArrayList<>();
        wordList.add("hot");
        wordList.add("dot");
        wordList.add("dog");
        wordList.add("lot");
        wordList.add("log");
        wordList.add("cog");

        WordLadder_I obj = new WordLadder_I();
        int ans = obj.ladderLength(beginWord, endWord, wordList);
        System.out.println(ans);

    }

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {

        Queue<Pair_Word> q = new LinkedList<>();
        q.add(new Pair_Word(beginWord, 1));

        Set<String> s = new HashSet<>();

        for (int i = 0; i < wordList.size(); i++) {
            s.add(wordList.get(i));
        }

        s.remove(beginWord);

        while (!q.isEmpty()) {
            String word = q.peek().first;
            int step = q.peek().second;

            q.remove();

            if (word.equals(endWord) == true)
                return step;

            for (int i = 0; i < word.length(); i++) {

                char[] charArray = word.toCharArray();

                for (char ch = 'a'; ch <= 'z'; ch++) {

                    charArray[i] = ch;
                    String replaceWord = new String(charArray);

                    if (s.contains(replaceWord)) {
                        s.remove(replaceWord);
                        q.add(new Pair_Word(replaceWord, step + 1));
                    }
                }
            }

        }

        return 0;

    }
}
