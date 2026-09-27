class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int minPath = Integer.MAX_VALUE;
        int[][] dp = new int[n][m];
        for(int[] row : dp) Arrays.fill(row,Integer.MIN_VALUE);
        for(int j = 0; j < m; j++){
           int pathSum = solve(0,j,matrix,dp);   
           minPath = Math.min(minPath,pathSum); 
        }  
        return minPath;     
    }
    public int solve(int row, int col, int[][]matrix,int[][] dp){
        int n = matrix.length;
        int m = matrix[0].length;
        if(col < 0 || col >= m) return (int)1e9;
        if(row == n-1) return matrix[row][col];
        if(dp[row][col] != Integer.MIN_VALUE) return dp[row][col];

        int down = solve(row+1,col,matrix,dp);
        int left = solve(row+1,col-1,matrix,dp);
        int right = solve(row+1,col+1,matrix,dp);
        return dp[row][col] = matrix[row][col] + Math.min(down,Math.min(right,left));
    }

}