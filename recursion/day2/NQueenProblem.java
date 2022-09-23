package recursion.day2;

import java.util.ArrayList;
import java.util.List;


public class NQueenProblem {

    public List<List<String>> solveNQueens(int n) {
        List<List<String>> list = new ArrayList<>();
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }
        dfs(0, board, list);
        return list;
    }

    private void dfs(int column, char[][] board, List<List<String>> list) {
        if (column == board.length) {
            list.add(generate(board));
            return;
        }
        for (int i = 0; i < board.length; i++) {
            if (check(board, i, column)) {
                board[i][column] = 'Q';
                dfs(column + 1, board, list);
                board[i][column] = '.';
            }
        }
    }

    private boolean check(char[][] board, int row, int col) {
        int dupRow = row;
        int dupCol = col;
        while (row >= 0 && col >= 0) {
            if (board[row][col] == 'Q')
                return false;
            row--;
            col--;
        }
        row = dupRow;
        col = dupCol;
        while (col >= 0) {
            if (board[row][col] == 'Q')
                return false;
            col--;
        }
        col = dupCol;
        while (col >= 0 && row < board.length) {
            if (board[row][col] == 'Q')
                return false;
            col--;
            row++;
        }
        return true;
    }

    private List<String> generate(char[][] board) {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < board.length; i++) {
            StringBuilder str = new StringBuilder();
            for (int j = 0; j < board.length; j++) {
                str.append(board[i][j]);
            }
            list.add(str.toString());
        }
        return list;
    }

    public static void main(String[] args){
        NQueenProblem obj = new NQueenProblem();
        System.out.println(obj.solveNQueens(4));
    }

}
