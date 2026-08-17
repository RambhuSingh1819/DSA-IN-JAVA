class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];
        for(int[] row : dp) Arrays.fill(row,-1);
       // return solve(m-1,n-1,grid,dp);
       for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(i == 0 && j == 0) dp[i][j] = grid[0][0];
                else{
                    int up = 1000000000;
                    int left = 1000000000;
                    if(i > 0) up = dp[i-1][j];
                    if(j > 0) left = dp[i][j-1];
                    dp[i][j] = grid[i][j] + Math.min(up,left);
                }
            }
       }
       return dp[m-1][n-1];
        
    }
    public int solve(int i, int j, int[][] grid, int[][] dp){
        if(i == 0 && j == 0) return grid[0][0];
        if(i < 0 || j < 0) return 1000000000;
        if(dp[i][j] != -1) return dp[i][j];
        int up = solve(i-1,j,grid,dp);
        int left = solve(i,j-1,grid,dp);
        return  dp[i][j] = grid[i][j] + Math.min(up,left);
    }
}