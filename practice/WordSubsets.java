package practice;

import java.util.ArrayList;
import java.util.List;

public class WordSubsets {

    public List<String> wordSubsets(String[] words1, String[] words2) {
        List<String> list = new ArrayList<>();
        int[] target = new int[26];
        for (String str : words2) {
            int[] temp = new int[26];
            for (int i = 0; i < str.length(); i++) {
                char ch = str.charAt(i);
                temp[ch - 'a']++;
                target[ch - 'a'] = Math.max(temp[ch - 'a'], target[ch - 'a']);
            }
        }

        for (String str : words1) {
            int[] temp = new int[26];
            for (int i = 0; i < str.length(); i++) {
                char ch = str.charAt(i);
                temp[ch - 'a']++;
            }
            if (checkSum(temp, target)) {
                list.add(str);
            }
        }
        return list;
    }

    private boolean checkSum(int[] temp, int[] target) {
        for (int i = 0; i < 26; i++) {
            if (temp[i] < target[i])
                return false;
        }
        return true;
    }

}
