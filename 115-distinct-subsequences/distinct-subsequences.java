/*
    MEMORIZTION METHOD
    T.C = O(N*M);
    S.C = O(N*M)+O(M+N);
 */
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

// TABULATION METHOD(
    //T.C = O(N*M)
    //SC = O(N*M)
//)
/*class Solution {
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
*/
class Solution {
    public int numDistinct(String s, String t) {
        int n = s.length();
        int m = t.length();
        if (m > n) return 0;
        long[] prev = new long[m + 1];
        prev[0] = 1;
        for (int i = 1; i <= n; i++) {
            long[] curr = new long[m + 1];
            curr[0] = 1; // Empty string t can always be formed 1 way
            
            for (int j = 1; j <= m; j++) {
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    curr[j] = prev[j - 1] + prev[j];
                } else {
                    curr[j] = prev[j];
                }
            }
            prev = curr;
        }

        return (int) prev[m];
    }
}