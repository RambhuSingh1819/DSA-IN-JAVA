/*class Solution {
    public int longestPalindromeSubseq(String s) {
        int n = s.length();
        int[][] dp = new int[n][n];
        for(int[] row: dp) Arrays.fill(row,-1);
        return solve(0,n-1,s,dp);
        
    }
    public int solve(int st, int end, String s,int[][] dp){
        if(st >= end) return (st == end) ? 1 : 0;
        if(dp[st][end] != -1) return dp[st][end];
        if(s.charAt(st) == s.charAt(end)){
            int ans = solve(st+1,end-1,s,dp);
            return ans + 2;
        }
        else {
            int fSkip = solve(st+1, end, s,dp);
            int lSkip = solve(st, end-1,s,dp);
            return dp[st][end] = Math.max(fSkip, lSkip);
        }
    }
}*/

class Solution {
    public int longestPalindromeSubseq(String s) {
        String t = new StringBuilder(s).reverse().toString();
        return lcs(s,t);
    }
    public int lcs(String s, String t){
        int n = s.length();
        int m = t.length();
        int[][] dp = new int[n+1][m+1];
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= m; j++){
                if(s.charAt(i-1) == t.charAt(j-1)) dp[i][j] = 1 + dp[i-1][j-1];
                else dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
            }
        }
        return dp[n][m];
    }
}