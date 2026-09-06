/*class Solution {
    public int numDistinct(String s, String t) {
        int n = s.length();
        int m = t.length();
        int[][] dp = new int[n][m];
        for(int[] row : dp) Arrays.fill(row,-1);
       return  solve(n-1,m-1,s,t,dp);
    }
    public int solve(int i, int j, String s, String t,int[][] dp){

        if(i < 0 && j >= 0) return 0;
        if(j < 0) return 1;
        if(dp[i][j] != -1) return dp[i][j];

        if(s.charAt(i) == t.charAt(j)){
            int take = solve(i-1,j-1,s,t,dp);
            int notTake = solve(i-1,j,s,t,dp);
            return dp[i][j] = take + notTake;
        }else {
            return solve(i-1,j,s,t,dp);
        }
    }
}
*/

class Solution {
    public int numDistinct(String s, String t) {
        int n = s.length();
        int m = t.length();
        int[][] dp = new int[n+1][m+1];
        for(int i = 0; i < n; i++){
            dp[i][0] = 1;
        }
        for(int i = 1; i <= n; i++){
            for(int j = 1;j <= m; j++){
                if(s.charAt(i-1) == t.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1] + dp[i-1][j];
                }else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[n][m];

    }
}