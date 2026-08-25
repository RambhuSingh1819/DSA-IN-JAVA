class Solution {
    public int numDecodings(String s) {
        int n = s.length();
        int[] dp = new int[n];
        Arrays.fill(dp,-1);
        return solve(0,n,s,dp);
        
    }
    public int solve(int idx, int n, String s,int[] dp){
        if(idx == n) return 1;
        if (s.charAt(idx) == '0') return 0;
        if(dp[idx] != -1) return dp[idx];
        int take =  solve(idx+1,n,s,dp);
        if(idx + 1 < n){
            int num = Integer.parseInt(s.substring(idx,idx+2));
            if(num <= 26) take += solve(idx+2,n,s,dp);
        }
        return dp[idx] = take;
    }
}