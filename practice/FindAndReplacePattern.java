package practice;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class FindAndReplacePattern {

    public List<String> findAndReplacePattern(String[] words, String pattern) {
        HashMap<Character, Integer> hm = new HashMap<>();
        int k = 0;
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < pattern.length(); i++) {
            char ch = pattern.charAt(i);
            if (!hm.containsKey(ch)) {
                hm.put(ch, k++);
            }
            str.append(hm.get(ch));
        }
        List<String> arr = new ArrayList<>();
        for (String word : words) {
            StringBuilder s = new StringBuilder();
            hm.clear();
            k=0;
            for (int i = 0; i < word.length(); i++) {
                char ch = word.charAt(i);
                if (!hm.containsKey(ch)) {
                    hm.put(ch, k++);
                }
                s.append(hm.get(ch));
            }
            if (s.toString().equals(str.toString())) {
                arr.add(word);
            }
        }
        return arr;
    }

}
