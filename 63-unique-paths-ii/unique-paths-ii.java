class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] dp = new int[m][n];
        for(int[] row : dp) Arrays.fill(row,-1);
        return solve(m-1,n-1,obstacleGrid,dp);
        
    }
    public int solve(int m, int n, int[][] arr,int[][] dp){
        if(m < 0 || n < 0) return 0;
        if(arr[m][n] == 1) return 0;
        if(m == 0 && n == 0) return 1;
        if(dp[m][n] != -1) return dp[m][n];
        int up = solve(m-1,n,arr,dp);
        int left = solve(m,n-1,arr,dp);
        return dp[m][n] = left + up;
    }
}