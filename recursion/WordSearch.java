package recursion;

public class WordSearch {

    boolean ans = false;

    public boolean exist(char[][] board, String word) {
        wordSearch(board, word, 0, 0, 0);
        return ans;
    }

    public void wordSearch(char[][] board, String word, int index, int i, int j) {
        if (index >= word.length()) {
            ans = true;
            return;
        }
    }

}
