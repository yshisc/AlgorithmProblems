package Leetcode;
/**
 * @author xiangfeidong
 *
 * 79.Word Search
 */
public class WordSearch {
    public boolean exist(char[][] board, String word) {
        boolean[][] visited = new boolean[board.length][board[0].length];

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (search(board, word, i, j, 0, visited)) {
                    return true;
                }
            }
        }

        return false;
    }

    private final int[] dx = {0, 0, -1, 1};
    private final int[] dy = {-1, 1, 0, 0};

    private boolean search(char[][] board, String word, int i, int j, int index, boolean[][] visited) {
        if (index >= word.length()) {
            return true;
        }

        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length) {
            return false;
        }

        if (visited[i][j] || board[i][j] != word.charAt(index)) {
            return false;
        }

        visited[i][j] = true;
        for (int k = 0; k < dx.length; k++) {
            int x = i + dx[k], y = j + dy[k];
            if (search(board, word, x, y, index + 1, visited)) {
                return true;
            }
        }
        visited[i][j] = false;

        return false;
    }
}
