package String;

import java.util.*;

public class UniqueMorseCodeWords{
    public static void main(String[] args){

    }

    public int uniqueMorseRepresentations(String[] words){
        String[] morse = {
             ".-", "-...", "-.-.", "-..", ".", "..-.",
                "--.", "....", "..", ".---", "-.-", ".-..",
                "--", "-.", "---", ".--.", "--.-", ".-.",
                "...", "-", "..-", "...-", ".--", "-..-",
                "-.--", "--.."
        };

        Set<String> s = new HashSet<>();

        for(String word: words){
            String code = "";

            for(char ch : word.toCharArray()){
                code += morse[ch-'a'];
            }

        }
        return s.size();
    }
}