package Leetcode;
/**
 * @author xiangfeidong
 *
 * 37.Sudoku Solver
 *
 * Try all possible solution cell by cell.
 */
public class No037SudokuSolver {
    public void solveSudoku(char[][] board) {
        solve(board);
    }

    private boolean solve(char[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') {
                    //Try 9 possible numbers.
                    for (char c = '1'; c <= '9'; c++) {
                        //Proceed only the number is valid.
                        if (isValid(board, i, j, c)) {
                            board[i][j] = c;
                            if (solve(board)) {
                                return true;
                            } else {
                                board[i][j] = '.';
                            }
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    private boolean isValid(char[][] board, int i, int j, char c) {
        //Check the ith row
        for (int col = 0; col < 9; col++) {
            if (board[i][col] == c) {
                return false;
            }
        }

        //Check the ith column
        for (int row = 0; row < 9; row++) {
            if (board[row][j] == c) {
                return false;
            }
        }

        //Check the block
        for (int row = i / 3 * 3; row < i / 3 * 3 + 3; row++) {
            for (int col = j / 3 * 3; col < j / 3 * 3 + 3; col++) {
                if (board[row][col] == c) {
                    return false;
                }
            }
        }

        return true;
    }
}
