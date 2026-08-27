class Solution {
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
}