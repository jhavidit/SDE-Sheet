package string;

public class ReverseWordsInString {

    public String reverseWords(String s) {
        StringBuilder ans = new StringBuilder();
        StringBuilder w = new StringBuilder();
        s = s.trim();
        int n = s.length();
        s += " ";
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            char ch1 = s.charAt(i + 1);
            if (ch != ' ') {
                w.append(ch);
            } else if (ch1 != ' ') {
                w.insert(0, ' ');
                ans.insert(0, w);
                w.delete(0, w.length() + 1);
            }
        }
        ans.insert(0, w);
        w.delete(0, w.length() + 1);
        return ans.toString();
    }

    public static void main(String[] args) {
        ReverseWordsInString obj = new ReverseWordsInString();
        String str = "  hello world  ";
        System.out.println(obj.reverseWords(str));
    }

}
