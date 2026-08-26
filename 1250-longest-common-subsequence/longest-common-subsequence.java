class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int sl = text1.length();
        int tl = text2.length();
        int[][] dp = new int[sl][tl];
        for(int[] row : dp) Arrays.fill(row,-1);
        return solve(text1,0,text2,0,dp);
        
    }
    public int solve(String s,int si, String t, int ti ,int[][] dp){
        if(si == s.length() || ti == t.length()) return 0;
        if(dp[si][ti] != -1) return dp[si][ti];
        if(s.charAt(si) == t.charAt(ti)){
            int ans = solve(s,si+1,t,ti+1,dp);
            return 1 + ans;
        }else{
            int notTake = solve(s,si+1,t,ti,dp);
            int Take = solve(s,si,t,ti+1,dp);
            return dp[si][ti] = Math.max(notTake,Take);
        }

    }
}