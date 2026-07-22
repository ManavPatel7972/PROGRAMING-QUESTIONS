package String;

import java.util.HashMap;
import java.util.Map;

public class SumOfBeautyOfAllAbuString {
    public static void main(String[] args) {
        String s = "aabcb";
        System.out.println(beautySumOptimal(s));
    }

    public static int getMinCount(int[] freq) {
        int minCount = Integer.MAX_VALUE;
        for (int i = 0; i < 26; i++) {
            if (freq[i] != 0) {
                minCount = Math.min(minCount, freq[i]);
            }
        }
        return minCount;
    }

    public static int getMaxCount(int[] freq) {
        int maxCount = 0;

        for (int i = 0; i < freq.length; i++) {
            maxCount = Math.max(maxCount, freq[i]);
        }

        return maxCount;
    }

    public static int beautySum(String s) {
        int sum = 0;
        for (int i = 0; i < s.length(); i++) {
            int[] freq = new int[26];
            for (int j = i; j < s.length(); j++) {
                freq[s.charAt(j) - 'a']++;
                int beauty = getMaxCount(freq) - getMinCount(freq);
                sum += beauty;
            }
        }
        return sum;
    }

    public static int beautySumOptimal(String s) {
        int sum = 0;

        for (int i = 0; i < s.length(); i++) {
            Map<Character, Integer> map = new HashMap<>();

            for (int j = i; j < s.length(); j++) {
                map.put(s.charAt(j), map.getOrDefault(s.charAt(j), 0) + 1);

                int maxi = Integer.MIN_VALUE;
                int mini = Integer.MAX_VALUE;

                for (int val : map.values()) {
                    mini = Math.min(mini, val);
                    maxi = Math.max(maxi, val);
                }

                sum += (maxi - mini);
            }

        }

        return sum;
    }

}