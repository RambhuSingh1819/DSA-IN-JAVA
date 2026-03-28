class Solution {
    public boolean exist(char[][] board, String word) {
        int n = board.length;
        int m = board[0].length;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (solve(i, j, board, word, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean solve(int i, int j, char[][] board, String word, int idx) {

        // base case
        if (idx == word.length()) return true;

        // boundary + mismatch
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length
            || board[i][j] != word.charAt(idx)) {
            return false;
        }

        // mark visited
        char temp = board[i][j];
        board[i][j] = '#';

        // explore all 4 directions
        boolean found = solve(i + 1, j, board, word, idx + 1) ||
                        solve(i - 1, j, board, word, idx + 1) ||
                        solve(i, j + 1, board, word, idx + 1) ||
                        solve(i, j - 1, board, word, idx + 1);

        // backtrack
        board[i][j] = temp;

        return found;
    }
}