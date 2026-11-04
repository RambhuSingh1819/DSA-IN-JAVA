class Solution {
    public int[][] onesMinusZeros(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        int[][] diff = new int[n][m];

        int[] row = new int[n];
        int[] col = new int[m];

        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = 0; j < m; j++) {
                sum += grid[i][j];
            }
            row[i] = sum;
        }

        for (int j = 0; j < m; j++) {
            int sum = 0;
            for (int i = 0; i < n; i++) {
                sum += grid[i][j];
            }
            col[j] = sum;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                diff[i][j] = row[i] + col[j]
                    - (m - row[i]) - (n - col[j]);
            }
        }

        return diff;
    }
}