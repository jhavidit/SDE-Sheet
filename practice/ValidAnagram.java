package practice;

import java.util.HashMap;

public class ValidAnagram {

    public boolean isAnagram(String s, String t) {
        HashMap<Character, Integer> hm = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (hm.containsKey(ch)) {
                hm.put(ch, hm.get(ch) + 1);
            } else
                hm.put(ch, 1);
        }
        for (int i = 0; i < t.length(); i++) {
            char ch = t.charAt(i);
            if (!hm.containsKey(ch))
                return false;
            if (hm.get(ch) == 1)
                hm.remove(ch);
            else
                hm.put(ch, hm.get(ch) - 1);
        }
        return hm.isEmpty();
    }

}
