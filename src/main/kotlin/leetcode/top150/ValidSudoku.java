package src.main.kotlin.leetcode.top150;

import java.util.HashMap;

public class ValidSudoku {
    public static void main(String[] args) {
        char[][] ch = new char[][]{
                {'5','3','.','.','7','.','.','.','.'},
                {'6','.','.','1','9','5','.','.','.'},
                {'.','9','8','.','.','.','.','6','.'},
                {'8','.','.','.','6','.','.','.','3'},
                {'4','.','.','8','.','3','.','.','1'},
                {'7','.','.','.','2','.','.','.','6'},
                {'.','6','.','.','.','.','2','8','.'},
                {'.','.','.','4','1','9','.','.','5'},
                {'.','.','.','.','8','.','.','7','9'}
        };
        System.out.println(isValidSudoku(ch));

    }

    public static boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            HashMap<Character, Character> map = new HashMap<>();
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] >= '0' && board[i][j] <= '9') {
                    if (map.containsKey(board[i][j])) {
                        return false;
                    } else {
                        map.put(board[i][j], board[i][j]);
                    }
                }
            }
        }
        for (int i = 0; i < board.length; i++) {
            HashMap<Character, Character> map = new HashMap<>();
            for (int j = 0; j < board[i].length; j++) {
                if (board[j][i] >= '0' && board[j][i] <= '9') {
                    if (map.containsKey(board[j][i])) {
                        return false;
                    } else {
                        map.put(board[j][i], board[j][i]);
                    }
                }
            }
        }
        for (int k = 0; k < 9; k++) {
            int start = (k * 3) % 9;
            int limit = ((k * 3) % 9) + 3;
            int iLimit = ((k / 3) *3)+3;
            HashMap<Character, Character> map = new HashMap<>();
            for (int i = (k / 3)*3; i < iLimit; i++) {

                for (int j = start; j < limit; j++) {

                    if (board[i][j] >= '0' && board[i][j] <= '9') {
                        if (map.containsKey(board[i][j])) {
                            return false;
                        } else {
                            map.put(board[i][j], board[i][j]);
                        }
                    }
                }
            }
        }
        return true;
    }
}
