package array.day4;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class LongestSubstringWithoutRepeat {

    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> hs = new HashSet<>();
        Queue<Character> q = new LinkedList<>();
        int n = s.length();
        int count = 0;
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if (!hs.contains(ch)) {
                hs.add(ch);
                q.add(ch);
            } else {
                count = Math.max(count, q.size());
                while (!q.isEmpty() && q.peek() != ch) {
                    hs.remove(q.peek());
                    q.poll();
                }
                if (!q.isEmpty() && q.peek() == ch) {
                    hs.remove(q.peek());
                    q.poll();
                }
                q.offer(ch);
                hs.add(ch);
            }
        }
        return Math.max(q.size(), count);
    }

    public int lengthOfLongestSubstringBetter(String s) {
        HashMap<Character, Integer> hm = new HashMap<>();
        int n = s.length();
        int startIndex = -1;
        int c = 0, count = 0;
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if (!hm.containsKey(ch)) {
                hm.put(ch, i);
                c++;
            } else {
                if (hm.get(ch) < startIndex) {
                    hm.put(ch, i);
                    c++;
                } else {
                    count = Math.max(c, count);
                    startIndex = hm.get(ch) + 1;
                    hm.put(ch, i);
                    c = i - startIndex + 1;
                }
            }
        }
        return Math.max(count, c);
    }

    public static void main(String[] args) {
        LongestSubstringWithoutRepeat obj = new LongestSubstringWithoutRepeat();
        String str = "aab";
        System.out.println(obj.lengthOfLongestSubstring(str));
        System.out.println(obj.lengthOfLongestSubstringBetter(str));
    }

}
