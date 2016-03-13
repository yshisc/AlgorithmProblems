package Leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author xiangfeidong
 *
 * 36.Valid Sudoku
 */
public class ValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < 9; i++) {
            Set<Character> set1 = new HashSet<>();  //Used to check ith row
            Set<Character> set2 = new HashSet<>();  //Used to check ith column
            Set<Character> set3 = new HashSet<>();  //Used to check ith block

            for (int j = 0; j < 9; j++) {
                //Check ith row
                if (board[i][j] != '.' && !set1.add(board[i][j])) {
                    return false;
                }
                //Check ith column
                if (board[j][i] != '.' && !set2.add(board[j][i])) {
                    return false;
                }
                //Check ith block
                if (board[i / 3 * 3 + j / 3][i % 3 * 3 + j % 3] != '.' && !set3.add(board[i / 3 * 3 + j / 3][i % 3 * 3 + j % 3])) {
                    return false;
                }
            }
        }
        return true;
    }
}
